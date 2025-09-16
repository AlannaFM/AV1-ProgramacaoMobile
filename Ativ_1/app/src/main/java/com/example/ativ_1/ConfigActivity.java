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

public class ConfigActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharedPreferencesEditor;
    private EditText editTextNome;
    private EditText editTextSenha;
    private EditText editTextConfirmarSenha;

    private Button buttonConfirm;
    private Button buttonCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

        String nomeRecuperado = sharedPreferences.getString("nome", "Jão Ninguém");
        String senhaRecuperada = sharedPreferences.getString("senha", "8 Dígitos");

        editTextNome = findViewById(R.id.editTextName);
        editTextNome.setText(nomeRecuperado);
        editTextSenha = findViewById(R.id.editTextPassword1);
        editTextSenha.setText(senhaRecuperada);
        editTextConfirmarSenha = findViewById(R.id.editTextPassword2);


        buttonConfirm = findViewById(R.id.btnConfirm);
        buttonCancel = findViewById(R.id.btnCancel);
        buttonCancel.setOnClickListener(this);
        buttonConfirm.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnConfirm) {
            validarESalvar();
        }
        if (v.getId() == R.id.btnCancel) {
            finish();
        }
    }


    private void validarESalvar() {
        String nome = editTextNome.getText().toString();
        String senha = editTextSenha.getText().toString();
        String confirmarSenha = editTextConfirmarSenha.getText().toString();

        if (nome.isBlank()) return;
        if (senha.isBlank() || confirmarSenha.isBlank()) return;
        if (!senha.equals(confirmarSenha)) return;
        if (senha.length() < 8) return;


        sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putString("nome", nome);
        sharedPreferencesEditor.putString("senha", senha);
        sharedPreferencesEditor.commit();

        finish();
    }
}