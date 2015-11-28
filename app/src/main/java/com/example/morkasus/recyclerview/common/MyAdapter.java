package com.example.morkasus.recyclerview.common;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.morkasus.recyclerview.R;
import com.example.morkasus.recyclerview.ui.MainActivity;

import java.util.List;

/**
 * Created by morkasus on 06/11/2015.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private Context mContext;
    private List<Task> mTasks;

    public MyAdapter(Context context, List<Task> tasks) {
        super();
        mContext = context;
        mTasks = tasks;
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
        holder.bind(mTasks.get(position));
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }


    public Task getTaskInPosition(int position) {
        return mTasks.get(position);
    }

    public void add(Task task) {
        mTasks.add(task);
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
        }
        public void bind(Task t) {
            title.setText(t.getTitle());
            task.setText(t.getTask());
            doneButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if(mContext instanceof MainActivity){
                        ((MainActivity)mContext).removeTask(mTasks.get(position));
                    }
                    removeAt(position);
                }
            });
        }
    }
}