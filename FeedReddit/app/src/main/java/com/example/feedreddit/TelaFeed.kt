package com.example.feedreddit

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity


class TelaFeed : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_feed)
    }

    fun returnToHomeScreen(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}