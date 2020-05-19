package com.example.misionservi.interfaces;

import com.example.misionservi.model.Encuesta;
import com.example.misionservi.model.LoginPost;
import com.example.misionservi.model.Token;
import com.example.misionservi.model.Persona;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @POST("api/Cuentas/Login")
    Call<Token> postLogin(@Body LoginPost post);


    @Headers({"Content-Type: application/json"})
    @POST("api/Encuesta/{Cedula}")
    Call<Persona> getPersona(@Path("Cedula") String cedula);

    @POST("api/Encuesta/RegistrarEncuesta")
    Call<Encuesta> postEncuesta();
}
