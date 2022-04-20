package com.example.latihanretrofitviewmodel.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.latihanretrofitviewmodel.model.ResponseDataNewsItem
import com.example.latihanretrofitviewmodel.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelNews : ViewModel(){
    //live data initialization
    private var liveDataNews :MutableLiveData<List<ResponseDataNewsItem>> = MutableLiveData()
    fun getLiveNewsObserver() : MutableLiveData<List<ResponseDataNewsItem>>{
        return liveDataNews
    }
    //set value of response in liveDataNews
    fun makeApiNews(){
        RetrofitClient.instance.getAllNews()
            .enqueue(object : Callback<List<ResponseDataNewsItem>> {
                override fun onResponse(
                    call: Call<List<ResponseDataNewsItem>>,
                    response: Response<List<ResponseDataNewsItem>>
                ) {
                    if(response.isSuccessful){
                        liveDataNews.postValue(response.body())
                    }else{
                        liveDataNews.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<ResponseDataNewsItem>>, t: Throwable) {
                    liveDataNews.postValue(null)
                }

            })
    }
}