package com.example.pr01.data.service

import com.example.pr01.data.model.ProductResponse
import com.example.pr01.data.model.Recipe
import com.example.pr01.data.model.RecipeResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface RecipeService {
    @POST("recipes/add")
    suspend fun addRecipe(@Body recipe: Recipe): Recipe
}