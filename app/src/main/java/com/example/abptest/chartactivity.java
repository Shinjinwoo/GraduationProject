package com.example.abptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class chartactivity extends AppCompatActivity {

    RequestQueue profil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chartactivity);

        profil = Volley.newRequestQueue(this);
        TextView tv_record1;
        String url = "";


        StringRequest chartpro = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String arg0) {

                try {
                    JSONArray students = new JSONArray(arg0);
                    for (int i = 0; i < students.length(); i++) {
                        JSONObject student = students.getJSONObject(i);

                        int PROGAMES = student.getInt("GAMES");
                        int PROPA = student.getInt("PA");
                        int PROAB = student.getInt("AB");
                        int PROH = student.getInt("H");
                        int PROTB = student.getInt("TB");
                        int PROTREEB = student.getInt("TREEB");
                        int PROHR = student.getInt("HR");
                        int PROBB = student.getInt("BB");
                        int PROSO = student.getInt("SO");




                        }

                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }


        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        profil.add(chartpro);







    }
}
