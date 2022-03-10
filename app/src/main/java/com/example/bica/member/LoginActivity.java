package com.example.bica.member;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.bica.MainActivity;
import com.example.bica.R;

public class LoginActivity extends AppCompatActivity {

    Button btn_login;
    EditText edt_ID,edt_PW;
    TextView tv_Find_ID, tv_Find_PW;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent startMain = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(startMain);
            }
        });

        // TODO: 로그인 구현


    }

    public void init(){
        edt_ID = findViewById(R.id.edt_id);
        edt_PW = findViewById(R.id.edt_pw);
        tv_Find_ID = findViewById(R.id.tv_Find_ID);
        tv_Find_PW = findViewById(R.id.tv_Find_PW);
        btn_login = findViewById(R.id.btn_login);
    }
}