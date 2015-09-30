package com.brij.service

import spray.routing.{Route, HttpServiceActor}

class RequestHandlerActor extends HttpServiceActor{
    override def receive: Receive = runRoute(route)
   val route:Route =  path("firstRoute"){
        complete("Request completed")
    }
}
