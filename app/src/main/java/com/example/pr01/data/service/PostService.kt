package com.example.pr01.data.service

import com.example.pr01.data.model.Post
import retrofit2.http.DELETE
import retrofit2.http.Path

interface PostService {
    @DELETE("posts/{id}")
    suspend fun deletePost(@Path("id") id: Int)
}