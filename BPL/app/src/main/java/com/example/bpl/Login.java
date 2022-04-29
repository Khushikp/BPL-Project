package com.example.bpl;

import static android.content.ContentValues.TAG;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    TextView createAccount, forgotPassword;
    Button loginBtn;
    EditText userEmail, password;
    ProgressDialog progressDialog;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        createAccount = (TextView) findViewById(R.id.create_account);
        forgotPassword = (TextView) findViewById(R.id.forget_password);
        loginBtn = (Button) findViewById(R.id.login_btn);

        userEmail = findViewById(R.id.user_email);
        password = findViewById(R.id.user_password);

        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performLogin();
            }
        });

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Login.this, Signin.class);
                startActivity(in);
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(Login.this, forgetpass.class);
                startActivity(in);

            }
        });
    }

    public void performLogin() {
        String email = userEmail.getText().toString().trim();
        String pass = password.getText().toString();

        if (email.isEmpty() || !email.matches(emailPattern)) {
            userEmail.setError("Enter correct email address");
        } else if (pass.isEmpty()) {
            password.setError("Enter correct password");
        } else {
            progressDialog.setMessage("Please wait while Logging in...");
            progressDialog.setTitle("Login");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.signInWithEmailAndPassword(email, pass)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Log.d(TAG, "signInWithEmail:success");
                                progressDialog.dismiss();

                                Intent in = new Intent(Login.this, Dashboard.class);
                                startActivity(in);
                            } else {
                                progressDialog.dismiss();

                                Log.w(TAG, "signInWithEmail:failure", task.getException());
                                Toast.makeText(Login.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
        }
    }
}