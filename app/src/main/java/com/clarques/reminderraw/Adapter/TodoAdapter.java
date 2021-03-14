package com.clarques.reminderraw.Adapter;

import android.annotation.SuppressLint;
import android.app.Application;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.clarques.reminderraw.R;
import com.clarques.reminderraw.util.PlanType2Image;
import com.clarques.reminderraw.vo.plan;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private List<plan> mPlanList;

    public TodoAdapter(List<plan> mPlanList) {
        this.mPlanList = mPlanList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.todoView.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint({"ClickableViewAccessibility", "ShowToast"})
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int position = holder.getAdapterPosition();
                plan p = mPlanList.get(position);
                Toast.makeText(v.getContext(),"clicked"+p.getPlanName(),Toast.LENGTH_SHORT);
                return false;
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        plan p = mPlanList.get(position);
        holder.planName.setText(p.getPlanName());
        holder.planTypeImage.setImageResource(PlanType2Image.getImageOfPlanType(p.getPlanType()));
        holder.intro.setText(p.getBriefIntro());

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        holder.startTimeView.setText(format.format(p.getStartTime()));
        holder.endTimeView.setText(format.format(p.getEndTime()));
    }

    @Override
    public int getItemCount() {
        return mPlanList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        View todoView;
        TextView planName;
        ImageView planTypeImage;
        TextView startTimeView;
        TextView endTimeView;
        TextView intro;

        public ViewHolder(View view) {
            super(view);
            todoView = view;
            planName = view.findViewById(R.id.todo_name);
            planTypeImage = view.findViewById(R.id.plan_type_image);
            startTimeView = view.findViewById(R.id.startTime);
            endTimeView = view.findViewById(R.id.endTime);
            intro = view.findViewById(R.id.intro);
        }
    }

}
