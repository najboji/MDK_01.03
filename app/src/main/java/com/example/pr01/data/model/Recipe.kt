package com.example.pr01.data.model

data class Recipe(
    val id: Int? = null,
    val name: String? = null,
    val ingredients: List<String>? = null,
    val cookTimeMinutes: Int? = null,
    val difficulty: String? = null
)
