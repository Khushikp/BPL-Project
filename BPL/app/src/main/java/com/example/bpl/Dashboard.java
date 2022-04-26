package com.example.bpl;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.GravityInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.bpl.databinding.FragmentFirst2Binding;
import com.example.bpl.ui.booking.BookingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    TextView seemore2;
    Toolbar toolbaraction;
    ActionBarDrawerToggle actionBarDrawerToggle;
    private FragmentFirst2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_dashboard);

        seemore2 = findViewById(R.id.seemore2);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.nav_view);
        toolbaraction = findViewById(R.id.toolbaraction);
        seemore2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Dashboard.this,SeeMore2.class);
                startActivity(intent);
            }
        });

        setSupportActionBar(toolbaraction);

         actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout ,toolbaraction, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
         actionBarDrawerToggle.syncState();

         navigationView = findViewById(R.id.nav_view);
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);

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



        //navigationView.setNavigationItemSelectedListener(this);
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


/*    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            switch (item.getItemId()){

                case R.id.nav_booking:
                Toast.makeText(this, "PROFILE TEST", Toast.LENGTH_SHORT).show();
                break;
            }
            return true;

        }
        return super.onOptionsItemSelected(item);
    }*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer,menu);
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        /*NOTE: DRAWER MENU ACTION AHI THI CHALASE.
         PARTICULAR JE ID ITEM MA AAPEL CHHE A ID THI CONDITION CHECK KARI NE SCREEN OPEN KARAVI.
         WRITTEN BY : RAJESH GONDALIYA
         */
        drawerLayout.closeDrawer(GravityCompat.START);
        if(item.getItemId() == R.id.nav_booking) {
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new profilefragment()).commit();
            Intent newIntent = new Intent(this, booking.class);
            startActivity(newIntent);
        }
        return true;
    }

    /*@Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        System.out.println("THIS IS WORKING");
        if(item.getItemId() == R.id.home){

            Toast.makeText(this,"dfsdf",Toast.LENGTH_SHORT).show();
        }else if (item.getItemId() == R.id.nav_booking){
            Toast.makeText(this,"dfsdf",Toast.LENGTH_SHORT).show();

        }

        return true;
    }*/
}