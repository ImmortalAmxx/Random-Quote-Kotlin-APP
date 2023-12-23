package com.example.randomquote.network

import com.example.randomquote.entity.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://dummyjson.com/quotes/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

interface RandomQuoteApiService {
    @GET("random")
   suspend fun getData(): Response
}

object RandomQuoteApi {
    val retrofitService: RandomQuoteApiService by lazy {
        retrofit.create(RandomQuoteApiService::class.java)
    }
}