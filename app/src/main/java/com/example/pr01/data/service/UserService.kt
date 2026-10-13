package com.example.pr01.data.service

import com.example.pr01.data.model.Recipe
import com.example.pr01.data.model.RecipeResponse
import com.example.pr01.data.model.User
import com.example.pr01.data.model.UserResponse
import retrofit2.http.Body
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserService {
    @PUT("users/{id}")
    suspend fun updateUser(@Path("id") id: Int, @Body user: User): User
}