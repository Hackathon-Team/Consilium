package com.hackathon.arra.consilium;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends ActionBarActivity {
    private ListView mListView;
    private AssignmentList mAssignments = new AssignmentList(new Assignment("Eat Dinner", 1, new Date(2015, 2, 9), 25), new Assignment("Calculus Homework", 3, new Date(2015, 1, 8), 25), new Assignment("APUSH Worksheet", 2, new Date(2015, 2, 8), 25));
    private Intent intntToNewAssignment;
    ArrayAdapter<Assignment> mArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize IntentView
        intntToNewAssignment = new Intent(MainActivity.this, NewAssignmentActivity.class);

        // Get ListView object from xml
        mListView = (ListView) findViewById(R.id.listView);

        // ArrayList values
//        mAssignments = new AssignmentList();
//            mAssignments.add(new Assignment("Eat Dinner", 1, new Date(2015, 2, 9), 25)); // no3
//            mAssignments.add(new Assignment("Calculus Homework", 3, new Date(2015, 1, 8), 25)); // no1
//            mAssignments.add(new Assignment("APUSH Worksheet", 2, new Date(2015, 2, 8), 25)); // no2
        updateAssignmentList();
        Log.d("Show number of items", mAssignments.size() + "");

        for(Assignment ass : mAssignments)
            Log.d("Check sort", "Check: " + ass);


        // Define a new adapter
        mArrayAdapter = new ArrayAdapter<Assignment>(this,
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

        getMenuInflater().inflate(R.menu.main_activity_actions, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch(item.getItemId()) {
            case R.id.action_add:
                startActivityForResult(intntToNewAssignment, 1);
                return true;
            case R.id.action_settings:
                //openSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == Activity.RESULT_OK){
            Log.d("Check Returned Assignment", "Returned Assignment Title Information");
            mAssignments.add(new Assignment(data.getStringExtra("title"), data.getIntExtra("priority", 1), new Date(data.getIntExtra("dueYear", 2015), data.getIntExtra("dueMonth", 1), data.getIntExtra("dueDay", 1)), data.getIntExtra("duration", 0)));
            updateAssignmentList();
            mArrayAdapter.notifyDataSetChanged();
        }
    }

    public void freeTime(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("ALERT");
        alert.setMessage("How Much Free Time Do You Have?");

        // Set an EditText view to get user input
        final EditText input = new EditText(this);
        //input.setRawInputType(InputType.TYPE_CLASS_NUMBER);
        input.setHint("In Minutes");
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            private boolean shouldFindAssignment = false;
            public void onClick(DialogInterface dialog, int whichButton) {
                int squoTime = Integer.parseInt(input.getText().toString());


                AssignmentList dueTomorrow = new AssignmentList();
                Calendar todayDate = Calendar.getInstance();
                Calendar cal = Calendar.getInstance();

                for(Assignment ass : mAssignments) {
                    cal.setTime(ass.getDueDate());
                    if(cal.get(Calendar.MONTH) == todayDate.get(Calendar.MONTH) && cal.get(Calendar.YEAR) == todayDate.get(Calendar.YEAR) && cal.get(Calendar.DATE) - 1 == todayDate.get(Calendar.DATE)) {
                        dueTomorrow.add(ass);
                    }
                }

                int diff = 10000000;
                int min = 0;
                for(Assignment ass: dueTomorrow) {
                    if(ass.getDuration() <= squoTime && diff > squoTime-ass.getDuration()) {
                        diff=squoTime-ass.getDuration();
                        min = dueTomorrow.indexOf(ass);
                    }
                }

                alert.setTitle("You Should Work On:");
                alert.setMessage(dueTomorrow.get(min).toString());

                alert.show();
            }

        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });

        alert.show();
    }

    public void updateAssignmentList() {
        mAssignments.sortDate();
    }
}
