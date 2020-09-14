package com.diego.sejas.flowtest.interactor;

import com.diego.sejas.flowtest.interfaces.APIService;
import com.diego.sejas.flowtest.interfaces.MainContract;
import com.diego.sejas.flowtest.models.Province;
import com.diego.sejas.flowtest.models.WeatherResponse;
import com.diego.sejas.flowtest.utils.ApiUtils;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainInteractor implements MainContract.Ineractor{
    private APIService mAPIService;
    private MainContract.onOperationListener mListner;


    public MainInteractor(MainContract.onOperationListener mListner) {
        this.mListner = mListner;
        mAPIService = ApiUtils.getAPIService();
    }

    @Override
    public void performGetData(String city) {

        mListner.onStart();
        mAPIService.getWeatherData(city,"6").enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {

                if(response.isSuccessful()) {
                    mListner.onSuccess(response.body());
                    mListner.onEnd();
                }
                else{
                    mListner.onFailure(response.message());
                    mListner.onEnd();
                }
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                mListner.onFailure(t.getMessage());
                mListner.onEnd();
            }
        });
    }

    @Override
    public void performGetProvince() {
        mListner.onStart();
        mAPIService.getProvince("https://apis.datos.gob.ar/georef/api/provincias").enqueue(new Callback<Province>() {
            @Override
            public void onResponse(Call<Province> call, Response<Province> response) {

                if(response.isSuccessful()) {
                    mListner.onSuccessProv((List<Province>) response.body().getProvince());
                    mListner.onEnd();
                }
            }

            @Override
            public void onFailure(Call<Province> call, Throwable t) {
                mListner.onFailure(t.getMessage());
                mListner.onEnd();
            }
        });
    }
}
