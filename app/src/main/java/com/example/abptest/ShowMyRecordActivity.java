package com.example.abptest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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


public class ShowMyRecordActivity extends AppCompatActivity {


    private TextView tv_record,test,test2,test3,test4,test5;
    Button bt_bt6;
    private RequestQueue showRequst;
    private RequestQueue plz;
    Button bt_BT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_my_record);



        tv_record = (TextView) findViewById(R.id.tv_record);
        test = (TextView) findViewById(R.id.test);
        test2 = (TextView) findViewById(R.id.test2);
        test3 = (TextView) findViewById(R.id.test3);
        test4 = (TextView) findViewById(R.id.test4);
        test5 = (TextView) findViewById(R.id.test5);
        bt_BT = (Button)findViewById(R.id.bt5);

        final String userID = MyApp.user_id;

        showRequst = Volley.newRequestQueue(getApplicationContext());
        plz = Volley.newRequestQueue(getApplicationContext());


        final String showUrl = "http://jinu716.dothome.co.kr/show5.php";
        String ppurl = "http://jinu716.dothome.co.kr/plz.php";


        StringRequest pls = new StringRequest(Request.Method.POST, showUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String arg0) {


                try {
                    JSONArray students = new JSONArray(arg0);
                    for (int i = 0; i < students.length(); i++) {
                        JSONObject student = students.getJSONObject(i);

                        String userID = student.getString("userID");
                        int MYGAMES = student.getInt("MYGAMES");
                        int MYPA = student.getInt("MYPA");
                        int MYAB = student.getInt("MYAB");
                        int MYH = student.getInt("MYH");
                        int MYTB = student.getInt("MYTB");
                        int MYTREEB = student.getInt("MYTREEB");
                        int MYHR = student.getInt("MYHR");
                        int MYBB = student.getInt("MYBB");
                        int MYSO = student.getInt("MYSO");

                        tv_record.append(

                                        "출장수 :" + MYGAMES + "\n" +
                                        "타석 :" + MYPA + "\n" +
                                        "타수 :" + MYAB + "\n" +
                                        "안타 :" + MYH + "\n" +
                                        "2루타 :" + MYTB + "\n" +
                                        "3루타 :" + MYTREEB + "\n" +
                                        "홈런 :" + MYHR + "\n" +
                                        "볼넷 :" + MYBB + "\n" +
                                        "삼진 :" + MYSO + "\n" +
                                        "\n");

                        //타율 구하는 공식
                        final float AVG;
                        AVG = (float) MYH / (float) MYAB;
                        String AVGs = String.format("%.3f", AVG);
                        test.setText("타율 :" + AVGs);


                        // 출루율 구하는 공식
                        final float OBP;
                        float OBPr1, OBPr2;

                        OBPr1 = (float) MYH + (float) MYBB;
                        OBPr2 = (float) MYAB + (float) MYBB;
                        OBP = OBPr1 / OBPr2;
                        String OBPs = String.format("%.3f", OBP);
                        test2.setText("출루율 :" + OBPs);


                        //장타율 구하는 공식

                        int SLGr11;
                        final float SLG;

                        SLGr11 = MYH + (2 * MYTB) + (3 * MYTREEB) + (4 * MYHR);

                        SLG = (float) SLGr11 / (float) MYPA;
                        String SLGs = String.format("%.3f", SLG);
                        test3.setText("장타율 :" + SLGs);

                        //OPS 구하는공식

                        final float OPS;
                        OPS = SLG + OBP;
                        String OPSs = String.format("%.3f", OPS);
                        test4.setText("OPS :" + OPSs);

                        //타석당 삼진확률

                        float KPA;
                        KPA = (float) MYSO / (float) MYPA * 100;
                        String KPAs = String.format("%3.2f", KPA);

                        //타석당 홈런확률

                        final float HRPA;
                        HRPA = (float) MYHR / (float) MYPA * 100;
                        String HRPAs = String.format("%3.2f", HRPA);


                        test5.append(" 타석당" + "\n" + "삼진을 당할 확률은 " + KPAs + "% 이고" + "\n" + "홈런을 칠 확률은 " + HRPAs + "% 입니다.");


                        bt_BT.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                Intent intent = new Intent(ShowMyRecordActivity.this, FPsalActivity.class);
                                intent.putExtra("value", OPS);
                                intent.putExtra("vAVG",AVG);
                                intent.putExtra("vOBP",OBP);
                                intent.putExtra("vSLG",SLG);
                                intent.putExtra("vHRPA",HRPA);


                                startActivity(intent);

                            }





                    });}

                }
                catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


        }}) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();

                parameters.put("userID",userID);

                return parameters;


            }
        };
        plz.add(pls);






        /*JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, showUrl,null,new Response.Listener<JSONObject>() {

                @Override
                public void onResponse(JSONObject arg0) {

                    try {
                        JSONArray students = arg0.getJSONArray("MYRECORD1");
                        for (int i = 0; i < students.length(); i++) {
                            JSONObject student = students.getJSONObject(0);

                            String userID = student.getString("userID");
                            int MYGAMES = student.getInt("MYGAMES");
                            int MYPA = student.getInt("MYPA");
                            int MYAB = student.getInt("MYAB");
                            int MYH = student.getInt("MYH");
                            int MYTB = student.getInt("MYTB");
                            int MYTREEB = student.getInt("MYTREEB");
                            int MYHR = student.getInt("MYHR");
                            int MYBB = student.getInt("MYBB");
                            int MYSO = student.getInt("MYSO");


                            tv_record.append(
                                    "출장수 :" + MYGAMES + "\n" +
                                            "타석 :" + MYPA + "\n" +
                                            "타수 :" + MYAB + "\n" +
                                            "안타 :" + MYH + "\n" +
                                            "2루타 :" + MYTB + "\n" +
                                            "3루타 :" + MYTREEB + "\n" +
                                            "홈런 :" + MYHR + "\n" +
                                            "볼넷 :" + MYBB + "\n" +
                                            "삼진 :" + MYSO + "\n" +
                                            "\n");

                            //타율 구하는 공식
                            float AVG;
                            AVG = (float) MYH / (float) MYAB;
                            String AVGs = String.format("%.3f", AVG);
                            test.setText("타율 :" + AVGs);


                            // 출루율 구하는 공식
                            float OBP;
                            float OBPr1, OBPr2;

                            OBPr1 = (float) MYH + (float) MYBB;
                            OBPr2 = (float) MYAB + (float) MYBB;
                            OBP = OBPr1 / OBPr2;
                            String OBPs = String.format("%.3f", OBP);
                            test2.setText("출루율 :" + OBPs);


                            //장타율 구하는 공식

                            int SLGr11;
                            float SLG;

                            SLGr11 = MYH + (2 * MYTB) + (3 * MYTREEB) + (4 * MYHR);

                            SLG = (float) SLGr11 / (float) MYPA;
                            String SLGs = String.format("%.3f", SLG);
                            test3.setText("장타율 :" + SLGs);

                            //OPS 구하는공식

                            final float OPS;
                            OPS = SLG + OBP;
                            String OPSs = String.format("%.3f", OPS);
                            test4.setText("OPS :" + OPSs);

                            //타석당 삼진확률

                            float KPA;
                            KPA = (float) MYSO / (float) MYPA * 100;
                            String KPAs = String.format("%3.2f", KPA);

                            //타석당 홈런확률

                            float HRPA;
                            HRPA = (float) MYHR / (float) MYPA * 100;
                            String HRPAs = String.format("%3.2f", HRPA);


                            test5.append(userID+" 타석당" + "\n" + "삼진을 당할 확률은 " + KPAs + "% 이고" + "\n" + "홈런을 칠 확률은 " + HRPAs + "% 입니다.");


                            bt_BT.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {

                                    Intent intent = new Intent(ShowMyRecordActivity.this, FPsalActivity.class);
                                    intent.putExtra("value", OPS);
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
                 }


                 );

                 showRequst.add(request);
*/
             }
         }













