package com.yt8492.repository

import com.yt8492.infra.db.User
import org.jetbrains.exposed.sql.transactions.transaction

object UserRepository {
    fun getAllUsers(): List<User> {
        val result = transaction {
            User.all().toList()
        }
        return result
    }

    fun createUser(name: String, age: Int) {
        transaction {
            User.new {
                this.name = name
                this.age = age
            }
        }
    }
}