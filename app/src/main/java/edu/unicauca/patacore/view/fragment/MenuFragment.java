package edu.unicauca.patacore.view.fragment;


import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import edu.unicauca.patacore.R;
import edu.unicauca.patacore.adapter.PedidosAdapterRecyclerView;
import edu.unicauca.patacore.adapter.PedidosMenuRecyclerView;
import edu.unicauca.patacore.model.Menu;
import edu.unicauca.patacore.model.Pedidos;
import edu.unicauca.patacore.view.AddActivity;
import edu.unicauca.patacore.view.AgregarPlatoActivity;
import edu.unicauca.patacore.view.ContainerActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {
    FloatingActionButton fabBtnPedido;
    Activity activity;
    Fragment menuFragment;
    ArrayList<Menu> listMenu;
    GridView gridView;
    RecyclerView menuRecycler;
    PedidosMenuRecyclerView pedidosMenuRecyclerView;



    public MenuFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_menu, container, false);
        View view= inflater.inflate(R.layout.fragment_menu, container, false);
        init(view);


        listMenu = new ArrayList<>();
        menuRecycler =view.findViewById(R.id.menuRecycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(linearLayoutManager.VERTICAL);
        menuRecycler.setLayoutManager(linearLayoutManager);
        pedidosMenuRecyclerView = new PedidosMenuRecyclerView(buildLista(), R.layout.cardview_menu, getActivity());
        menuRecycler.setAdapter(pedidosMenuRecyclerView);



        //get all data from sqlite
        /*Cursor cursor= AgregarPlatoActivity.sqLiteFood.getData("SELECT * FROM  FOOD");
        //list.clear();
        while (cursor.moveToNext()){
            int id = cursor.getInt(0);
            String name= cursor.getString(1);
            String price = cursor.getString(2);
            byte[] image = cursor.getBlob(3);
            listMenu.add(new Menu(id, name, price, image));

        }*/
        //pedidosMenuRecyclerView.notifyDataSetChanged();
        //consultarListMenu();

        //TOLBAR
        showToolbar("Lista Pedidos", false, view);

        fabBtnPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), AgregarPlatoActivity.class);
                startActivity(intent);

            }
        });
        return view;
    }

    private void consultarListMenu() {

       /* Cursor cursor= AgregarPlatoActivity.sqLiteFood.getData("SELECT * FROM  FOOD");

            while (cursor.moveToNext()){
                int id = cursor.getInt(0);
                String name= cursor.getString(1);
                String price = cursor.getString(2);
                byte[] image = cursor.getBlob(3);
                listMenu.add(new Menu(id, name, price, image));
            }*/





    }

    public void init(View view){
        fabBtnPedido= view.findViewById(R.id.fabBtnPedido);





    }



    private ArrayList<Menu> buildLista() {
        ArrayList <Menu> menu= new ArrayList<>();

        /*menu.add(new Menu("https://image.freepik.com/foto-gratis/plato-pechuga-pollo_1205-4244.jpg", "pollo", "5000"  ));
        menu.add(new Menu("https://peru21.pe/resizer/GjiPoTh0tNBPixu-SjuZ58BFDpM=/980x528/smart/arc-anglerfish-arc2-prod-elcomercio.s3.amazonaws.com/public/ZCPPKN7SHBAA7HPUJHRUGHS32U.jpg", "pollo", "5000"  ));
        menu.add(new Menu("https://cdn.pixabay.com/photo/2014/12/16/23/45/soup-570922_960_720.jpg", "pollo", "5000"  ));
        menu.add(new Menu("https://cdn.colombia.com/sdi/2011/08/02/bandeja-paisa-500927.jpg", "pollo", "5000"  ));
        menu.add(new Menu("https://www.reinadelaselva.pe/content/img_noticia/limonada.jpg", "pollo", "5000"  ));*/

        return menu;
    }
    public void showToolbar(String title, boolean upBotton, View view){
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(upBotton);

    }


}
