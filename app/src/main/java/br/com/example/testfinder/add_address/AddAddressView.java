package br.com.example.testfinder.add_address;

/**
 * Created by Tiago Avellar on 08/11/2017.
 */
//usado para fazer a comunicação entre a Activity e o Presenter
public interface AddAddressView {
    void sucessoAdd(String endereco);
    void falhaAdd();
}
