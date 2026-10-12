package com.example.pr01.data.model

data class RecipeResponse(
    val id: Int,
    val name: String,
    val ingredients: List<String>,
    val cookTimeMinutes: Int,
    val difficulty: String
)
