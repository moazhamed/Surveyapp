package com.example.surveyapp.API;

import com.example.surveyapp.API.Model.LoginResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Services {

    @POST("login")
    @FormUrlEncoded

    Call <LoginResponse> getResponse(@Field("user_name") String userName , @Field("password") String password);



}
