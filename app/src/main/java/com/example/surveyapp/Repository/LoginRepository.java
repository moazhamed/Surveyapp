package com.example.surveyapp.Repository;

import android.util.Log;

import com.example.surveyapp.API.ApiManager;
import com.example.surveyapp.API.Model.LoginResponse.Data;
import com.example.surveyapp.API.Model.LoginResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginRepository {

    LoginResponse loginResponse;
    Data data;

    String userName;
    String password;

    public LoginRepository( String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void getLoginResponse(final onLoginResponsePreparedListener onLoginResponsePreparedListener) {

        ApiManager.getApis()
                .getResponse(userName, password)
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                        if (response.isSuccessful() && "success".equals(response.body().getStatus())) {

                            data = response.body().getData();

                            if(onLoginResponsePreparedListener!=null){

                                   onLoginResponsePreparedListener.onLoginResponsePrepared(data);

                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) {
                        Log.e("fail",t.getLocalizedMessage());
                    }
                });
    }

    public interface onLoginResponsePreparedListener {

         void onLoginResponsePrepared(Data data);

    }


}
