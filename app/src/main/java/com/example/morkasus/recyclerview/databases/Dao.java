package com.example.morkasus.recyclerview.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.morkasus.recyclerview.common.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by morkasus on 24/11/2015.
 */
public class Dao implements IdataFunctions{

    private static Dao mDao;
    private Context mContext;
    private TasksDbHelper mHelper;
    private String[] tasksColumns = { TasksDbFinals.TaskStrings._ID,
            TasksDbFinals.TaskStrings.COLUMN_TASK_TITLE,
            TasksDbFinals.TaskStrings.COLUMN_TASK_BODY};

    private Dao(Context context) {
        mContext = context;
        mHelper = new TasksDbHelper(this.mContext);
    }

    public static Dao getInstance(Context context) {
        if(mDao == null) {
            mDao = new Dao(context);
        }
        return mDao;
    }


    @Override
    public List<Task> getAllTasks() {
        SQLiteDatabase db = null;
        try {
            db = mHelper.getReadableDatabase();
            List<Task> tasks = new ArrayList<Task>();
            Cursor cursor = db.query(TasksDbFinals.TaskStrings.TABLE_NAME,
                    tasksColumns,
                    null, null, null, null, TasksDbFinals.TaskStrings._ID);
            cursor.moveToFirst();
            while(!cursor.isAfterLast()) {
                tasks.add(cursorToTask(cursor));
                cursor.moveToNext();
            }
            cursor.close();
            return tasks;
        } finally {
            if (db != null)
                db.close();
        }
    }

    @Override
    public void removeTask(Task task) {
        if (task == null) return;
        SQLiteDatabase db = null;
        try {
            db = mHelper.getReadableDatabase();
            int id = task.getId();
            db.delete(TasksDbFinals.TaskStrings.TABLE_NAME,
                    TasksDbFinals.TaskStrings._ID + " = " + id,
                    null);
        } finally {
            if(db != null)
                db.close();
        }
    }

    @Override
    public Task addTask(Task task) {
        if(task == null) return null;
        SQLiteDatabase db = null;
        try {
            db = mHelper.getReadableDatabase();

            ContentValues values = new ContentValues();
            values.put(TasksDbFinals.TaskStrings.COLUMN_TASK_TITLE, task.getTitle());
            values.put(TasksDbFinals.TaskStrings.COLUMN_TASK_BODY, task.getTask());

            long i = db.insert(TasksDbFinals.TaskStrings.TABLE_NAME, null, values);

            Cursor cursor = db.query(TasksDbFinals.TaskStrings.TABLE_NAME,
                    tasksColumns,
                    TasksDbFinals.TaskStrings._ID + " = " + i,
                    null, null, null, null);
            cursor.moveToFirst();

            Task newTask = cursorToTask(cursor);
            newTask.setId((int)i);
            cursor.close();
            return newTask;
        } finally {
            if (db != null)
                db.close();
        }
    }

    private Task cursorToTask(Cursor cursor) {
        Task task = new Task();

        task.setId(cursor.getInt(cursor.getColumnIndex(
                TasksDbFinals.TaskStrings._ID)));
        task.setTitle(cursor.getString(cursor.getColumnIndex(
                TasksDbFinals.TaskStrings.COLUMN_TASK_TITLE)));
        task.setTask(cursor.getString(cursor.getColumnIndex(
                TasksDbFinals.TaskStrings.COLUMN_TASK_BODY)));

        return task;
    }

}
