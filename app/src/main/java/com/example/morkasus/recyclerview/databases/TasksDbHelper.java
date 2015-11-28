package com.example.morkasus.recyclerview.databases;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by morkasus on 24/11/2015.
 */
public class TasksDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "tasks.db";

    public TasksDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_TABLE = "CREATE TABLE "
                + TasksDbFinals.TaskStrings.TABLE_NAME + " (" + TasksDbFinals.TaskStrings._ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + TasksDbFinals.TaskStrings.COLUMN_TASK_TITLE
                + " TEXT NOT NULL, " + TasksDbFinals.TaskStrings.COLUMN_TASK_BODY
                + " TEXT NOT NULL)";
        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TasksDbFinals.TaskStrings.TABLE_NAME);
        onCreate(db);
    }
}
