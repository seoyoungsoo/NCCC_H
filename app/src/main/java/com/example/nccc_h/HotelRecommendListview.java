package com.example.nccc_h;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class HotelRecommendListview extends AppCompatActivity {

    private ListView recomListview = null;
    private RecommendAdapter recomAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_recommend_listview);

        recomListview = (ListView) findViewById(R.id.hotel_listview);

        recomAdapter = new RecommendAdapter(this);
        recomListview.setAdapter(recomAdapter);
    }

    private class ViewHolder {
        public ImageView hrImg;
        public TextView hrTitle;
        public RatingBar hrRating;
    }

    private class RecommendAdapter extends BaseAdapter {

        private Context hrContext = null;
        private ArrayList<RecomListviewData> recomListviewData = new ArrayList<RecomListviewData>();

        public RecommendAdapter(Context hrContext) {
            super();
            this.hrContext = hrContext;
        }

        @Override
        public int getCount() {
            return recomListviewData.size();
        }

        @Override
        public Object getItem(int position) {
            return recomListviewData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();

                LayoutInflater inflater = (LayoutInflater) hrContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.activity_hotel_recommendview, null);

                holder.hrImg = (ImageView) convertView.findViewById(R.id.hotel_recommend_img);
                holder.hrTitle = (TextView) convertView.findViewById(R.id.hotel_recommend_title);
                holder.hrRating = (RatingBar) convertView.findViewById(R.id.hotel_recommend_rating);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            RecomListviewData recomData = recomListviewData.get(position);

            if(recomData.getRecom_img() != null) {
                holder.hrImg.setVisibility(View.VISIBLE);
                //holder.hrImg.setImageDrawable(recomData.getRecom_img());
            } else {
                holder.hrImg.setVisibility(View.GONE);
            }

            holder.hrTitle.setText(recomData.getRecom_title());

            return convertView;
        }
    }
}
