package com.example.project.data

import com.google.gson.annotations.SerializedName

data class ApiAttraction(
    @SerializedName("ScenicSpotName") val name: String, // 景點名稱 [cite: 21]
    @SerializedName("Address") val location: String,    // 地點 [cite: 21]
    @SerializedName("Picture") val picture: PictureInfo?
)

data class PictureInfo(
    @SerializedName("PictureUrl1") val imageUrl: String // 圖片網址 [cite: 21]
)