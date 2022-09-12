package com.example.compose.ui.lazylist

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


interface BiliService {
    companion object {
        val gson = Gson()
        private var retrofit = Retrofit.Builder()
            .baseUrl("http://api.bilibili.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }).build()
            )
            .build()

        val impl: BiliService = retrofit.create(BiliService::class.java)
    }

    @GET("x/web-interface/popular")
    suspend fun popularVideos(
        @Query("pn") pageNumber: Int,
        @Query("ps") pageSize: Int
    ): PopularResponse?
}