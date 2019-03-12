package com.example.surveyapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.surveyapp.API.Model.LoginResponse.Data;
import com.example.surveyapp.Base.BaseActivity;
import com.example.surveyapp.Repository.LoginRepository;

public class HomeActivity extends BaseActivity {

    protected EditText userName;
    protected EditText password;
    protected Button nextButton;
    LoginRepository loginRepository;
    String usrName;
    String pssword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_home);
        initView();

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.next_button) {
                    usrName = userName.getText().toString();
                    pssword = password.getText().toString();
                    loginRepository = new LoginRepository(usrName, pssword);
                    loginRepository.getLoginResponse(new LoginRepository.onLoginResponsePreparedListener() {
                        @Override
                        public void onLoginResponsePrepared(Data data) {
                            if (data != null) {
                                userAuthinticated();
                            } else
                                showMessage(R.string.error, R.string.login_failed, R.string.ok);
                        }
                    });

                }
            }
        });

    }

    public void userAuthinticated() {
        //Toast.makeText(activity, "clicked", Toast.LENGTH_SHORT).show();
        startactivity();

    }

    public void startactivity() {

        startActivity(new Intent(activity, CoursesActivity.class));

    }

    private void initView() {
        userName = findViewById(R.id.user_name);
        password = findViewById(R.id.password);
        nextButton = findViewById(R.id.next_button);
    }


}