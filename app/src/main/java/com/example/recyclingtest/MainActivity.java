package com.example.recyclingtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclingtest.R;
import com.example.recyclingtest.adatepr.MainAdapter;
import com.example.recyclingtest.data.model.NewsItem;

import net.admixer.sdk.AdSize;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recycler = findViewById(R.id.recycler);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        MainAdapter adapter = new MainAdapter();
        recycler.setAdapter(adapter);


        List<NewsItem> items = new ArrayList<>();
        for(int i = 0;i < 40;i++) {
            items.add(new NewsItem(String.format("Title %s\nSubtitle\nContent\n", i)));
        }

        for(int i = 0;i <= 20;i++) {
            if(i % 3 == 0) {
                NewsItem item = new NewsItem();
                item.setZoneId("27f210ac-a998-4e44-a9c5-f1064ef60ed4");
                ArrayList<AdSize> adSizes = new ArrayList<>();
                adSizes.add(new AdSize(1014, 338));
                adSizes.add(new AdSize(1014, 845));
                item.setAdSizes(adSizes);
                item.setImportant(2);
                items.add(i, item);
            }
        }

        for(int i = 21;i <= 40;i++) {
            if(i % 3 == 0) {
                NewsItem item = new NewsItem();
                item.setZoneId("e6822eec-8954-4ddc-a6b5-4f791b6603fd");
                ArrayList<AdSize> adSizes = new ArrayList<>();
                adSizes.add(new AdSize(300, 250));
                item.setAdSizes(adSizes);
                item.setImportant(3);
                items.add(i, item);
            }
        }

        adapter.setData(items);
    }
}
