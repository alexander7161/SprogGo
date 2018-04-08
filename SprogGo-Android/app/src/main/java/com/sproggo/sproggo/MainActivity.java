package com.sproggo.sproggo;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements MainFragment.OnFragmentInteractionListener, MyListFragment.OnFragmentInteractionListener, AchievementsFragment.OnFragmentInteractionListener, ChangeLanguageFragment.OnFragmentInteractionListener, AboutFragment.OnFragmentInteractionListener {
    //when click category hackathon button, run this code (for all 3 categories)
    // hackathon.makeCurrent();

    private DrawerLayout mDrawerLayout;

    @Override
    public void onFragmentInteraction(Uri uri) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        Fragment fragment = null;
        Class fragmentClass;
        fragmentClass = MainFragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Insert the fragment by replacing any existing fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        setTitle("Start Learning!");


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here
                        // Create a new fragment and specify the fragment to show based on nav item clicked
                        Fragment fragment = null;
                        Class fragmentClass;
                        switch(menuItem.getItemId()) {
                            case R.id.main_drawer_item:
                                fragmentClass = MainFragment.class;
                                break;
                            case R.id.my_list_drawer_item:
                                fragmentClass = MyListFragment.class;
                                break;
                            case R.id.achievements_drawer_item:
                                fragmentClass = AchievementsFragment.class;
                                break;
                            case R.id.change_language_drawer_item:
                                fragmentClass = ChangeLanguageFragment.class;
                                break;
                            case R.id.about_drawer_item:
                                fragmentClass = AboutFragment.class;
                                break;
                            case R.id.log_out_drawer_item:
                                finish();
                                SharedPreferences pref = getApplicationContext().getSharedPreferences("sproggo", 0);

                                SharedPreferences.Editor editor = pref.edit();
                                editor.putBoolean("isLoggedIn", false);
                                editor.commit();
                                Toast.makeText(MainActivity.this, "Logged Out", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                            default:
                                fragmentClass = MainFragment.class;
                        }

                        try {
                            fragment = (Fragment) fragmentClass.newInstance();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                        // Insert the fragment by replacing any existing fragment
                        FragmentManager fragmentManager = getSupportFragmentManager();
                        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();

                        // Highlight the selected item has been done by NavigationView
                        menuItem.setChecked(true);
                        // Set action bar title
                        setTitle(menuItem.getTitle());
                        // Close the navigation drawer
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                int score = 0;
                try {
                    SharedPreferences pref = getApplicationContext().getSharedPreferences("sproggo", 0);
                    score = pref.getInt("score", 0);
                } catch(Exception e) {

                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    }
