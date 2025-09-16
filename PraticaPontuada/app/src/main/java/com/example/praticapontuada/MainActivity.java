package com.example.praticapontuada;

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

        //Implementando a interface ViewOnClickListener para associar uma ação a um botão

        //Variáveis locais do tipo Button
        Button btn_config = findViewById(R.id.button_config);
        Button btn_sobre = findViewById(R.id.button_about);
        Button btn_sair =  findViewById(R.id.button_exit);
        //Quem config "notifica" quando é clicado
        btn_config.setOnClickListener(this);
        //Chama o metodo onClick
        btn_sobre.setOnClickListener(this);
        btn_sair.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
    if (v.getId() == R.id.button_config){
        //"Intenção" de carregar a classe ConfigActivity
        Intent i = new Intent(getApplicationContext(), ConfigActivity.class);
        startActivity(i);
    }
    if (v.getId() == R.id.button_about){
        //Faça algo
    }
    if (v.getId() == R.id.button_exit){
        finish();
    }

    }
}