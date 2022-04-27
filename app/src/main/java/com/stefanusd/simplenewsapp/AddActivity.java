package com.stefanusd.simplenewsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        TextView titleEdit = findViewById(R.id.add_title);
        TextView contentEdit = findViewById(R.id.add_content);
        Button addButton = findViewById(R.id.add_action);

        addButton.setOnClickListener(listener -> {
            Intent data = new Intent();
            String title = titleEdit.getText().toString();
            String content = contentEdit.getText().toString();
            if(title.length() > 0 && content.length() > 0) {
                data.putExtra("title", title);
                data.putExtra("content", content);
                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });
    }
}