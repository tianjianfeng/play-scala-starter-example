package filters

import akka.stream.Materializer
import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import play.api.libs.json.Json

import play.api.test.FakeRequest
import org.scalatestplus.play._
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._
import play.test.WithApplication
import play.api.mvc.Results._
import scala.concurrent.ExecutionContext.Implicits.global

class ExampleFilterSpec extends PlaySpec with GuiceOneAppPerSuite {

  // Override fakeApplication if you need a Application with other than
  // default parameters.
  override def fakeApplication() = new GuiceApplicationBuilder().
    configure(
        Map("play.filters.enabled" -> List("filters.ExampleFilter")) ++
        Map("slick.dbs.default.profile"  -> "slick.jdbc.H2Profile$",
        "slick.dbs.default.db.driver" -> "org.h2.Driver",
        "slick.dbs.default.db.url" -> "jdbc:h2:mem:play")
    ).build()

  implicit lazy val materializer: Materializer = app.materializer

  "A filter" should {
    "can parse a JSON body" in new WithApplication{
      val filter = new ExampleFilter()
      val request = FakeRequest(POST, "/").withJsonBody(Json.parse("""{ "field": "value" }"""))

      val Action: DefaultActionBuilder = fakeApplication().injector.instanceOf[DefaultActionBuilder]
      val action = Action(Ok("success"))
      val result = filter(action)(request).run()

      header("X-ExampleFilter", result) must be (Some("foo"))
    }
  }
}

