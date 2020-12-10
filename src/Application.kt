package com.example

import io.ktor.application.*
import io.ktor.http.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    embeddedServer(
        Netty, watchPaths = listOf("solutions/exercise4"), port = 8080, host = "127.0.0.1",

        module = Application::module
    ).start(true)
}

const val jsonResponse = """{
    "id": 1,
    "task": "Pay waterbill",
    "description": "Pay water bill today",
}"""

fun Application.module() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/json") {
            call.respondText(jsonResponse, ContentType.Application.Json)
        }
    }
}