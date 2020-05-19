package com.example.riabonow.account;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.riabonow.R;
import com.example.riabonow.utils.AppNavigator;
import com.example.riabonow.utils.SchemeAction;
import com.google.android.material.textview.MaterialTextView;

public class SignInActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    private TextView signUp,signIn,forgotPassword;
    EditText tvUserId,tvPassword;
    ImageView imgSigin;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        signUp = findViewById(R.id.tv_signup);
        forgotPassword = findViewById(R.id.tv_forgot_passwrd);
        tvUserId = (EditText) findViewById(R.id.tv_userid);
        tvPassword = (EditText) findViewById(R.id.tv_passwrd);
        imgSigin = (ImageView)findViewById(R.id.img_signin);

        tvPassword.addTextChangedListener(this);
        signUp.setOnClickListener(this);
        imgSigin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.tv_signup:
                AppNavigator.handleAction(SignInActivity.this, SchemeAction.ACTION_SIGNUP);
                break;

            case R.id.img_signin:
                AppNavigator.handleAction(SignInActivity.this, SchemeAction.ACTION_DASHBOARD);
                break;

            case R.id.tv_forgot_passwrd:

                break;


        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

        if(!TextUtils.isEmpty(tvPassword.getText().toString())){
            imgSigin.setVisibility(View.VISIBLE);
        }else {
            imgSigin.setVisibility(View.GONE);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {

    }
}
