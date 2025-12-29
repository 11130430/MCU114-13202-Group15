package com.example.project.ui.plan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project.R
import com.example.project.data.Attraction

class PlannedAttractionAdapter(
    private val attractions: List<Attraction>,
    private val onItemClick: (Attraction) -> Unit,
    private val onDeleteClick: (Attraction) -> Unit
) : RecyclerView.Adapter<PlannedAttractionAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // ✅ 關鍵 1：確認這些 R.id.xxxx 在你的 item_attraction.xml 裡拼字完全正確
        val name: TextView = view.findViewById(R.id.text_name)
        val location: TextView = view.findViewById(R.id.text_location)
        val image: ImageView = view.findViewById(R.id.image_attraction)
        val actionButton: Button = view.findViewById(R.id.button_add_to_plan)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // ✅ 這裡沿用 item_attraction 是沒問題的，因為結構一樣
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_attraction, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val attraction = attractions[position]

        holder.name.text = attraction.name
        holder.location.text = attraction.location

        Glide.with(holder.itemView.context)
            .load(attraction.imageUrl)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .into(holder.image)

        holder.itemView.setOnClickListener {
            onItemClick(attraction)
        }

        // ✅ 關鍵 2：強制將按鈕文字改為「刪除」，並綁定刪除邏輯
        holder.actionButton.visibility = View.VISIBLE
        holder.actionButton.text = "刪除行程"
        holder.actionButton.setOnClickListener {
            onDeleteClick(attraction)
        }
    }

    override fun getItemCount() = attractions.size
}