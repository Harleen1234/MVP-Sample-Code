package com.mvpsamplecode.model;

import com.google.gson.annotations.SerializedName;


public class Data {

    @SerializedName("RestResponse")
    private RestResponse restResponse;

    public RestResponse getRestResponse() {
        return restResponse;
    }
}
