package edu.unicauca.patacore.model;

import java.util.ArrayList;

public class Pedido {
    private int codigo;
    private String nombre;
    private int estado;
    private ArrayList<Producto> Productos;


    public Pedido(int codigo, String nombre, int estado, ArrayList<Producto> productos) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.estado = estado;
        Productos = productos;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public ArrayList<Producto> getProductos() {
        return Productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        Productos = productos;
    }
}
