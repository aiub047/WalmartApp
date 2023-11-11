package com.mak.walmartapp

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import java.io.File

class ItemDesc : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_desc)

        val ivItemLogo = findViewById<ImageView>(R.id.ivItemLogo)
        val ivItemImage = findViewById<ImageView>(R.id.ivItemImage)

        val tvItemName = findViewById<TextView>(R.id.tvItemName)
        val tvItemModel = findViewById<TextView>(R.id.tvItemModel)
        val tvItemDesc = findViewById<TextView>(R.id.tvItemDesc)

        tvItemName.text = intent.getStringExtra("itemName")
        tvItemModel.text = intent.getStringExtra("itemModel")
        tvItemDesc.text = intent.getStringExtra("itemPrice")

        val btnHome = findViewById<AppCompatButton>(R.id.btnHome)


        val fileImage = intent.getStringExtra("itemName")?.let { File(cacheDir, it) }
        val fileLogo = File(cacheDir, intent.getStringExtra("itemName") + "_logo")

        //Log.i("mak_findings", intent.getStringExtra("itemName") + "_logo")

        if (fileImage != null) {
            if (fileImage.exists()) {
                val imageBitmap = BitmapFactory.decodeFile(fileImage.absolutePath)
                ivItemImage.setImageBitmap(imageBitmap)
            }
        }

        if (fileLogo.exists()) {
            val logoBitmap = BitmapFactory.decodeFile(fileLogo.absolutePath)
            ivItemLogo.setImageBitmap(logoBitmap)
        }

        btnHome.setOnClickListener {
            finish()
        }
    }
}