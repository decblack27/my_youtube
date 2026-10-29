package com.example.youtubeclone

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup Toolbar
        setSupportActionBar(findViewById(R.id.toolbar))

        // Find RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewVideos)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Example: Open WebYouTubeActivity on startup or handle click
        // You can customize your video list adapter here
    }
}
