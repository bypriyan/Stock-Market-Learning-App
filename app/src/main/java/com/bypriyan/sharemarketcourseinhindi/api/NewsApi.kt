package com.bypriyan.sharemarketcourseinhindi.api

import com.bypriyan.bustrackingsystem.utility.Constants
import com.bypriyan.sharemarketcourseinhindi.model.ModelArticelResponce
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//https://newsapi.org/v2/top-headlines?country=us&apiKey=3a373044c31f4521956acbcf931af15b

interface NewsApi {

    @GET("v2/top-headlines?country=in&category=business&apiKey=${Constants.KEY_NEWS_API_KEY}")
    fun getHeadlines(
        @Query("page") page:Int,
        @Query("pageSize") pageSize:Int
    ):Call<ModelArticelResponce>

}

object NewsService{
    val newsInstance:NewsApi
    init {
        val  retrofit = Retrofit.Builder().baseUrl(Constants.KEY_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        newsInstance = retrofit.create(NewsApi::class.java)
    }
}