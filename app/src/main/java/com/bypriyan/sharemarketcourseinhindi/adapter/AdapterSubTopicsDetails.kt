package com.bypriyan.sharemarketcourseinhindi.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import coil.load
import com.airbnb.lottie.LottieAnimationView
import com.bypriyan.sharemarketcourseinhindi.R
import com.bypriyan.sharemarketcourseinhindi.model.ModelOnBordingScreen
import com.bypriyan.sharemarketcourseinhindi.model.ModelSubTopic
import com.google.android.material.card.MaterialCardView

class AdapterSubTopicsDetails(val context: Context, val contentList: List<ModelSubTopic>) :
    RecyclerView.Adapter<AdapterSubTopicsDetails.HolderSubTopicsDetails>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderSubTopicsDetails {
        val view = LayoutInflater.from(context).inflate(R.layout.row_topic_content, parent, false)
        return HolderSubTopicsDetails(view)
    }

    override fun onBindViewHolder(holder: HolderSubTopicsDetails, position: Int) {
        var modelSubTopic = contentList[position]

        holder.titleTv.text = modelSubTopic.title
        holder.descriptionTv.text = modelSubTopic.description

    }

    override fun getItemCount(): Int {
        return contentList.size
    }

    inner class HolderSubTopicsDetails(itemView: View) : RecyclerView.ViewHolder(itemView){
        val titleTv: TextView = itemView.findViewById(R.id.titleTv)
        val descriptionTv: TextView = itemView.findViewById(R.id.descriptionTv)
    }

}
