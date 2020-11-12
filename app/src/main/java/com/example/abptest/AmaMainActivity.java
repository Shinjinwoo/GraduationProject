package com.example.abptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AmaMainActivity extends AppCompatActivity {


    private Button bt_AmaMarket,bt_AmaplayerRequst,bt_AmaMatch,bt_AmaMain,bt_AmaLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ama_main);


        bt_AmaMarket = (Button)findViewById(R.id.bt_AmaMarket);
        bt_AmaMarket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AmaMainActivity.this,AmaMarketActivity.class);
                startActivity(intent);

            }
        });


        bt_AmaplayerRequst = (Button)findViewById(R.id.bt_AmaplayerRequst);
        bt_AmaplayerRequst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AmaMainActivity.this,AmaPlyaerRequstActivity.class);
                startActivity(intent);

            }
        });


        bt_AmaMatch = (Button)findViewById(R.id.bt_AmaMatch);
        bt_AmaMatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AmaMainActivity.this,AmaMatchActivity.class);
                startActivity(intent);

            }
        });

        bt_AmaMain = (Button)findViewById(R.id.bt_AmaMain);
        bt_AmaMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AmaMainActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

        bt_AmaLogout = (Button)findViewById(R.id.bt_AmaLogout);
        bt_AmaLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AmaMainActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });













    }
}
