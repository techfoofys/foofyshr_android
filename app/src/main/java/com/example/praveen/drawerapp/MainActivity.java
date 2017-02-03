package com.example.praveen.drawerapp;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;

    // Make sure to be using android.support.v7.app.ActionBarDrawerToggle version.
    // The android.support.v4.app.ActionBarDrawerToggle has been deprecated.
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find our drawer view
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        // Find our drawer view
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        // Setup drawer view
        setupDrawerContent(nvDrawer);
// Lookup navigation view
        NavigationView navigationView = (NavigationView) findViewById(R.id.nvView);

        View headerLayout = navigationView.getHeaderView(0);
// We can now look up items within the header if needed
        ImageView ivHeaderPhoto = (ImageView) headerLayout.findViewById(R.id.profile_image);

    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        switch(menuItem.getItemId()) {
                            case R.id.employee:
//                                fragmentClass = FirstFragment.class;
                                Intent i=new Intent(getApplicationContext(),FirstFragment.class);
                                startActivity(i);
                                break;
                            case R.id.admin:
                                Intent i1=new Intent(getApplicationContext(),SecondFragment.class);
                                startActivity(i1);
                                break;
                            case R.id.projects:
//                                fragmentClass = FirstFragment.class;
                                Intent i2=new Intent(getApplicationContext(),EmployeeList.class);
                                startActivity(i2);
                                break;
                            case R.id.featured_projects:
                                Intent i3=new Intent(getApplicationContext(),FeatureProject.class);
                                startActivity(i3);
                                break;
                            default:
//                                Intent i3=new Intent(getApplicationContext(),FirstFragment.class);
//                                startActivity(i3);
                        }
//                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar home/up action should open or close the drawer.
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawer.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void OpenDrawer(View view) {
        mDrawer.openDrawer(Gravity.LEFT);
    }
}
