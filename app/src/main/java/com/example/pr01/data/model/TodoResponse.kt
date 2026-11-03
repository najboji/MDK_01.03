package com.example.pr01.data.model

data class TodoResponse(
    val items: List<Todo>? = null,
    val page: Int? = null,
    val perPage: Int? = null,
    val totalItems: Int? = null,
    val totalPages: Int? = null
)
