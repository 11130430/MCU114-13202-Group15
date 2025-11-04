package com.example.homework2;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MyListener implements View.OnClickListener {

    private TextView tvNumber;
    private Activity activity;

    public MyListener(TextView tvNumber, Activity activity) {
        this.tvNumber = tvNumber;
        this.activity = activity;
    }

    @Override
    public void onClick(View v) {
        if (v instanceof Button) {
            Button btn = (Button) v;
            String text = btn.getText().toString();
            String current = tvNumber.getText().toString().replace("電話號碼：", "");

            switch (text) {
                case "清除":
                    tvNumber.setText("電話號碼：");
                    break;
                case "CALL":
                    if (!current.isEmpty()) {
                        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + current));
                        activity.startActivity(intent);
                    }
                    break;
                default:
                    tvNumber.setText("電話號碼：" + current + text);
                    break;
            }
        }
    }
}
