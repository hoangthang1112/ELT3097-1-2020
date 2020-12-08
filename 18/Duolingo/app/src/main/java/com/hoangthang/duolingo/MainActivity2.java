package com.hoangthang.duolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    Button btnKiemtra;
    Button btnTiepTuc;
    Button button2;
    Button button3;
    Button button4;
    ProgressBar pbChay;
    int choose =0;
    TextView textView2;
    TextView textView3;
    ImageButton btnNhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnKiemtra = (Button) findViewById(R.id.buttonKiemtra);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        pbChay = (ProgressBar) findViewById(R.id.progressBar);
        btnTiepTuc = (Button) findViewById(R.id.buttonTiepTuc);
        btnNhan = (ImageButton) findViewById(R.id.exit_imageButton);

        Intent intent = getIntent();
        final int ketqua = intent.getIntExtra("prb", 111);
        pbChay.setProgress(ketqua);

        button2.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnKiemtra.setBackgroundResource(R.drawable.blue);
                button3.setBackgroundResource(R.drawable.duongvien_goctron);
                button4.setBackgroundResource(R.drawable.duongvien_goctron);
                choose=2;
                textView2.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.INVISIBLE);
                button2.setBackgroundResource(R.drawable.xanh);
            }
        }));

        button3.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnKiemtra.setBackgroundResource(R.drawable.blue);
                button3.setBackgroundResource(R.drawable.xanh);
                button2.setBackgroundResource(R.drawable.duongvien_goctron);
                button4.setBackgroundResource(R.drawable.duongvien_goctron);
                choose=3;
                textView2.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.INVISIBLE);

            }
        }));

        button4.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnKiemtra.setBackgroundResource(R.drawable.blue);
                button4.setBackgroundResource(R.drawable.xanh);
                button3.setBackgroundResource(R.drawable.duongvien_goctron);
                button2.setBackgroundResource(R.drawable.duongvien_goctron);
                choose=4;
                textView2.setVisibility(View.INVISIBLE);
                textView3.setVisibility(View.INVISIBLE);
            }
        }));

        btnKiemtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                button2.setEnabled(false);
                button3.setEnabled(false);
                button4.setEnabled(false);
                btnKiemtra.setBackgroundResource(R.drawable.blue);
                if (choose==3){
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
                Intent intent = new Intent(MainActivity2.this, MainActivity0.class);
                startActivity(intent);
            }
        });

        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                intent.putExtra("prb",pbChay.getProgress());
                startActivity(intent);
            }
        });

        String noidung = "Đáp án đúng:\n" +
                "Thu is very handsome";
        SpannableString s = new SpannableString(noidung);
        s.setSpan(new StyleSpan(Typeface.BOLD), 0, 12, 0 );
        textView3. setText(s);

    }
}