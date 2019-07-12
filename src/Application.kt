package com.yt8492

import com.yt8492.controller.userController
import com.yt8492.infra.db.User
import com.yt8492.infra.db.Users
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.jackson.jackson
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    DatabaseFactory.init()
    transaction {
        SchemaUtils.create(Users)
        User.new {
            name = "swallowtail"
            age = 24
        }
    }
    val server = embeddedServer(Netty, 8492) {
        install(ContentNegotiation) {
            jackson()
        }
        routing {
            userController()
        }
    }
    server.start()
}