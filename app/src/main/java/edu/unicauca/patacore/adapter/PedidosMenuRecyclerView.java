package edu.unicauca.patacore.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import edu.unicauca.patacore.R;
import edu.unicauca.patacore.data.db.SQLiteFood;
import edu.unicauca.patacore.model.Menu;
import edu.unicauca.patacore.model.Pedidos;
import edu.unicauca.patacore.view.AgregarPlatoActivity;
import edu.unicauca.patacore.view.PedidoDetalleActivity;

public class PedidosMenuRecyclerView extends RecyclerView.Adapter<PedidosMenuRecyclerView.PedidosAViewHolder> {
    private ArrayList<Menu> menuArrayList;
    private List<Menu> menuList;
    private int resource;
    private Activity activity;
    private Context context;
    private RecyclerView recyclerView;

    public PedidosMenuRecyclerView(List<Menu> menuList, Context context, RecyclerView recyclerView) {
        this.menuList = menuList;
        this.context = context;
        this.recyclerView = recyclerView;
    }

    public PedidosMenuRecyclerView(ArrayList<Menu> menuArrayList, int resource, Activity activity) {
        this.menuArrayList = menuArrayList;
        this.resource = resource;
        this.activity = activity;
    }


    @NonNull
    @Override
    /*public PedidosAViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_menu,parent, false);
        return new PedidosAViewHolder(view);
    }*/
    public PedidosAViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(resource,parent, false);
        return new PedidosAViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull PedidosAViewHolder holder, final int position) {

        final Menu menu = menuArrayList.get(position);
        holder.txtNombre.setText(menu.getTxtNombre());
        holder.txtPrecio.setText(menu.getTxtPrecio());

        //holder.txtNombre.setText("Name: " + menu.getTxtNombre());
        //holder.txtPrecio.setText("Price: " + menu.getTxtPrecio());

        /*byte [] foodImage =menu.getImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0, foodImage.length);
        holder.img_card_menu.setImageBitmap(bitmap);*/

        Picasso.with(activity)
                .load(menu.getImg())
                .resize(120, 120)
                .placeholder(R.drawable.panadero)
                .error(R.drawable.panadero)
                .into(holder.img_card_menu);
       ;

        //listen to single view layout click
       /* holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Choose option");
                builder.setMessage("Update or delete user?");
                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        //go to update activity
                        goToUpdateActivity(menu.getId());

                    }
                });
                builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       // SQLiteFood dbHelper = new SQLiteFood(context);
                        //dbHelper.deleteMenuRecord(menu.getId(), context);

                        menuList.remove(position);
                        recyclerView.removeViewAt(position);
                        notifyItemRemoved(position);
                        notifyItemRangeChanged(position, menuList.size());
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();
            }
        });*/


    }
    private void goToUpdateActivity(long personId){
        Intent goToUpdate = new Intent(context, AgregarPlatoActivity.class);
        goToUpdate.putExtra("USER_ID", personId);
        context.startActivity(goToUpdate);
    }


    @Override
    public int getItemCount() {
        return menuArrayList.size();
    }


    public class PedidosAViewHolder extends RecyclerView.ViewHolder {


        public Menu menu;
        TextView txtNombre;
        TextView txtPrecio;
        ImageView img_card_menu;
        //public View layout;



        //TODOS LOS VIEW QUE COMPONEN A LA CARD
        public PedidosAViewHolder(@NonNull View itemView) {

            super(itemView);
            //layout= itemView;
            img_card_menu = itemView.findViewById(R.id.img_card_menu);
            txtNombre = itemView.findViewById(R.id.txtNombre);
            txtPrecio = itemView.findViewById(R.id.txtPrecio);

        }

      /*  public void add(int position, Menu menu) {
            menuList.add(position, menu);
            notifyItemInserted(position);
        }

        public void removeMenu(int position) {
            menuList.remove(position);
            notifyItemRemoved(position);
        }*/


    }
}
