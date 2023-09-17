package com.example.easyshelf;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import android.app.Dialog;


public class DialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_layout);

        AppCompatButton btn1 = findViewById(R.id.btn_1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a dialog
                Dialog dialog = new Dialog(DialogActivity.this);

                // Set the content view to the layout associated with WinterActivity
                dialog.setContentView(R.layout.activity_winter);

                // You can customize the dialog as needed, e.g., set a title, etc.

                // Show the dialog
                dialog.show();
            }
        });
    }
}


