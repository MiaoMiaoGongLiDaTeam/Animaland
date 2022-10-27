package com.example.animaland;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText usename,usepwd,usepwd2;
    Button submit,previous;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置页面布局
        setContentView(R.layout.register_tab_fragment);
        usename= this.findViewById(R.id.usename);			    //用户名编辑框
        usepwd= this.findViewById(R.id.usepwd);				//设置初始密码编辑框
        usepwd2=this.findViewById(R.id.usepwd2);			    //二次输入密码编辑框
        submit=this.findViewById(R.id.submit);				//注册按钮
        previous=this.findViewById(R.id.previous);     //返回按钮
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        submit.setOnClickListener(new View.OnClickListener() {
            boolean flag = true;            //判断用户是否已存在的标志位
            @Override
            public void onClick(View v) {
                String name = usename.getText().toString();                //用户名
                String pwd01 = usepwd.getText().toString();                //密码
                String pwd02 = usepwd2.getText().toString();            //二次输入的密码
                String sex = "";                                        //性别
                if (name.equals("") || pwd01.equals("") || pwd02.equals("")) {
                    Toast.makeText(Register.this, "用户名或密码不能为空!！", Toast.LENGTH_LONG).show();
                } else {
                    //如果两次输入都正确
                }
                if (flag == true) {                                             //判断用户是否已存在
                    if (pwd01.equals(pwd02)) {                                //判断两次输入的密码是否一致，若一致则继续，不一致则提醒密码不一致
                        //注册成功的情况
                        Toast.makeText(Register.this, "注册成功", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(Register.this, "密码不一致！", Toast.LENGTH_LONG).show();            //提示密码不一致
                    }
                } else {
                    Toast.makeText(Register.this, "用户已存在！", Toast.LENGTH_LONG).show();            //提示密码不一致
                }

            }

        });
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Register.this.finish();
            }
        });
    ;}
}

