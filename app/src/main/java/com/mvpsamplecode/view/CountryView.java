package com.mvpsamplecode.view;


import com.mvpsamplecode.model.Country;

import java.util.List;


public interface CountryView {

    void countriesReady(List<Country> countries);
}
