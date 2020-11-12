package com.example.abptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class MPinsertActivity extends AppCompatActivity {


    final static private String url = "http://jinu716.dothome.co.kr/mpitest.php";

    RequestQueue mpQueue;

    private EditText et_MPGAMES,et_MPW,et_MPL,et_MPIP,et_MPLR,et_MPBB,et_MPSO,et_MPH;
    private Button bt_Mpinsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpinsert);

        bt_Mpinsert = findViewById(R.id.bt_Mpinsert);



        et_MPGAMES = findViewById(R.id.et_MPGAMES);
        et_MPW = findViewById(R.id.et_MPW);
        et_MPL = findViewById(R.id.et_MPL);
        et_MPIP = findViewById(R.id.et_MPIP);
        et_MPLR = findViewById(R.id.et_MPLR);
        et_MPBB = findViewById(R.id.et_MPBB);
        et_MPSO = findViewById(R.id.et_MPSO);
        et_MPH = findViewById(R.id.et_MPH);
        final String userID = MyApp.user_id;


        mpQueue = Volley.newRequestQueue(getApplicationContext());


        bt_Mpinsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                StringRequest Mptest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        Toast.makeText(getApplicationContext(), "기록입력에 성공 하였습니다.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MPinsertActivity.this,RecordActivity.class);
                        startActivity(intent);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(getApplicationContext(), "기록입력에 실패 하였습니다.", Toast.LENGTH_SHORT).show();

                    }


                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("userID",userID);
                        parameters.put("MPGAMES", et_MPGAMES.getText().toString());
                        parameters.put("MPW", et_MPW.getText().toString());
                        parameters.put("MPL", et_MPL.getText().toString());
                        parameters.put("MPIP", et_MPIP.getText().toString());
                        parameters.put("MPLR", et_MPLR.getText().toString());
                        parameters.put("MPH", et_MPH.getText().toString());
                        parameters.put("MPBB", et_MPBB.getText().toString());
                        parameters.put("MPSO", et_MPSO.getText().toString());


                        return parameters;

                    }

                };
                mpQueue.add(Mptest);


            }

        });



    }
}
