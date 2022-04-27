package com.stefanusd.simplenewsapp;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultCaller;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public FragmentA fragmentA;
    public FragmentB fragmentB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addButton = findViewById(R.id.main_add);

        fragmentA = new FragmentA();
        fragmentB = new FragmentB();

        FragmentTransaction fta = getSupportFragmentManager().beginTransaction();
        fta.replace(R.id.main_fragment_a, fragmentA);
        fta.commit();
        FragmentTransaction ftb = getSupportFragmentManager().beginTransaction();
        ftb.replace(R.id.main_fragment_b, fragmentB);
        ftb.commit();

        ActivityResultLauncher<Intent> addNewsLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        String title = data.getStringExtra("title");
                        String content = data.getStringExtra("content");
                        FragmentA.newsData.add(new NewsData(title, content));
                        fragmentA.newsListAdapter.notifyDataSetChanged();
                    }
                });

        addButton.setOnClickListener(listener -> {
            addNewsLauncher.launch(new Intent(this, AddActivity.class));
        });
    }

    public void refreshNewsContent(int position, NewsData newsData) {
        fragmentB.refreshNewsContent(position, newsData);
    }
}