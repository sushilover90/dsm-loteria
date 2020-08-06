package com.example.loteria.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.loteria.R;

public class LoginFragment extends Fragment {

    Button btnClearEmail, btnClearPassword, btnLogIn;
    EditText etEmail, etPassword;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        // Assign buttons
        btnClearEmail = view.findViewById(R.id.btn_loginClearEmail);
        btnClearPassword = view.findViewById(R.id.btn_loginClearPassword);
        btnLogIn = view.findViewById(R.id.btn_loginLogIn);

        // Assing edit texts
        etPassword = view.findViewById(R.id.et_loginPassword);
        etEmail = view.findViewById(R.id.et_loginEmail);


        setBtnEvents();

        return view;
    }

    private void setBtnEvents() {
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email, password;

                // storing email and password
                email = etEmail.getText().toString();
                password = etPassword.getText().toString();

                // if email and/or password are empty, alert the user
                if(email.equals("") || password.equals(""))
                {
                    Toast.makeText(getActivity(), "Do not leave empty fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                // send the log in request
                Toast.makeText(getActivity(),"Hello from loteria",Toast.LENGTH_SHORT).show();

            }
        });

        btnClearPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnClearEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}