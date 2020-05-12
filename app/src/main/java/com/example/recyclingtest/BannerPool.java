package com.example.recyclingtest;

import android.content.Context;

import net.admixer.sdk.AdSize;
import net.admixer.sdk.BannerAdView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BannerPool {

    private String zoneId;
    private ArrayList<AdSize> adSizes;
    private Context context;
    private Stack<BannerAdView> banners = new Stack<>();

    public BannerPool(String zoneId, ArrayList<AdSize> adSizes, Context context) {
        this.zoneId = zoneId;
        this.adSizes = adSizes;
        this.context = context;

        for(int i = 0;i < 3;i++) {
            addBanner();
        }
    }

    public BannerAdView getAd(){
        BannerAdView bav = banners.pop();

        addBanner();

        return bav;
    }

    private void addBanner(){
        BannerAdView bav = new BannerAdView(context);
        bav.setPlacementID(zoneId);
        bav.setAdSizes(adSizes);
        bav.setResizeAdToFitContainer(true);

        bav.loadAd();
        banners.add(0, bav);
    }

}
