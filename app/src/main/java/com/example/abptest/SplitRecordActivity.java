package com.example.abptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplitRecordActivity extends AppCompatActivity {



    Button bt_ToPR,bt_ToFR,bt_Splogout,bt_DRT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_record);

        bt_ToPR = findViewById(R.id.bt_ToPR);
        bt_ToFR = findViewById(R.id.bt_ToFR);
        bt_Splogout = findViewById(R.id.bt_Splogout);

        Intent intent = getIntent();
        final String userID = intent.getStringExtra("toSr");



        bt_ToPR .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplitRecordActivity.this,MPinsertActivity.class);
                intent.putExtra("userIDp",userID);
                startActivity(intent);
            }
        });

        bt_ToFR .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplitRecordActivity.this,InsertActivity.class);
                intent.putExtra("userIDf",userID);
                startActivity(intent);
            }
        });

        bt_Splogout .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplitRecordActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });













    }
}
