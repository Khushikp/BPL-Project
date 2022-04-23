package com.example.bpl;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

class Settings extends AppCompatActivity {

        TextView privacy,notifications,logout,changeemail,changephone,changepass;
        Button edtprofile;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_setting);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            privacy = (TextView) findViewById(R.id.privacy);
            notifications = (TextView) findViewById(R.id.notifications);
            logout = (TextView) findViewById(R.id.logout);
            changeemail = (TextView) findViewById(R.id.changeemail);
            changephone = (TextView) findViewById(R.id.changephone);
            changepass = (TextView) findViewById(R.id.changepass);
            edtprofile = (Button) findViewById(R.id.btnprofile);

            edtprofile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(Settings.this, profile.class);
                    startActivity(in);
                }
            });

            privacy.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(Settings.this, privacy.class);
                    startActivity(in);
                }
            });

            /*notifications.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(Settings.this, Notifications.class);
                    startActivity(in);
                }
            });*/

            changeemail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(Settings.this, change_email.class);
                    startActivity(in);
                }
            });
            changephone.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(Settings.this, change_phone.class);
                    startActivity(in);
                }
            });
            changepass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent in = new Intent(Settings.this, change_new_pass.class);
                    startActivity(in);
                }
            });
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(),"Logout Successfully",Toast.LENGTH_LONG).show();
                }
            });
        }
    }
