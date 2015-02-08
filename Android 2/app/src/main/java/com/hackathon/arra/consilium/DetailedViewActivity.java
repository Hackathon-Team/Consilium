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
import android.widget.Button;
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
public class DetailedViewActivity extends Activity {
    private Intent intntToMainActivity;
    private static boolean isAssignUpdated;
    private static boolean isAssignCompleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_view);

//        Intent currIntent = getIntent();
//        String assignTitle = currIntent.getStringExtra("title");
//            EditText assignTitleText = (EditText) findViewById(R.id.assignName);
//            assignTitleText.setHint(assignTitle);
//        int assignPriority = currIntent.getIntExtra("priority", 1);
//            EditText assignPriorityText = (EditText) findViewById(R.id.prioritySelector);
//            assignPriorityText.setHint(assignPriority);
//
//        int assignDate = currIntent.getIntExtra("dueDay", 1);
//        int assignMonth = currIntent.getIntExtra("dueMonth", 1)-1;
//        int assignYear = currIntent.getIntExtra("dueYear", 2015);
//            DatePicker datepicker = (DatePicker) findViewById(R.id.datePicker);
//            datepicker.updateDate(assignYear, assignMonth, assignDate);
//
//
//        int assignDuration = currIntent.getIntExtra("duration", 15);
//            EditText assignDurationText = (EditText) findViewById(R.id.duration);
//            assignDurationText.setHint(assignDuration);
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
//        //Intent intent = new Intent(NewAssignmentActivity.this, MainActivity.class);
//        EditText txtAssignName = (EditText) findViewById(R.id.assignName);
//        EditText time = (EditText) findViewById(R.id.duration);
//        int duration = Integer.parseInt(time.getText().toString());
//        DatePicker datepicker = (DatePicker) findViewById(R.id.datePicker);
//        int priority = 1; //how are we defining this?
//
//        intntToMainActivity = new Intent();
//        intntToMainActivity.putExtra("title", txtAssignName.getText().toString());
//        intntToMainActivity.putExtra("priority", priority);
//        intntToMainActivity.putExtra("dueMonth", datepicker.getMonth()+1);
//        intntToMainActivity.putExtra("dueDay", datepicker.getDayOfMonth());
//        intntToMainActivity.putExtra("dueYear", datepicker.getYear());
//        intntToMainActivity.putExtra("duration", duration);
//
//
//        Button bttnCompleted = (Button) findViewById(R.id.completeButton);
//        bttnCompleted.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isAssignCompleted = true;
//            }
//        });
//
//        Button bttnUpdate = (Button) findViewById(R.id.updateButton);
//        bttnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                isAssignUpdated = true;
//            }
//        });
//        intntToMainActivity.putExtra("index", getIntent().getIntArrayExtra("index"));
//        intntToMainActivity.putExtra("isAssignCompleted", isAssignCompleted);
//        intntToMainActivity.putExtra("isAssignUpdated", isAssignUpdated);
//
//
//        setResult(RESULT_OK, intntToMainActivity);
//        finish();
    }

}
