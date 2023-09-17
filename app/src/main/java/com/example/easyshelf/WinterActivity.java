package com.example.easyshelf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class WinterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winter);

    }
//here
    private void displayShoeInfo(String shoeInfo) {
        TextView textView = new TextView(this);
        textView.setText(shoeInfo);

        // Добавляем текстовое представление в LinearLayout для отображения
        LinearLayout layoutShoes = findViewById(R.id.layout_shoes);
        layoutShoes.addView(textView);
    }

//    here

}