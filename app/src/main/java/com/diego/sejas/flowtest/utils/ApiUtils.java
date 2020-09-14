package com.diego.sejas.flowtest.utils;

import com.diego.sejas.flowtest.interfaces.APIService;

public class ApiUtils {
    private ApiUtils() {}

    //public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    public static APIService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(APIService.class);
    }
}
