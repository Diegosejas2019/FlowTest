package com.diego.sejas.flowtest.interfaces;

import com.diego.sejas.flowtest.models.Province;
import com.diego.sejas.flowtest.models.WeatherResponse;

import java.util.List;

public interface MainContract {
    interface View{
        void onGetDataSuccessful(WeatherResponse response);
        void onGetProvinceSuccessful(List<Province> provinces);
        void onGetDataFailure(String message);
        void onProcessStart();
        void onProcessEnd();
    }

    interface Presenter{
        void getData(String city);
        void getProvince();
    }

    interface Ineractor{
        void performGetData(String city);
        void performGetProvince();
    }

    interface onOperationListener{
        void onSuccess(WeatherResponse response);
        void onSuccessProv(List<Province> provinces);
        void onFailure(String message);
        void onStart();
        void onEnd();
    }
}
