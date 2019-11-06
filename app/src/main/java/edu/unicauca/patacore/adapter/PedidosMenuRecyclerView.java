package edu.unicauca.patacore.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import edu.unicauca.patacore.R;
import edu.unicauca.patacore.model.Menu;
import edu.unicauca.patacore.model.Pedidos;
import edu.unicauca.patacore.view.PedidoDetalleActivity;

public class PedidosMenuRecyclerView extends RecyclerView.Adapter<PedidosMenuRecyclerView.PedidosAViewHolder> {
    private ArrayList<Menu> menuArrayList;
    private int resource;
    private Activity activity;

    public PedidosMenuRecyclerView(ArrayList<Menu> menuArrayList, int resource, Activity activity) {
        this.menuArrayList = menuArrayList;
        this.resource = resource;
        this.activity = activity;
    }


    @NonNull
    @Override
    public PedidosAViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PedidosAViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PedidosAViewHolder holder, int position) {
        Menu menu = menuArrayList.get(position);
        holder.txtNombre.setText(menu.getTxtNombre());
        holder.txtPrecio.setText(menu.getTxtPrecio());
        Picasso.with(activity)
                .load(menu.getImgCard())
                .resize(120, 120)
                .placeholder(R.drawable.panadero)
                .error(R.drawable.panadero)
                .into(holder.img_card_list);


    }

    @Override
    public int getItemCount() {
        return menuArrayList.size();
    }
    public class PedidosAViewHolder extends RecyclerView.ViewHolder {


        public Menu menu;
        TextView txtNombre;
        TextView txtPrecio;
        ImageView img_card_list;



        //TODOS LOS VIEW QUE COMPONEN A LA CARD
        public PedidosAViewHolder(@NonNull View itemView) {
            super(itemView);

            img_card_list = itemView.findViewById(R.id.img_card_list);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);

        }




    }
}
