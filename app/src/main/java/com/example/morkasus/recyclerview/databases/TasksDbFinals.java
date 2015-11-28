package com.example.morkasus.recyclerview.databases;

import android.provider.BaseColumns;

/**
 * Created by morkasus on 24/11/2015.
 */
public class TasksDbFinals {

    public static final class TaskStrings implements BaseColumns {

        public static final String TABLE_NAME = "tasks";
        public static final String COLUMN_TASK_TITLE = "task_title";
        public static final String COLUMN_TASK_BODY = "task_body";

    }
}
