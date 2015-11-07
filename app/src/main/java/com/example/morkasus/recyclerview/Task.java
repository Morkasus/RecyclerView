package com.example.morkasus.recyclerview;

/**
 * Created by morkasus on 06/11/2015.
 */
public class Task {

    private String mTitle;
    private String mTask;

    Task(String title, String task) {
        setTitle(title);
        setTask(task);
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
