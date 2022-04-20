package com.example.latihanretrofitviewmodel.network

import com.example.latihanretrofitviewmodel.model.ResponseDataNewsItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitServices {
    @GET("news")
    fun getAllNews() : Call<List<ResponseDataNewsItem>>
}