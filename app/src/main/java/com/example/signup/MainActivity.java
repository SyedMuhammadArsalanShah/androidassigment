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

public class MainActivity extends AppCompatActivity {
 EditText name;
 EditText pass;
 FirebaseAuth auth;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        init();

        if(auth.getCurrentUser() != null){
            Intent intent = new Intent(MainActivity.this, Home.class);
            startActivity(intent);}
    }

    private void init() {



        name =findViewById(R.id.editText);
        pass=findViewById(R.id.editText2);
        auth =FirebaseAuth.getInstance();

    }

    public void login(View view) {
        String mail= name.getText().toString();
        String pas= pass.getText().toString();
        if (mail.isEmpty()){

            name.setError("required");

        }else if(pas.isEmpty()){

            pass.setError("required");

        }else{

            login(mail,pas);


        }







    }

    private void login(String mail, String pas) {

        auth.signInWithEmailAndPassword(mail,pas).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){

                    Intent intent =new Intent(MainActivity.this,Home.class);
                    startActivity(intent);

                }else{
                    Toast.makeText(MainActivity.this,task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    public void signup(View view) {


        Intent intent =new Intent(MainActivity.this,Signup.class);
        startActivity(intent);



    }
}
