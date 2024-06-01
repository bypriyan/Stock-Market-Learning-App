package com.bypriyan.sharemarketcourseinhindi.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.bypriyan.bustrackingsystem.utility.Constants
import com.bypriyan.sharemarketcourseinhindi.R
import com.bypriyan.sharemarketcourseinhindi.activity.SubTopicsActivity
import com.bypriyan.sharemarketcourseinhindi.model.ModelTopics
import com.google.android.material.card.MaterialCardView

class AdapterTopics(private val context: Context, private val topicList: List<ModelTopics>):
    RecyclerView.Adapter<AdapterTopics.HolderTopics>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderTopics {
        val view = LayoutInflater.from(context).inflate(R.layout.row_topics, parent, false)
        return HolderTopics(view)
    }

    override fun onBindViewHolder(holder: HolderTopics, position: Int) {
        val modelTopics = topicList[position]

        holder.titleTv.text = modelTopics.title
        holder.topicImg.load(modelTopics.imgUrl){
            crossfade(true)
            placeholder(R.drawable.logo)
        }
        holder.itemView.setOnClickListener{
            var intent = Intent(context, SubTopicsActivity::class.java)
            intent.putExtra(Constants.KEY_IMG_URL, modelTopics.imgUrl)
            intent.putExtra(Constants.KEY_SUB_TOPIC, modelTopics.topic)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return topicList.size
    }

    inner class HolderTopics(itemView:View): RecyclerView.ViewHolder(itemView) {
        val topicImg: ImageView = itemView.findViewById(R.id.topicImg)
        val titleTv: TextView = itemView.findViewById(R.id.topicTv)
    }
}