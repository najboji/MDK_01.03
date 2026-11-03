package com.example.pr01.data.service

import com.example.pr01.data.model.TodoResponse
import retrofit2.Response
import retrofit2.http.GET

interface TodoService {
    @GET("todos/records")
    suspend fun getTodos(): Response<TodoResponse>
}