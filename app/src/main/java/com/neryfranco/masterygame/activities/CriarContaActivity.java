package com.neryfranco.masterygame.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.neryfranco.masterygame.AlunoBundle;
import com.neryfranco.masterygame.R;
import com.neryfranco.masterygame.model.Aluno;

public class CriarContaActivity extends AppCompatActivity {

    private EditText nome;
    private EditText nick;
    private EditText email;
    private EditText pass;
    private EditText confirmPass;
    private Button createAccountBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_conta);

        nome = (EditText) findViewById(R.id.name_value);
        nick = (EditText) findViewById(R.id.value_nickname);
        email = (EditText) findViewById(R.id.email_value);
        pass = (EditText) findViewById(R.id.pass_value);
        confirmPass = (EditText) findViewById(R.id.confirmPass_value);
        createAccountBtn = (Button) findViewById(R.id.criarConta_btn);

        createAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validate()) createAccount();
            }
        });
    }

    private boolean validate(){
        String sNome = nome.getText().toString();
        String sNick = nick.getText().toString();
        String sEmail = email.getText().toString();
        String sPass = pass.getText().toString();
        String sConfirmPass = confirmPass.getText().toString();

        if(sNome.isEmpty()){
            nome.setError("Campo vazio");
            return false;
        }
        if(sNick.isEmpty()) {
            nick.setError("Campo vazio");
            return false;
        }
        if(sEmail.isEmpty() || !sEmail.contains("@")) {
            email.setError("Email inválido");
            return false;
        }
        if(sPass.length() < 8) {
            pass.setError("Mínimo de 8 caracteres");
            return false;
        }
        if(!sConfirmPass.equals(sPass)) {
            confirmPass.setError("Senhas diferentes");
            return false;
        }
        return true;
    }

    private void createAccount(){
        String sNome = nome.getText().toString();
        String sNick = nick.getText().toString();
        String sEmail = email.getText().toString();
        String sPass = pass.getText().toString();
        Aluno aluno = new Aluno(sEmail, sPass, sNome, sNick);

        Intent intent = new Intent(getApplicationContext(), AlunoActivity.class);
        AlunoBundle.setAluno(aluno);
        AlunoBundle.newAccount();
        startActivity(intent);
    }
}
