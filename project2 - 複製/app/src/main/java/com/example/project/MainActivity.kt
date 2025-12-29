package com.example.project

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController

        // 攔截邏輯
        navController.addOnDestinationChangedListener { _, destination, _ ->
            val prefs = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)

            // ✅ 修正點：不要只用 contains，要檢查值是否為空或 null
            val savedEmail = prefs.getString("email", null)
            val isLoggedIn = !savedEmail.isNullOrEmpty()

            // 如果要去的地方不是「首頁」也不是「登入頁」，且未登入
            if (destination.id != R.id.navigation_home &&
                destination.id != R.id.navigation_user && !isLoggedIn) {

                // 使用 post 確保 Fragment 切換穩定，避免在生命週期中崩潰
                binding.root.post {
                    if (navController.currentDestination?.id != R.id.navigation_user) {
                        navController.navigate(R.id.navigation_user)
                        Toast.makeText(this, "請先登入才能使用此功能", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }

        binding.navView.itemIconTintList = null
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.navigation_home, R.id.navigation_search, R.id.navigation_plan, R.id.navigation_user)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }
}