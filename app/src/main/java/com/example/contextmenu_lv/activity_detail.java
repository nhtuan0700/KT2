package com.example.contextmenu_lv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class activity_detail extends AppCompatActivity {
    TextView tvName,tvPhone;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra(MainActivity.BUNDLE);
        String name = bundle.getString("NAME");
        String phone = bundle.getString("PHONE");
        int image = bundle.getInt("IMAGE");
        tvName = findViewById(R.id.tv_name);
        tvPhone = findViewById(R.id.tv_phone);
        imageView = findViewById(R.id.image);
        tvName.setText(name);
        tvPhone.setText(phone);
        imageView.setImageResource(image);
    }
}