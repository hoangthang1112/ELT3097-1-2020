package com.hoangthang.duolingo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity00 extends AppCompatActivity {
    ImageButton basic1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main00);

        basic1 = (ImageButton) findViewById(R.id.buttonStart);

        basic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity00.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("CẤP ĐỘ 0/5");
                builder.setMessage("BÀI HỌC 3/4");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("BẮT ĐẦU + 10 KN", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                        Intent nextscreen = new Intent(MainActivity00.this,MainActivity.class);
                        startActivity(nextscreen);
                    }
                });
                builder.show();
            }
        });
    }
}




