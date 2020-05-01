package com.example.recyclingtest.adatepr.view_holder;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclingtest.R;
import com.example.recyclingtest.data.model.NewsItem;

import net.admixer.sdk.BannerAdView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.title)
    TextView titleView;
    @BindView(R.id.item)
    FrameLayout itemView;
    Context context;

    public ItemViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        this.context = itemView.getContext();
    }

    public void showBanner(NewsItem item) {
        if(itemView.getChildCount() == 0) {
            BannerAdView bav = new BannerAdView(context);
            bav.setPlacementID(item.getZoneId());
            bav.setAdSizes(item.getAdSizes());
            bav.setExpandsToFitScreenWidth(true);
            bav.setResizeAdToFitContainer(true);
            bav.loadAd();

            itemView.addView(bav);
        }
//        else {
//            BannerAdView bav = (BannerAdView) itemView.getChildAt(0);
//            bav.loadAd();
//        }

    }

    public void showTitle(String title) {
        titleView.setText(title);
    }

}
