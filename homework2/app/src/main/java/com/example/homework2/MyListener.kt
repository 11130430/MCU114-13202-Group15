package com.example.homework2

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.view.View
import android.widget.Button
import android.widget.TextView

class MyListener(private val tvNumber: TextView, private val activity: Activity) :
    View.OnClickListener {

    override fun onClick(v: View?) {
        if (v is Button) {
            val text = v.text.toString()
            val current = tvNumber.text.toString().replace("電話號碼：", "")

            when (text) {
                "清除" -> tvNumber.text = "電話號碼："
                "CALL" -> {
                    if (current.isNotEmpty()) {
                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$current"))
                        activity.startActivity(intent)
                    }
                }
                else -> tvNumber.text = "電話號碼：$current$text"
            }
        }
    }
}
