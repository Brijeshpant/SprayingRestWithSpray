package com.brij.service

import akka.actor.Actor
import spray.http._
import HttpMethods._

class MyHttpService extends Actor {
    def receive = {
        case HttpRequest(GET, Uri.Path("/testPath"), _, _, _) =>
            sender() ! HttpResponse(entity = "response ")
        case HttpRequest(_,_,_,_,_) => sender() ! HttpResponse(entity = "no route possible ")
    }
}
