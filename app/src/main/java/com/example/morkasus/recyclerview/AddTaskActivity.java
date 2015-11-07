package com.example.morkasus.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddTaskActivity extends Activity {

    Button addTaskButton;
    EditText titleEditText;
    EditText taskEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        titleEditText = (EditText) findViewById(R.id.titleEditText);
        taskEditText = (EditText) findViewById(R.id.taskEditText);

        addTaskButton = (Button) findViewById(R.id.addTaskButton);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = titleEditText.getText().toString();
                String task = taskEditText.getText().toString();

                if(title.equals("") || task.equals("")){
                    Toast.makeText(AddTaskActivity.this,"Please enter Title and Task",Toast.LENGTH_LONG).show();
                }
                else {

                    Intent intent = new Intent();
                    intent.putExtra("TITLE",title);
                    intent.putExtra("TASK",task);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });



    }
}
