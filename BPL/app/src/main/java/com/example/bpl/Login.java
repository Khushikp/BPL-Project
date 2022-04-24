package com.example.bpl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    TextView createacc, forgotpass;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
//        Log.d(tag, message);

        createacc = (TextView) findViewById(R.id.createacc);
        forgotpass = (TextView) findViewById(R.id.forgetpass);

        Intent intent = new Intent(Login.this, Dashboard.class);
        startActivity(intent);

        createacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Login.this, Signin.class);
                startActivity(in);
            }
        });

        //---------if Forget password click-----------
        forgotpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Login.this, forgetpass.class);
                startActivity(in);

            }
        });
    }
}