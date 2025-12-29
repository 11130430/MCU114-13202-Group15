package com.example.project.ui.user

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.project.R
import com.example.project.databinding.FragmentUserBinding

class UserFragment : Fragment(R.layout.fragment_user) {

    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUserBinding.bind(view)

        val authPrefs = requireActivity().getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val savedEmail = authPrefs.getString("email", null)

        // 初始化狀態
        if (savedEmail != null) {
            showProfile(savedEmail)
        } else {
            showLoginLayout()
        }

        // --- 註冊邏輯 ---
        binding.btnRegister.setOnClickListener {
            val email = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()

            if (email.endsWith("@gmail.com") && password.length >= 6) {
                authPrefs.edit().putString("pwd_$email", password).apply()
                Toast.makeText(context, "註冊成功！請登入", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "格式錯誤或密碼太短", Toast.LENGTH_SHORT).show()
            }
        }

        // --- 登入邏輯 ---
        binding.btnLogin.setOnClickListener {
            val email = binding.editUsername.text.toString()
            val password = binding.editPassword.text.toString()
            val savedPassword = authPrefs.getString("pwd_$email", null)

            if (savedPassword == password) {
                authPrefs.edit().putString("email", email).apply()
                showProfile(email)
                Toast.makeText(context, "登入成功！", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.navigation_home)
            } else {
                Toast.makeText(context, "密碼錯誤或帳號不存在", Toast.LENGTH_SHORT).show()
            }
        }

        // --- 登出邏輯 ---
        binding.btnLogout.setOnClickListener {
            // ✅ 只移除登入狀態，保留註冊資料，這樣才不會導致無法登入
            authPrefs.edit().remove("email").apply()
            showLoginLayout()
            Toast.makeText(context, "已登出", Toast.LENGTH_SHORT).show()
        }
    } // 👈 onViewCreated 在這裡結束

    // ✅ 這些函式必須在 onViewCreated 之外，但在 UserFragment 之內
    private fun showLoginLayout() {
        binding.layoutLogin.visibility = View.VISIBLE
        binding.layoutProfile.visibility = View.GONE
        binding.editUsername.text.clear()
        binding.editPassword.text.clear()
    }

    private fun showProfile(username: String) {
        binding.layoutLogin.visibility = View.GONE
        binding.layoutProfile.visibility = View.VISIBLE
        binding.textWelcome.text = "您好！\n已登入帳號：$username"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}