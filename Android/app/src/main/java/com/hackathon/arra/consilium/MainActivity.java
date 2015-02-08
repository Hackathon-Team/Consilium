package com.hackathon.arra.consilium;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends ActionBarActivity {
    ListView mListView;
    AssignmentList mAssignments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get ListView object from xml
        mListView = (ListView) findViewById(R.id.listView);

        // ArrayList values
        mAssignments = new AssignmentList();
            mAssignments.add(new Assignment("APUSH Worksheet", 2, new Date(2015, 2, 8), 25)); // test case 1
            mAssignments.add(new Assignment("Calculus Homework", 3, new Date(2015, 1, 8), 25)); // test case 2
            mAssignments.add(new Assignment("Eat Dinner", 1, new Date(2015, 2, 8), 25)); // test case 3
        mAssignments.sortDate();

        // Define a new adapter
        ArrayAdapter<Assignment> mArrayAdapter = new ArrayAdapter<Assignment>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, mAssignments);

        // Assign adapter to ListView
        mListView.setAdapter(mArrayAdapter);

//        mListView.setOnClickListener(new AdapterView.OnClickListener() {
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
