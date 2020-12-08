package com.hoangthang.duolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity4 extends AppCompatActivity {

    Button btnKiemtra;
    Button btnTiepTuc;
    ProgressBar pbChay;
    int choose =0;
    TextView textView2;
    TextView textView3;
    ImageButton btnNhan;
    ImageButton button;
    ImageButton button2;
    ImageButton button3;
    ImageButton button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        btnKiemtra = (Button) findViewById(R.id.buttonKiemtra);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        pbChay = (ProgressBar) findViewById(R.id.progressBar);
        btnTiepTuc = (Button) findViewById(R.id.buttonTiepTuc);
        btnNhan = (ImageButton) findViewById(R.id.exit_imageButton);
        button = (ImageButton) findViewById(R.id.imageButton);
        button2 = (ImageButton) findViewById(R.id.imageButton2);
        button3 = (ImageButton) findViewById(R.id.imageButton3);
        button4 = (ImageButton) findViewById(R.id.imageButton4);

        Intent intent = getIntent();
        final int ketqua = intent.getIntExtra("prb", 111);
        pbChay.setProgress(ketqua);

        button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnKiemtra.setBackgroundResource(R.drawable.blue);
                choose=1;
                textView2.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.INVISIBLE);
                button.setBackgroundResource(R.drawable.chon);
                button2.setBackgroundResource(R.drawable.bg);
                button3.setBackgroundResource(R.drawable.bg);
                button4.setBackgroundResource(R.drawable.bg);
            }
        }));

        button2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnKiemtra.setBackgroundResource(R.drawable.blue);
                choose=2;
                textView2.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.INVISIBLE);
                button2.setBackgroundResource(R.drawable.chon);
                button.setBackgroundResource(R.drawable.bg);
                button3.setBackgroundResource(R.drawable.bg);
                button4.setBackgroundResource(R.drawable.bg);
            }
        }));

        button3.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnKiemtra.setBackgroundResource(R.drawable.blue);
                choose=3;
                textView2.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.INVISIBLE);
                button3.setBackgroundResource(R.drawable.chon);
                button.setBackgroundResource(R.drawable.bg);
                button2.setBackgroundResource(R.drawable.bg);
                button4.setBackgroundResource(R.drawable.bg);

            }
        }));

        button4.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnKiemtra.setBackgroundResource(R.drawable.blue);
                choose=4;
                textView2.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.INVISIBLE);
                button4.setBackgroundResource(R.drawable.chon);
                button.setBackgroundResource(R.drawable.bg);
                button2.setBackgroundResource(R.drawable.bg);
                button3.setBackgroundResource(R.drawable.bg);
            }
        }));

        btnKiemtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button.setEnabled(false);
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                btnKiemtra.setBackgroundResource(R.drawable.blue);
                if (choose==2){
                    textView2.setVisibility(View.VISIBLE);
                    textView3.setVisibility(View.INVISIBLE);
                    btnKiemtra.setVisibility(View.INVISIBLE);
                    btnTiepTuc.setVisibility(View.VISIBLE);
                    pbChay.setProgress(pbChay.getProgress() + 10);
                }
                else {
                    textView3.setVisibility(View.VISIBLE);
                    textView2.setVisibility(View.INVISIBLE);
                    btnKiemtra.setVisibility(View.INVISIBLE);
                    btnTiepTuc.setVisibility(View.VISIBLE);

                }
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, MainActivity0.class);
                startActivity(intent);
            }
        });

        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity4.this, MainActivity5.class);
                intent.putExtra("prb",pbChay.getProgress());
                startActivity(intent);
            }
        });

    }
}