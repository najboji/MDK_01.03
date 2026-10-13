package com.example.pr01.data

import com.example.pr01.data.service.ProductService
import com.example.pr01.data.service.RecipeService
import com.example.pr01.data.service.UserService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy
import kotlin.jvm.java

object RetrofitClient {
    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.59", 3128))

    val httpClient = OkHttpClient.Builder()
        .proxy(proxy)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

//    Практическая 14
    val productsService: ProductService = retrofit.create(ProductService::class.java)
    //    Практическая 15
    val recipeService: RecipeService = retrofit.create(RecipeService::class.java)
    //    Практическая 16
    val userService: UserService = retrofit.create(UserService::class.java)
}