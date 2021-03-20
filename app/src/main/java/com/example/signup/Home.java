package com.example.signup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.lang.ref.Reference;
import java.util.ArrayList;
import java.util.Scanner;

public class Home extends AppCompatActivity {
    FirebaseAuth auth;
    CourseAdapter adapter;
    ArrayList<Courses> coursearray;
    FirebaseDatabase database;
    DatabaseReference reference;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        array();
        ref();
    }

    private void ref() {


        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                 Courses courses= snapshot.getValue(Courses.class);
                 coursearray.add(courses);
                 adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void array() {

        adapter = new CourseAdapter(Home.this, coursearray);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Home.this);
        linearLayoutManager.setOrientation(recyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        coursearray.add (new Courses("Php course","3months",R.drawable.php));
        coursearray.add (new Courses("Java & AppDevelopment  course","3months",R.drawable.java));


    }

    private void init() {
        auth = FirebaseAuth.getInstance();
        recyclerView = findViewById(R.id.recyclerView);
        coursearray = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        reference = database.getReference("courses");
    }

    public void logout(View view) {

        auth.signOut();
        Intent intent = new Intent(Home.this, MainActivity.class);
        startActivity(intent);
    }

    public void add(View view) {
        Intent intent = new Intent(Home.this, Courseadd.class);
        startActivity(intent);
    }
}
