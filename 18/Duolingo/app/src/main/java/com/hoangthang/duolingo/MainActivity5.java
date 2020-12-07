package com.hoangthang.duolingo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity5 extends AppCompatActivity implements View.OnClickListener {

    Button btnKiemtra;
    Button btnTiepTuc;
    ProgressBar pbChay;
    TextView textView2;
    TextView textView3;
    ImageButton btnNhan;
    EditText editText;
    ImageButton btnPlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        pbChay = (ProgressBar) findViewById(R.id.progressBar);
        btnTiepTuc = (Button) findViewById(R.id.buttonTiepTuc);
        btnNhan = (ImageButton) findViewById(R.id.exit_imageButton);
        btnKiemtra = (Button) findViewById(R.id.buttonKiemtra);
        editText = (EditText) findViewById(R.id.edittext);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        btnPlay = (ImageButton)findViewById(R.id.btnPlay);

        Intent intent = getIntent();
        final int ketqua = intent.getIntExtra("prb", 111);
        pbChay.setProgress(ketqua);
        

        btnKiemtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String noiDung = editText.getText().toString();
                if(noiDung.equals("amazing good job bro")) {
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
                Intent intent = new Intent(MainActivity5.this, MainActivity0.class);
                intent.putExtra("prb",pbChay.getProgress());
                startActivity(intent);
            }
        });

        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity5.this, MainActivity0.class);
                startActivity(intent);
            }
        });

        btnPlay.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnPlay:
                MediaPlayer player = MediaPlayer.create(this, R.raw.amthanh);
                player.start();
                break;
            default:
                break;
        }
    }
}