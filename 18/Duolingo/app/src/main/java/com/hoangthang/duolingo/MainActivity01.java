package com.hoangthang.duolingo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.service.controls.templates.ControlButton;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity01 extends AppCompatActivity {
    EditText edtuser,edtpassword;
    Button btndangky,btndangnhap,btnthoat;
    String ten,mk;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main01);
        Anhxa();
        Controlbutton();

    }

    private void Controlbutton() {
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity01.this, android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Ban co chac muon thoat khoi app");
                builder.setMessage("Lua chon ben duoi de xac nhan");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                builder.show();
            }
        });
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity01.this);
                dialog.setTitle("Hộp thoại xử lý");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.customdialog);
                final EditText edttk = (EditText)dialog.findViewById(R.id.edttk);
                final EditText edtmk = (EditText)dialog.findViewById(R.id.edtmk);
                Button btnhuy = (Button) dialog.findViewById(R.id.buttonhuy);
                Button btndongy = (Button) dialog.findViewById(R.id.buttondongy);
                btndongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ten = edttk.getText().toString().trim();
                        mk = edtmk.getText().toString().trim();

                        edtuser.setText(ten);
                        edtpassword.setText(mk);

                        dialog.cancel();

                    }
                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtuser.getText().length() !=0 && edtpassword.getText().length() !=0){
                    if (edtuser.getText().toString().equals(ten) && edtpassword.getText().toString().equals(mk)){
                        Toast.makeText(MainActivity01.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent nextscreen = new Intent(MainActivity01.this,MainActivity00.class);
                        startActivity(nextscreen);
                    }else if (edtuser.getText().toString().equals("truong") && edtpassword.getText().toString().equals("2709")){
                        Toast.makeText(MainActivity01.this, "Bạn đã đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent nextscreen = new Intent(MainActivity01.this,MainActivity00.class);
                        startActivity(nextscreen);
                    }else {
                        Toast.makeText(MainActivity01.this, "Bạn đã đăng nhập thất bai ", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(MainActivity01.this, "Mời bạn nhập đủ thông tin", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void Anhxa() {
        edtuser = (EditText) findViewById(R.id.edittextuser);
        edtpassword = (EditText) findViewById(R.id.edittextpassword);
        btndangnhap = (Button) findViewById(R.id.buttondangnhap);
        btndangky = (Button) findViewById(R.id.buttondangky);
        btnthoat =(Button) findViewById(R.id.buttonthoat);

    }

}