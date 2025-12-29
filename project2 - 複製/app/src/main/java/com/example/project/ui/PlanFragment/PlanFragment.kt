package com.example.project.ui.plan

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.DetailActivity
import com.example.project.R
import com.example.project.data.Attraction
// ✅ 重要：修正為你最新的資料庫路徑
import com.example.project.data.db.AppDatabase
import com.example.project.databinding.FragmentPlanBinding
import com.google.android.gms.location.LocationServices
import kotlinx.coroutines.*

class PlanFragment : Fragment(R.layout.fragment_plan) {
    private var _binding: FragmentPlanBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPlanBinding.bind(view)

        // 1. 設定 AI 按鈕監聽
        binding.btnAiOptimize?.setOnClickListener {
            checkPermissionAndOptimize()
        }

        loadPlannedAttractions()
    }

    override fun onResume() {
        super.onResume()
        loadPlannedAttractions()
    }

    private fun loadPlannedAttractions() {
        // ✅ 確保與 UserFragment 存入的 Key 一致：使用 "email"
        val authPrefs = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val currentUser = authPrefs.getString("email", "") ?: ""

        if (currentUser.isEmpty()) {
            // 如果沒登入，隱藏清單
            binding.recyclerPlan.visibility = View.GONE
            return
        }

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            try {
                // ✅ 透過正確路徑的 AppDatabase 取得資料
                val db = AppDatabase.getDatabase(requireContext())
                val list = db.attractionDao().getPlannedByUserId(currentUser)
                withContext(Dispatchers.Main) {
                    updateUI(list)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun checkPermissionAndOptimize() {
        if (ContextCompat.checkSelfPermission(requireContext(), Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED) {
            getDeviceLocationAndOptimize()
        } else {
            requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 100)
        }
    }

    private fun getDeviceLocationAndOptimize() {
        val fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        try {
            fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
                if (location != null) {
                    optimizeByLocation(location.latitude, location.longitude)
                } else {
                    // 保底方案：桃園車站
                    Toast.makeText(context, "正在模擬目前位置...", Toast.LENGTH_SHORT).show()
                    optimizeByLocation(24.9892, 121.3135)
                }
            }
        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }

    private fun optimizeByLocation(userLat: Double, userLng: Double) {
        val authPrefs = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val currentUser = authPrefs.getString("email", "") ?: ""

        if (currentUser.isEmpty()) return

        Toast.makeText(context, "AI 正在重新規劃您的行程順序...", Toast.LENGTH_SHORT).show()

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            try {
                val db = AppDatabase.getDatabase(requireContext())
                val list = db.attractionDao().getPlannedByUserId(currentUser)

                if (list.isNotEmpty()) {
                    // ✅ AI 排序演算法 (由近到遠)
                    val optimizedList = list.sortedBy { attraction ->
                        val results = FloatArray(1)
                        Location.distanceBetween(userLat, userLng, attraction.latitude, attraction.longitude, results)
                        results[0]
                    }

                    delay(800) // 模擬 AI 運算

                    withContext(Dispatchers.Main) {
                        updateUI(optimizedList)
                        Toast.makeText(context, "✨ 已為您排出最佳順序！", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "優化失敗", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun updateUI(list: List<Attraction>) {
        if (list.isEmpty()) {
            binding.recyclerPlan.visibility = View.GONE
        } else {
            binding.recyclerPlan.visibility = View.VISIBLE
            binding.recyclerPlan.layoutManager = LinearLayoutManager(requireContext())
            // ✅ 這裡會用到你寫好的 Adapter
            binding.recyclerPlan.adapter = PlannedAttractionAdapter(
                attractions = list,
                onItemClick = { item ->
                    val intent = Intent(requireContext(), DetailActivity::class.java).apply {
                        putExtra("name", item.name)
                        putExtra("location", item.location)
                        putExtra("imageUrl", item.imageUrl)
                        putExtra("desc", item.description)
                    }
                    startActivity(intent)
                },
                onDeleteClick = { item -> deleteItem(item) }
            )
        }
    }

    private fun deleteItem(attraction: Attraction) {
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            AppDatabase.getDatabase(requireContext()).attractionDao().deleteAttraction(attraction)
            loadPlannedAttractions()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}