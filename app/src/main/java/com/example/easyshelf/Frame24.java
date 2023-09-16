package com.example.easyshelf;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.easyshelf.R;

public class Frame24 extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame24);

        ImageButton btnForShelf = findViewById(R.id.btn_for_shelf);

        btnForShelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Создаем AlertDialog
                AlertDialog.Builder builder = new AlertDialog.Builder(Frame24.this);

                // Устанавливаем макет для диалогового окна с фоном-обводкой
                View dialogView = getLayoutInflater().inflate(R.layout.dialog_layout, null);
                builder.setView(dialogView);


                // Устанавливаем кнопку "Закрыть"
                builder.setPositiveButton("Закрыть", null);

                // Показываем диалоговое окно
                AlertDialog dialog = builder.create();
                dialog.show();

                // Устанавливаем фон-обводку для диалогового окна
                dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_button24);
            }
        });
    }
}
