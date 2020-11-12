package com.example.abptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class InsertActivity extends AppCompatActivity {

    final static private String url = "http://jinu716.dothome.co.kr/mfitest.php";

    RequestQueue requestQueue;

    private EditText et_MYGAMES,et_MYPA,et_MYAB,et_MYH,et_MYTB,et_MYTREEB,et_MYHR,et_MYBB,et_MYSO;

    private Button bt_test,bt_InsertMM;

    String userID = MyApp.user_id;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);


        bt_test = findViewById(R.id.bt_test);
        bt_InsertMM = findViewById(R.id.bt_InsertMM);






        et_MYGAMES = findViewById(R.id.et_MYGAMES);
        et_MYPA =  findViewById(R.id.et_MYPA);
        et_MYAB =  findViewById(R.id.et_MYAB);
        et_MYH =  findViewById(R.id.et_MYH);
        et_MYTB =  findViewById(R.id.et_MYTB);
        et_MYTREEB = findViewById(R.id.et_MYTREEB);
        et_MYHR =  findViewById(R.id.et_MYHR);
        et_MYBB = findViewById(R.id.et_MYBB);
        et_MYSO = findViewById(R.id.et_MYSO);

        final String userID = MyApp.user_id;













        requestQueue = Volley.newRequestQueue(getApplicationContext());



        bt_InsertMM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(InsertActivity.this,MPinsertActivity.class);
                startActivity(intent);

            }
        });


        bt_test.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                StringRequest test = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getApplicationContext(), "기록입력에 성공 하였습니다.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(InsertActivity.this,MyrecordActivity.class);
                        startActivity(intent);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {


                        Toast.makeText(getApplicationContext(), "기록입력에 실패 하였습니다.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(InsertActivity.this,MyrecordActivity.class);
                        startActivity(intent);

                    }
                } ) {

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();

                        parameters.put("userID",userID);
                        parameters.put("MYGAMES", et_MYGAMES.getText().toString());
                        parameters.put("MYPA", et_MYPA.getText().toString());
                        parameters.put("MYAB", et_MYAB.getText().toString());
                        parameters.put("MYH", et_MYH.getText().toString());
                        parameters.put("MYTB", et_MYTB.getText().toString());
                        parameters.put("MYTREEB", et_MYTREEB.getText().toString());
                        parameters.put("MYHR", et_MYHR.getText().toString());
                        parameters.put("MYBB", et_MYBB.getText().toString());
                        parameters.put("MYSO", et_MYSO.getText().toString());

                        return parameters;


                    }
                };
                requestQueue.add(test);
            }


        });
    }

}
