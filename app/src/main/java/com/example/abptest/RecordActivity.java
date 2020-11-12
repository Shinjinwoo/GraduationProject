package com.example.abptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class RecordActivity extends AppCompatActivity {

    final static private String url = "http://jinu716.dothome.co.kr/del.php";
    private Button bt_serch,bt_home,bt_logoutrecord,bt_myrecord;


    RequestQueue delQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        Intent intent = getIntent();
        final String userID = intent.getStringExtra("toMain");

        delQueue = Volley.newRequestQueue(getApplicationContext());


        bt_serch = (Button)findViewById(R.id.bt_serch);
        bt_serch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RecordActivity.this,SerchActivity.class);
                startActivity(intent);

            }
        });


        bt_home = (Button)findViewById(R.id.bt_home);
        bt_home.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {


                Intent intent = new Intent(RecordActivity.this, MainActivity.class);
                startActivity(intent);

            }


        });


        /* bt_home.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View view) {

                Intent intent = new Intent(RecordActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
        */

        bt_logoutrecord = (Button)findViewById(R.id.bt_logoutrecord);
        bt_logoutrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RecordActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

        bt_myrecord = (Button)findViewById(R.id.bt_myrecord);
        bt_myrecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(RecordActivity.this,MyrecordActivity.class);
                intent.putExtra("toMr",userID);
                startActivity(intent);

            }
        });




    }
}
