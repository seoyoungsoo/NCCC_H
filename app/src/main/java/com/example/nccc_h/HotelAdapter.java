package com.example.nccc_h;

import android.content.Intent;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {

    private ArrayList<Hotel> items = new ArrayList<>();

    String hotelname, cityname;

    public interface OnItemClickListener {
        void onItemClick(View v, int position);
    }

    private OnItemClickListener mListener = null;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public HotelAdapter(ArrayList<Hotel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public HotelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_hotel_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull HotelAdapter.ViewHolder viewHolder, int position) {
        Hotel item = items.get(position);

        Glide.with(viewHolder.itemView.getContext())
                .load(item.getHotelImg())
                .into(viewHolder.htlImg);

        Glide.with(viewHolder.itemView.getContext())
                .load(item.getAddShow())
                .into(viewHolder.htlAddShow);

        viewHolder.htlCity.setText(item.getCityName());
        viewHolder.htlName.setText(item.getHotelName());
        viewHolder.htlRating.setRating(Float.parseFloat(item.getRating()));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<Hotel> items) {
        this.items = items;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView htlImg, htlAddShow;
        TextView htlCity, htlName;
        RatingBar htlRating;

        ViewHolder(final View itemView) {
            super(itemView);

            htlCity = itemView.findViewById(R.id.hotel_city);
            htlImg = itemView.findViewById(R.id.hotel_img);
            htlName = itemView.findViewById(R.id.hotel_title);
            htlRating = itemView.findViewById(R.id.hotel_rating);
            htlAddShow = itemView.findViewById(R.id.hotel_addshow);

            /*htlAddShow.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(itemView.getContext(), HotelDetail2.class);
                    i.putExtra("hotelname", hotelname);
                    i.putExtra("cityname", cityname);
                    itemView.getContext().startActivity(i);
                }
            });*/

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION) {
                        if (mListener != null) {
                            mListener.onItemClick(v, pos);
                        }
                    }
                }
            });
        }
    }

}
