package com.networks.test.esi.auxiliares;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.networks.test.esi.BD.Cliente;
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
    private final List<Cliente> clientes;

    public ListViewHeli(List<Helicoptero> helinhos, List<Cliente> clientes, Activity act) {
        this.helinhos = helinhos;
        this.clientes = clientes;
        this.act = act;
    }

    @Override
    public int getCount() {
        if(clientes==null)  return helinhos.size();
        else return clientes.size();
    }

    @Override
    public Object getItem(int i) {
        if(clientes==null) return helinhos.get(i);
        else return clientes.get(i);
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

        TextView nome = (TextView) view.findViewById(R.id.listView_nome);
        TextView fabricante = (TextView) view.findViewById(R.id.listView_fabricante);

        if(clientes==null){
            Helicoptero helinho = helinhos.get(i);
            nome.setText(helinho.getNome());
            fabricante.setText(helinho.getFabricante());
        }
        else {
            Cliente cliente = clientes.get(i);
            nome.setText(cliente.getNome());
        }

        return view;
    }
}
