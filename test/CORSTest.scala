import controllers.HomeController
import org.scalatest.mockito.MockitoSugar

import scala.concurrent.Future
import org.scalatestplus.play._
import play.api.Configuration
import play.api.mvc._
import play.api.test._
import play.api.test.Helpers._
import play.test.WithApplication

import scala.concurrent.ExecutionContext.Implicits.global

class CORSTest extends PlaySpec with Results with MockitoSugar {

  "Example Page#index" should {
    "should be valid" in  {

//      val controller = new HomeController(Helpers.stubControllerComponents(), mock[Configuration])
//      val request = FakeRequest("OPTIONS", "/")
//        .withHeaders("Origin" -> "http://localhost",
//          "Access-Control-Request-Method" -> "POST",
//          "Content-Type" -> "application/json")
//      val result: Future[Result] = controller.index().apply(request)
//      status(result) mustBe OK

    }
  }
}