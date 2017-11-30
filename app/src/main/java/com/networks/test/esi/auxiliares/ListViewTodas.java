package com.networks.test.esi.auxiliares;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.networks.test.esi.BD.Cliente;
import com.networks.test.esi.BD.Helicoptero;
import com.networks.test.esi.BD.Transacoes;
import com.networks.test.esi.R;
import java.util.List;

/**
 * Created by ju on 13/11/17.
 * class ListViewTodas
 */

public class ListViewTodas extends BaseAdapter {

    private final List<Helicoptero> helinhos;
    private final List<Transacoes> transacoes;
    private final Activity act;
    private final List<Cliente> clientes;

    public ListViewTodas(List<Helicoptero> helinhos, List<Cliente> clientes, List<Transacoes> transacoes, Activity act) {
        this.helinhos = helinhos;
        this.clientes = clientes;
        this.transacoes = transacoes;
        this.act = act;
    }

    @Override
    public int getCount() {
        if(clientes==null && transacoes==null)  return helinhos.size();
        if(helinhos==null && clientes==null) return transacoes.size();
        else  return clientes.size();
    }

    @Override
    public Object getItem(int i) {
        if(clientes==null && transacoes==null) return helinhos.get(i);
        if(helinhos==null && clientes==null) return transacoes.get(i);
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
        TextView data = (TextView) view.findViewById(R.id.listView_data);
        TextView nemSei = (TextView) view.findViewById(R.id.listView_nomee);

        if(clientes==null && transacoes==null){
            Helicoptero helinho = helinhos.get(i);
            nome.setText(helinho.getNome());
            fabricante.setText(helinho.getFabricante());
        }
        else if(helinhos==null && clientes==null){
            Transacoes transacao = transacoes.get(i);
            if(transacao.getCompra_venda()==1) nome.setText("Compra");
            else nome.setText("Venda");
            nome.setTextSize(12);
            data.setText(transacao.getData());
            data.setTextSize(12);
            nemSei.setText(transacao.getNomeHelinho());
            fabricante.setText(transacao.getNomeFabricante());
        }
        else {
            Cliente cliente = clientes.get(i);
            nome.setText(cliente.getNome());
        }

        return view;
    }
}
