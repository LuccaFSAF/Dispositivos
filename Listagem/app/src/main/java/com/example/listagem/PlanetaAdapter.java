package com.example.listagem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PlanetaAdapter extends ArrayAdapter<Planeta> {

    Context nContext;
    int nResorceXML;
    List<Planeta> planetas;

    public PlanetaAdapter(Context context, int resource, List<Planeta> objects){
        super(context, resource, objects);
        nContext = context;
        nResorceXML = resource;
        planetas = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(this.getContext());
        View v = layoutInflater.inflate(nResorceXML,parent,false);
        TextView txtnomeplaneta = v.findViewById(R.id.textView2);
        ImageView imageview = v.findViewById(R.id.imageView);
        Planeta planeta = planetas.get(position);

        txtnomeplaneta.setText(planeta.nome);
        imageview.setImageResource(planeta.foto);
        return v;
    }
}
