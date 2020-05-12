package com.example.recyclingtest.adatepr;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclingtest.BannerPool;
import com.example.recyclingtest.R;
import com.example.recyclingtest.adatepr.view_holder.ItemViewHolder;
import com.example.recyclingtest.data.model.NewsItem;

import net.admixer.sdk.AdSize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NewsItem> items = new ArrayList<>();
    private Map<String, BannerPool> bannerPool = new HashMap<>();

    public MainAdapter(Context context, String zone1, ArrayList<AdSize> adSizes1, String zone2, ArrayList<AdSize> adSizes2) {
        BannerPool pool1 = new BannerPool(zone1, adSizes1, context);
        BannerPool pool2 = new BannerPool(zone2, adSizes2, context);

        bannerPool.put(zone1, pool1);
        bannerPool.put(zone2, pool2);
    }

    @Override
    public int getItemViewType(int position) {
        return items.get(position).getImportant();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_news, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder h, int position) {
        NewsItem newsItem = items.get(position);
        if(h instanceof ItemViewHolder) {
            ItemViewHolder holder = (ItemViewHolder) h;
            if(newsItem.getImportant() == 2 || newsItem.getImportant() == 3) {
                String zoneId = newsItem.getZoneId();
                holder.showBanner(bannerPool.get(zoneId).getAd());
                return;
            }

            holder.showTitle(newsItem.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setData(List<NewsItem> items) {
        this.items.addAll(items);
    }

}
