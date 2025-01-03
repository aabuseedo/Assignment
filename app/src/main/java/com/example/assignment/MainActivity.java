package com.example.assignment;

import android.os.Bundle;
import android.view.MenuItem;
//TODO import android.widget.Toolbar;
import androidx.appcompat.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView btn_navigationView;

    //TODO-------------------------------
    private DrawerLayout drawerlayout;
    //TODO-------------------------------


    //implements BottomNavigationView.OnNavigationItemSelectedListener
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //TODO-------------------------------
        Toolbar toolBar = findViewById(R.id.toolBar);
        setSupportActionBar(toolBar);
        //TODO-------------------------------
        drawerlayout = findViewById(R.id.main);
        NavigationView nav_view = findViewById(R.id.nav_view);
        nav_view.setNavigationItemSelectedListener(this);
        //TODO-------------------------------
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerlayout, toolBar,
                R.string.open_nav, R.string.close_nav);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();
        //TODO-------------------------------
//        if (savedInstanceState == null){
//            getSupportFragmentManager().beginTransaction().replace(R.id.fl_activity_main,new NewsFragment()).commit();
//            navigationView.setCheckedItem(R.id.nav_view);
//        }
        //TODO-------------------------------

        btn_navigationView = findViewById(R.id.btn_navigationView);

        btn_navigationView.setOnNavigationItemSelectedListener(this);
        btn_navigationView.setSelectedItemId(R.id.news_item);

    }

    NewsFragment newsFragment = new NewsFragment();
    LocationFragment locationFragment = new LocationFragment();
    MusicFragment musicFragment = new MusicFragment();
    FavoritesFragment favoritesFragment = new FavoritesFragment();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.news_item:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_activity_main, newsFragment)
                        .commit();
                return true;
            case R.id.location_item:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_activity_main, locationFragment)
                        .commit();
                return true;
            case R.id.music_item:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_activity_main, musicFragment)
                        .commit();
                return true;
            case R.id.favorites_item:
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fl_activity_main, favoritesFragment)
                        .commit();
                return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        if (drawerlayout.isDrawerOpen(GravityCompat.START)) {
            drawerlayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}