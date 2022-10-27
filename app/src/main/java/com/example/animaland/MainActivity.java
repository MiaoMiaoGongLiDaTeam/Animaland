package com.example.animaland;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText name,pwd;
    Button btnlogin;
    TextView textreg,textforget;
    SharedPreferences sp1,sp2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = this.findViewById(R.id.name);            //用户名输入框
        pwd = this.findViewById(R.id.pwd);              //密码输入框
        btnlogin = this.findViewById(R.id.login);         //登录按钮
        textreg = this.findViewById(R.id.reg);               //注册跳转
        textforget=this.findViewById(R.id.forgetPass);
        sp1 =  this.getSharedPreferences("useinfo",this.MODE_PRIVATE);
        sp2 = this.getSharedPreferences("username",this.MODE_PRIVATE);

        name.setText(sp1.getString("usname",null));
        pwd.setText(sp1.getString("uspwd",null));
        btnlogin.setOnClickListener(new View.OnClickListener() {                //登录事件
            @Override
            public void onClick(View v) {
                String username = name.getText().toString();
                String password = pwd.getText().toString();                 //获取用户输入的用户名和密码
                //查询用户名和密码相同的数据
                Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_LONG).show();
            }
        });

        textreg.setOnClickListener(new View.OnClickListener() {                  //注册事件
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Register.class);//跳转到注册页面
                startActivity(intent);
                Toast.makeText(MainActivity.this,"前往注册！",Toast.LENGTH_SHORT).show();
            }
        });

        textforget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ForgetPass.class);
                //跳转到忘记密码页面
                startActivityForResult(intent,1);

        }}
        );
    }
}
