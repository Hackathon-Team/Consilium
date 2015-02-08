package com.hackathon.arra.consilium;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Abinesh on 2/8/15.
 */
public class NewAssignmentActivity extends Activity {
    private Intent intntToMainActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_assignment);
        //AssignmentList mAssignment = (AssignmentList)
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View view) {
        //Intent intent = new Intent(NewAssignmentActivity.this, MainActivity.class);
        EditText txtAssignName = (EditText) findViewById(R.id.assignName);
        EditText time = (EditText) findViewById(R.id.duration);
        int duration = Integer.parseInt(time.getText().toString());
        DatePicker datepicker = (DatePicker) findViewById(R.id.datePicker);
        int priority = 1; //how are we defining this?

        intntToMainActivity = new Intent();
        intntToMainActivity.putExtra("title", txtAssignName.getText().toString());
        intntToMainActivity.putExtra("priority", priority);
        intntToMainActivity.putExtra("dueMonth", datepicker.getMonth());
        intntToMainActivity.putExtra("dueDay", datepicker.getDayOfMonth());
        intntToMainActivity.putExtra("dueYear", datepicker.getYear());
        intntToMainActivity.putExtra("duration", duration);
        setResult(RESULT_OK, intntToMainActivity);
        finish();
    }

}
