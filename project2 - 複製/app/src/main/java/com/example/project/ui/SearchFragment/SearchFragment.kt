package com.example.project.ui.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.project.DetailActivity
import com.example.project.R
import com.example.project.data.AppDatabase
import com.example.project.data.Attraction
import com.example.project.data.MockData
import com.example.project.databinding.FragmentSearchBinding
import com.example.project.ui.home.AttractionAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchFragment : Fragment(R.layout.fragment_search) {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentSearchBinding.bind(view)

        binding.btnSearch.setOnClickListener {
            val query = binding.editSearch.text.toString().trim()
            if (query.isNotEmpty()) {
                performSearch(query)
            } else {
                Toast.makeText(context, "請輸入地區或景點名稱", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun performSearch(query: String) {
        binding.progressBar.visibility = View.VISIBLE
        binding.recyclerSearchResults.visibility = View.GONE

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            delay(800)

            // 支援英文地名搜尋與多欄位比對
            val normalizedQuery = query.lowercase().trim()
            val keyword = when {
                normalizedQuery.contains("taipei") -> "台北"
                normalizedQuery.contains("taichung") -> "台中"
                normalizedQuery.contains("kaohsiung") -> "高雄"
                normalizedQuery.contains("tainan") -> "台南"
                else -> query
            }

            val results = MockData.recommendedAttractions.filter {
                it.name.contains(keyword, ignoreCase = true) ||
                        it.location.contains(keyword, ignoreCase = true)
            }

            withContext(Dispatchers.Main) {
                binding.progressBar.visibility = View.GONE
                binding.recyclerSearchResults.visibility = View.VISIBLE

                if (results.isNotEmpty()) {
                    binding.recyclerSearchResults.adapter = AttractionAdapter(
                        results,
                        onItemClick = { attraction ->
                            // ✅ 實作跳轉詳情頁
                            val intent = Intent(requireContext(), DetailActivity::class.java).apply {
                                putExtra("name", attraction.name)
                                putExtra("location", attraction.location)
                                putExtra("imageUrl", attraction.imageUrl)
                                putExtra("desc", attraction.description)
                            }
                            startActivity(intent)
                        },
                        onAddClick = { selectedItem ->
                            saveToPlan(selectedItem)
                        }
                    )
                } else {
                    Toast.makeText(context, "找不到結果", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun saveToPlan(attraction: Attraction) {
        // ✅ 檢查登入狀態
        val prefs = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val currentUser = prefs.getString("email", null)

        if (currentUser == null) {
            Toast.makeText(context, "請先登入才能加入行程！", Toast.LENGTH_SHORT).show()
            return
        }

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            val db = AppDatabase.getDatabase(requireContext())
            // ✅ 將帳號 Email 注入資料
            val attractionWithUser = attraction.copy(userId = currentUser)
            db.attractionDao().insertAttraction(attractionWithUser)

            withContext(Dispatchers.Main) {
                Toast.makeText(context, "已加入您的行程！", Toast.LENGTH_SHORT).show()
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}