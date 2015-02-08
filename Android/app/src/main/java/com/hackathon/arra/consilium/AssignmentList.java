package com.hackathon.arra.consilium;

import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

/**
 * Created by Abinesh on 2/7/15.
 */
public class AssignmentList extends ArrayList<Assignment> {

    AssignmentList() {

    }

    public AssignmentList(Assignment a1, Assignment a2, Assignment a3) {
        addAssignment(a1);
        addAssignment(a2);
        addAssignment(a3);
    }

    public void addAssignment(Assignment assign) {
        this.add(assign);
    }

    public void sortDuration() {
        Collections.sort(this);
    }

    public void sortDate() {
        for(int outer = 0; outer < this.size()-1; outer++){
            for(int inner = 0; inner < this.size()-outer-1; inner++){
                if(this.get(inner).getDueYear()>this.get(inner+1).getDueYear()) {
                    Assignment temp = this.get(inner);
                    this.set(inner,this.get(inner+1));
                    this.set(inner+1, temp);
                }
                else if(this.get(inner).getDueYear()==this.get(inner+1).getDueYear()) {
                    if(this.get(inner).getDueMonth()>this.get(inner+1).getDueMonth()) {
                        Assignment temp = this.get(inner);
                        this.set(inner,this.get(inner+1));
                        this.set(inner+1, temp);
                    }
                    else if(this.get(inner).getDueMonth()==this.get(inner+1).getDueMonth()) {
                        if(this.get(inner).getDueDate()>this.get(inner+1).getDueDate()) {
                            Assignment temp = this.get(inner);
                            this.set(inner,this.get(inner+1));
                            this.set(inner+1, temp);
                        }
                        else if(this.get(inner).getDueDate()==this.get(inner+1).getDueDate()) {
                            if(this.get(inner).getPriority()>this.get(inner+1).getPriority()) {
                                Assignment temp = this.get(inner);
                                this.set(inner, this.get(inner+1));
                                this.set(inner+1,temp);
                            }
                        }
                    }
                }
            }
        }

    }
}
