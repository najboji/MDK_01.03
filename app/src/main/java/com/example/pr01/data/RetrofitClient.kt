package com.example.pr01.data

import com.example.pr01.data.service.AuthService
import com.example.pr01.data.service.PostService
import com.example.pr01.data.service.ProductService
import com.example.pr01.data.service.RecipeService
import com.example.pr01.data.service.TodoService
import com.example.pr01.data.service.UserService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy
import kotlin.jvm.java

object RetrofitClient {
    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.59", 3128))


    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }


    val httpClient = OkHttpClient.Builder()
        .proxy(proxy)
        .addInterceptor(loggingInterceptor)
        .build()

    val client = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val swagger: Retrofit = Retrofit.Builder()
        .baseUrl("http://10.207.106.59:8090/api/collections/")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    //    Практическая 14
    val productsService: ProductService = retrofit.create(ProductService::class.java)
    //    Практическая 15
    val recipeService: RecipeService = retrofit.create(RecipeService::class.java)
    //    Практическая 16
    val userService: UserService = retrofit.create(UserService::class.java)
    //    Практическая 17
    val postService: PostService = retrofit.create(PostService::class.java)
    //    Практическая 18
    val authService: AuthService = swagger.create(AuthService::class.java)
    val todoService: TodoService = swagger.create(TodoService::class.java)
}