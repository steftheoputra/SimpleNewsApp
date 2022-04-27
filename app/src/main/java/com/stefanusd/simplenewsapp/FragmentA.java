package com.stefanusd.simplenewsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Arrays;

public class FragmentA extends Fragment {
    public static ArrayList<NewsData> newsData = new ArrayList<>(Arrays.asList(
        new NewsData("News title 1", "This is news content number 1\nPlease enjoy this first daily news\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus congue interdum ante, eu condimentum dui fermentum ut. Morbi consequat varius felis sit amet maximus. Sed sagittis fermentum nibh quis fringilla. Proin odio leo, malesuada quis ante a, tempus consequat libero. Aenean ut ipsum vitae odio fringilla dapibus. Nam at vestibulum lorem. In hac habitasse platea dictumst. Donec rutrum condimentum felis, ac venenatis massa vulputate vitae. Integer congue, lacus id luctus aliquet, lacus ipsum pretium nisi, sed finibus lectus massa nec nisl. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nunc feugiat massa massa, eu porta tellus posuere eu. Nullam vel nibh tristique, semper eros in, luctus ligula. Curabitur viverra, justo commodo auctor rutrum, erat eros dapibus leo, at lobortis lectus magna at nunc. In egestas sit amet dolor in varius. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Ut dolor lorem, pretium ut felis et, pulvinar pellentesque nisi."),
        new NewsData("News title 2", "This is news content number 2\nPlease enjoy this second daily news\nNulla nunc magna, scelerisque nec porttitor ut, interdum vel quam. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus et purus at metus tempor elementum. Pellentesque accumsan odio non erat porttitor tristique. In quis felis ut dui maximus sagittis id sed odio. Duis at tortor ex. Curabitur tristique ultrices semper. Nullam mattis, ante sit amet sollicitudin vulputate, sem purus feugiat tellus, sit amet egestas est sapien et mi. Aliquam erat volutpat. Quisque non eros eu felis interdum eleifend. Proin tincidunt nunc ligula, vitae fermentum lorem efficitur et. Curabitur lobortis dui eu ornare vestibulum. Phasellus augue libero, lacinia sit amet lacus in, ultricies vestibulum magna. Vestibulum nisl risus, auctor ac ullamcorper non, pharetra vel tellus. Proin volutpat metus commodo odio imperdiet, in posuere magna congue. Proin commodo ex urna, sed semper nulla varius eget.")
    ));
    public CustomArrayAdapter newsListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ListView newsList = view.findViewById(R.id.fragment_a_list);
        newsListAdapter = new CustomArrayAdapter(requireContext(), newsData);
        newsList.setAdapter(newsListAdapter);

        newsList.setOnItemClickListener((parent, view1, position, id) -> {
            MainActivity activity = (MainActivity) requireActivity();
            activity.refreshNewsContent(position, newsData.get(position));
        });
    }
}
