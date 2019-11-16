package edu.unicauca.patacore.model;

public class Menu {
    private int id;
    private String txtNombre;
    private String txtPrecio;
    private byte[] image;

    public Menu(int id, String txtNombre, String txtPrecio, byte[] image) {
        this.id = id;
        this.txtNombre = txtNombre;
        this.txtPrecio = txtPrecio;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(String txtNombre) {
        this.txtNombre = txtNombre;
    }

    public String getTxtPrecio() {
        return txtPrecio;
    }

    public void setTxtPrecio(String txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }
}
