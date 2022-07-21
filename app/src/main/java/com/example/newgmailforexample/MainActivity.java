package com.example.newgmailforexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;

import com.example.newgmailforexample.adapter.DataAdapter;
import com.example.newgmailforexample.fragment.AllinboxFragment;
import com.example.newgmailforexample.fragment.PrimaryFragment;
import com.example.newgmailforexample.fragment.SnoozedFragment;
import com.example.newgmailforexample.fragment.SocialFragment;
import com.example.newgmailforexample.fragment.StarredFragment;
import com.example.newgmailforexample.models.DataModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawer;


    RecyclerView recyclerView;
    List<DataModel> dataModels = new ArrayList<>();


    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*
        recyclerView = findViewById(R.id.recyclerView);

        dataModels.add(new DataModel("John"));
        dataModels.add(new DataModel("Machale"));
        dataModels.add(new DataModel("John c2"));
        dataModels.add(new DataModel("John 2"));
        dataModels.add(new DataModel("John 3"));
        dataModels.add(new DataModel("John 4"));
        dataModels.add(new DataModel("John 5"));
        dataModels.add(new DataModel("John 5"));
        dataModels.add(new DataModel("John 6"));
        dataModels.add(new DataModel("John 77"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new DataAdapter(dataModels));*/


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            // TODO
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();
        switch (item.getItemId()) {
            case R.id.nav_All_inbox:
                openFragment(AllinboxFragment.newInstance("1", "2"));
                closeDrawer();
                return true;
            case R.id.nav_primary:
                openFragment(PrimaryFragment.newInstance("1", "2"));
                closeDrawer();
                return true;
            case R.id.nav_social:
                openFragment(SocialFragment.newInstance("1", "2"));
                closeDrawer();
                return true;
            case R.id.nav_starred:
                openFragment(StarredFragment.newInstance("1", "2"));
                closeDrawer();
                return true;
            case R.id.nav_snoozed:
                openFragment(SnoozedFragment.newInstance("1", "2"));
                closeDrawer();
                return true;
        }
        return false;
    }

    public void closeDrawer() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }


    public void openFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.flFragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}