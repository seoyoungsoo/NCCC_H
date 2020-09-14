package com.example.nccc_h;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;


public class Hotel {

    private String cityName;
    private String hotelName;
    private String hotelImg;
    private String rating;
    private String addShow;

    public Hotel(String cityName, String hotelName, String hotelImg, String rating, String addShow) {
        this.cityName = cityName;
        this.hotelName = hotelName;
        this.hotelImg = hotelImg;
        this.rating = rating;
        this.addShow = addShow;
    }

    public String getCityName() {
        return cityName;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getHotelImg() {
        return hotelImg;
    }

    public String getRating() {
        return rating;
    }

    public String getAddShow() {
        return addShow;
    }
}
