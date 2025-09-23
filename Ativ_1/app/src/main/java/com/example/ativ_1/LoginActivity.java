package com.example.ativ_1;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private SharedPreferences.Editor sharedPreferencesEditor;
    private SharedPreferences sharedPreferences;
    private EditText editTextNome;
    private EditText editTextSenha;
    private EditText editTextConfirmarSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);
        String nomeRecuperado = sharedPreferences.getString("nome", "Jão Ninguém");
        String senhaRecuperada = sharedPreferences.getString("senha", "8 Dígitos");
        editTextNome = findViewById(R.id.editTextText4);
        editTextNome.setText(nomeRecuperado);
        editTextSenha = findViewById(R.id.editTextTextPassword2);
        editTextSenha.setText(senhaRecuperada);

        Button btn_entrar =  findViewById(R.id.btnSign);
        Button btn_sair =  findViewById(R.id.btnSair);
        btn_entrar.setOnClickListener(this);
        btn_sair.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnSign){
            String nome = editTextNome.getText().toString();
            String senha = editTextSenha.getText().toString();
            String nomeSalvo = sharedPreferences.getString("nome", "");
            String senhaSalva = sharedPreferences.getString("senha", "");
            if (nome.isBlank()) return;
            if (senha.isBlank()) return;
            if (nome.equals(nomeSalvo) && senhaSalva.equals(senha)){
                finish();
            }
        }
        if (v.getId() == R.id.btnSair){
            finishAffinity(); //sai de tudo
        }
    }
}