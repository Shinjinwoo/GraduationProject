package com.example.abptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MyrecordActivity extends AppCompatActivity {

    final static private String showUrl = "http://jinu716.dothome.co.kr/show2.php";

    private Button bt_insert,bt_showrecord,bt_myrmain,bt_myrlogout,bt_mrback;

    RequestQueue testRequstqueue;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrecord);

        testRequstqueue = Volley.newRequestQueue(this);

        Intent intent = getIntent();
        final String userID = MyApp.user_id;

        bt_mrback = findViewById(R.id.bt_mrback);
        bt_mrback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MyrecordActivity.this,RecordActivity.class);
                startActivity(intent);

            }
        });


        bt_myrmain = findViewById(R.id.bt_myrmain);
        bt_myrmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MyrecordActivity.this,MainActivity.class);
                startActivity(intent);

            }
        });

        bt_myrlogout = findViewById(R.id.bt_myrlogout);
        bt_myrlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MyrecordActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });






        bt_showrecord = findViewById(R.id.bt_showrecord);
        bt_showrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent = new Intent(MyrecordActivity.this,SplitShowAcitivity.class);

                startActivity(intent);

            }
        });


        bt_insert = findViewById(R.id.bt_insert);
        bt_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MyrecordActivity.this,SplitRecordActivity.class);
                intent.putExtra("toSr",userID);
                startActivity(intent);

            }
        });









    }
}
