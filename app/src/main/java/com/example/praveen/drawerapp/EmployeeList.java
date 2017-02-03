package com.example.praveen.drawerapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeList extends AppCompatActivity {

    ListView listview;
    Button addBtn;
    String[] subjects = new String[] {
            "Android",
            "PHP",
            "Blogger",
            "WordPress",
            "SEO"
    };
    List<String> subject_list;
    ArrayAdapter<String> arrayadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_list);

        addBtn=(Button)findViewById(R.id.button);
        listview=(ListView)findViewById(R.id.employee_list);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addEmployeeIntent=new Intent(getApplicationContext(),AddEmployee.class);
                startActivity(addEmployeeIntent);
            }
        });

        subject_list = new ArrayList<String>(Arrays.asList(subjects));
        arrayadapter = new ArrayAdapter<String>(EmployeeList.this, android.R.layout.simple_list_item_1, subject_list);
        listview.setAdapter(arrayadapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                subject_list.remove(position);
                subject_list.get(position);
                Toast.makeText(EmployeeList.this, subjects[position], Toast.LENGTH_LONG).show();

            }
        });

        listview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(EmployeeList.this);
                // Setting Dialog Title
                alertDialog.setTitle("Confirm Delete...");
                // Setting Dialog Message
                alertDialog.setMessage("Are you sure you want delete this?");

                // Setting Positive "Yes" Button
                alertDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int which) {

                        subject_list.remove(position);
                        arrayadapter.notifyDataSetChanged();
                        Toast.makeText(EmployeeList.this, "Item Deleted", Toast.LENGTH_LONG).show();
                    }
                });

                // Setting Negative "NO" Button
                alertDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Write your code here to invoke NO event
                        Toast.makeText(getApplicationContext(), "You clicked on NO", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                // Showing Alert Message
                alertDialog.show();
                return true;
            }
        });
    }

}
