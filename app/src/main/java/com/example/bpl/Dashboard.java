package com.example.bpl;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TextView seemore2;
    Toolbar toolbaraction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_dashboard);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_view);
        toolbaraction = findViewById(R.id.toolbaraction);
        seemore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Dashboard.this,l.class)
            }
        });

        setSupportActionBar(toolbaraction);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout ,toolbaraction, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
         actionBarDrawerToggle.syncState();

         navigationView = findViewById(R.id.nav_view);


        ImageSlider imageSlider = findViewById(R.id.slider);
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.shivrajpur, "Shivrajpur Beach"));
        slideModels.add(new SlideModel(R.drawable.abu, "Abu"));
        slideModels.add(new SlideModel(R.drawable.location, "Goa"));
        slideModels.add(new SlideModel(R.drawable.kutch, "Kutch"));
        slideModels.add(new SlideModel(R.drawable.diu, "Diu"));

        imageSlider.setImageList(slideModels, true);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.home);

        // Perform item selected listener
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.suggestion:
                        Intent intent = new Intent(Dashboard.this, Suggestion.class);
                        startActivity(intent);
                       case R.id.wishlist:
                        startActivity(new Intent(getApplicationContext(), wishlist.class));
                        overridePendingTransition(0, 0);
                    case R.id.home:
                        return true;
                    case R.id.booking:
                       Intent in = new Intent(Dashboard.this, booking.class);
                       startActivity(in);
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), profile.class));
                        overridePendingTransition(0, 0);
                }
                return true;
            }
        });
/*
    com.example.bpl.databinding.ActivityDashboardBinding binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       setSupportActionBar(binding.appBarDashboarld.toolbar);
        binding.appBarDashboard.toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        ActivityDashboardBinding binding;
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
       // AppBarConfiguration mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_profile, R.id.nav_wishlist, R.id.nav_booking, R.id.nav_share, R.id.nav_help, R.id.nav_logout)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = findNavController(this, R.id.action_bar_activity_content);
         NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
            NavigationUI.setupWithNavController(navigationView, navController);
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.dashboard, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = findNavController(this, R.id.action_bar_activity_content);

        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();*/
    }

    public void setSupportActionBar(Toolbar toolbar) {
    }
}