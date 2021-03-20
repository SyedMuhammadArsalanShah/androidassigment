package com.example.signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Courseadd extends AppCompatActivity {
EditText cname,cdetails;
FirebaseDatabase database;
DatabaseReference reference;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courseadd);
        init();

    }

    private void init() {


        cname =findViewById(R.id.editText8);
        cdetails =findViewById(R.id.editText9);
        database=FirebaseDatabase.getInstance();
        reference=database.getReference("courses");
    }


    public void add(View view) {

        String name=cname.getText().toString();
        String duaration=cdetails.getText().toString();

        Courses courses =new Courses(name,duaration,R.drawable.ic_launcher_background);

        String key1 =reference.push().getKey();
     //   String key =auth.getCurrentUser().getUid();
        reference.child(key1).setValue(courses).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
              if (task.isSuccessful()){

                  Intent intent =new Intent(Courseadd.this,Home.class);
                  startActivity(intent);

              }else {
                  Toast.makeText(Courseadd.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
              }
            }
        });


    }
}
