package com.example.surveyapp.API;

import android.util.Log;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiManager {


    private static Retrofit retrofitInstance;

    private static Retrofit getInstance() {


        if (retrofitInstance == null) {
            //adding interceptors
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                @Override
                public void log(String message) {
                    Log.e("api", message);
                }
            });
            //setting the level
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

             //interceptors parent class is okttp
            OkHttpClient client = new OkHttpClient.Builder()
                    .addInterceptor(loggingInterceptor)
                    .build();

            retrofitInstance = new Retrofit.Builder()
                    .baseUrl("http://stdattendance.com/survey/public/api/moderator/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();


        }
        return retrofitInstance;

    }


    public static Services getApis() {
        return getInstance().create(Services.class);

    }
}
