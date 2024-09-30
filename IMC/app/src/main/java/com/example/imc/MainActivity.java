package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("ciclo de vida", "onCreate");
        EditText edt = findViewById(R.id.editTextTextPersonName3);
        EditText edtalt = findViewById(R.id.editTextTextPersonName2);
        EditText edtpeso = findViewById(R.id.editTextTextPersonName);
        Button button = findViewById(R.id.button);
        Float peso = Float.parseFloat(edtpeso.getText().toString());
        Float alt = Float.parseFloat(edtalt.getText().toString());
        Float imc = peso/(alt*alt);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                i.putExtra("msg", edt.getText().toString());
                i.putExtra("alt", edtalt.getText().toString());
                i.putExtra("pes", edtpeso.getText().toString());
                i.putExtra("imc", imc);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("ciclo de vida", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("ciclo de vida", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("ciclo de vida","onPause");
    }
}