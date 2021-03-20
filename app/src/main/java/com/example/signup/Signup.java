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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signup extends AppCompatActivity {
EditText name, email, pass;
FirebaseAuth auth;
FirebaseDatabase database;
DatabaseReference reference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

  init();



    }

    private void init() {
        name =findViewById(R.id.editText3);
        email=findViewById(R.id.editText5);
        pass =findViewById(R.id.editText4);
        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        reference=database.getReference();

    }


    public void signup(View view) {

        String naam = name.getText().toString();
        String mail = email.getText().toString();
        String pas = pass.getText().toString();
        if(mail.isEmpty()){

            email.setError("required");
        }else   if(pas.isEmpty()){

            pass.setError("required");
        }
        else {
            signupp(naam,mail,pas);
        }
    }

    private void signupp(final String naam, final String mail, final String pas) {

        auth.createUserWithEmailAndPassword(mail,pas).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    String key =auth.getCurrentUser().getUid();
                    User user =new User(naam,mail,pas);
                    reference.child(key).setValue(user);
                    Intent intent =new Intent(Signup.this,Home.class);
                    startActivity(intent);

                }else {
                    Toast.makeText(Signup.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}
