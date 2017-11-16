package com.networks.test.esi.auxiliares;

import android.app.AlertDialog;
import android.content.Context;
import com.networks.test.esi.R;

/**
 * Created by ju on 15/11/17.
 * class Mensagens
 */

public class Mensagens {

    public static void mensagem(Context context, int titulo, int texto){
        AlertDialog.Builder dlg = new AlertDialog.Builder(context);
        if(titulo==R.string.erro_titulo) dlg.setTitle(R.string.erro_titulo);
        if(texto==R.string.estoque_vazio_string) dlg.setMessage(R.string.estoque_vazio_string);
        if(texto==R.string.heli_n_encontrado_string) dlg.setMessage(R.string.heli_n_encontrado_string);
        if(texto==R.string.heli_existente_string) dlg.setMessage(R.string.heli_existente_string);
        if(texto==R.string.error_email_exists) dlg.setMessage(R.string.error_email_exists);
        dlg.setNeutralButton(R.string.ok_string,null);
        dlg.show();
    }
}
