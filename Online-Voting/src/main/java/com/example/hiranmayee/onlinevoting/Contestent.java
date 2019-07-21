package com.example.hiranmayee.onlinevoting;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class Contestent extends AppCompatActivity {
    Button one,two,three;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contestent);


        one=(Button)findViewById(R.id.button1);
        two=(Button)findViewById(R.id.button2);
        three=(Button)findViewById(R.id.button3);

        Intent intent=getIntent();



        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View textview1) {

                //Finishing current DashBoard activity on button click.

                Intent i = new Intent(Contestent.this, Final.class);
                startActivity(i);
                finish();

            }
        });


        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View textview1) {

                //Finishing current DashBoard activity on button click.

                Intent j = new Intent(Contestent.this, Final.class);
                startActivity(j);
                finish();

            }
        });


        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View textview1) {

                //Finishing current DashBoard activity on button click.

                Intent k = new Intent(Contestent.this, Final.class);
                startActivity(k);
                finish();

            }
        });


    }

}