package com.example.nccc_h;

import android.graphics.drawable.Drawable;

public class RecomListviewData {
    private Drawable recom_img;
    private String recom_title;
    private String recom_value;

    public RecomListviewData(Drawable recom_img, String recom_title, String recom_value) {
        this.recom_img = recom_img;
        this.recom_title = recom_title;
        this.recom_value = recom_value;
    }

    public Drawable getRecom_img() {
        return recom_img;
    }

    public void setRecom_img(Drawable recom_img) {
        this.recom_img = recom_img;
    }

    public String getRecom_title() {
        return recom_title;
    }

    public void setRecom_title(String recom_title) {
        this.recom_title = recom_title;
    }

    public String getRecom_value() {
        return recom_value;
    }

    public void setRecom_value(String recom_value) {
        this.recom_value = recom_value;
    }

}
