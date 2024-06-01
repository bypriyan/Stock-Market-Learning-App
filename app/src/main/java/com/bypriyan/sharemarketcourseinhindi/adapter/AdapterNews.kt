package com.bypriyan.sharemarketcourseinhindi.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.bypriyan.bustrackingsystem.utility.Constants
import com.bypriyan.sharemarketcourseinhindi.R
import com.bypriyan.sharemarketcourseinhindi.activity.NewsDetailsActivity
import com.bypriyan.sharemarketcourseinhindi.model.ModelArticles
import com.bypriyan.sharemarketcourseinhindi.model.ModelTopics
import com.google.android.material.card.MaterialCardView

class AdapterNews(private val context: Context, private val newsList: List<ModelArticles>):
    RecyclerView.Adapter<AdapterNews.HolderNews>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderNews {
        val view = LayoutInflater.from(context).inflate(R.layout.row_news, parent, false)
        return HolderNews(view)
    }

    override fun getItemCount(): Int {
       return newsList.size
    }

    override fun onBindViewHolder(holder: HolderNews, position: Int) {
        val modelNews = newsList[position]

        holder.newsTitleTv.text = modelNews.title
        val arr = modelNews.publishedAt.split("T")
        holder.newsDateTv.text = arr[0]


        modelNews.urlToImage.let {
            holder.newsImg.load(it){
                crossfade(true)
                placeholder(R.drawable.logo)
            }
        }

        holder.itemView.setOnClickListener{
            var intent = Intent(context, NewsDetailsActivity::class.java)
            intent.putExtra(Constants.KEY_NEWS_IMG, modelNews.urlToImage)
            intent.putExtra(Constants.KEY_NEWS_TITLE, modelNews.title)
            intent.putExtra(Constants.KEY_NEWS_DATE, modelNews.publishedAt)
            intent.putExtra(Constants.KEY_NEWS_DESCRIPTION, modelNews.description)
            intent.putExtra(Constants.KEY_NEWS_CONTENT, modelNews.content)
            context.startActivity(intent)
        }
    }

    inner class HolderNews(itemView:View): RecyclerView.ViewHolder(itemView) {
        val newsImg: ImageView = itemView.findViewById(R.id.newsImg)
        val newsTitleTv: TextView = itemView.findViewById(R.id.newsTitleTv)
        val newsDateTv: TextView = itemView.findViewById(R.id.newsDateTv)
        val imageVisib: RelativeLayout =itemView.findViewById(R.id.imageVisib)
    }

}