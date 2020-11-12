package com.example.abptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class ShowMYPRecordActivity extends AppCompatActivity {


    private TextView textView9,tv_WIN,tv_ERA,tv_SB;
    private RequestQueue myprRequst;
    private RequestQueue pla;
    private Button button6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_myprecord);


        textView9 = (TextView)findViewById(R.id.tv_TT);
        tv_WIN = (TextView)findViewById(R.id.tv_WIN);
        tv_ERA = (TextView)findViewById(R.id.tv_ERA);
        tv_SB = (TextView)findViewById(R.id.tv_SB);
        button6 = (Button)findViewById(R.id.button6);

        final String userID = MyApp.user_id;


       myprRequst = Volley.newRequestQueue(getApplicationContext());
       String prUrl = "http://jinu716.dothome.co.kr/showpr.php";


       StringRequest PRrequst = new StringRequest(Request.Method.POST, prUrl, new Response.Listener<String>() {
           @Override
           public void onResponse(String arg0) {

               try {
                   JSONArray prs = new JSONArray(arg0);
                   for (int i = 0; i < prs.length(); i++) {
                       JSONObject pr = prs.getJSONObject(i);

                       int MPGAMES = pr.getInt("MPGAMES");
                       int MPW = pr.getInt("MPW");
                       int MPL = pr.getInt("MPL");
                       int MPIP = pr.getInt("MPIP");
                       int MPLR = pr.getInt("MPLR");
                       int MPH = pr.getInt("MPH");
                       int MPBB = pr.getInt("MPBB");
                       int MPSO = pr.getInt("MPSO");


                       textView9.append(
                               "등판수 :" + MPGAMES + "\n" +
                                       "승리 :" + MPW + "\n" +
                                       "패배 :" + MPL + "\n" +
                                       "이닝 :" + MPIP + "\n" +
                                       "자책점 :" + MPLR + "\n" +
                                       "피안타 :" +MPH +"\n"+
                                       "볼넷 :" + MPBB + "\n" +
                                       "삼진 :" + MPSO + "\n" +
                                       "\n");


                       // 승률 구하는 공식

                       final float WINP;
                       float WINP1;
                       WINP1 = (float) MPW + (float) MPL;
                       WINP = (float) MPW / WINP1;

                       String WINPs = String.format("%.3f", WINP);

                       tv_WIN.setText("승률: " + WINPs);

                       //방어율 구하는 공식

                       final float ERA;
                       float ERA1;
                       ERA1 = (float) MPLR * 9;
                       ERA = ERA1 / (float) MPIP;

                       String ERAs = String.format("%3.2f", ERA);

                       tv_ERA.setText("방어율 " + ERAs);


                       //볼넷삼진비율

                       final float SB;
                       SB = (float) MPSO / (float) MPBB;
                       String SBs = String.format("%.0f", SB);

                       // whip 구하는 공식
                       final float WHIP,WHIP1;
                       WHIP1 = (float)MPH + (float) MPBB;
                       WHIP = WHIP1 / (float)MPIP;


                       tv_SB.append("당신은 볼넷 1개당 " + SBs + "개의 삼진을 잡고 있습니다!");


                       button6.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View view) {

                               Intent intent = new Intent(ShowMYPRecordActivity.this, MPsalActivity.class);
                               intent.putExtra("vERA",ERA);
                               intent.putExtra("vWINP",WINP);
                               intent.putExtra("vSB",SB);
                               intent.putExtra("vWHIP",WHIP);
                               startActivity(intent);

                           }
                       });


                   }
               } catch (JSONException e) {
                   e.printStackTrace();
               }

           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {

           }
       }) {

           @Override
           protected Map<String, String> getParams() throws AuthFailureError {
               Map<String, String> parameters = new HashMap<String, String>();

               parameters.put("userID",userID);

               return parameters;


           }
       };

        myprRequst.add(PRrequst);





       /*JsonObjectRequest prequst = new JsonObjectRequest(Request.Method.GET, prUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject arg0) {

                try {
                    JSONArray prs = arg0.getJSONArray("MYPITRECORD");
                    for (int i = 0; i < prs.length(); i++) {
                        JSONObject pr = prs.getJSONObject(i);

                        int MPGAMES = pr.getInt("MPGAMES");
                        int MPW = pr.getInt("MPW");
                        int MPL = pr.getInt("MPL");
                        int MPIP = pr.getInt("MPIP");
                        int MPLR = pr.getInt("MPLR");
                        int MPBB = pr.getInt("MPBB");
                        int MPSO = pr.getInt("MPSO");


                        textView9.append(
                                "등판수 :" + MPGAMES + "\n" +
                                        "승리 :" + MPW + "\n" +
                                        "패배 :" + MPL + "\n" +
                                        "이닝 :" + MPIP + "\n" +
                                        "자책점 :" + MPLR + "\n" +
                                        "볼넷 :" + MPBB + "\n" +
                                        "삼진 :" + MPSO + "\n" +
                                        "\n");


                        // 승률 구하는 공식

                        float WINP;
                        float WINP1;
                        WINP1 = (float) MPW + (float) MPL;
                        WINP = (float) MPW / WINP1;

                        String WINPs = String.format("%.3f", WINP);

                        tv_WIN.setText("승률: " + WINPs);

                        //방어율 구하는 공식

                        final float ERA;
                        float ERA1;
                        ERA1 = (float) MPLR * 9;
                        ERA = ERA1 / (float) MPIP;

                        String ERAs = String.format("%3.2f", ERA);

                        tv_ERA.setText("방어율 " + ERAs);


                        //볼넷삼진비율

                        float SB;
                        SB = (float) MPSO / (float) MPBB;
                        String SBs = String.format("%.0f", SB);


                        tv_SB.append("당신은 볼넷 1개당 " + SBs + "개의 삼진을 잡고 있습니다!");


                        button6.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent intent = new Intent(ShowMYPRecordActivity.this, MPsalActivity.class);
                                intent.putExtra("vERA", ERA);
                                startActivity(intent);

                            }


                        });


                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError arg0) {


            }
        });

        myprRequst.add(prequst);
        */



    }
}
