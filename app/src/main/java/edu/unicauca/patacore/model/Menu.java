package edu.unicauca.patacore.model;

public class Menu {

    private int id;

    public Menu(String txtNombre, String txtPrecio, String img) {

        this.txtNombre = txtNombre;
        this.txtPrecio = txtPrecio;
        this.img = img;
    }

    private String txtNombre;
    private String txtPrecio;
    private String img;
    private byte[] image;
    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Menu(String txtNombre, String txtPrecio, byte[] image) {
        //this.id = id;
        this.txtNombre = txtNombre;
        this.txtPrecio = txtPrecio;
        this.image = image;
    }

    /*public Menu(String img, String txtNombre, String txtPrecio) {
        this.img = img;
        this.txtNombre = txtNombre;
        this.txtPrecio = txtPrecio;

    }*/
    public  Menu(){

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
