package com.example.praveen.drawerapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;

import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FirstFragment extends Activity {

    TextView textone,texttwo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_fragment);
//        textone=(TextView)findViewById(R.id.employees);
//        texttwo=(TextView)findViewById(R.id.projects);
    }

    public void EmployeeDetails(View view) {
        Intent employeeIntent=new Intent(getApplicationContext(),EmployeeList.class);
        startActivity(employeeIntent);
    }

    public void FeatureProjectDetails(View view) {
        Intent employeeIntent=new Intent(getApplicationContext(),FeatureProject.class);
        startActivity(employeeIntent);
    }
}
