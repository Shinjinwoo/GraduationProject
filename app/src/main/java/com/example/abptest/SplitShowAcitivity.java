package com.example.abptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SplitShowAcitivity extends AppCompatActivity {


    Button bt_PrShow,bt_FrShow,bt_ssMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_split_show_acitivity);


        bt_PrShow = findViewById(R.id.bt_PrShow);
        bt_FrShow = findViewById(R.id.bt_FrShow);
        bt_ssMain = findViewById(R.id.bt_ssMain);


        bt_PrShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SplitShowAcitivity.this,ShowMYPRecordActivity.class);
                startActivity(intent);

            }
        });


        bt_FrShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SplitShowAcitivity.this,ShowMyRecordActivity.class);
                startActivity(intent);

            }
        });

        bt_ssMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(SplitShowAcitivity.this,MainActivity.class);
                startActivity(intent);

            }
        });








    }
}
