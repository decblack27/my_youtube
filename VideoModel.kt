package com.example.youtubeclone

data class VideoModel(
    val videoId: String,
    val title: String,
    val channelName: String,
    val views: String,
    val uploadedTime: String,
    val duration: String,
    val thumbnailUrl: String,
    val channelProfileUrl: String,
    val videoUrl: String
)
