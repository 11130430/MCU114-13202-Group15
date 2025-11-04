package com.example.homework2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    TextView tvNumber;
    MyListener myListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNumber = findViewById(R.id.tvNumber);
        myListener = new MyListener(tvNumber, this);

        int[] btnIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btnClear, R.id.btnCall
        };

        for (int id : btnIds) {
            Button btn = findViewById(id);
            btn.setOnClickListener(myListener);
        }
    }
}
