package edu.unicauca.patacore.view.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import edu.unicauca.patacore.R;
import edu.unicauca.patacore.model.Producto;
import edu.unicauca.patacore.adapter.PedidosNewAdapterRecycler;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewOrdenFragment extends Fragment {

    ArrayList<Producto> listaProductos;
    RecyclerView recyclerProductos;
    PedidosNewAdapterRecycler adapter;


    public NewOrdenFragment() {
        // Required empty public constructor
    }


   @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {
       super.onCreate(savedInstanceState);
       View view = inflater.inflate(R.layout.fragment_new_orden, container, false);

       recyclerProductos = view.findViewById(R.id.recyclerProductos);

       LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
       linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);

       recyclerProductos.setLayoutManager(linearLayoutManager);

       llenarProductos ();

       adapter = new PedidosNewAdapterRecycler(listaProductos);
       recyclerProductos.setAdapter(adapter);



       // Inflate the layout for this fragment
       return view;
   }


    private void llenarProductos (){
        listaProductos = new ArrayList<Producto>();
        listaProductos.add (new Producto (1025, "Carnita", "Carne deliciosa asadita", 0, R.drawable.macet));
        listaProductos.add (new Producto (1026, "Pollito", "Pollito delicioso asadito", 0, R.drawable.panadero));
        listaProductos.add (new Producto (1026, "Pollito", "Pollito delicioso asadito", 0, R.drawable.panadero));
        listaProductos.add (new Producto (1026, "Pollito", "Pollito delicioso asadito", 0, R.drawable.panadero));
        listaProductos.add (new Producto (1026, "Pollito", "Pollito delicioso asadito", 0, R.drawable.panadero));
        listaProductos.add (new Producto (1026, "Pollito", "Pollito delicioso asadito", 0, R.drawable.panadero));
        listaProductos.add (new Producto (1026, "Pollito", "Pollito delicioso asadito", 0, R.drawable.panadero));

    }
}
