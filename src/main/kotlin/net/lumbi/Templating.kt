package net.lumbi

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.css.*
import kotlinx.html.*
import net.lumbi.models.*

fun BODY.muestra(texto: String) {
    h1 { +"${texto}" }
}

fun Application.configureTemplating() {
    routing {
        get("/") {
            val todos = TodoList()
            todos.todo.add(Todo(1, "Aprender Kotlin", "Tengo que aprender kotlin", false))
            todos.todo.add(
                    Todo(
                            2,
                            "Aprender KTor",
                            "Tengo que aprender hacer SSR en KTor usando DSL",
                            false
                    )
            )
            todos.todo.add(Todo(3, "KTor RESTAPi", "Aprender a hacer una restAPI en Kotlin", false))
            call.respondHtml {
                body {
                    muestra("Prueba embedding")
                    todos.todo.forEach { todo ->
                        ul {
                            li { +"ID: ${todo.id}" }
                            li { +"Título: ${todo.titulo}" }
                            li { +"Descripción: ${todo.cuerpo}" }
                            li { +"Completado: ${if (todo.completado) "Sí" else "No"}" }
                        }
                    }
                }
            }
        }
    }
}

// suspend inline fun ApplicationCall.respondCss(builder: CSSBuilder.() -> Unit) {
//     this.respondText(CSSBuilder().apply(builder).toString(), ContentType.Text.CSS)
// }
