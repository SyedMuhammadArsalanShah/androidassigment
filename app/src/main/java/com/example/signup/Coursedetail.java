package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Coursedetail extends AppCompatActivity {
    TextView name;
    TextView duration;
    ImageView imageIV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coursedetail);
        init();
        Bundle bundle=getIntent().getExtras();
        String cname=bundle.getString("name");
        String cduration =bundle.getString("duration");
        int image=bundle.getInt("img");
        name.setText(cname);
        duration.setText(cduration);
        imageIV.setImageResource(image);
    }

    private void init() {


        name=findViewById(R.id.editText8);
        duration=findViewById(R.id.editText9);
        imageIV=findViewById(R.id.imageView);



    }

}
