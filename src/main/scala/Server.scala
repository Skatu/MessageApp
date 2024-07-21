import akka.actor.typed.javadsl.Behaviors
import akka.actor.typed.{ActorSystem, Behavior}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Directives.*
import akka.http.scaladsl.server.Route
import akka.stream.{Materializer, SystemMaterializer}

import scala.concurrent.ExecutionContextExecutor
import scala.io.StdIn

object Server {

  @main def startServer() : Unit= {
    val rootBehavior: Behavior[Nothing] = Behaviors.setup[Nothing]{context=>Behaviors.empty}
    implicit val system: ActorSystem[Nothing] = ActorSystem[Nothing](rootBehavior, "akka-http-server")
    implicit val executionContext: ExecutionContextExecutor = system.executionContext
    implicit val materializer: Materializer = SystemMaterializer(system).materializer

    val route: Route = path("hello"){
      get {
        complete("OK")
      }
    }

    val server = Http().newServerAt("localhost", 8080).bind(route)
    println("Server online at http://localhost:8080")
    StdIn.readLine()

    server.flatMap(_.unbind())
      .onComplete(_=>system.terminate())

  }
}
