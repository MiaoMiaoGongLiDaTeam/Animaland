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
public class ForgetPass extends AppCompatActivity{
    EditText account,passw,passw2;
    Button correct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgetpass_tab_fragment);
        account= this.findViewById(R.id.account);			    //用户名编辑框
        passw= this.findViewById(R.id.passw);				//设置初始密码编辑框
        passw2=this.findViewById(R.id.passw2);			    //二次输入密码编辑框
        correct=this.findViewById(R.id.correct);				//注册按钮
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        correct.setOnClickListener(new View.OnClickListener() {
            boolean flag = true;            //判断用户是否已存在的标志位
            @Override
            public void onClick(View v) {
                String name = account.getText().toString();                //用户名
                String pwd01 = passw.getText().toString();                //密码
                String pwd02 = passw2.getText().toString();            //二次输入的密码
                if (name.equals("") || pwd01.equals("") || pwd02.equals("")) {
                    Toast.makeText(ForgetPass.this, "用户名或密码不能为空!！", Toast.LENGTH_LONG).show();
                } else {
                    //如果两次输入都正确
                }
                if (flag == true) {                                             //判断用户是否已存在
                    if (pwd01.equals(pwd02)) {                                //判断两次输入的密码是否一致，若一致则继续，不一致则提醒密码不一致
                        //注册成功的情况
                        Toast.makeText(ForgetPass.this, "注册成功", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(ForgetPass.this, "密码不一致！", Toast.LENGTH_LONG).show();            //提示密码不一致
                    }
                } else {
                    Toast.makeText(ForgetPass.this, "用户已存在！", Toast.LENGTH_LONG).show();            //提示密码不一致
                }

            }

        });
        ;}
}
