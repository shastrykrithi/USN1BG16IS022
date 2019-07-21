package com.example.hiranmayee.onlinevoting;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Final extends AppCompatActivity {
     Button logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);
        logout=(Button)findViewById(R.id.bu1);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Finishing current DashBoard activity on button click.
                finish();
                Intent intent = new Intent(Final.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
