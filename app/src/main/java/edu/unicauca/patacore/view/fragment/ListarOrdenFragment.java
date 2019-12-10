package edu.unicauca.patacore.view.fragment;


import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_listar_orden, container, false);
        RecyclerView pedidosRecycler =view.findViewById(R.id.menuListRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        pedidosRecycler.setLayoutManager(linearLayoutManager);
        PedidosAdapterRecyclerView pedidosAdapterRecyclerView =
                new PedidosAdapterRecyclerView(buildLista(),R.layout.cardview_list, getActivity());
        pedidosRecycler.setAdapter(pedidosAdapterRecyclerView);
        //TOLBAR
        showToolbar("Lista Pedidos", false, view);
        return view;

    }
  public ArrayList<Pedidos> buildLista(){
        ArrayList <Pedidos> pedidos= new ArrayList<>();


      pedidos.add(new Pedidos("https://www.reinadelaselva.pe/content/img_noticia/limonada.jpg", "pollo", "5000"  ));
      pedidos.add(new Pedidos("https://peru21.pe/resizer/GjiPoTh0tNBPixu-SjuZ58BFDpM=/980x528/smart/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/ZCPPKN7SHBAA7HPUJHRUGHS32U.jpg", "pollo", "5000"  ));
      pedidos.add(new Pedidos("https://cdn.pixabay.com/photo/2014/12/16/23/45/soup-570922_960_720.jpg", "pollo", "5000"  ));
      pedidos.add(new Pedidos("https://cdn.colombia.com/sdi/2011/08/02/bandeja-paisa-500927.jpg", "pollo", "5000"  ));
      pedidos.add(new Pedidos("https://www.reinadelaselva.pe/content/img_noticia/limonada.jpg", "pollo", "5000"  ));

        return pedidos;
    }


    public void showToolbar(String title, boolean upBotton, View view){
         Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
         ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upBotton);

    }


}
