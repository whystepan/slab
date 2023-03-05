package com.example.smartlab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainScreen : AppCompatActivity() {

    private var rNews: RecyclerView? = null
    private var news: ArrayList<NewsClass> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        rNews = findViewById(R.id.rNews)

        val retrofitServices: RetrofitServices =
            RetrofitClient.getClient("https://medic.madskill.ru/")
                .create(RetrofitServices::class.java)

        val response = retrofitServices.getNews().enqueue(object: Callback<ArrayList<NewsClass>> {
            override fun onResponse(
                call: Call<ArrayList<NewsClass>>,
                response: Response<ArrayList<NewsClass>>
            ) {
                news = response.body()!! // Создаем глобальный список карточек
                updateRecyclerView(news)
                Log.e("алло", news.toString()) // гляжу респонс)
            }
            override fun onFailure(call: Call<ArrayList<NewsClass>>, t: Throwable){
                Log.e("Беда", t.message.toString())
            }
        })
    }
    fun updateRecyclerView(news: ArrayList<NewsClass>){
        rNews?.layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        val recyclerAdapter = NewsAdapter(news)
        rNews?.adapter = recyclerAdapter
    }
}