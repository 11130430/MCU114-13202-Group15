package com.example.project.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.project.R
import com.example.project.data.Attraction
import com.bumptech.glide.Glide

// 1. 定義 ViewHolder
class AttractionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val name: TextView = itemView.findViewById(R.id.text_name)
    val location: TextView = itemView.findViewById(R.id.text_location)
    val image: ImageView = itemView.findViewById(R.id.image_attraction)
    val addButton: Button = itemView.findViewById(R.id.button_add_to_plan)
}

// 2. 定義 Adapter
class AttractionAdapter(
    private val attractions: List<Attraction>,
    private val onItemClick: (Attraction) -> Unit,
    private val onAddClick: (Attraction) -> Unit
) : RecyclerView.Adapter<AttractionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttractionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_attraction, parent, false)
        return AttractionViewHolder(view)
    }

    override fun onBindViewHolder(holder: AttractionViewHolder, position: Int) {
        val attraction = attractions[position]

        // 綁定文字資料
        holder.name.text = attraction.name
        holder.location.text = attraction.location

        // 使用 Glide 載入圖片
        Glide.with(holder.itemView.context)
            .load(attraction.imageUrl)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(R.drawable.ic_home_black_24dp)
            .into(holder.image)

        // 【功能實現】點擊整個項目（或圖片）觸發跳轉詳情頁
        holder.itemView.setOnClickListener {
            onItemClick(attraction)
        }

        // 點擊「加入行程」按鈕
        holder.addButton.setOnClickListener {
            onAddClick(attraction)
        }
    }

    override fun getItemCount() = attractions.size

}