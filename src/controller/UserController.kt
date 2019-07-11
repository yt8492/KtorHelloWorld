package com.yt8492.controller

import com.yt8492.repository.UserRepository
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.routing.route

fun Route.userController() {
    route("/user") {
        get {
            call.respond(
                HttpStatusCode.OK,
                UserRepository.getAllUsers().map { GetUserRespMsg(it.name, it.age) })
        }

        post {
            val request = call.receive<CreateUserReqMsg>()
            UserRepository.createUser(request.name, request.age)
            call.respond(HttpStatusCode.OK)
        }

        get("/detail") {
            call.respond(HttpStatusCode.OK, "user detail routing ok")
        }
    }
}

data class GetUserRespMsg(val name: String, val age: Int)
data class CreateUserReqMsg(val name: String, val age: Int)