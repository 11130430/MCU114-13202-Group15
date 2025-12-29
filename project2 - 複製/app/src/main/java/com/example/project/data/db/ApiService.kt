package com.example.project.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    // 取得全台景點，並根據關鍵字過濾名稱
    @GET("v2/Tourism/ScenicSpot")
    fun searchOnlineAttractions(
        @Query("\$filter") filter: String, // 例如: contains(ScenicSpotName, '台北')
        @Query("\$top") top: Int = 20,     // 只抓前 20 筆
        @Query("\$format") format: String = "JSON"
    ): Call<List<ApiAttraction>>
}