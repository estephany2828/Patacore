package edu.unicauca.patacore.view.fragment;


import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import edu.unicauca.patacore.R;
import edu.unicauca.patacore.adapter.PedidosAdapterRecyclerView;
import edu.unicauca.patacore.model.Pedidos;
/**
 * A simple {@link Fragment} subclass.
 */
public class ListarOrdenFragment extends Fragment {


    public ListarOrdenFragment() {
        // Required empty public constructor
    }



    @SuppressLint("WrongConstant")
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_listar_orden, container, false);

        RecyclerView pedidosRecycler = view.findViewById(R.id.menuRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        pedidosRecycler.setLayoutManager(linearLayoutManager);
        PedidosAdapterRecyclerView pedidosAdapterRecyclerView =
                new PedidosAdapterRecyclerView(buildLista(),R.layout.cardview_menu, getActivity());
        pedidosRecycler.setAdapter(pedidosAdapterRecyclerView);
        //TOLBAR

        return view;


    }
    public ArrayList<Pedidos> buildLista(){
        ArrayList <Pedidos> pedidos= new ArrayList<>();


        pedidos.add(new Pedidos( R.drawable.macet,"Pedido en preparacion", "10/20/2019", "24/04/2019"));
        pedidos.add(new Pedidos( R.drawable.temp, "Listo para Servir", "10/20/2019", "24/04/2019"));
        pedidos.add(new Pedidos( R.drawable.panadero, "Pedido servido", "10/20/2019", "24/04/2019"));
        return pedidos;
    }


    public void Toolbar(String title, boolean upBotton, View view){
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
         ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upBotton);

    }


}
