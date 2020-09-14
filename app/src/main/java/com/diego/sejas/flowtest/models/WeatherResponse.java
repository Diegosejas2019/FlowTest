package com.diego.sejas.flowtest.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class WeatherResponse {
    @SerializedName("list")
    public ArrayList<List> lista = new ArrayList<>();
    public class List{

        public List() {
        }

        @SerializedName("weather")
        public ArrayList<Weather> weather = new ArrayList<>();

        @SerializedName("main")
        public Main main;

        @SerializedName("dt")
        public Long date;

        @SerializedName("name")
        public String name;

        public ArrayList<Weather> getWeather() {
            return weather;
        }

        public Long getDate() {
            return date;
        }

        public String getName() {
            return name;
        }
        public class Weather {
            @SerializedName("main")
            public String main;

            @SerializedName("icon")
            public String icon;

            public String getMain() {
                return main;
            }

            public String getIcon() {
                return icon;
            }
        }

        public class Main {
            @SerializedName("temp")
            public String temp;
            @SerializedName("humidity")
            public String humidity;
            @SerializedName("temp_min")
            public String temp_min;
            @SerializedName("temp_max")
            public String temp_max;

            public String getTemp() {
                return temp;
            }

            public String getHumidity() {
                return humidity;
            }

            public String getTemp_min() {
                return temp_min;
            }

            public String getTemp_max() {
                return temp_max;
            }
        }
    }
}



