package com.example.misionservi.interfaces;

import com.example.misionservi.model.Encuesta;
import com.example.misionservi.model.Login;
import com.example.misionservi.model.Persona;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @POST("api/Cuentas/Login")
    Call<Login> postLogin();

    @POST("api/Encuesta/{cedula}")
    Call<Persona> getPersona(@Path("cedula") int cedula);

    @POST("api/Encuesta/RegistrarEncuesta")
    Call<Encuesta> postEncuesta();
}
