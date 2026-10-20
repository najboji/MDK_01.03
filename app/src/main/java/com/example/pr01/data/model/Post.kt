package com.example.pr01.data.model

data class Post(
    val id: Int? = null,
    val title: String? = null,
    val body: String? = null,
    val isDeleted: Boolean? = null,
    val deletedOn: String? = null
)
