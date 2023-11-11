package com.mak.walmartapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class ShoppingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val tvEmail = findViewById<TextView>(R.id.tvEmail)


        val sinIntent = intent //Java: Intent sinIntent = getIntent()
        tvEmail.text = sinIntent.getStringExtra("userName")

        val llElectronics = findViewById<LinearLayout>(R.id.llElectronics)

        llElectronics.setOnClickListener {
            val electronicsIntent = Intent(this, ItemListing::class.java)
            startActivity(electronicsIntent)
        }
    }
}