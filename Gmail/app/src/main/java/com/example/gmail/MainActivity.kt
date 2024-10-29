package com.example.gmail

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gmail.adapters.EmailAdapter
import com.example.gmail.models.EmailModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val emailList = listOf(
            EmailModel(
                resources.getIdentifier("thumb_e", "mipmap", packageName),
                "Education.com",
                "10:23 PM",
                "$90 only",
                "Do you want a course to learn Kotlin?"),
            EmailModel(
                resources.getIdentifier("thumb_c", "mipmap", packageName),
                "Cristiano Ronaldo",
                "11:22 AM",
                "Play football with me?",
                "Together playing football, please!"),
            EmailModel(
                resources.getIdentifier("thumb_t", "mipmap", packageName),
                "Techcombank",
                "11:04 AM",
                "Notify about security ",
                "Security ..."),
            EmailModel(
                resources.getIdentifier("thumb_s", "mipmap", packageName),
                "Soccer club",
                "10:26 AM",
                "Sunday: notify a match",
                "We have a match on Sunday."),
            EmailModel(
                resources.getIdentifier("thumb_m", "mipmap", packageName),
                "May",
                "10:00 AM",
                "Can we go to the cinema on Saturday?",
                "A new film ..."),
            EmailModel(
                resources.getIdentifier("thumb_e", "mipmap", packageName),
                "Education",
                "12:34 PM",
                "HUST notify",
                "There are many courses at daotao.ai"),
            EmailModel(
                resources.getIdentifier("thumb_c", "mipmap", packageName),
                "C booking",
                "11:22 AM",
                "Booking advertisementt",
                "We want to book you with a post in Instagram "),
            EmailModel(
                resources.getIdentifier("thumb_t", "mipmap", packageName),
                "Tuto.com",
                "11:04 AM",
                "8h de formation gratuite et les nouvea...",
                "Photoshop, SEO, Blender, CSS, WordPress"),
            EmailModel(
                resources.getIdentifier("thumb_s", "mipmap", packageName),
                "support",
                "10:26 AM",
                "Société Ovh : suivi de vos services - hp...",
                "SAS OVH - http://www.ovh.com 2 rue K..."),
            EmailModel(
                resources.getIdentifier("thumb_m", "mipmap", packageName),
                "Matt from Ionic",
                "10:00 AM",
                "The New Ionic Creator Is Here!",
                "Announcing the all-new Creator, build..."),
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EmailAdapter(emailList)
    }
}