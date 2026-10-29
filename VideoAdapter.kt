package com.example.youtubeclone

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class VideoAdapter(private val videoList: List<VideoModel>) :
    RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    class VideoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivThumbnail: ImageView = itemView.findViewById(R.id.ivThumbnail)
        val ivChannelProfile: CircleImageView = itemView.findViewById(R.id.ivChannelProfile)
        val tvVideoTitle: TextView = itemView.findViewById(R.id.tvVideoTitle)
        val tvChannelDetails: TextView = itemView.findViewById(R.id.tvChannelDetails)
        val tvDuration: TextView = itemView.findViewById(R.id.tvDuration)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_video, parent, false)
        return VideoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = videoList[position]

        holder.tvVideoTitle.text = video.title
        holder.tvChannelDetails.text = "${video.channelName} • ${video.views} • ${video.uploadedTime}"
        holder.tvDuration.text = video.duration

        Glide.with(holder.itemView.context)
            .load(video.thumbnailUrl)
            .into(holder.ivThumbnail)

        Glide.with(holder.itemView.context)
            .load(video.channelProfileUrl)
            .into(holder.ivChannelProfile)
    }

    override fun getItemCount(): Int = videoList.size
}
