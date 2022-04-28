package com.example.bpl;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.bpl.databinding.FragmentFirst2Binding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    AppBarConfiguration mAppBarConfiguration;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    BottomNavigationView bottomNavigationView;
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
        bottomNavigationView = findViewById(R.id.bottom_navigation);
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
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bottom_home: break;

                    case R.id.bottom_booking:
                        Intent intent = new Intent(Dashboard.this, booking.class);
                        startActivity(intent);
                        break;

                    case R.id.bottom_suggestion:
                        Intent intent1 = new Intent(Dashboard.this, Suggestion.class);
                        startActivity(intent1);
                        break;

                    case R.id.bottom_wishlist:
                        Intent intent2 = new Intent(Dashboard.this, wishlist.class);
                        startActivity(intent2);
                        break;

                    case R.id.bottom_profile:
                        Intent intent3 = new Intent(Dashboard.this, profile.class);
                        startActivity(intent3);
                        break;
                }
                return true;
            }
        });
    }

    public void setSupportActionBar(Toolbar toolbar) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_drawer,menu);
        getMenuInflater().inflate(R.menu.dashboard,menu);
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

        else if(item.getItemId() == R.id.nav_wishlist) {
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new profilefragment()).commit();
            Intent newIntent = new Intent(this, wishlist.class);
            startActivity(newIntent);
        }
        else if(item.getItemId() == R.id.nav_setting) {
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new profilefragment()).commit();
            Intent newIntent = new Intent(this,settings .class);
            startActivity(newIntent);
        }
        else if(item.getItemId() == R.id.nav_share) {
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new profilefragment()).commit();
            /*ApplicationInfo api = getApplicationContext().getApplicationInfo();
            String apkpath = api.sourceDir;
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("http://play.google.com/store/apps/details?id-BPL");
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(new File(apkpath)));
            startActivity(Intent.createChooser(intent, "Sharevia"));*/
            Intent in = new Intent();
            in.setAction(Intent.ACTION_SEND);
            in.putExtra(Intent.EXTRA_TEXT,"http://play.google.com/store/apps/details?id-BPL");
            in.setType("text/plain");
            startActivity(Intent.createChooser(in,"Share via"));

        }

        else if(item.getItemId() == R.id.nav_help) {
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new profilefragment()).commit();
            Intent newIntent = new Intent(this, help.class);
            startActivity(newIntent);
        }
        else if(item.getItemId() == R.id.nav_logout) {
            //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new profilefragment()).commit();
            Intent newIntent = new Intent(this, logout.class);
            startActivity(newIntent);
        }
        return true;
    }
}