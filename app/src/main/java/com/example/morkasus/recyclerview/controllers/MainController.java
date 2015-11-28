package com.example.morkasus.recyclerview.controllers;

import android.content.Context;

import com.example.morkasus.recyclerview.common.Listener;
import com.example.morkasus.recyclerview.common.Task;
import com.example.morkasus.recyclerview.databases.Dao;
import com.example.morkasus.recyclerview.databases.IdataFunctions;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by morkasus on 24/11/2015.
 */
public class MainController {

    private Context mContext;
    private IdataFunctions dao;
    private Listener mListener;

    public MainController(Context context) {
        mContext = context;
        dao = Dao.getInstance(mContext);
    }

    public void setListener(Listener listener) {
        mListener = listener;
    }

    public List<Task> getAllTasks() {
        List<Task> tasks = null;
        try {
            tasks = dao.getAllTasks();
        } catch (Exception e) {
            return new ArrayList<Task>();
        }
        return tasks;
    }

    public void removeTask(Task task) {
        dao.removeTask(task);
    }

    public void addTask(Task task) {
        Task t = dao.addTask(task);
        if(t == null) return;
        mListener.updateAdapterAboutChange(t);
    }
}
