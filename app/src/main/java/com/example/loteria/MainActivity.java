package com.example.loteria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.loteria.fragments.GameFragment;
import com.example.loteria.fragments.LoginFragment;

public class MainActivity extends AppCompatActivity {

    SharedPreferences credentialsSharedPreferences;
    LoginFragment loginFragment = new LoginFragment();
    GameFragment gameFragment = new GameFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction().add(R.id.cl_mainActivity, gameFragment).commit();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finishAffinity();
    }
}