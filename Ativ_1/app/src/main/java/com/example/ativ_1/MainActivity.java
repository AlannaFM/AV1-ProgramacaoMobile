package com.example.ativ_1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn_config = findViewById(R.id.btnConfig);
        Button btn_sair =  findViewById(R.id.btnExit);
        btn_config.setOnClickListener(this);
        btn_sair.setOnClickListener(this);
        Intent i = new Intent (getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnConfig){
            Intent i = new Intent (getApplicationContext(), ConfigActivity.class);
            startActivity(i);
        }
        if (v.getId() == R.id.btnExit){
            finish();
        }
    }
}