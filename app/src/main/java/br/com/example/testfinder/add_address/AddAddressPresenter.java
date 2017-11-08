package br.com.example.testfinder.add_address;

import android.text.TextUtils;

/**
 * Created by Tiago Avellar on 08/11/2017.
 */

public class AddAddressPresenter {
    AddAddressView addAddressView; // declaramos um objeto do tipo view para usarmos as funções presentes na nossa Main, fazemos a comunicação na view

    public AddAddressPresenter(AddAddressView addAddressView) {
        this.addAddressView = addAddressView; //construtor basico
    }

    public void valida_endereco(String endereco) { //tem a parte logica aqui, vendo se o endereço é vazio ou não

        if (TextUtils.isEmpty(endereco)) {
            addAddressView.falhaAdd(); //caso vazio, chama a função de falha da view
        } else{
            addAddressView.sucessoAdd(endereco);//se não tiver vazio, chama a função sucesso da view
        }
    }
}
