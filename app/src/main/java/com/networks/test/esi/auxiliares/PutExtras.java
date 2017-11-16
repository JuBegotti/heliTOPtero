package com.networks.test.esi.auxiliares;

import android.content.Intent;
import com.networks.test.esi.BD.BDTabelas;
import com.networks.test.esi.BD.Helicoptero;

/**
 * Created by ju on 15/11/17.
 * class PutExtras
 */

public class PutExtras {

    public static void putExtrasHelinho(Helicoptero helinho, Intent intent){
        intent.putExtra(BDTabelas.TabelaHelicoptero._NOME, helinho.getNome());
        intent.putExtra(BDTabelas.TabelaHelicoptero._FABRICANTE, helinho.getFabricante());
        intent.putExtra(BDTabelas.TabelaHelicoptero._ESTOQUE, helinho.getUnidades());
        intent.putExtra(BDTabelas.TabelaHelicoptero._PRECO_VENDA, helinho.getPrecoVendaSugerido());
        intent.putExtra(BDTabelas.TabelaHelicoptero._CAPACIDADE, helinho.getCapacidade());
        intent.putExtra(BDTabelas.TabelaHelicoptero._VELOCIDADE, helinho.getVelocidade());
        intent.putExtra(BDTabelas.TabelaHelicoptero._ACELERACAO, helinho.getAceleracao());
        intent.putExtra(BDTabelas.TabelaHelicoptero._CONTROLE, helinho.getControle());
        intent.putExtra(BDTabelas.TabelaHelicoptero._FRENAGEM, helinho.getFrenagem());
        intent.putExtra(BDTabelas.TabelaHelicoptero._PRECO_COMPRA, helinho.getPrecoCompra());
        intent.putExtra(BDTabelas.TabelaHelicoptero._FOTO, helinho.getFoto());
    }

}
