package br.com.example.testfinder.main;
// Tiago Avellar Fernandes RA 551910
//Pedro Henrique Romaoli Garcia RA 551805
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.example.testfinder.R;
import br.com.example.testfinder.add_address.AddAddressActivity;
import br.com.example.testfinder.add_address.AddAddressPresenter;
import br.com.example.testfinder.show_addresses.ShowAddressesActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MainView {//implementamos uma interface para termos uma comunicação entre a activity e o presenter, para usarmos as funções

    @BindView(R.id.btn_add_address) Button btnAddAddress; // alteramos a declaração do botao para podemos utilizar o Butterknife
    @BindView(R.id.btn_show_addresses) Button getBtnShowAddresses; // alteramos a declaração do botao para podemos utilizar o Butterknife
    MainPresenter mainPresenter; // declaramos um objeto do tipo Presenter para conseguimos utilizar a funçao desta classe

    //código utilizado para adicionar novos endereços
    private final int RC_ADD_ADDRESS = 123;
    //lista de endereços
    private ArrayList<String> lstAddresses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this); // declaração para funcionar o ButterKnife
        mainPresenter = new MainPresenter(this); // declaração para iniciar o objeto
    }

    @OnClick(R.id.btn_add_address) // fazemos so a parte de pegar palavras( view burra), aqui ela continua fazendo a mesma coisa de antes mas com o padrao do Butterknife
    public void adiciona_endereco() {
        //abre a activity para adicionar endereços
        Intent openAddAddressActivity = new Intent(MainActivity.this, AddAddressActivity.class);
        startActivityForResult(openAddAddressActivity, RC_ADD_ADDRESS);
    }

    @OnClick(R.id.btn_show_addresses)// fazemos so a parte de pegar palavras( view burra), diferente do que estava antes onde tinha uma logica que foi transferida para o Presenter
    public void mostra_enderecos() {
        mainPresenter.verifica_enderecos_existencia(lstAddresses); // chama a função que esta no presenter que apresenta ou não a lista com os endereço, passando a lista


    }

    @Override
    public void sucessoMostra() {//caso tenha sucesso(exista algum endereço) ele mostra a lista com os endereços
        Intent openShowAddressActivity = new Intent(MainActivity.this, ShowAddressesActivity.class);
        openShowAddressActivity.putStringArrayListExtra("addresses_list", lstAddresses);
        startActivity(openShowAddressActivity);
    }

    @Override
    public void falhaMostra() { //caso tenha falhado( não exista algum endereço) ele mostra uma mensagem de erro
        Toast.makeText(MainActivity.this, "Não há endereços cadastrados", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //captura o resultado da tela de cadastro de endereços e adiciona na lista
        if(requestCode == RC_ADD_ADDRESS && resultCode == Activity.RESULT_OK) {
            lstAddresses.add(data.getStringExtra("movie_name"));
        }
    }
}