package com.diego.sejas.flowtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.diego.sejas.flowtest.interfaces.MainContract;
import com.diego.sejas.flowtest.models.Province;
import com.diego.sejas.flowtest.models.WeatherResponse;
import com.diego.sejas.flowtest.presenter.MainPresenter;
import com.diego.sejas.flowtest.utils.RecyclerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    @BindView(R.id.progressBar)ProgressBar mProgressbar;
    @BindView(R.id.spinner)Spinner mSpinner;
    @BindView(R.id.recyclerView)RecyclerView mRecyclerView;

    public MainPresenter mPresenter;
    RecyclerAdapter mRecyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mPresenter = new MainPresenter(this);
        mPresenter.getProvince();
    }

    @Override
    public void onGetDataSuccessful(WeatherResponse weatherResponse) {
        List<WeatherResponse> list = new ArrayList<>();
        list.add(weatherResponse);
        mRecyclerAdapter = new RecyclerAdapter(this,list);
        mRecyclerView.setAdapter(mRecyclerAdapter);
    }

    @Override
    public void onGetProvinceSuccessful(List<Province> province) {

        ArrayAdapter<Province> adp = new ArrayAdapter<Province>(this,android.R.layout.simple_spinner_item, province);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adp.insert(new Province("Seleccione Cuidad","0"),0);
        mSpinner.setAdapter(adp);
        mSpinner.setSelection(0,false);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    String city = mSpinner.getSelectedItem().toString();
                    mPresenter.getData(city);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    @Override
    public void onGetDataFailure(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onProcessStart() {
       mProgressbar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onProcessEnd() {
       mProgressbar.setVisibility(View.INVISIBLE);
    }
}