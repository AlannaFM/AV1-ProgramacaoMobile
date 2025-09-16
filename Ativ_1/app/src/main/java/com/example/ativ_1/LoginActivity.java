package com.example.ativ_1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btn_entrar =  findViewById(R.id.btnSign);
        Button btn_sair =  findViewById(R.id.btnSair);
        btn_entrar.setOnClickListener(this);
        btn_sair.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSign){
            finish();
        }
        if (v.getId() == R.id.btnSair){
            finishAffinity(); //sai de tudo
        }
    }
}