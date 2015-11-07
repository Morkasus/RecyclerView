package com.example.morkasus.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by morkasus on 06/11/2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    public List<Task> mTasks;
    public MyAdapter() {
        super();
        mTasks = new ArrayList<Task>();
        add(new Task("Demo", "demo demo demo demo demo"));
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_raw, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Task task = mTasks.get(position);
        holder.title.setText(task.getTitle());
        holder.task.setText(task.getTask());
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }


    public void add(Task item) {
        mTasks.add(item);
        notifyDataSetChanged();
    }

    public void removeAt(int position) {
        mTasks.remove(position);
        notifyDataSetChanged();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView task;
        public Button doneButton;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
            task = (TextView)itemView.findViewById(R.id.task);
            doneButton = (Button) itemView.findViewById(R.id.doneButton);

            doneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    removeAt(position);
                }
            });
        }
    }
}