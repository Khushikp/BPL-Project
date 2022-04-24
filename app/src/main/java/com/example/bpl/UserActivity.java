package com.example.bpl;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bpl.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {

    ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = this.getIntent();

        if(intent != null)
        {
            String name = intent.getStringExtra("name");
            String email = intent.getStringExtra("email");
            String phone = intent.getStringExtra("phone");
            String city = intent.getStringExtra("city");
            String pincode = intent.getStringExtra("pincode");
            String country = intent.getStringExtra("country");
            String address = intent.getStringExtra("address");
            String gender = intent.getStringExtra("gender");
            int imageid = intent.getIntExtra("imageid",R.drawable.profile1);

            binding.nameProfile.setText(name);
            binding.emailProfile.setText(email);
            binding.phoneProfile.setText(phone);
            binding.cityProfile.setText(city);
            binding.pincodeProfile.setText(pincode);
            binding.countryProfile.setText(country);
            binding.genderProfile.setText(gender);
            binding.addressProfile.setText(address);
            binding.profileImage.setImageResource(imageid);

        }
    }
}