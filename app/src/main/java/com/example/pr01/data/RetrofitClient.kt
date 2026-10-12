package com.example.pr01.data

import com.example.pr01.data.service.ProductService
import com.example.pr01.data.service.RecipeService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.InetSocketAddress
import java.net.Proxy
import kotlin.jvm.java

object RetrofitClient {
//    val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress("10.207.106.59", 3128))

    val httpClient = OkHttpClient.Builder()
//        .proxy(proxy)
        .build()

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .client(httpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val productsService: ProductService = retrofit.create(ProductService::class.java)
    val recipeService: RecipeService = retrofit.create(RecipeService::class.java)
}