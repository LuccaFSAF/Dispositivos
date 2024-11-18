package com.example.mcv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    EditText edtNome, edtEmail, edtData;
    Button button;
    ListView listview;
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
        listview = findViewById(R.id.listView);

        database = openOrCreateDatabase("meubd", MODE_PRIVATE, null);
        database.execSQL("create table if not exists pessoas(id INTEGER primary key autoincrement,nome varchar, email varchar, dtnasc date);");
        carregarListagem();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nome = edtNome.getText().toString();
                String email = edtEmail.getText().toString();
                String data = edtData.getText().toString();

                SimpleDateFormat data1 = new SimpleDateFormat("aaaa-yy-xx");
                SimpleDateFormat data2 = new SimpleDateFormat("xx/yy/aaaa");
                String dataO;
                try {
                    dataO = data1.format(data2.parse(data));
                } catch (ParseException e){
                    throw new RuntimeException(e);
                }

                ContentValues cv = new ContentValues();
                cv.put("nome", nome);
                cv.put("email", email);
                cv.put("data" , dataO);
                long status = database.insert("pessoas", null, cv);

                if(status > 0){
                    Toast.makeText(getApplicationContext(), "Usuario inserido na tabela", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getApplicationContext(), "Erro na inserção", Toast.LENGTH_SHORT).show();
                }
                carregarListagem();
                edtNome.setText("");
                edtEmail.setText("");
                edtData.setText("");
            }
        });

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
                String email, nome, data;
                String l = String.valueOf(i+1);

                Cursor cursor = database.rawQuery("select * from pessoas where id = ?", new String[]{l});
                cursor.moveToFirst();
                nome = cursor.getString(1);
                email = cursor.getString(2);
                data = cursor.getString(3);

                edtNome.setText(nome);
                edtData.setText(email);
                edtEmail.setText(data);
            }
        });

    }
    public void carregarListagem() {
        Cursor cursor = database.rawQuery("Select * from pessoas;", null);
        cursor.moveToFirst();
        ArrayList<String> nomes = new ArrayList<>(0);
        while (!cursor.isAfterLast()) {
            nomes.add(cursor.getString(1));
            cursor.moveToNext();
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                nomes);
        listview.setAdapter(adapter);
    }
}