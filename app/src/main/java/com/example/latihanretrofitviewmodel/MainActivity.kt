package com.example.latihanretrofitviewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.latihanretrofitviewmodel.adapter.NewsAdapter
import com.example.latihanretrofitviewmodel.viewmodel.ViewModelNews
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //global var initialization of view model and adapter
    private lateinit var viewModel : ViewModelNews
    private lateinit var adapterNews : NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        getDataNewsUsingViewModel()
    }
    //initializing recycler view
    private fun initRecyclerView(){
        rv_news.layoutManager = LinearLayoutManager(this)
        adapterNews = NewsAdapter()
        rv_news.adapter = adapterNews
    }
    //get data of all news item
    private fun getDataNewsUsingViewModel() {
        viewModel = ViewModelProvider(this).get(ViewModelNews::class.java)
        viewModel.getLiveNewsObserver().observe(this, Observer {
            if (it.isNotEmpty()){
                adapterNews.setDataNews(it)
                adapterNews.notifyDataSetChanged()
            }
        })
        viewModel.makeApiNews()
    }
}