package br.com.example.testfinder.add_address;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import br.com.example.testfinder.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddAddressActivity extends AppCompatActivity implements AddAddressView{ //implementamos uma interface para termos uma comunicação entre a activity e o presenter, para usarmos as funções
    @BindView(R.id.edt_address) // alteramos a declaração da variavel para podemos utilizar o Butterknife
    TextView editAddress;
    @BindView(R.id.btn_add) // alteramos a declaração do botao para podemos utilizar o Butterknife
    Button btnAdd;
    AddAddressPresenter addAddressPresenter; // declaramos um objeto do tipo Presenter para conseguimos utilizar a funçao desta classe

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);
        ButterKnife.bind(this); // declaração para funcionar o ButterKnife
        addAddressPresenter = new AddAddressPresenter(this); // declaração para iniciar o objeto
    }

    @OnClick(R.id.btn_add) // fazemos so a parte de pegar palavras( view burra), diferente do que estava antes onde tinha uma logica que foi transferida para o Presenter
    public void valida_endereco() {
        addAddressPresenter.valida_endereco(editAddress.getText().toString());// chama a função que esta no presenter que valida o endereço passando o texto digitado no campo

    }


    @Override
    public void sucessoAdd(String endereco) { //caso tenha sucesso(exista algo digitado) ele adiciona o endereço
        Intent resultIntent = new Intent();
        resultIntent.putExtra("movie_name", editAddress.getText().toString());
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
    }

    @Override
    public void falhaAdd() {//caso tenha falhado( não exista algo digitado) ele imprime uma mensagem de erro
        Toast.makeText(AddAddressActivity.this, "Digite o endereço que deseja adicionar", Toast.LENGTH_SHORT).show();
    }
}
