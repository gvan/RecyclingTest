package com.example.recyclingtest.adatepr;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclingtest.R;
import com.example.recyclingtest.adatepr.view_holder.ItemViewHolder;
import com.example.recyclingtest.data.model.NewsItem;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<NewsItem> items = new ArrayList<>();

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
                holder.showBanner(newsItem);
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
