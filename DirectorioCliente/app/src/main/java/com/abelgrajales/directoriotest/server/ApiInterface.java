package com.abelgrajales.directoriotest.server;

import com.abelgrajales.directoriotest.model.Persona;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiInterface {


    @POST("directorio")
    Call<Persona> guardarPersona(@Body Persona persona);
}