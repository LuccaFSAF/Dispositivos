package com.example.imc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    Float  p, a, t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button button = findViewById(R.id.button2);
        TextView peso = findViewById(R.id.textView7);
        TextView alt = findViewById(R.id.textView9);
        TextView nome = findViewById(R.id.textView3);

        p = getIntent().getExtras().getFloat("pes");
        a = getIntent().getExtras().getFloat("alt");
        t = getIntent().getExtras().getFloat("imc");


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        public void setPerfil() {
            ImageView img = findViewById(R.id.imageView);
            TextView view = findViewById(R.id.textView12);
        if(t <= 18.5){
            view.setText("Abaixo do peso");
            img.setImageResource(R.drawable.abaixopeso);
        }
        else{
            if (t <= 24.9){
                view.setText("Normal");
                img.setImageResource(R.drawable.normal);
                else{
                    if (t <= 29.9){
                        view.setText("Sobrepeso");
                        img.setImageResource(R.drawable.sobrepeso);
                    }
                    else{
                        if (t <= 34.9){
                            view.setText("Obesidade 1");
                            img.setImageResource(R.drawable.obesidade1);
                        }
                        else{
                            if (t <= 39.9){
                                view.setText("Obesidade 2");
                                img.setImageResource(R.drawable.obesidade2);
                            }
                            else {
                                if (t > 40){
                                    view.setText("Obesidade 3");
                                    img.setImageResource(R.drawable.obesidade3);
                                }
                            }
                        }
                    }
                }
            }
        }
        }
    }
}