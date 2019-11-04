package edu.unicauca.patacore.adapter;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Picture;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.CollationElementIterator;
import java.util.ArrayList;

import edu.unicauca.patacore.R;
import edu.unicauca.patacore.model.Pedidos;
import edu.unicauca.patacore.view.PedidoDetalleActivity;

public class PedidosAdapterRecyclerView extends RecyclerView.Adapter<PedidosAdapterRecyclerView.PedidosAViewHolder>{


    public PedidosAdapterRecyclerView(ArrayList<Pedidos> pedidosArrayList, int resource, Activity activity) {
        this.pedidosArrayList = pedidosArrayList;
        this.resource = resource;
        this.activity = activity;
    }

    private ArrayList<Pedidos> pedidosArrayList;
    private int resource;
    private Activity activity;




    @NonNull
    @Override
    public PedidosAViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
        return new PedidosAViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PedidosAViewHolder holder, int position) {
        //TODA LA LISTA DE ELEMENTOS

       Pedidos pedido = pedidosArrayList.get(position);
       holder.txtNombre.setText(pedido.getTxtNombre());
       holder.txtPrecio.setText(pedido.getTxtPrecio());
       Picasso.with(activity)
               .load(pedido.getImgCard())
               .resize(120, 120)
               .placeholder(R.drawable.panadero)
               .error(R.drawable.panadero)
               .into(holder.img_card_list);
       holder.btnPrep.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(activity, PedidoDetalleActivity.class);
               activity.startActivity(intent);

           }
       });



    }

    @Override
    public int getItemCount() {
        return  pedidosArrayList.size();
    }

    public class PedidosAViewHolder extends RecyclerView.ViewHolder {


        public Pedidos pedidos;
        TextView txtNombre;
        TextView txtPrecio;
        ImageView img_card_list;
        Button btnPrep;


        //TODOS LOS VIEW QUE COMPONEN A LA CARD
        public PedidosAViewHolder(@NonNull View itemView) {
            super(itemView);
            btnPrep = itemView.findViewById(R.id.btnPrep);
            img_card_list = itemView.findViewById(R.id.img_card_list);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);

        }




    }
}
