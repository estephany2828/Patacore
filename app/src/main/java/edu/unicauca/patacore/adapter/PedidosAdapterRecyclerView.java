package edu.unicauca.patacore.adapter;

import android.app.Activity;
import android.graphics.Picture;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.text.CollationElementIterator;
import java.util.ArrayList;

import edu.unicauca.patacore.R;
import edu.unicauca.patacore.model.Pedidos;

public class PedidosAdapterRecyclerView extends RecyclerView.Adapter<PedidosAdapterRecyclerView.PedidosAViewHolder>{



    private ArrayList<Pedidos> pedidos;

    public PedidosAdapterRecyclerView(ArrayList<Pedidos> pedidos, int resource, Activity activity) {
        this.pedidos = pedidos;
        this.resource = resource;
        this.activity = activity;
    }

    private String[] mDataset;
    private int resource; //el card view
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


        holder.textNameCard.setText(position);
        holder.textDateCard.setText(position);
        holder.textDateActCard.setText(position);


    }

    @Override
    public int getItemCount() {

        return  pedidos.size();
    }

    public class PedidosAViewHolder extends RecyclerView.ViewHolder {

        public TextView textNameCard;
        private ImageView iconCard;
        private TextView textDateCard;
        private TextView textDateActCard;

        //TODOS LOS VIEW QUE COMPONEN A LA CARD
        public PedidosAViewHolder(@NonNull View itemView) {
            super(itemView);
            iconCard = itemView.findViewById(R.id.iconCard);
            textNameCard = itemView.findViewById(R.id.textNameCard);
            textDateCard = itemView.findViewById(R.id.textDateCard);
            textDateActCard = itemView.findViewById(R.id.textDatActCard);

        }
    }
}
