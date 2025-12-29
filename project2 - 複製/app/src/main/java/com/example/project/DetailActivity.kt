package com.example.project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.project.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. 接收 Intent 傳過來的資料
        val name = intent.getStringExtra("name")
        val location = intent.getStringExtra("location")
        val imageUrl = intent.getStringExtra("imageUrl")
        val desc = intent.getStringExtra("desc")

        // 2. 將資料放到對應的 UI 元件
        binding.tvDetailName.text = name
        binding.tvDetailLocation.text = location
        binding.tvDetailDesc.text = desc

        // 3. 使用 Glide 載入圖片
        Glide.with(this)
            .load(imageUrl)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .into(binding.imgDetail)

        // 設定點擊返回
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = name
    }

    override fun onSupportNavigateUp(): Boolean {
        finish() // 點擊左上角返回按鈕關閉頁面
        return true
    }
}