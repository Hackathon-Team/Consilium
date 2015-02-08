package com.hackathon.arra.consilium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by Abinesh on 2/7/15.
 */
public class AssignmentList {
    /**
     * @param mAssignments Holds all of user's assignments
     */
    private ArrayList<Assignment> mAssignments = new ArrayList<Assignment>();

    AssignmentList() {
        Assignment ass2 = new Assignment(2, new Date(2015, 2, 8), 30);
        mAssignments.add(ass2);
        Assignment ass1 = new Assignment(3, new Date(2015, 2, 8), 30);
        mAssignments.add(ass1);
        Assignment ass3 = new Assignment(2, new Date(2015, 1, 8), 30);
        mAssignments.add(ass3);
    }

    public void addAssignment(Assignment assignment) {
        mAssignments.add(assignment);
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
