package com.networks.test.esi.auxiliares;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.networks.test.esi.BD.Helicoptero;
import com.networks.test.esi.R;
import java.util.List;

/**
 * Created by ju on 13/11/17.
 * class ListViewHeli
 */

public class ListViewHeli extends BaseAdapter {

    private final List<Helicoptero> helinhos;
    private final Activity act;

    public ListViewHeli(List<Helicoptero> helinhos, Activity act) {
        this.helinhos = helinhos;
        this.act = act;
    }

    @Override
    public int getCount() {
        return helinhos.size();
    }

    @Override
    public Object getItem(int i) {
        return helinhos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view;
        view = act.getLayoutInflater().inflate(R.layout.list_view_helinhos, viewGroup, false);
        Helicoptero helinho = helinhos.get(i);

        TextView nome = (TextView) view.findViewById(R.id.listView_nome);
        TextView fabricante = (TextView) view.findViewById(R.id.listView_fabricante);

        nome.setText(helinho.getNome());
        fabricante.setText(helinho.getFabricante());

        return view;
    }
}
