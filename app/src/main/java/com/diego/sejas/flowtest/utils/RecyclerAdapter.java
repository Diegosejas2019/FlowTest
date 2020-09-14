package com.diego.sejas.flowtest.utils;

import android.content.Context;
import android.icu.text.UnicodeSetSpanner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.diego.sejas.flowtest.R;
import com.diego.sejas.flowtest.models.WeatherResponse;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.HolderView> {
    Context context;
    List<WeatherResponse> weatherList;

    public RecyclerAdapter(Context context, List<WeatherResponse> mainList) {
        this.context = context;
        this.weatherList = mainList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview_row, parent,false);
        return new HolderView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.HolderView holder, int position) {

        java.util.Date time=new java.util.Date(weatherList.get(0).lista.get(position).date*1000);
        String timeText = time + "\n" +  weatherList.get(0).lista.get(position).weather.get(0).getMain();
        String temText = "Temp :" +weatherList.get(0).lista.get(position).main.getTemp();
        String min = "Temp min: " + weatherList.get(0).lista.get(position).main.getTemp_min();
        String max = "Temp max: " + weatherList.get(0).lista.get(position).main.getTemp_max();
        
        holder.type.setText(timeText);
        holder.temp.setText(temText);
        holder.min.setText(min);
        holder.max.setText(max);

        String url = weatherList.get(0).lista.get(position).weather.get(0).getIcon();
        Picasso.get().load( "http://openweathermap.org/img/w/" + url + ".png")
                .resize(110, 110).centerCrop()
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return weatherList.get(0).lista.size();
    }

    public class HolderView extends RecyclerView.ViewHolder {
        TextView temp;
        TextView type;
        TextView min;
        TextView max;
        ImageView image;

        public HolderView(@NonNull View itemView) {
            super(itemView);
            type = itemView.findViewById(R.id.txtType);
            temp = itemView.findViewById(R.id.txtTemp);
            min = itemView.findViewById(R.id.txtMin);
            max = itemView.findViewById(R.id.txtMax);
            image = itemView.findViewById(R.id.icon);
        }
    }
}
