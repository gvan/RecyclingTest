package com.example.recyclingtest.adatepr.view_holder;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclingtest.R;
import com.example.recyclingtest.data.model.NewsItem;

import net.admixer.sdk.AdListener;
import net.admixer.sdk.AdView;
import net.admixer.sdk.BannerAdView;
import net.admixer.sdk.NativeAdResponse;
import net.admixer.sdk.ResultCode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.internal.Utils;

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

    public void showBanner(BannerAdView bav) {
        itemView.removeAllViews();;
        itemView.addView(bav);
    }

    public void showBanner(NewsItem item) {
        if(itemView.getChildCount() == 0) {
            BannerAdView bav = new BannerAdView(context);
            bav.setPlacementID(item.getZoneId());
            bav.setAdSizes(item.getAdSizes());
            bav.setExpandsToFitScreenWidth(true);
            bav.setResizeAdToFitContainer(true);
            bav.loadAd();
            bav.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded(AdView adView) {

                    Log.d("MyCustomLog", String.format("creative_id: %s", adView.getCreativeId()));
                }

                @Override
                public void onAdLoaded(NativeAdResponse nativeAdResponse) {

                }

                @Override
                public void onAdRequestFailed(AdView adView, ResultCode resultCode) {

                }

                @Override
                public void onAdExpanded(AdView adView) {

                }

                @Override
                public void onAdCollapsed(AdView adView) {

                }

                @Override
                public void onAdClicked(AdView adView) {

                }

                @Override
                public void onAdClicked(AdView adView, String s) {

                }
            });

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
