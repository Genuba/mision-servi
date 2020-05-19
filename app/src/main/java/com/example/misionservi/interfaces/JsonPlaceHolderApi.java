package com.example.misionservi.interfaces;

import com.example.misionservi.model.Encuesta;
import com.example.misionservi.model.LoginPost;
import com.example.misionservi.model.RespuestaPost;
import com.example.misionservi.model.Token;
import com.example.misionservi.model.Persona;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JsonPlaceHolderApi {

    @POST("api/Cuentas/Login")
    Call<Token> postLogin(@Body LoginPost post);

    @GET("api/Encuesta/{Cedula}")
    Call<Persona> getPersona(@Path("Cedula") String cedula);

    @POST("api/Encuesta/RegistrarEncuesta")
    Call<RespuestaPost> postEncuesta(@Body Encuesta encuesta);
}
