package com.brij

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import com.brij.service.RequestHandlerActor
import spray.can.Http
import akka.pattern.ask
import akka.util.Timeout
import spray.routing.SimpleRoutingApp
import scala.concurrent.duration._

object MainWithSimpleRoute extends App with SimpleRoutingApp{

    implicit val system = ActorSystem("SprayingRestWithSpray")

    implicit def executionContext = system.dispatcher
   implicit def timeout: Timeout = Timeout(15.seconds)


    startServer("localhost", port = 8050) {
        path("firstRoute"){
            complete("Request completed")
        }
    }


    val apiRouteActor = system.actorOf(Props[RequestHandlerActor], "application-actor")
    (IO(Http) ? Http.Bind(apiRouteActor, interface = "localhost", port = 8080))
}
