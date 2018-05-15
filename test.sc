import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

//val a = Future.successful(Some("a"))
val a = Future.successful(None)
val b = Future.successful("b")

for {
  aa <- a
  bb <- b if (aa.isDefined)
} yield bb

