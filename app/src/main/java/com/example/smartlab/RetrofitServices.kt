package com.example.smartlab

import retrofit2.Call
import retrofit2.http.*

interface RetrofitServices {

    @GET("api/news")
    fun getNews(): Call<ArrayList<NewsClass>> // Получение списка
}