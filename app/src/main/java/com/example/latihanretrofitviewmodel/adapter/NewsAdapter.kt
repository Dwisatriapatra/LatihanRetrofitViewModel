package com.example.latihanretrofitviewmodel.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.latihanretrofitviewmodel.R
import com.example.latihanretrofitviewmodel.model.ResponseDataNewsItem
import kotlinx.android.synthetic.main.item_news_adapter.view.*

class NewsAdapter() : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    //property of response list from API
    private var listNews : List<ResponseDataNewsItem>? = null
    //fun for set value of data news
    fun setDataNews(news : List<ResponseDataNewsItem>){
        this.listNews = news
    }
    //class view holder definition
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsAdapter.ViewHolder, position: Int) {
        //set value per news item
        with(holder.itemView){
            with(listNews!![position]){
                item_judul_news.text = title
                item_author_news.text = author
                item_tanggal_news.text = createdAt
            }
        }

        //use glide for set image per news item
        Glide.with(holder.itemView.item_image_news.context)
            .load(listNews!![position].image)
            .error(R.drawable.ic_launcher_background)
            .override(50, 100)
            .into(holder.itemView.item_image_news)
    }

    override fun getItemCount(): Int {
        //check if listNews is null or not
        return if(listNews.isNullOrEmpty()){
            0
        }else{
            listNews!!.size
        }
    }
}