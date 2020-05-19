package com.example.misionservi.utils;

import com.example.misionservi.interfaces.JsonPlaceHolderApi;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "https://servicioapp.azurewebsites.net/";

    public static JsonPlaceHolderApi getAPIService(String token) {

        return RetrofitClient.getClient(BASE_URL,token).create(JsonPlaceHolderApi.class);
    }
}
