package com.example.abptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ProMainActivity extends AppCompatActivity {


    private Button bt_Pro_live,bt_ProMatch,bt_ProEntry,bt_ProNews,bt_ProMain,bt_ProLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro_main);


        bt_Pro_live = (Button)findViewById(R.id.bt_Pro_live);
        bt_Pro_live.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ProMainActivity.this,ProLiveActivity.class);
                startActivity(intent);

            }
        });

        bt_ProMatch = (Button)findViewById(R.id.bt_ProMatch);
        bt_ProMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ProMainActivity.this,ProMatchActivity.class);
                startActivity(intent);

            }
        });


        bt_ProEntry = (Button)findViewById(R.id.bt_ProEntry);
        bt_ProEntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ProMainActivity.this,ProPlayerEntry.class);
                startActivity(intent);

            }
        });

        bt_ProNews = (Button)findViewById(R.id.bt_ProNews);
        bt_ProNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ProMainActivity.this,NewsActivity.class);
                startActivity(intent);

            }
        });

        bt_ProMain = (Button)findViewById(R.id.bt_ProMain);
        bt_ProMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ProMainActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });



        bt_ProLogout = (Button)findViewById(R.id.bt_ProLogout);
        bt_ProLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ProMainActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });






    }
}
