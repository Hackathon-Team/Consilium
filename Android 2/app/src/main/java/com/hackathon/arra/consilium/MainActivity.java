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
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends ActionBarActivity {
    private ListView mListView;
    private AssignmentList mAssignments = new AssignmentList(new Assignment("Eat Dinner", 1, 2015, 2, 9, 25), new Assignment("Calculus Homework", 3, 2015, 3, 8, 25), new Assignment("APUSH Worksheet", 2, 2015, 2, 8, 500));
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

        updateAssignmentList();
        Log.d("Show number of items", mAssignments.size() + "");

        for(Assignment ass : mAssignments)
            Log.d("Check sort", "Check: " + ass);


        // Define a new adapter
        mArrayAdapter = new ArrayAdapter<Assignment>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, mAssignments);

        // Assign adapter to ListView
        mListView.setAdapter(mArrayAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Assignment temp = (Assignment) mListView.getItemAtPosition(position);
                Intent intntToDetailed = new Intent(MainActivity.this, DetailedViewActivity.class);
                intntToDetailed.putExtra("title", temp.toString());
                intntToDetailed.putExtra("priority", temp.getPriority());
                intntToDetailed.putExtra("dueMonth", temp.getDueMonth());
                intntToDetailed.putExtra("dueDay", temp.getDueDate());
                intntToDetailed.putExtra("dueYear", temp.getDueYear());
                intntToDetailed.putExtra("duration", temp.getDuration());
                intntToDetailed.putExtra("index", position);
                startActivityForResult(intntToDetailed, 2);
            }
        });
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
        if(requestCode == 1 && resultCode == Activity.RESULT_OK) {
            mAssignments.add(new Assignment(data.getStringExtra("title"), data.getIntExtra("priority", 1), data.getIntExtra("dueYear", 2015), data.getIntExtra("dueMonth", 1), data.getIntExtra("dueDay", 1), data.getIntExtra("duration", 0)));
            updateAssignmentList();
            mArrayAdapter.notifyDataSetChanged();
        } else if (requestCode == 2 && resultCode == Activity.RESULT_OK) {
            if(data.getBooleanExtra("isAssignCompleted", false)) {
                mAssignments.remove(data.getIntExtra("index", 0));

                if(data.getBooleanExtra("isAssignUpdated", false)) {
                    mAssignments.add(new Assignment(data.getStringExtra("title"), data.getIntExtra("priority", 1), data.getIntExtra("dueYear", 2015), data.getIntExtra("dueMonth", 1), data.getIntExtra("dueDay", 1), data.getIntExtra("duration", 0)));
                    updateAssignmentList();
                    mArrayAdapter.notifyDataSetChanged();
                }
            }
        }
    }

    public void freeTime(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("ALERT");
        builder.setMessage("How Much Free Time Do You Have?");

        // Set an EditText view to get user input
        final EditText input = new EditText(this);
        input.setRawInputType(InputType.TYPE_CLASS_NUMBER);
        input.setHint("In Minutes");
        builder.setView(input);


        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                int squoTime = Integer.parseInt(input.getText().toString());
                showAssignment(squoTime);
                dialog.dismiss();
            }
        });


        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        });

        builder.show();
    }

    public void updateAssignmentList() {
        mAssignments.sortDate();
    }

    public void showAssignment(int squoTime)
    {
        ArrayList<Assignment> dueTomorrow = new ArrayList<Assignment>();
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date(System.currentTimeMillis()));
        Log.d("Year",cal.get(Calendar.YEAR)+"");
        Log.d("Month",cal.get(Calendar.MONTH)+"");
        Log.d("Date",cal.get(Calendar.DATE)+"");

        for(Assignment ass : mAssignments) {
            if(ass.getDueYear()==cal.get(Calendar.YEAR) && ass.getDueMonth()==cal.get(Calendar.MONTH)+1 && ass.getDueDate()-1==cal.get(Calendar.DATE)) {
                dueTomorrow.add(ass);
            }
        }
        Log.d("Size of the ArrayList",dueTomorrow.size()+"");
        AlertDialog.Builder assignAlert = new AlertDialog.Builder(this);

        if(dueTomorrow.size() > 0) {
            int diff = 10000000;
            int min = 0;
            for (Assignment ass : dueTomorrow) {
                if (diff > Math.abs(squoTime - ass.getDuration())) {
                    diff = Math.abs(squoTime - ass.getDuration());
                    min = dueTomorrow.indexOf(ass);
                }
            }
            assignAlert.setTitle("You Should Work On:");
            assignAlert.setMessage(dueTomorrow.get(min).toString());
        }
        else
        {
            int diff = 10000000;
            int min = 0;
            for (Assignment ass : mAssignments) {
                if ( diff > Math.abs(squoTime - ass.getDuration())) {
                    diff = Math.abs(squoTime - ass.getDuration());
                    min = mAssignments.indexOf(ass);
                }
            }
            assignAlert.setTitle("You Should Work On:");
            assignAlert.setMessage(mAssignments.get(min).toString());
        }

        assignAlert.show();
    }



}
