package com.example.abptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView abp_id,abp_pass;
    private Button bt_record,bt_news,bt_kbo,bt_logoutmain,bt_Pro,bt_Ama,bt_abpr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        final String userID = intent.getStringExtra("toMain");

       /* 인자값 받아오기

       abp_id = findViewById(R.id.abp_id);

        final Intent intent = getIntent();
        String userID = intent.getStringExtra("userID");


        abp_id.setText(userID+"님");*/

       bt_Pro = (Button)findViewById(R.id.bt_Pro);
       bt_Pro.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent intent = new Intent(MainActivity.this,ProMainActivity.class);
               startActivity(intent);


           }
       });

       bt_Ama = (Button)findViewById(R.id.bt_Ama);
       bt_Ama.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent intent = new Intent(MainActivity.this,AmaMainActivity.class);
               startActivity(intent);

           }
       });

        /*bt_kbo = (Button)findViewById(R.id.bt_kbo);
        bt_kbo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,KboActivity.class);
                startActivity(intent);
            }
        });*/


        /*bt_news = (Button)findViewById(R.id.bt_news);
        bt_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,NewsActivity.class);
                startActivity(intent);

            }
        });*/

        bt_logoutmain = (Button)findViewById(R.id.bt_logoutmain);
        bt_logoutmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        bt_record =(Button)findViewById(R.id.bt_record);
        bt_record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,RecordActivity.class);
                intent.putExtra("toReacord",userID);
                startActivity(intent);
            }
        });

        bt_abpr = (Button)findViewById(R.id.bt_abpr);
        bt_abpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AbprActivity.class);
                startActivity(intent);
            }
        });


    }
}
