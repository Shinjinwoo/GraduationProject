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

public class MYRchart extends AppCompatActivity {

    int userAVG = MyApp.user_avg;
    int userOBP = MyApp.user_obp;
    int userSLG = MyApp.user_slg;
    int userOPS = MyApp.user_ops;
    int userHRPA = MyApp.user_hrpa;

    Button bt_frctor,bt_frmm;
    TextView tv_mfc;

    RadarChart radarChart2;
    String[] lables = {"타율","출루율","장타율","OPS","홈런확률"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myrchart);

        bt_frctor = (Button)findViewById(R.id.bt_frctor);
        bt_frmm = (Button)findViewById(R.id.bt_frmm);
        tv_mfc = (TextView)findViewById(R.id.tv_mfc);



            radarChart2 = findViewById(R.id.radar_Chart2);

            RadarDataSet dataSet1 = new RadarDataSet(dataValues1(), "당신의기록");
            dataSet1.setColor(Color.RED);
            dataSet1.setFillColor(Color.RED);
            dataSet1.setDrawFilled(true);
            dataSet1.setFillAlpha(180);
            dataSet1.setLineWidth(2f);
            dataSet1.setDrawHighlightIndicators(false);
            dataSet1.setDrawHighlightCircleEnabled(true);


            RadarDataSet dataSet2 = new RadarDataSet(dataValues2(), "프로야구평균");
            dataSet2.setColor(Color.BLUE);
            dataSet2.setFillColor(Color.BLUE);
            dataSet2.setDrawFilled(true);
            dataSet2.setFillAlpha(180);
            dataSet2.setLineWidth(2f);
            dataSet2.setDrawHighlightIndicators(false);
            dataSet2.setDrawHighlightCircleEnabled(true);


            XAxis xAxis = radarChart2.getXAxis();
            xAxis.setValueFormatter(new IndexAxisValueFormatter(lables));
            xAxis.setAxisMaxValue(6);
            xAxis.setAxisMinValue(0);
            xAxis.setLabelCount(6, true);
            //xAxis.setAxisMinimum(1f);


            YAxis yAxis = radarChart2.getYAxis();
            yAxis.setAxisMaxValue(6);
            yAxis.setAxisMinValue(0);
            yAxis.setLabelCount(6, true);
            /*yAxis.setLabelCount(6,true);*/
            //yAxis.setAxisMinimum(1f);


            ArrayList<IRadarDataSet> sets = new ArrayList<>();
            sets.add(dataSet1);
            sets.add(dataSet2);

            RadarData data = new RadarData(sets);
            data.setValueTextSize(8f);
            data.setDrawValues(false);
            data.setValueTextColor(Color.BLACK);

            radarChart2.setData(data);
            radarChart2.invalidate();
            radarChart2.animateXY(1000, 1000);


            tv_mfc.setText("그래프로 알아보는 당신의 타자 기록입니다."+"\n" +
                    "방사형 차트가 꽉 찰 수록 당신은 좋은 타자 입니다!"+"\n"+
                    "타율은 안타를 칠 확률을 의미합니다 타격정확도를 나타냅니다 !" + "\n" +
                    "출루율은 루상에 출루할 확률을 나타냅니다 ! "+"\n"+
                    "장타율은 안타의 가치들을 산정해 장타를 칠 확률을 나타냅니다 !"+"\n"+
                    "OPS는 출루율과 장타율을 합친 수치로서 전체적인 타자로서의 능력치를 나타냅니다."+"\n"+
                    "홈런확률은 장타율을 넘어 순수하게 홈런을 칙 확률을 나타냅니다 !");



            bt_frctor.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MYRchart.this,RecordActivity.class);
                    startActivity(intent);
                }
            });


            bt_frmm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MYRchart.this,MainActivity.class);
                    startActivity(intent);
                }
            });


        }

        private ArrayList<RadarEntry> dataValues1(){
            ArrayList<RadarEntry>dataVals = new ArrayList<RadarEntry>();
            dataVals.add(new RadarEntry(userAVG));
            dataVals.add(new RadarEntry(userOBP));
            dataVals.add(new RadarEntry(userSLG));
            dataVals.add(new RadarEntry(userOPS));
            dataVals.add(new RadarEntry(userHRPA));
            return dataVals;

        }

        private ArrayList<RadarEntry> dataValues2(){
            ArrayList<RadarEntry>dataVals = new ArrayList<RadarEntry>();
            dataVals.add(new RadarEntry(3));
            dataVals.add(new RadarEntry(3));
            dataVals.add(new RadarEntry(3));
            dataVals.add(new RadarEntry(3));
            dataVals.add(new RadarEntry(3));
            return dataVals;

        }
}
