package com.example.signup;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;

public class CourseAdapter  extends RecyclerView.Adapter<CourseHolder> {

    Context context ;
    ArrayList<Courses>courses;

    public CourseAdapter(@NonNull Context context, ArrayList<Courses> courses) {
        this.context = context;
        this.courses = courses;
    }

    public CourseHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(context).inflate(R.layout.courseslist,parent,false);
        CourseHolder courseHolder =new  CourseHolder(view);
        return courseHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull CourseHolder holder, final int position) {
       holder.img.setImageResource(courses.get(position).getImg());
       holder.course.setText(courses.get(position).getCname());
        holder.Duration.setText(courses.get(position).getDuration());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, Coursedetail.class);
                intent.putExtra("name",courses.get(position).getCname());
                intent.putExtra("duration",courses.get(position).getDuration());
                intent.putExtra("img",courses.get(position).getImg());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return courses.size();
    }
}
