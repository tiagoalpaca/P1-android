package br.com.example.testfinder.show_addresses;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import br.com.example.testfinder.R;
import br.com.example.testfinder.add_address.AddAddressActivity;
import br.com.example.testfinder.main.MainActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;

import java.util.ArrayList;

public class ShowAddressesActivity extends AppCompatActivity  {

    @BindView(R.id.rv_addresses) RecyclerView rvAddresses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_addresses);
        ButterKnife.bind(this);
        rvAddresses = (RecyclerView) findViewById(R.id.rv_addresses);


        //captura a lista enviada pela MainActivity
        ArrayList<String> lstAddresses = getIntent().getStringArrayListExtra("addresses_list");
        //instancia um AddressesAdapter passando a lista de endereços
        AddressesAdapter addressesAdapter = new AddressesAdapter(lstAddresses);

        //seta o adapter no Recycler View
        rvAddresses.setAdapter(addressesAdapter);

        //cria o gerenciador de layouts
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //seta o gerenciador de layouts no Recycler View
        rvAddresses.setLayoutManager(layoutManager);
    }


}