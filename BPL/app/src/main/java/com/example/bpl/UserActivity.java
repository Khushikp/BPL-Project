package com.example.bpl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserActivity extends AppCompatActivity {

    //ActivityUserBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Intent intent = this.getIntent();

        TextView tv1 = findViewById(R.id.nameProfile);
        TextView tv2 = findViewById(R.id.emailProfile);
        TextView tv3 = findViewById(R.id.phoneProfile);
        TextView tv4 = findViewById(R.id.cityProfile);
        TextView tv5 = findViewById(R.id.pincodeProfile);
        TextView tv6 = findViewById(R.id.countryProfile);
        TextView tv7 = findViewById(R.id.addressProfile);
        TextView tv8 = findViewById(R.id.genderProfile);
        ImageView img = findViewById(R.id.imageProfile);
        Button btn = findViewById(R.id.btnBooking);

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

            tv1.setText(name);
            tv2.setText(email);
            tv3.setText(phone);
            tv4.setText(city);
            tv5.setText(pincode);
            tv6.setText(country);
            tv7.setText(address);
            tv8.setText(gender);
            img.setImageResource(imageid);

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(UserActivity.this, booking.class);
                    startActivity(intent);
                }
            });

        //   binding.nameProfile.setText(name);
         //  binding.emailProfile.setText(email);
         //  binding.phoneProfile.setText(phone);
           //binding.cityProfile.setText(city);
            //binding.pincodeProfile.setText(pincode);
           // binding.countryProfile.setText(country);
           // binding.genderProfile.setText(gender);
       //     binding.addressProfile.setText(address);
         //   binding.profileImage.setImageResource(imageid);



        }
    }
}