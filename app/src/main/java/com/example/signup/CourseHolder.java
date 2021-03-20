package com.example.signup;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CourseHolder extends RecyclerView.ViewHolder {
    ImageView img;
    TextView course;
    TextView Duration;


    public CourseHolder(@NonNull View itemView) {
        super(itemView);
        img =itemView.findViewById(R.id.img);
        course=itemView.findViewById(R.id.name);
        Duration=itemView.findViewById(R.id.detail);

    }
}
