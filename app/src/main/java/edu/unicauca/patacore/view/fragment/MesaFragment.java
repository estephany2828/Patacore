package edu.unicauca.patacore.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;

import java.util.ArrayList;

import edu.unicauca.patacore.R;
import edu.unicauca.patacore.adapter.MesaAdapterRecyclerView;
import edu.unicauca.patacore.adapter.PedidosAdapterRecyclerView;
import edu.unicauca.patacore.model.Mesa;

/**
 * A simple {@link Fragment} subclass.
 */
public class MesaFragment extends Fragment {


    public MesaFragment() {
        // Required empty public constructor
    }

    private GridLayout gridLayout;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_mesa, container, false);
        View view= inflater.inflate(R.layout.fragment_mesa, container, false);

        RecyclerView mesaRecycler =view.findViewById(R.id.mesaRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        mesaRecycler.setLayoutManager(linearLayoutManager);
        MesaAdapterRecyclerView mesaAdapterRecyclerView =
                new MesaAdapterRecyclerView(buildLista(),R.layout.cardview_mesa, getActivity());
        mesaRecycler.setAdapter(mesaAdapterRecyclerView);
        //TOLBAR
        //showToolbar("Lista Pedidos", false, view);

        return view;
    }

    private ArrayList<Mesa> buildLista() {
        ArrayList <Mesa> mesa= new ArrayList<>();
        mesa.add(new Mesa("https://image.freepik.com/foto-gratis/plato-pechuga-pollo_1205-4244.jpg", "1"));
        mesa.add(new Mesa("https://image.freepik.com/foto-gratis/plato-pechuga-pollo_1205-4244.jpg", "2"));

        return mesa;

    }

}
