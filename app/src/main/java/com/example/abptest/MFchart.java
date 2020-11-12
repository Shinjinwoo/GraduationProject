package com.example.abptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;
import com.github.mikephil.charting.data.RadarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;

import java.util.ArrayList;

public class MFchart extends AppCompatActivity {

    double proera = 4.17;
    double prowin = 0.500;
    double prosb = 2.02;

    int userERA = MyApp.user_era;
    int userWINP = MyApp.user_win;
    int userSB = MyApp.user_sb;
    int userWHIP = MyApp.user_whip;
    TextView tv_mpc;
    Button bt_prr,bt_prm;


    RadarChart radarChart;
    String[] lables = {"방어율", "승률", "볼넷삼진비율","이닝당출루허용율"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mfchart);

        radarChart = findViewById(R.id.radar_Chart);
        tv_mpc = (TextView)findViewById(R.id.tv_mpc);
        bt_prr = (Button) findViewById(R.id.bt_prr);
        bt_prm = (Button) findViewById(R.id.bt_prm);


        RadarDataSet dataSet1 = new RadarDataSet(dataValues1(),"당신의 투수 기록");
        dataSet1.setColor(Color.RED);
        dataSet1.setFillColor(Color.RED);
        dataSet1.setDrawFilled(true);
        dataSet1.setFillAlpha(180);
        dataSet1.setLineWidth(2f);
        dataSet1.setDrawHighlightIndicators(false);
        dataSet1.setDrawHighlightCircleEnabled(true);


        RadarDataSet dataSet2 = new RadarDataSet(dataValues2(),"프로야구선수 평균");
        dataSet2.setColor(Color.BLUE);
        dataSet2.setFillColor(Color.BLUE);
        dataSet2.setDrawFilled(true);
        dataSet2.setFillAlpha(180);
        dataSet2.setLineWidth(2f);
        dataSet2.setDrawHighlightIndicators(false);
        dataSet2.setDrawHighlightCircleEnabled(true);


        XAxis xAxis = radarChart.getXAxis();
        xAxis.setValueFormatter(new IndexAxisValueFormatter(lables));
        xAxis.setAxisMaxValue(6);
        xAxis.setAxisMinValue(0);
        xAxis.setLabelCount(6,true);
        //xAxis.setAxisMinimum(1f);


        YAxis yAxis = radarChart.getYAxis();
        yAxis.setAxisMaxValue(6);
        yAxis.setAxisMinValue(0);
        yAxis.setLabelCount(6,true);
        /*yAxis.setLabelCount(6,true);*/
        //yAxis.setAxisMinimum(1f);



        ArrayList<IRadarDataSet> sets = new ArrayList<>();
        sets.add(dataSet1);
        sets.add(dataSet2);

        RadarData data = new RadarData(sets);
        data.setValueTextSize(8f);
        data.setDrawValues(false);
        data.setValueTextColor(Color.BLACK);

        radarChart.setData(data);
        radarChart.invalidate();
        radarChart.animateXY(1000,1000);

        tv_mpc.setText("그래프로 알아보는 당신의 투수 기록입니다."+"\n" +
                "방사형 차트가 꽉 찰 수록 당신은 좋은 투수 입니다!"+"\n"+
                "ERA는 평균자책점을 의미합니다 !" + "\n" +
                "승률은 투수로 등판시 팀의 승리 확률을 나타냅니다."+"\n"+
                "볼넷삼진 비율은 제구력을 나타냅니다."+"\n"+
                "WHIP는 이닝당 출루 허용 횟수로서 투수의 구위를 나타냅니다."
        );


        bt_prr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MFchart.this,RecordActivity.class);
                startActivity(intent);
            }
        });

        bt_prm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MFchart.this,MainActivity.class);
                startActivity(intent);
            }
        });






    }

    private ArrayList<RadarEntry> dataValues1(){
        ArrayList<RadarEntry>dataVals = new ArrayList<RadarEntry>();
        dataVals.add(new RadarEntry(userERA));
        dataVals.add(new RadarEntry(userWINP));
        dataVals.add(new RadarEntry(userSB));
        dataVals.add(new RadarEntry(userWHIP));
        return dataVals;

    }

    private ArrayList<RadarEntry> dataValues2(){
        ArrayList<RadarEntry>dataVals = new ArrayList<RadarEntry>();
        dataVals.add(new RadarEntry(3));
        dataVals.add(new RadarEntry(3));
        dataVals.add(new RadarEntry(3));
        dataVals.add(new RadarEntry(3));
        return dataVals;

    }
}
