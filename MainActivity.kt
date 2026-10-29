package com.example.youtubeclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var videoAdapter: VideoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewVideos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // စမ်းသပ်ရန် Dummy Data များ
        val sampleList = listOf(
            VideoModel(
                "1", 
                "YouTube Clone App ရေးနည်း အစအဆုံး (Kotlin & ExoPlayer)", 
                "Dev Channel", 
                "15K views", 
                "2 days ago", 
                "12:45", 
                "https://img.youtube.com/vi/dQw4w9WgXcQ/hqdefault.jpg", 
                "https://via.placeholder.com/150", 
                "https://www.sample-videos.com/video123/mp4/720/big_buck_bunny_720p_1mb.mp4"
            )
        )

        videoAdapter = VideoAdapter(sampleList)
        recyclerView.adapter = videoAdapter
    }
}
