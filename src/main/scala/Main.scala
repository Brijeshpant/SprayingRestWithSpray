package com.brij

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import com.brij.service.RequestHandlerActor
import spray.can.Http

object Main extends App {

    implicit val system = ActorSystem("SprayingRestWithSpray")
    val apiRouteHandlerActor = system.actorOf(Props[RequestHandlerActor], "application-actor")
    (IO(Http) ! Http.Bind(apiRouteHandlerActor, interface = "localhost", port = 8080))
}
