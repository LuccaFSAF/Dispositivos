package com.example.listagem;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] lista = new String[]{"Mercurio", "Venus", "Terra", "Marte"};
    ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PlanetaDAO dao = new PlanetaDAO();
        setContentView(R.layout.activity_main);
        listview = findViewById(R.id.ListView);
        PlanetaAdapter planeta = new PlanetaAdapter(this,R.layout.planetas,dao.planetas);


        listview.setAdapter(planeta);
        /*listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this ,Integer.toString(position), Toast.LENGTH_LONG.show());
            }
        });*/
    }
}