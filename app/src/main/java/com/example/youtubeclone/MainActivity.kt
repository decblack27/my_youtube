package com.example.youtubeclone

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Toolbar ကို ဘေးကင်းစွာ ချိတ်ဆက်ခြင်း
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        if (toolbar != null) {
            setSupportActionBar(toolbar)
        }

        // RecyclerView ကို ချိတ်ဆက်ခြင်း
        val recyclerViewVideos = findViewById<RecyclerView>(R.id.recyclerViewVideos)
    }
}
