package com.mvpsamplecode.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.mvpsamplecode.R;
import com.mvpsamplecode.adapters.CountriesAdapter;
import com.mvpsamplecode.model.Country;
import com.mvpsamplecode.presenter.CountryPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CountryView {

    private RecyclerView mCountryList;
    private ArrayList<Country> dataModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        CountryPresenter countryPresenter = new CountryPresenter(this);

        // Maybe it's best to call it on onResume()
        countryPresenter.getCountries();
        // Get ListView object from xml

        mCountryList = (RecyclerView) findViewById(R.id.country_list);

        dataModels = new ArrayList<>();


    }

    @Override
    public void countriesReady(List<Country> countries) {
        Log.e("Size", "::" + countries.size());
        for (int i = 0; i < countries.size(); i++) {
            dataModels.add(countries.get(i));
        }
        setAdapter();
    }

    /**
     * @description This method is used to set adapter to the recyclerView
     */
    private void setAdapter() {
        CountriesAdapter mCountryAdapter = new CountriesAdapter(getApplicationContext(), dataModels);
        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false) {
            @Override
            public boolean canScrollVertically() {
                return true;
            }

        };
        mCountryList.setLayoutManager(lm);
        mCountryList.setItemAnimator(new DefaultItemAnimator());
        mCountryList.setAdapter(mCountryAdapter);
        mCountryList.scrollBy(0, 0);
    }

}
