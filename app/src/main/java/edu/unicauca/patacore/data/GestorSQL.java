package edu.unicauca.patacore.data;

import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.security.ProtectionDomain;
import java.util.ArrayList;

import edu.unicauca.patacore.data.utilidades.Utilidades;
import edu.unicauca.patacore.model.Pedido;
import edu.unicauca.patacore.model.Producto;

public class GestorSQL {
    private Context context;
    private Gson gson;
    private ArrayList<Producto> listaProductos;
    private ArrayList<Pedido> listaPedidos;
    ConexionSQLiteHelper conn = new ConexionSQLiteHelper(context, "bd_productos", null, 1);
    public GestorSQL(Context context) {
        this.context = context;
        gson = new Gson();
    }


    public Producto consultarProducto(String codigo) {

        Producto producto = new Producto();


        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {String.valueOf(codigo)};         // Parámetro de búsqueda
        String[] campos = {Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_DESCRIPCION}; //Parámetros obtenidos

        try {
            Cursor cursor = db.query(Utilidades.TABLA_PRODUCTO, campos, Utilidades.CAMPO_ID + "=?", parametros, null, null, null);
            cursor.moveToFirst();
            producto.setNombre(cursor.getString(0));
            producto.setDescripcion(cursor.getString(1));
            cursor.close();
        } catch (Exception e) {
            Toast.makeText(context, "El documento no existe", Toast.LENGTH_LONG).show();

        }
        return producto;
    }


    public void registrarProducto(int codigo, String nombre, String descripcion, int cantidad, int imagen, int selected) {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(context, "producto", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Utilidades.CAMPO_ID, codigo);
        values.put(Utilidades.CAMPO_NOMBRE, nombre);
        values.put(Utilidades.CAMPO_DESCRIPCION, descripcion);
        values.put(Utilidades.CAMPO_CANTIDAD, cantidad);
        values.put(Utilidades.CAMPO_IMAGEN, imagen);
        values.put(Utilidades.CAMPO_SELECTED, selected);

        Long idResultante = db.insert(Utilidades.TABLA_PRODUCTO, Utilidades.CAMPO_ID, values);

        Toast.makeText(context, "Id Registro: " + idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }


    public ArrayList<Producto> consultarProductos() {
        listaProductos = new ArrayList<Producto>();
        ConexionSQLiteHelper conn;
        conn = new ConexionSQLiteHelper(context, "producto", null, 1);
        SQLiteDatabase db = conn.getReadableDatabase();

        Producto producto = null;
        // listaUsuarios=new ArrayList<Usuario>();
        //select * from usuarios
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_PRODUCTO, null);
        listaProductos = new ArrayList<Producto>();
        while (cursor.moveToNext()) {
            producto = new Producto();
            producto.setCodigo(cursor.getInt(0));
            producto.setNombre(cursor.getString(1));
            producto.setDescripcion(cursor.getString(2));
            producto.setCantidad(cursor.getInt(3));
            producto.setImagen(cursor.getInt(4));
            boolean selected = false;
            if (cursor.getInt(5) == 1) {
                selected = true;
            }
            producto.setSelected(selected);
            listaProductos.add(producto);
        }

        return listaProductos;
    }

/*
    public Pedido consultarPedido(int codigo) {

        Pedido pedido = new Pedido();

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(context, "bd_pedidos", null, 1);
        SQLiteDatabase db = conn.getReadableDatabase();
        String[] parametros = {String.valueOf(codigo)};         // Parámetro de búsqueda
        String[] campos = {Utilidades.CAMPO_FECHA, Utilidades.CAMPO_HORA, Utilidades.CAMPO_ESTADO, Utilidades.CAMPO_IMAGEN, Utilidades.CAMPO_COD_PRODUCTOS, Utilidades.CAMPO_NPRODUCTOS}; //Parámetros obtenidos

        try {
            Cursor cursor = db.query(Utilidades.TABLA_PRODUCTO, campos, Utilidades.CAMPO_ID + "=?", parametros, null, null, null);
            cursor.moveToFirst();
            pedido.setCodigo(codigo);
            pedido.setFecha(cursor.getString(0));
            pedido.setHora(cursor.getString(1));
            pedido.setEstado(cursor.getInt(2));
            pedido.setImagen(cursor.getInt(3));


            Type type = new TypeToken<ArrayList<Integer>>() {
            }.getType();
            String outputString = cursor.getString(4);
            ArrayList<Integer> arrayList = gson.fromJson(outputString, type);
            pedido.setCodProductos(arrayList);

            outputString = cursor.getString(5);
            arrayList = gson.fromJson(outputString, type);
            pedido.setNumProductos(arrayList);


            cursor.close();
        } catch (Exception e) {
            Toast.makeText(context, "El documento no existe", Toast.LENGTH_LONG).show();

        }
        return pedido;
    }

*/
/*
    private ArrayList<Pedido> consultarPedidos() {
        listaPedidos = new ArrayList<Pedido>();
        ConexionSQLiteHelper conn;
        conn = new ConexionSQLiteHelper(context, "bd_pedidos", null, 1);
        SQLiteDatabase db = conn.getReadableDatabase();

        Pedido pedido = null;
        // listaUsuarios=new ArrayList<Usuario>();
        //select * from usuarios
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_PRODUCTO, null);
        listaPedidos = new ArrayList<Pedido>();
        while (cursor.moveToNext()) {
            pedido = new Pedido();
            pedido.setFecha(cursor.getString(1));
            pedido.setHora(cursor.getString(2));
            pedido.setEstado(cursor.getInt(3));

            Type type = new TypeToken<ArrayList<Integer>>() {
            }.getType();
            String outputString = cursor.getString(5);
            ArrayList<Integer> arrayList = gson.fromJson(outputString, type);
            pedido.setCodProductos(arrayList);

            outputString = cursor.getString(6);
            arrayList = gson.fromJson(outputString, type);
            pedido.setNumProductos(arrayList);

            listaPedidos.add(pedido);
        }

        return listaPedidos;
    }
*/
    public void regPedido (int mesa, String fecha,String hora, String nombre, int estado, int cantidad){
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(context, "pedido", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID, mesa);
        values.put(Utilidades.CAMPO_FECHA, fecha);
        values.put(Utilidades.CAMPO_HORA, hora);
        values.put(Utilidades.CAMPO_ESTADO, estado);
        values.put(Utilidades.CAMPO_NOM_PROD, nombre);
        values.put(Utilidades.CAMPO_CANT_PRODUCTO, cantidad);

        Long idResultante = db.insert(Utilidades.TABLA_PEDIDO, Utilidades.CAMPO_ID, values);

        Toast.makeText(context, "Id Registro: " + idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }

    public Pedido consPedido (int mesa){

        ConexionSQLiteHelper conn;
        conn = new ConexionSQLiteHelper(context, "pedido", null, 1);
        SQLiteDatabase db = conn.getReadableDatabase();
        // + " WHERE "+Utilidades.CAMPO_ID+"="+String.valueOf(mesa) +" AND "+Utilidades.CAMPO_ESTADO+" =1"
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_PEDIDO + " WHERE "+Utilidades.CAMPO_ID+"="+String.valueOf(mesa) +" AND "+Utilidades.CAMPO_ESTADO+" =1", null);
        listaProductos = new ArrayList<Producto>();
        Pedido pedido = new Pedido();


        while (cursor.moveToNext()) {
            pedido.setMesa(cursor.getInt(0));
            pedido.setFecha(cursor.getString(1));
            pedido.setHora(cursor.getString(2));
            pedido.setEstado(cursor.getInt(3));

            Producto producto = new Producto();
            producto.setNombre(cursor.getString(4));
            producto.setCantidad(cursor.getInt(5));
            listaProductos.add(producto);
        }
        pedido.setProductos(listaProductos);
        return pedido;
    }

/*
    public void registrarPedido(int codigo, String fecha, String hora, int estado, int imagen, ArrayList<Integer> codProductos, ArrayList<Integer> numProductos) {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(context, "bd_pedidos", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(Utilidades.CAMPO_ID, codigo);
        values.put(Utilidades.CAMPO_FECHA, fecha);
        values.put(Utilidades.CAMPO_HORA, hora);
        values.put(Utilidades.CAMPO_ESTADO, estado);
        values.put(Utilidades.CAMPO_IMAGEN, imagen);

        Gson gson = new Gson();
        String inputString = gson.toJson(codProductos);
        values.put(Utilidades.CAMPO_COD_PRODUCTOS, inputString);

        inputString = gson.toJson(numProductos);
        values.put(Utilidades.CAMPO_NPRODUCTOS, inputString);


        Long idResultante = db.insert(Utilidades.TABLA_PRODUCTO, Utilidades.CAMPO_ID, values);

        Toast.makeText(context, "Id Registro: " + idResultante, Toast.LENGTH_SHORT).show();
        db.close();
    }

    */

    public void actualizarPedido(int mesa, int estado, Producto producto) {
        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(context, "pedido", null, 1);
        SQLiteDatabase db=conn.getWritableDatabase();

        String[] parametros={String.valueOf(mesa)};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOM_PROD , producto.getNombre());
        values.put(Utilidades.CAMPO_CANT_PRODUCTO, producto.getCantidad());
        values.put(Utilidades.CAMPO_ESTADO, estado);

        db.update(Utilidades.TABLA_PEDIDO,values,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(context,"Ya se actualizó el pedido",Toast.LENGTH_LONG).show();
        db.close();
    }

    private int buscarPedido(int mesa) {
        int size = listaPedidos.size();
        int posicion = -1;
        int i = 0;
        for (i = 0; i < size; i++) {
            if (listaPedidos.get(i).getMesa() == mesa) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }

    private int buscarProductoEnPedido(ArrayList<String> listaCodigos, String codigo) {
        int size = listaCodigos.size();
        int posicion = -1;
        int i = 0;
        for (i = 0; i < size; i++) {
            if (listaCodigos.get(i) == codigo) {
                posicion = i;
                break;
            }
        }
        return posicion;
    }


    public ArrayList<String> cambiosPedido (int idPedido, Pedido newPedido){
        ArrayList<String> cambios = new ArrayList<String>();



        Pedido pedido = consPedido(idPedido);
        ArrayList<String> codsPedido = new ArrayList<String>();
        for (int i=0; i<pedido.getProductos().size(); i++){
            codsPedido.add(pedido.getProductos().get(i).getNombre());
        }
        ArrayList<String> codsNewPedido = new ArrayList<String>();
        for (int i=0; i<pedido.getProductos().size(); i++){
             codsNewPedido.add(newPedido.getProductos().get(i).getNombre());
        }
        int tCP = codsNewPedido.size();
        int i = 0;
        for (i = 0; i < tCP; i++) {
            int pos = buscarProductoEnPedido(codsPedido, codsNewPedido.get(i));
            if (pos != -1) {
                // Modificar el producto
                int diferencia = newPedido.getProductos().get(i).getCantidad() - pedido.getProductos().get(pos).getCantidad();
                if (diferencia >= 1) {
                   cambios.add("Añadir " + String.valueOf(diferencia) + " " + codsPedido.get(pos));
                } else if (diferencia < 0) {
                   diferencia = -diferencia;
                   cambios.add("Quitar " + String.valueOf(diferencia)+ " " + codsPedido.get(pos));
                }
            }else{
                cambios.add("Añadir " + String.valueOf(newPedido.getProductos().get(i).getCantidad()) + " " + codsNewPedido.get(i));
            }
        }
        return cambios;
    }

/*
    public void actualizarPedido(int idPedido, Pedido newPedido) {
        SQLiteDatabase db = conn.getWritableDatabase();
        String[] parametros = {String.valueOf(idPedido)};
        ContentValues values = new ContentValues();

        Gson gson = new Gson();
        String inputString = gson.toJson(newPedido.getCodProductos());
        values.put(Utilidades.CAMPO_COD_PRODUCTOS, inputString);

        inputString = gson.toJson(newPedido.getNumProductos());
        values.put(Utilidades.CAMPO_NPRODUCTOS, inputString);

        db.update(Utilidades.TABLA_PEDIDO, values, Utilidades.CAMPO_ID + "=?", parametros);
        Toast.makeText(context, "Ya se actualizó el pedido", Toast.LENGTH_LONG).show();
        db.close();
    }

*/

}
