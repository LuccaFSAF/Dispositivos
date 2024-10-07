package br.ifsc.edu.br.lista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] lista = new String[]{"Datena", "Boulos", "Marçal", "Tabata", "Nunes"};

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView.findViewById(R.id.listview);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.activity_list_item,
                android.R.id.text1,
                lista);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (view.findViewById(R.id.txtview));
                String s = textView.getText().toString();
                //Toast.makeText(getApplicationContext(), Integer.txtString(i) + " "+ s, Toast.LENGTH_LONG.show());
            }
        });
    }
}