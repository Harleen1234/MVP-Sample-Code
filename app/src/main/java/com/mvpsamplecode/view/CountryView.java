package com.mvpsamplecode.view;


import com.mvpsamplecode.model.Country;

import java.util.List;

/**
 * This class represents the country view interface.
 *
 * @author Jean Carlos (Github: @jeancsanchez)
 * @date 09/03/18.
 * Jesus loves you.
 */
public interface CountryView {

    void countriesReady(List<Country> countries);
}
