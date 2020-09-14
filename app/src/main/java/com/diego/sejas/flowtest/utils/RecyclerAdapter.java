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

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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


       /* Date d = new Date();
        String date= weatherList.get(0).lista.get(position).main.;
        DateFormat df=new SimpleDateFormat("dd-MM-yyyy");
        try {
            d = df.parse(date);
        } catch (ParseException e) {}*/
        //Date d = weatherList.get(0).lista.get(position).date;
        java.util.Date time=new java.util.Date((long)weatherList.get(0).lista.get(position).date*1000);

        holder.type.setText(time +  weatherList.get(0).lista.get(position).weather.get(0).getMain());
        holder.temp.setText("Temp :" +weatherList.get(0).lista.get(position).main.getTemp());
        holder.min.setText("Temp min: " + weatherList.get(0).lista.get(position).main.getTemp_min());
        holder.max.setText("Temp max: " + weatherList.get(0).lista.get(position).main.getTemp_max());

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
            type = (TextView)itemView.findViewById(R.id.txtType);
            temp = (TextView)itemView.findViewById(R.id.txtTemp);
            min = (TextView)itemView.findViewById(R.id.txtMin);
            max = (TextView)itemView.findViewById(R.id.txtMax);
            image = (ImageView)itemView.findViewById(R.id.icon);
        }
    }
}
