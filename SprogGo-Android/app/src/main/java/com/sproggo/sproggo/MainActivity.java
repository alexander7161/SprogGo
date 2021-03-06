package com.sproggo.sproggo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Main activity holds fragments of different pages.
 * @author Alexander Davis
 */
public class MainActivity extends AppCompatActivity
        implements MainFragment.OnFragmentInteractionListener, MyListFragment.OnFragmentInteractionListener, AchievementsFragment.OnFragmentInteractionListener, ChangeLanguageFragment.OnFragmentInteractionListener, AboutFragment.OnFragmentInteractionListener {

    private DrawerLayout mDrawerLayout;

    private TextView score;

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
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        }

        score = (TextView) findViewById(R.id.right_toolbar_text).findViewById(R.id.scoreText);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        Fragment fragment = null;
        Class fragmentClass;
        fragmentClass = MainFragment.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Set initial fragment.
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        setTitle("Start Learning!");


        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        // Changes displayed fragment based on user choice.
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
                                // End this activity when log out chosen so back button doesn't work.
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
    protected void onResume() {
        super.onResume();
        score = (TextView) findViewById(R.id.right_toolbar_text).findViewById(R.id.scoreText);

        // Get total score.
        SharedPreferences pref = getApplicationContext().getSharedPreferences("sproggo", 0);
        int scoreInt = pref.getInt("score", 0);
        score.setText(Integer.toString(scoreInt));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    }
