package models

import java.sql.Timestamp
import java.text.SimpleDateFormat

import play.api.libs.json._

case class Organiser(id: Long, name: String, createdAt: Timestamp = new Timestamp(System.currentTimeMillis))

object Organiser {
  implicit object timestampFormat extends Format[Timestamp] {
    val format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS'Z'")
    def reads(json: JsValue) = {
      val str = json.as[String]
      JsSuccess(new Timestamp(format.parse(str).getTime))
    }
    def writes(ts: Timestamp) = JsString(format.format(ts))
  }
  implicit val personFormat = Json.format[Organiser]
}
