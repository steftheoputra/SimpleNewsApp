package com.stefanusd.simplenewsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomArrayAdapter extends ArrayAdapter<NewsData> {
    private Context context;
    private ArrayList<NewsData> newsData;

    public CustomArrayAdapter(@NonNull Context context, ArrayList<NewsData> newsData) {
        super(context, 0, newsData);
        this.context = context;
        this.newsData = newsData;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View customView = convertView;
        if(customView == null)
            customView = LayoutInflater.from(context).inflate(R.layout.item_news, parent, false);

        TextView titleText = customView.findViewById(R.id.item_news_title);
        TextView contentText = customView.findViewById(R.id.item_news_content);

        String title = newsData.get(position).title;
        String content = newsData.get(position).content;

        if(title.length() > 10)
            title = title.substring(0, 10) + "...";
        if(content.length() > 30)
            content = content.substring(0, 30) + "...";

        titleText.setText(title);
        contentText.setText(content);

        return customView;
    }
}
