package com.example.abptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class FPsalActivity extends AppCompatActivity {

    private TextView tv_EXTRA,tv_tps;
    BarChart c_bar2;
    Button bt_myfchart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpsal);

        tv_EXTRA = (TextView) findViewById(R.id.tt1);
        tv_tps = (TextView)findViewById(R.id.tps);

        c_bar2 = (BarChart)findViewById(R.id.c_bar2);

        c_bar2.setDrawBarShadow(false);
        c_bar2.setDrawValueAboveBar(true);
        c_bar2.setMaxVisibleValueCount(100);
        c_bar2.setPinchZoom(false);
        c_bar2.setDrawGridBackground(true);


        bt_myfchart=(Button)findViewById(R.id.bt_myfchart);


        Intent intent = getIntent();
        float userOPS = intent.getFloatExtra("value", 36.7F);
        float userAVG = intent.getFloatExtra("vAVG",36.7F);
        float userOBP = intent.getFloatExtra("vOBP",36.7F);
        float userSLG = intent.getFloatExtra("vSLG",36.7F);
        float userHRPA = intent.getFloatExtra("vHRPA",36.7F);

        float avgPSAL = 15000;
        float avgPOPS = 772;
        float avgPOPS1 = avgPOPS / 1000;
        float Sal = avgPSAL / avgPOPS1;

        float userSAL = userOPS * Sal;

        String Valtest;


        String userSals = String.format("%.0f", userSAL);


        if (userOPS >= 1) {
            Valtest = "정말 대단합니다! \n 당신은 리그의 MVP 수준 입니다 !";
            MyApp.user_ops = 6;
        } else if (userOPS >= 0.9) {
            Valtest = " 좋습니다 ! \n 당신은 팀의 핵심선수 입니다!";
            MyApp.user_ops = 5;
        } else if (userOPS >= 0.8) {
            Valtest = "준수합니다! \n 당신은 팀의 주전선수 입니다! ";
            MyApp.user_ops = 4;
        } else if (userOPS >= 0.710) {
            Valtest = "평범 합니다 ! \n 그렇지만 당신은 \n 1군에 어울리는 선수입니다 !";
            MyApp.user_ops = 3;
        } else if (userOPS >= 0.670) {
            Valtest = "평볌 합니다 ! \n 팀의 주전선수가 될떄까지 화이팅 !";
            MyApp.user_ops = 2;
        } else {
            Valtest = "노력이 필요합니다 ! \n 그렇지만 포기하지 마십시요 !.";
            MyApp.user_ops = 1;
        }

        if (userAVG >= 0.35) {
            MyApp.user_avg = 6;
        } else if (userAVG >= 0.325) {
            MyApp.user_avg = 5;
        } else if (userAVG >= 0.300) {
            MyApp.user_avg = 4;
        } else if (userAVG >= 0.267) {
            MyApp.user_avg = 3;
        } else if (userAVG >= 0.240) {
            MyApp.user_avg = 2;
        } else {
            MyApp.user_avg = 1;
        }

        if (userOBP >= 0.500) {
            MyApp.user_obp = 6;
        } else if (userOBP >= 0.400) {
            MyApp.user_obp = 5;
        } else if (userOBP >= 0.340) {
            MyApp.user_obp = 4;
        } else if (userOBP >= 0.320) {
            MyApp.user_obp = 3;
        } else if (userOBP >= 0.290) {
            MyApp.user_obp = 2;
        } else {
            MyApp.user_obp = 1;
        }

        if (userSLG >= 0.500) {
            MyApp.user_slg = 6;
        } else if (userAVG >= 0.425) {
            MyApp.user_slg = 5;
        } else if (userAVG >= 0.400) {
            MyApp.user_slg = 4;
        } else if (userAVG >= 0.385) {
            MyApp.user_slg = 3;
        } else if (userAVG >= 0.345) {
            MyApp.user_slg = 2;
        } else {
            MyApp.user_slg = 1;
        }

        if (userHRPA >= 9) {
            MyApp.user_avg = 6;
        } else if (userHRPA >= 8.5) {
            MyApp.user_hrpa = 5;
        } else if (userHRPA >= 8) {
            MyApp.user_hrpa = 4;
        } else if (userHRPA >= 7) {
            MyApp.user_hrpa = 3;
        } else if (userHRPA >= 6) {
            MyApp.user_hrpa = 2;
        } else {
            MyApp.user_hrpa = 1;
        }


        tv_EXTRA.append("당신이 프로데뷔시"+"\n"+
                         "예상 연봉은 "+ userSals +" 만원 입니다");

        tv_tps.append(Valtest);


        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, userOPS));
        barEntries.add(new BarEntry(2, 0.77f));


        BarDataSet barDataSet = new BarDataSet(barEntries,"당신과 프로타자 비교");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        YAxis yAxis = c_bar2.getAxisLeft();
        yAxis.setAxisMaxValue(2);
        yAxis.setAxisMinValue(0);
        yAxis.setLabelCount(20,true);

        c_bar2.animateY(1500);

        BarData data = new BarData(barDataSet);
        c_bar2.setData(data);



        bt_myfchart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(FPsalActivity.this,MYRchart.class);
                startActivity(intent);

            }
        });


    }

}
