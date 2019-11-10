package edu.unicauca.patacore.model;

public class Menu {

    private String imgCard;
    private String txtNombre;
    private String txtPrecio;

    public Menu(String imgCard, String txtNombre, String txtPrecio) {
        this.imgCard = imgCard;
        this.txtNombre = txtNombre;
        this.txtPrecio = txtPrecio;
    }

    public String getImgCard() {
        return imgCard;
    }

    public void setImgCard(String imgCard) {
        this.imgCard = imgCard;
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
}
