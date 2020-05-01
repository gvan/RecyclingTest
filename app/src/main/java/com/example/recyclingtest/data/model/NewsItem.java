package com.example.recyclingtest.data.model;

import net.admixer.sdk.AdSize;

import java.util.ArrayList;
import java.util.List;

public class NewsItem {

    private String title;
    private String zoneId;
    private ArrayList<AdSize> adSizes;
    private int important;

    public NewsItem() {
    }

    public NewsItem(String title) {
        this.title = title;
        this.important = 0;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getZoneId() {
        return zoneId;
    }

    public void setZoneId(String zoneId) {
        this.zoneId = zoneId;
    }

    public int getImportant() {
        return important;
    }

    public void setImportant(int important) {
        this.important = important;
    }

    public ArrayList<AdSize> getAdSizes() {
        return adSizes;
    }

    public void setAdSizes(ArrayList<AdSize> adSizes) {
        this.adSizes = adSizes;
    }
}
