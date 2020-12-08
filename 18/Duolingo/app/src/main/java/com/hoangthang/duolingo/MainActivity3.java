package com.hoangthang.duolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    EditText editText;
    Button btnKiemtra;
    Button btnTiepTuc;
    ProgressBar pbChay;
    ImageButton btnNhan;
    TextView textView2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        editText = findViewById(R.id.edittext);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        pbChay = (ProgressBar) findViewById(R.id.progressBar);
        btnTiepTuc = (Button) findViewById(R.id.buttonTiepTuc);
        btnNhan = (ImageButton) findViewById(R.id.exit_imageButton);
        btnKiemtra = (Button) findViewById(R.id.buttonKiemtra);

        Intent intent = getIntent();
        final int ketqua = intent.getIntExtra("prb", 111);
        pbChay.setProgress(ketqua);

        btnKiemtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noiDung = editText.getText().toString();
                    if(noiDung.equals("ball")) {
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
        btnTiepTuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                intent.putExtra("prb",pbChay.getProgress());
                startActivity(intent);
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity0.class);
                startActivity(intent);
            }
        });

    }
}