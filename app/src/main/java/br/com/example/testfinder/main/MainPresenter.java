package br.com.example.testfinder.main;

import android.text.TextUtils;

import java.util.ArrayList;

import br.com.example.testfinder.add_address.AddAddressView;

/**
 * Created by Tiago Avellar on 08/11/2017.
 */

public class MainPresenter {  // declaramos um objeto do tipo view para usarmos as funções presentes na nossa Main, fazemos a comunicação na view

    MainView mainView;

    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
    } //construtor basico

    public void verifica_enderecos_existencia(ArrayList<String> enderecos) {//tem a parte logica aqui, vendo se o endereço tem itens presente ou não

        if(enderecos.size() <= 0){
            mainView.falhaMostra(); //caso sem itens, chama a função de falha da view
        } else{
            mainView.sucessoMostra();//caso com algum item, chama a função de sucesso da view
        }
    }
}
