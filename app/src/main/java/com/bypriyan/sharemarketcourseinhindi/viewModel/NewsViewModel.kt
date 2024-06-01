package com.bypriyan.sharemarketcourseinhindi.viewModel

import android.graphics.ColorSpace.Model
import android.util.Log
import android.util.Size
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bypriyan.sharemarketcourseinhindi.api.NewsApi
import com.bypriyan.sharemarketcourseinhindi.api.NewsService
import com.bypriyan.sharemarketcourseinhindi.model.ModelArticelResponce
import com.bypriyan.sharemarketcourseinhindi.model.ModelArticles
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel : ViewModel() {

    private val _newsList = MutableLiveData<List<ModelArticles>>()
    val newsList: LiveData<List<ModelArticles>> = _newsList

    fun getNews(page:Int, pageSize: Int){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                var news:Call<ModelArticelResponce> = NewsService.newsInstance.getHeadlines(page = page, pageSize = pageSize)
                news.enqueue(object :Callback<ModelArticelResponce>{
                    override fun onResponse(p0: Call<ModelArticelResponce>, responce: Response<ModelArticelResponce>) {
                        val news = responce.body()
                        Log.d("TAG", "onResponse view model: ${news.toString()}")
                        news?.let {
                            _newsList.value = news.articles
                            Log.d("TAG", "onResponse news view model: ${news.articles.toString()}")
                        }
                    }
                    override fun onFailure(p0: Call<ModelArticelResponce>, p1: Throwable) {
                        Log.d("TAG", "onFailure: ${p1}")
                    }

                })
            }

        }
    }

}