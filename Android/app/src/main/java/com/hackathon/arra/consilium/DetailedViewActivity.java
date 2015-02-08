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

    private EditText assignTitleText;
    private EditText assignPriorityText;
    private DatePicker datepicker;
    private EditText assignDurationText;

    public static final int ASSIGNMENT_COMPLETED = 0;
    public static final int ASSIGNMENT_UPDATED = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_view);

        Intent currIntent = getIntent();
        String assignTitle = currIntent.getStringExtra("title");
            assignTitleText = (EditText) findViewById(R.id.assignName);
            assignTitleText.setText(assignTitle);

        int assignPriority = currIntent.getIntExtra("priority", 1);
            assignPriorityText = (EditText) findViewById(R.id.prioritySelector);
            assignPriorityText.setText(""+assignPriority);

        int assignDate = currIntent.getIntExtra("dueDay", 1);
        int assignMonth = currIntent.getIntExtra("dueMonth", 1)-1;
        int assignYear = currIntent.getIntExtra("dueYear", 2015);
            datepicker = (DatePicker) findViewById(R.id.datePicker);
            datepicker.updateDate(assignYear, assignMonth, assignDate);


        int assignDuration = currIntent.getIntExtra("duration", 15);
            assignDurationText = (EditText) findViewById(R.id.duration);
            assignDurationText.setText(""+assignDuration);
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

    public void clickCompleted(View view) {
        intntToMainActivity = new Intent();
        intntToMainActivity.putExtra("title", assignTitleText.getText().toString());
        intntToMainActivity.putExtra("priority", Integer.parseInt(assignPriorityText.getText().toString()));
        intntToMainActivity.putExtra("dueMonth", datepicker.getMonth()+1);
        intntToMainActivity.putExtra("dueDay", datepicker.getDayOfMonth());
        intntToMainActivity.putExtra("dueYear", datepicker.getYear());
        intntToMainActivity.putExtra("duration", Integer.parseInt(assignDurationText.getText().toString()));
        intntToMainActivity.putExtra("index", getIntent().getIntExtra("index", 0));

        setResult(ASSIGNMENT_COMPLETED, intntToMainActivity);
        finish();
    }

    public void clickUpdate(View view) {
        intntToMainActivity = new Intent();

        intntToMainActivity.putExtra("title", assignTitleText.getText().toString());
        intntToMainActivity.putExtra("priority", Integer.parseInt(assignPriorityText.getText().toString()));
        intntToMainActivity.putExtra("dueMonth", datepicker.getMonth()+1);
        intntToMainActivity.putExtra("dueDay", datepicker.getDayOfMonth());
        intntToMainActivity.putExtra("dueYear", datepicker.getYear());
        intntToMainActivity.putExtra("duration", Integer.parseInt(assignDurationText.getText().toString()));
        intntToMainActivity.putExtra("index", getIntent().getIntExtra("index", 0));

        setResult(ASSIGNMENT_UPDATED, intntToMainActivity);
        finish();
    }
}
