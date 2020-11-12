package com.example.abptest;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class AbprActivity extends AppCompatActivity implements OnClickListener {

    private final int MAX_STAGA = 28;
    private final int MAX_S = 2;
    private final int MAX_B = 3;
    private final int MAX_O = 2;

    private int currentStage = 2;
    private int currentLeftScore = 0;
    private int currentRightScore = 0;
    private int currentS = 0;
    private int currentB = 0;
    private int currentO = 0;

    private ConstraintLayout layoutTeamLeft, layoutTeamRight;
    private TextView tvStage;
    private TextView tvLeftTeam, tvRightTeam;
    private TextView tvLeftScore, tvRightScore;
    private Button btnStagePlus, btnStageMinus;
    private Button btnLeftTeamPlus, btnLeftTeamMinus;
    private Button btnRightTeamPlus, btnRightTeamMinus;
    private Button btnSPlus, btnSMinus;
    private Button btnBPlus, btnBMinus;
    private Button btnOPlus, btnOMinus;
    private Button bt_rm;

    private View[] viewSArray, viewBArray, viewOArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abpr);

        tvStage = findViewById(R.id.tv_stage);
        btnStagePlus = findViewById(R.id.btn_stage_plus);
        btnStageMinus = findViewById(R.id.btn_stage_minus);

        layoutTeamLeft = findViewById(R.id.layout_team_left);
        layoutTeamRight = findViewById(R.id.layout_team_right);
        tvLeftTeam = findViewById(R.id.tv_left_team);
        tvRightTeam = findViewById(R.id.tv_right_team);
        tvLeftScore = findViewById(R.id.tv_left_score);
        tvRightScore = findViewById(R.id.tv_right_score);
        btnLeftTeamPlus = findViewById(R.id.btn_left_team_plus);
        btnLeftTeamMinus = findViewById(R.id.btn_left_team_minus);
        btnRightTeamPlus = findViewById(R.id.btn_right_team_plus);
        btnRightTeamMinus = findViewById(R.id.btn_right_team_minus);

        btnSPlus = findViewById(R.id.btn_s_plus);
        btnSMinus = findViewById(R.id.btn_s_minus);
        btnBPlus = findViewById(R.id.btn_b_plus);
        btnBMinus = findViewById(R.id.btn_b_minus);
        btnOPlus = findViewById(R.id.btn_o_plus);
        btnOMinus = findViewById(R.id.btn_o_minus);

        viewSArray = new View[MAX_S];
        viewSArray[0] = findViewById(R.id.view_s_select1);
        viewSArray[1] = findViewById(R.id.view_s_select2);
        viewSArray[0].setOnClickListener(this);
        viewSArray[1].setOnClickListener(this);

        viewBArray = new View[MAX_B];
        viewBArray[0] = findViewById(R.id.view_b_select1);
        viewBArray[1] = findViewById(R.id.view_b_select2);
        viewBArray[2] = findViewById(R.id.view_b_select3);
        viewBArray[0].setOnClickListener(this);
        viewBArray[1].setOnClickListener(this);
        viewBArray[2].setOnClickListener(this);

        viewOArray = new View[MAX_O];
        viewOArray[0] = findViewById(R.id.view_o_select1);
        viewOArray[1] = findViewById(R.id.view_o_select2);
        viewOArray[0].setOnClickListener(this);
        viewOArray[1].setOnClickListener(this);

        tvLeftTeam.setOnClickListener(this);
        tvRightTeam.setOnClickListener(this);
        tvLeftScore.setOnClickListener(this);
        tvRightScore.setOnClickListener(this);

        tvStage.setOnClickListener(this);
        btnStagePlus.setOnClickListener(this);
        btnStageMinus.setOnClickListener(this);

        btnLeftTeamPlus.setOnClickListener(this);
        btnLeftTeamMinus.setOnClickListener(this);
        btnRightTeamPlus.setOnClickListener(this);
        btnRightTeamMinus.setOnClickListener(this);

        btnSPlus.setOnClickListener(this);
        btnSMinus.setOnClickListener(this);
        btnBPlus.setOnClickListener(this);
        btnBMinus.setOnClickListener(this);
        btnOPlus.setOnClickListener(this);
        btnOMinus.setOnClickListener(this);

        setStage();
        setScore(tvLeftScore, currentLeftScore);
        setScore(tvRightScore, currentRightScore);
        tvLeftTeam.setText(PrefUtil.getInstance(AbprActivity.this).getStringExtra("leftTeam", "Team A"));
        tvRightTeam.setText(PrefUtil.getInstance(AbprActivity.this).getStringExtra("rightTeam", "Team B"));


        bt_rm = (Button)findViewById(R.id.bt_rm);
        bt_rm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AbprActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 스테이지 설정
     */
    private void setStage() {

        int stage = currentStage / 2;
        int teamSelect = currentStage % 2;

        if (teamSelect == 0) {
            tvLeftTeam.setBackgroundResource(R.drawable.round_rect_select);
            tvLeftScore.setBackgroundResource(R.drawable.circle_outline_red);
            layoutTeamLeft.setBackgroundResource(R.drawable.round_rect_select);
            tvRightTeam.setBackgroundResource(R.drawable.round_rect_stroke);
            tvRightScore.setBackgroundResource(R.drawable.circle_outline);
            layoutTeamRight.setBackgroundResource(R.drawable.round_rect_stroke);
            tvStage.setText(">" + stage);
        }
        else {
            tvStage.setText(stage + "<");
            tvLeftTeam.setBackgroundResource(R.drawable.round_rect_stroke);
            tvLeftScore.setBackgroundResource(R.drawable.circle_outline);
            layoutTeamLeft.setBackgroundResource(R.drawable.round_rect_stroke);
            tvRightTeam.setBackgroundResource(R.drawable.round_rect_select);
            tvRightScore.setBackgroundResource(R.drawable.circle_outline_red);
            layoutTeamRight.setBackgroundResource(R.drawable.round_rect_select);
        }

    }

    /**
     * 회차 증가
     */
    private void StagePlus() {
        if ((currentStage + 1) < MAX_STAGA) {
            currentStage++;
            setStage();
        }
    }

    /**
     * 회차 감소
     */
    private void StageMinus() {
        if (1 < (currentStage - 1)) {
            currentStage--;
            setStage();
        }
    }

    /**
     * 점수 설정
     * @param scoreView
     * @param score
     */
    private void setScore(TextView scoreView, int score) {
        if (-1 < score  && 100 > score )
            scoreView.setText(String.valueOf(score));
    }

    /**
     * 스트라이크 증가
     */
    private void SPlus() {

        if (currentS == MAX_S) {
            //아웃
            for (View view : viewSArray) {
                view.setBackgroundResource(R.drawable.circle_outline_yellow);
            }
            currentS = 0;

            OPlus();
        }
        else if (currentS < MAX_S)
            viewSArray[currentS++].setBackgroundResource(R.drawable.circle_yellow);
    }

    /**
     * 스트라이크 감소
     */
    private void SMinus() {
        if (0 < currentS)
            viewSArray[--currentS].setBackgroundResource(R.drawable.circle_outline_yellow);
    }

    /**
     * 볼 증가
     */
    private void BPlus() {

        if (currentB == MAX_B) {
            //볼넷
            for (View view : viewBArray) {
                view.setBackgroundResource(R.drawable.circle_outline_green);
            }
            currentB = 0;
        }
        else if (currentB < MAX_B)
            viewBArray[currentB++].setBackgroundResource(R.drawable.circle_green);
    }

    /**
     * 볼 감소
     */
    private void BMinus() {
        if (0 < currentB)
            viewBArray[--currentB].setBackgroundResource(R.drawable.circle_outline_green);
    }

    /**
     * 아웃 증가
     */
    private void OPlus() {
        if (currentO == MAX_O) {
            //공수교대
            for (View view : viewOArray) {
                view.setBackgroundResource(R.drawable.circle_outline_red);
            }
            currentO = 0;

            currentStage++;
            setStage();
        }
        else if (currentO < MAX_O)
            viewOArray[currentO++].setBackgroundResource(R.drawable.circle_red);
    }

    /**
     * 아웃 감소
     */
    private void OMinus() {
        if (0 < currentO)
            viewOArray[--currentO].setBackgroundResource(R.drawable.circle_outline_red);
    }

    /**
     * 각 버튼별 이벤트
     * @param view
     */
    @Override
    public void onClick(View view) {

        if (tvStage == view || btnStagePlus == view)
            StagePlus();
        else if (btnLeftTeamPlus == view || tvLeftScore == view)
            setScore(tvLeftScore, ++currentLeftScore);
        else if (btnLeftTeamMinus == view)
            setScore(tvLeftScore, --currentLeftScore);
        else if (btnRightTeamPlus == view || tvRightScore == view)
            setScore(tvRightScore, ++currentRightScore);
        else if (btnRightTeamMinus == view)
            setScore(tvRightScore, --currentRightScore);
        else if (btnStageMinus == view)
            StageMinus();
        else if (btnSPlus == view || viewSArray[0] == view || viewSArray[1] == view)
            SPlus();
        else if (btnSMinus == view)
            SMinus();
        else if (btnBPlus == view || viewBArray[0] == view || viewBArray[1] == view || viewBArray[2] == view)
            BPlus();
        else if (btnBMinus == view)
            BMinus();
        else if (btnOPlus == view || viewOArray[0] == view || viewOArray[1] == view)
            OPlus();
        else if (btnOMinus == view)
            OMinus();
        else if (tvLeftTeam == view)
            showTeamInputDlg(tvLeftTeam, "leftTeam");
        else if (tvRightTeam == view)
            showTeamInputDlg(tvRightTeam, "rightTeam");
    }

    /**
     * 팀명 입력 다이얼로그
     * @param textView
     * @param key
     */
    private void showTeamInputDlg(final TextView textView, final String key) {

        AlertDialog.Builder ad = new AlertDialog.Builder(AbprActivity.this);

        ad.setTitle("팀 이름 입력");       // 제목 설정

        // EditText 삽입하기
        final EditText et = new EditText(AbprActivity.this);
        et.setText(textView.getText().toString());
        ad.setView(et);

        // 확인 버튼 설정
        ad.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                String value = et.getText().toString();

                if (!TextUtils.isEmpty(value)) {
                    PrefUtil.getInstance(AbprActivity.this).putStringExtra(key, value);
                    textView.setText(value);
                    dialog.dismiss();     //닫기
                }
            }
        });

        // 취소 버튼 설정
        ad.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();     //닫기
                // Event
            }
        });

        // 창 띄우기
        ad.show();



    }
}
