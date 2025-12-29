package com.example.project.ui.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project.DetailActivity
import com.example.project.R
import com.example.project.data.AppDatabase
import com.example.project.data.Attraction
import com.example.project.data.MockData
import com.example.project.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        val attractionsList = MockData.recommendedAttractions

        val adapter = AttractionAdapter(
            attractions = attractionsList,
            onItemClick = { attraction ->
                val intent = Intent(requireContext(), DetailActivity::class.java).apply {
                    putExtra("name", attraction.name)
                    putExtra("location", attraction.location)
                    putExtra("imageUrl", attraction.imageUrl)
                    putExtra("desc", attraction.description)
                }
                startActivity(intent)
            },
            onAddClick = { selectedItem ->
                // ✅ 這裡呼叫 saveToPlan
                saveToPlan(selectedItem)
            }
        )

        binding.recyclerViewAttractions.apply {
            this.adapter = adapter
            this.layoutManager = LinearLayoutManager(context)
        }
    }

    // ✅ 確保 saveToPlan 是獨立在 class 裡面的函式，不要塞在 setupRecyclerView 裡面
    private fun saveToPlan(attraction: Attraction) {
        val authPrefs = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val currentUser = authPrefs.getString("email", null)

        if (currentUser == null) {
            Toast.makeText(context, "請先登入才能加入行程！", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.navigation_user)
            return
        }

        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.IO) {
            try {
                val db = AppDatabase.getDatabase(requireContext())

                // ✅ 關鍵修正：將 id 設為 0，讓 Room 自動產生新 ID，避免與 MockData 重複
                // 同時確保所有新欄位 (userId, latitude, longitude) 都被 copy 進去
                val attractionWithUser = attraction.copy(
                    id = 0,
                    userId = currentUser,
                    latitude = attraction.latitude,
                    longitude = attraction.longitude
                )

                db.attractionDao().insertAttraction(attractionWithUser)

                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "成功加入：${attraction.name}", Toast.LENGTH_SHORT).show()
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    // 如果失敗，在 Logcat 搜尋 "DB_ERROR" 就能看到原因
                    android.util.Log.e("DB_ERROR", "失敗原因: ${e.message}")
                    Toast.makeText(context, "加入失敗，原因：${e.localizedMessage}", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}