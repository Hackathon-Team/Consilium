package com.hackathon.arra.consilium;

import java.sql.Time;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Abinesh on 2/7/15.
 */
public class Assignment implements Comparable<Assignment> {
    /**
     * @param mPriority Integer value that holds the priority of completing the assignment (1-3)
     */
    private int mPriority;

    /**
     * @param mDueDate Instance of Date class that holds the due date of the class
     */
    private Date mDueDate;

    /**
     * @param mDuration Integer that holds the length of time an assignment takes
     */
    private int mDuration;

    /**
     *
     * @param priority Integer value that holds the priority of completing the assignment (1-3)
     * @param dueDate Instance of Date class that holds the due date of the class
     * @param duration Integer that holds the length of time an assignment takes
     */
    Assignment(int priority, Date dueDate, int duration) {
        mPriority = priority;
        mDueDate = dueDate;
        mDuration = duration;
    }

    public int getPriority() {
        return mPriority;
    }

    public Date getDueDate() {
        return mDueDate;
    }

    public int getDuration() {
        return mDuration;
    }
    public void setDuration(int mDuration) {
        this.mDuration = mDuration;
    }

    @Override
    public int compareTo(Assignment another) {
        if(this.getDuration() > another.getDuration()) return 1;
        else if(this.getDuration() == another.getDuration()) return 0;
        else return -1;
    }
}
