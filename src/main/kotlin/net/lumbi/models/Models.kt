package net.lumbi.models

data class Todo(var id: Int, var titulo: String, var cuerpo: String, val completado: Boolean)

data class TodoList(val todo: MutableList<Todo> = mutableListOf())
