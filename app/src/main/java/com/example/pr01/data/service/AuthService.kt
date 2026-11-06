package com.example.pr01.data.service

import com.example.pr01.data.model.AuthRequest
import com.example.pr01.data.model.AuthResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("users/auth-with-password")
    suspend fun authWithPassword(@Body authRequest: AuthRequest): AuthResponse
}