package com.example.morkasus.recyclerview.databases;

import com.example.morkasus.recyclerview.common.Task;

import java.util.List;

/**
 * Created by morkasus on 24/11/2015.
 */
public interface IdataFunctions {

    List<Task> getAllTasks();
    void removeTask(Task task);
    Task addTask(Task task);
}
