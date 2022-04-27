package com.stefanusd.simplenewsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;

public class FragmentB extends Fragment {
    private TextView titleText, contentText;
    private ImageView newsImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        titleText = view.findViewById(R.id.fragment_b_title);
        contentText = view.findViewById(R.id.fragment_b_content);
        newsImage = view.findViewById(R.id.fragment_b_image);
    }

    public void refreshNewsContent(int position, NewsData newsData) {
        titleText.setText(newsData.title);
        contentText.setText(newsData.content);
        switch(position % 3) {
            case 0:
                Glide.with(requireContext())
                    .load(R.drawable.news1)
                    .fitCenter()
                    .into(newsImage);
                break;
            case 1:
                Glide.with(requireContext())
                    .load(R.drawable.news2)
                    .fitCenter()
                    .into(newsImage);
                break;
            case 2:
                Glide.with(requireContext())
                    .load(R.drawable.news3)
                    .fitCenter()
                    .into(newsImage);
                break;
        }
    }
}
