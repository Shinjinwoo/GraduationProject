package com.example.abptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MPsalActivity extends AppCompatActivity {

    TextView tv,tv_tv1;
    BarChart c_bar;
    Button bt_mypchart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mpsal);


        bt_mypchart = (Button)findViewById(R.id.bt_mypchart);
        tv = (TextView)findViewById(R.id.tv);
        tv_tv1 = (TextView)findViewById(R.id.tv_tv1);
        c_bar = (BarChart)findViewById(R.id.c_bar2);


        c_bar.setDrawBarShadow(false);
        c_bar.setDrawValueAboveBar(true);
        c_bar.setMaxVisibleValueCount(100);
        c_bar.setPinchZoom(false);
        c_bar.setDrawGridBackground(true);




        String Valtest;


        Intent intent = getIntent();
        float userERA = intent.getFloatExtra("vERA",36.7F);
        float userWINP = intent.getFloatExtra("vWINP",36.7F);
        float userSB = intent.getFloatExtra("vSB",36.7F);
        float userWHIP = intent.getFloatExtra("vWHIP",36.7F);


        float avgPSAL = 15000;
        float avgPERA = 42;
        float avgPERA1= avgPERA / 10;
        float sal = avgPSAL / avgPERA1;

        float avgPWINP = 500;
        float avgPWINP1 = avgPWINP / 1000;
        float Sal = avgPSAL / avgPWINP1;

        float userSAL = userWINP * Sal;



        String userSALs = String.format("%.0f",userSAL);



        if (userERA <= 1.8) {
            Valtest = "정말 대단합니다! \n 당신은 리그의 MVP 수준 입니다 !";
            MyApp.user_era = 6;
        } else if (userERA <= 2.5) {
            Valtest = " 좋습니다 ! \n 당신은 팀의 핵심선수 입니다!";
            MyApp.user_era = 5;
        } else if (userERA <= 3.5) {
            Valtest = "준수합니다! \n 당신은 팀의 주전선수 입니다! ";
            MyApp.user_era = 4;
        } else if (userERA <= 4.0) {
            Valtest = "평범 합니다 ! \n 그렇지만 당신은 \n 1군에 어울리는 선수입니다 !";
            MyApp.user_era = 3;
        } else if (userERA <= 4.5) {
            Valtest = "평볌 합니다 ! \n 팀의 주전선수가 될떄까지 화이팅 !";
            MyApp.user_era = 2;
        } else {
            Valtest = "노력이 필요합니다 ! \n 그렇지만 포기하지 마십시요 !.";
            MyApp.user_era = 1;
        }



        if (userWINP >= 0.75 ) {
            MyApp.user_win = 6;

        } else if (userWINP >= 0.7) {
            MyApp.user_win = 5;

        } else if (userWINP >= 0.6) {
            MyApp.user_win = 4;

        } else if (userWINP >= 0.5) {
            MyApp.user_win = 3;

        } else if (userWINP >= 0.4) {
            MyApp.user_win = 2;

        } else {
            MyApp.user_win = 1;
        }


        if (userSB >= 3.0 ) {
            MyApp.user_sb = 6;

        } else if (userSB >= 2.6) {
            MyApp.user_sb = 5;

        } else if (userSB >= 2.3) {
            MyApp.user_sb = 4;

        } else if (userSB >= 2.0) {
            MyApp.user_sb = 3;

        } else if (userSB >= 1.5) {
            MyApp.user_sb = 2;

        } else {
            MyApp.user_sb = 1;
        }

        if (userWHIP <= 1.0 ) {
            MyApp.user_whip = 6;

        } else if (userWHIP <= 1.15) {
            MyApp.user_whip = 5;

        } else if (userWHIP <= 1.3) {
            MyApp.user_whip = 4;

        } else if (userWHIP <= 1.4) {
            MyApp.user_whip = 3;

        } else if (userWHIP <= 1.5) {
            MyApp.user_whip = 2;

        } else {
            MyApp.user_whip = 1;
        }










        tv.append("당신이 프로데뷔시"+"\n"+
                "예상 연봉은 "+ userSALs +" 만원 입니다");



        tv_tv1.append(Valtest);



        ArrayList<BarEntry> barEntries = new ArrayList<>();
        barEntries.add(new BarEntry(1, userERA));
        barEntries.add(new BarEntry(2, 4.23f));


        BarDataSet barDataSet = new BarDataSet(barEntries,"당신과 프로투수 비교");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        c_bar.animateY(1500);

        BarData data = new BarData(barDataSet);
        c_bar.setData(data);

        String[] values = { "Jan", "Feb"};


        bt_mypchart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MPsalActivity.this,MFchart.class);

                startActivity(intent);

            }
        });













    }


}
