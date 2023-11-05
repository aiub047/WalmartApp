package com.mak.walmartapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val tvEmail = findViewById<TextView>(R.id.tvEmail)


        val sinIntent = intent //Java: Intent sinIntent = getIntent()
        tvEmail.text = sinIntent.getStringExtra("userName")
    }
}