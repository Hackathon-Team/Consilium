package com.hackathon.arra.consilium;

import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by Abinesh on 2/7/15.
 */
public class AssignmentList extends ArrayList<Assignment> {
    /**
     * @param mAssignments Holds all of user's assignments
     */
    private ArrayList<Assignment> mAssignments = new ArrayList<Assignment>();

    public void addAssignment(Assignment assign) {
        mAssignments.add(assign);
    }

    public void sortDuration() {
        Collections.sort(mAssignments);
    }
    public void sortDate() {
        int min;
        Assignment temp;
        for(int outer = 0; outer < mAssignments.size()-1; outer++){
            min = outer;
            for(int inner = outer + 1; inner < mAssignments.size(); inner++){
                if(mAssignments.get(inner).getDueDate().before(mAssignments.get(min).getDueDate()))
                    min = inner;
                else if(mAssignments.get(inner).getDueDate().equals(mAssignments.get(min).getDueDate()))
                    if(mAssignments.get(inner).getPriority() < mAssignments.get(min).getPriority())
                        min = inner;
            }
            temp = mAssignments.get(outer);
            mAssignments.set(outer, mAssignments.get(min));
            mAssignments.set(min, temp);
        }
    }

    public void printAssignments() {
        for(Assignment ass : mAssignments) {
            System.out.println("Due Date: " + ass.getDueDate() + " Priority: " + ass.getPriority() + " Duration: " + ass.getDuration());
        }
    }
}
