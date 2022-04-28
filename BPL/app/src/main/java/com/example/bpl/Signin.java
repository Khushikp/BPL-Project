package com.example.bpl;

import static android.content.ContentValues.TAG;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Signin extends AppCompatActivity {

    EditText userName, userEmail, password, confirmPassword, userPhone;
    Button signInBtn;
    String role;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;
    RadioGroup userRoleRadioGroup;
    RadioButton roleRadioButton;

    FirebaseAuth mAuth;
    FirebaseUser mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        userName = findViewById(R.id.user_name);
        userEmail = findViewById(R.id.user_email);
        userPhone = findViewById(R.id.user_phone);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirm_password);
        userRoleRadioGroup = findViewById(R.id.user_role);

        progressDialog = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();

        signInBtn = findViewById(R.id.register_btn);

        signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerformAuth();
            }
        });
    }

    private void PerformAuth() {
        String name = userName.getText().toString().trim();
        String email = userEmail.getText().toString().trim();
        String phone = userPhone.getText().toString().trim();
        String pass = password.getText().toString();
        String confirmPass = confirmPassword.getText().toString();

        int selectedRoleId = userRoleRadioGroup.getCheckedRadioButtonId();
        roleRadioButton = (RadioButton) findViewById(selectedRoleId);

        if (!email.matches(emailPattern)) {
            userEmail.setError("Enter correct email address");
        } else if (pass.isEmpty() || pass.length() < 6) {
            password.setError("Enter strong password");
        } else if (confirmPass.isEmpty() || !pass.equals(confirmPass)) {
            confirmPassword.setError("Password should be same with the above password");
        } else if (selectedRoleId < 0) {
            roleRadioButton.setError("Select role");
        } else {
            progressDialog.setMessage("Please wait while Registration...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            role = roleRadioButton.getText().toString();

            mAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        String userId = task.getResult().getUser().getUid();
                        crateUserInFirebaseDatabase(userId, name, email, phone, role);
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(Signin.this, "Error while creating new user in firebase auth", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void crateUserInFirebaseDatabase(String userId, String userName, String email, String phone, String role) {
        Map<String, Object> user = new HashMap<>();
        user.put("id", userId);
        user.put("name", userName);
        user.put("email", email);
        user.put("phone", phone);
        user.put("role", role);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection("data").document(userId)
                .set(user)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(TAG, "USer created successfully!");

                        progressDialog.dismiss();
                        Toast.makeText(Signin.this, "Registration successfull", Toast.LENGTH_SHORT).show();

                        sendUserToNextActivity();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error creating user.", e);

                        progressDialog.dismiss();
                        Toast.makeText(Signin.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(Signin.this,Login.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}