package com.example.morkasus.recyclerview.common;

/**
 * Created by morkasus on 06/11/2015.
 */


public class Task {

    private int mId = 0;
    private String mTitle;
    private String mTask;


    public Task(String title, String task) {
        setTitle(title);
        setTask(task);
    }

    public Task() {}


    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String mtitle) {
        this.mTitle = mtitle;
    }

    public String getTask() {
        return mTask;
    }

    public void setTask(String task) {
        mTask = task;
    }

}
