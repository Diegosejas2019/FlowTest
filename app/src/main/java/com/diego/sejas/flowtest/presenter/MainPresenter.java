package com.diego.sejas.flowtest.presenter;

import com.diego.sejas.flowtest.interactor.MainInteractor;
import com.diego.sejas.flowtest.interfaces.MainContract;
import com.diego.sejas.flowtest.models.Province;
import com.diego.sejas.flowtest.models.WeatherResponse;

import java.util.List;

public class MainPresenter implements MainContract.Presenter, MainContract.onOperationListener{

    private MainContract.View mView;
    private MainInteractor mInteractor;

    public MainPresenter(MainContract.View mView) {
        this.mView = mView;
        mInteractor = new MainInteractor(this);
    }

    @Override
    public void getData(String city) {
        mInteractor.performGetData(city);
    }

    @Override
    public void getProvince() {
        mInteractor.performGetProvince();
    }

    @Override
    public void onSuccess(WeatherResponse response) {
        mView.onGetDataSuccessful(response);
    }

    @Override
    public void onSuccessProv(List<Province> province) {
        mView.onGetProvinceSuccessful(province);
    }

    @Override
    public void onFailure(String message) {
        mView.onGetDataFailure(message);
    }

    @Override
    public void onStart() {
        mView.onProcessStart();
    }

    @Override
    public void onEnd() {
        mView.onProcessEnd();
    }
}
