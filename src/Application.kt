package com.yt8492

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.html.*
import kotlinx.html.*
import kotlinx.css.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    routing {
        get("/") {
            call.respondHtml {
                lang = "ja"
                head {
                    title = "KtorHelloWorld"
                    meta {
                        charset = "UTF-8"
                    }
                }
                body {
                    h1 {
                        + "Hello Ktor!"
                    }
                    p {
                        + "This page is created by Ktor."
                    }
                }
            }
        }
    }
}