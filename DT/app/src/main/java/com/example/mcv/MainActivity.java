package com.example.mcv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Date;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    EditText edtNome, edtEmail, edtData;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Associar variaveis locais a views da interface
        edtNome = findViewById(R.id.editTextNome);
        edtEmail = findViewById(R.id.editTextEmail);
        edtData = findViewById(R.id.editTextDT);
        //Definindo tratamento para evento de click
        button = findViewById(R.id.btnCadastrar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nome = edtNome.getText().toString();
                String email = edtEmail.getText().toString();
                // data = edtData.getText().toString();
                ContentValues cv = new ContentValues();
                cv.put("nome", nome);
                cv.put("email", email);
                long status = database.insert("pessoas", null, cv);

                if(status > 0){
                    Toast.makeText(getApplicationContext(), "Usuario inserido na tabela", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(getApplicationContext(), "Erro na inserção", Toast.LENGTH_SHORT).show();
                }
            }
        });

        database = openOrCreateDatabase("meubd", MODE_PRIVATE, null);
        database.execSQL("create table if not exists pessoas(id INTEGER primary key autoincrement,nome varchar, email varchar, dtnasc DATE)");
    }
}