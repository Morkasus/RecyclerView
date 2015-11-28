package com.example.morkasus.recyclerview.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;

import com.example.morkasus.recyclerview.controllers.MainController;
import com.example.morkasus.recyclerview.common.Listener;
import com.example.morkasus.recyclerview.common.MyAdapter;
import com.example.morkasus.recyclerview.R;
import com.example.morkasus.recyclerview.common.Task;


public class MainActivity extends AppCompatActivity implements Listener {

    public static final String TITLE = "TITLE";
    public static final String BODY = "BODY";

    private MainController mController;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private MyAdapter mAdapter;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mController = new MainController(this);
        mController.setListener(this);

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new MyAdapter(this, mController.getAllTasks());
        mRecyclerView.setAdapter(mAdapter);

        addButton = (Button) findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivityForResult(intent, 1);
            }
        });

    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String title = data.getStringExtra(TITLE);
                String task = data.getStringExtra(BODY);
                mController.addTask(new Task(title, task));
            }
        }
    }

    @Override
    public void updateAdapterAboutChange(Task task) {
            mAdapter.add(task);
    }

    public void removeTask(Task task) {
        mController.removeTask(task);
    }
}