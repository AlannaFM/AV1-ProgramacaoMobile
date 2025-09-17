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

    // Armazena dados persistentes (nome e senha)
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharedPreferencesEditor;

    // Campos de entrada de texto
    private EditText editTextNome;
    private EditText editTextSenha;
    private EditText editTextConfirmarSenha;

    private Button buttonConfirm;
    private Button buttonCancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        // Obtém as preferências salvas com o nome "MyPreferences"
        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);

        // Recupera valores já salvos, ou usa os padrões caso não existam
        String nomeRecuperado = sharedPreferences.getString("nome", "Jão Ninguém");
        String senhaRecuperada = sharedPreferences.getString("senha", "8 Dígitos");

        // Liga os campos de texto do XML com o código e preenche com os valores recuperados
        editTextNome = findViewById(R.id.editTextName);
        editTextNome.setText(nomeRecuperado);
        editTextSenha = findViewById(R.id.editTextPassword1);
        editTextSenha.setText(senhaRecuperada);
        editTextConfirmarSenha = findViewById(R.id.editTextPassword2);

        // Define que os cliques dos botoes serão tratados nesta classe (onClick)
        buttonConfirm = findViewById(R.id.btnConfirm);
        buttonCancel = findViewById(R.id.btnCancel);
        buttonCancel.setOnClickListener(this);
        buttonConfirm.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        // Se o botão Confirmar foi clicado
        if (v.getId() == R.id.btnConfirm) {
            validarESalvar(); // Valida os dados e salva nas preferências
        }

        // Se o botão Cancelar foi clicado
        if (v.getId() == R.id.btnCancel) {
            finish(); // Fecha a tela sem salvar
        }
    }


    //valida os dados e salva, se estiver tudo correto
    private void validarESalvar() {
        String nome = editTextNome.getText().toString();
        String senha = editTextSenha.getText().toString();
        String confirmarSenha = editTextConfirmarSenha.getText().toString();

        // Regras de validação
        if (nome.isBlank()) return; // Nome não pode ser vazio
        if (senha.isBlank() || confirmarSenha.isBlank()) return; // Senha e confirmação não podem ser vazias
        if (!senha.equals(confirmarSenha)) return;  // Senha e confirmação devem ser iguais
        if (senha.length() < 8) return; // Senha precisa ter pelo menos 8 caracteres

        // Salva os dados em SharedPreferences
        sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putString("nome", nome);
        sharedPreferencesEditor.putString("senha", senha);
        sharedPreferencesEditor.commit(); // Aplica as mudanças

        finish(); // Fecha a Activity e volta para a anterior
    }
}