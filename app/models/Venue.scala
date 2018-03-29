package models

import play.api.libs.json._

case class Venue(id: Long, name: String, organiserId: Long)

object Venue {
  implicit val venueFormat = Json.format[Venue]
}


