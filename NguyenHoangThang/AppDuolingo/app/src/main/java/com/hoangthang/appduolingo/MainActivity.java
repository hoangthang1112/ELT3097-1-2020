package com.example.truongthongthai;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.hoangthang.appduolingo.R;

public class MainActivity extends AppCompatActivity {
    Button ans1;
    Button ans2;
    Button ans3;
    Button check;
    ImageButton exit;
    TextView guide;
    TextView question;
    TextView right;
    TextView wrong;
    ProgressBar prgBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ans1 = (Button) findViewById(R.id.ans1_button);
        ans2 = (Button) findViewById(R.id.ans2_button);
        ans3 = (Button) findViewById(R.id.ans3_button);
        check = (Button) findViewById(R.id.check_button);
        exit = (ImageButton) findViewById(R.id.exit_imageButton);
        guide = (TextView) findViewById(R.id.guide_textView);
        question = (TextView) findViewById(R.id.question_textView);
        right = (TextView) findViewById(R.id.right_textview);
        wrong = (TextView) findViewById(R.id.wrong_textView);
        prgBar = (ProgressBar) findViewById(R.id.progressBar);
        right.setVisibility(View.INVISIBLE);
        wrong.setVisibility(View.INVISIBLE);
        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans1.setSelected(true);
                ans2.setSelected(false);
                ans3.setSelected(false);
                right.setVisibility(View.INVISIBLE);
                wrong.setVisibility(View.INVISIBLE);
            }
        });
        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans2.setSelected(true);
                ans1.setSelected(false);
                ans3.setSelected(false);
                right.setVisibility(View.INVISIBLE);
                wrong.setVisibility(View.INVISIBLE);
            }
        });
        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ans3.setSelected(true);
                ans1.setSelected(false);
                ans2.setSelected(false);
                right.setVisibility(View.INVISIBLE);
                wrong.setVisibility(View.INVISIBLE);
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ans2.isSelected()){
                    prgBar.setProgress(prgBar.getProgress() + 10);
                    right.setVisibility(View.VISIBLE);
                }
                else {
                    wrong.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}