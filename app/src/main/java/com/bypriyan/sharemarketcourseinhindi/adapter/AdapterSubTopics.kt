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
import com.bypriyan.sharemarketcourseinhindi.activity.SubTopicDetailsActivity
import com.bypriyan.sharemarketcourseinhindi.activity.SubTopicsActivity
import com.bypriyan.sharemarketcourseinhindi.model.ModelArticles
import com.bypriyan.sharemarketcourseinhindi.model.ModelSubTopic
import com.bypriyan.sharemarketcourseinhindi.model.ModelTopics
import com.google.android.material.card.MaterialCardView

class AdapterSubTopics(private val context: Context, private val subTopicList: List<ModelSubTopic>):
    RecyclerView.Adapter<AdapterSubTopics.HolderSubTopics>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderSubTopics {
        val view = LayoutInflater.from(context).inflate(R.layout.row_sub_topics, parent, false)
        return HolderSubTopics(view)
    }

    override fun getItemCount(): Int {
       return subTopicList.size
    }

    override fun onBindViewHolder(holder: HolderSubTopics, position: Int) {
        val modelSubTopic = subTopicList[position]


        holder.titleTv.text = modelSubTopic.title

            holder.topicImg.load(modelSubTopic.imgUrl){
                crossfade(true)
                placeholder(R.drawable.logo)
            }


        holder.itemView.setOnClickListener{
            var intent = Intent(context, SubTopicDetailsActivity::class.java)
            intent.putExtra(Constants.KEY_SUB_TOPIC, modelSubTopic.topic)
            intent.putExtra(Constants.KEY_SUB_TOPIC_ID, "${modelSubTopic.id}")
            context.startActivity(intent)
        }
    }

    inner class HolderSubTopics(itemView:View): RecyclerView.ViewHolder(itemView) {
        val topicImg: ImageView = itemView.findViewById(R.id.topicImg)
        val titleTv: TextView = itemView.findViewById(R.id.titleTv)
    }

}