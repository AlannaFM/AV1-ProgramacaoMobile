package com.example.praticapontuada;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfigActivity extends AppCompatActivity implements View.OnClickListener {
    private SharedPreferences sharedPreferences; // Tabela de preferencias onde os dados serão persistidos;
    private SharedPreferences.Editor sharedPreferencesEditor; //Editor para escrever na Tabela
    private EditText editTextNome;
    private RadioButton radioButtonMasculino;
    private RadioButton radioButtonFeminino;
    private Button buttonApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

       //Cria a tabela MyPreferences vazia
        sharedPreferences = getSharedPreferences("MyPreferences", Context.MODE_PRIVATE);  // Retorna um objeto instancia da classe SharedPreferences
        //Pede o valor da chave nome, e se estiver vazia, retorna a string "Jão Ninguém"
        String nomeRecuperado = sharedPreferences.getString("nome", "Jão Ninguém");
        //Variável que guarda o sexo
        int sexo = sharedPreferences.getInt("sexo",0 );
        editTextNome=findViewById(R.id.editTextNome);
        editTextNome.setText(nomeRecuperado);
        radioButtonMasculino= findViewById(R.id.radioButtonMasculino);
        radioButtonFeminino= findViewById(R.id.radioButtonFeminino);

        if (sexo==0){
            //se o radioButton masculino estiver checado
            radioButtonMasculino.setChecked(true); //bolinha ativada
        }
        else {
            radioButtonFeminino.setChecked(true); //bolinha ativada
        }

        buttonApply = findViewById(R.id.buttonApply);
        buttonApply.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) { //ButtonApply foi pressionado
        if(v.getId() == R.id.buttonApply) {
            sharedPreferencesEditor =  sharedPreferences.edit(); //Pode escrever na Tabela
            sharedPreferencesEditor.putString("nome", editTextNome.getText().toString());
            if (radioButtonMasculino.isChecked()) {
                sharedPreferencesEditor.putInt("sexo", 0);
            }
            else {
                sharedPreferencesEditor.putInt("sexo", 1);
            }
            sharedPreferencesEditor.commit();
            finish();
        }
    }
}