package com.zenmo.ztor.plugins

import com.zenmo.orm.companysurvey.SurveyRepository
import com.zenmo.orm.companysurvey.dto.*
import com.zenmo.orm.connectToPostgres
import com.zenmo.ztor.errorMessageToJson
import com.zenmo.ztor.user.UserSession
import io.ktor.http.*
import io.ktor.serialization.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.sessions.*
import java.sql.*
import kotlinx.coroutines.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.TransactionManager
import java.util.*

fun Application.configureDatabases(): Database {
    val db: Database = connectToPostgres()

    routing {
        // Create
        post("/company-survey") {
            val survey: Survey?
            try {
                survey = call.receive<Survey>()
            } catch (e: BadRequestException) {
                if (e.cause is JsonConvertException) {
                    call.respond(HttpStatusCode.BadRequest, errorMessageToJson(e.cause?.message))
                    return@post
                }
                call.respond(HttpStatusCode.BadRequest,  errorMessageToJson(e.message))
                return@post
            }

            val repository = SurveyRepository(db)
            repository.save(survey)

            // TODO: return entity from database
            call.respond(HttpStatusCode.Created, survey)
        }
        // fetch all
        get("/company-survey") {
            val userSession = call.sessions.get<UserSession>()
            if (userSession == null) {
                call.respond(HttpStatusCode.Unauthorized)
                return@get
            }

            val userId = userSession.getUserId()

            val repository = SurveyRepository(db)
            val surveys = repository.getSurveysByUser(userId)

            call.respond(HttpStatusCode.OK, surveys)
        }
    }

    return db
}
