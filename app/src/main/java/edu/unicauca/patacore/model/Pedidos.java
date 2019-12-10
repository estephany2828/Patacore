package edu.unicauca.patacore.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Pedidos {
    private String imgCard;
    private String txtNombre;
    private String txtPrecio;
    private String textNameCard;
    private String textDateCard;
    private String textDateActCard;
   private int img;
    public int getImg() {
        return img;
    }
    public void setImg(int img) {
        this.img = img;
    }

    public String getImgCard() {
        return imgCard;
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

    public void setImgCard(String imgCard) {
        this.imgCard = imgCard;
    }

    public String getTextNameCard() {
        return textNameCard;
    }

    public void setTextNameCard(String textNameCard) {
        this.textNameCard = textNameCard;
    }

    public String getTextDateCard() {
        return textDateCard;
    }

    public void setTextDateCard(String textDateCard) {
        this.textDateCard = textDateCard;
    }

    public String getTextDateActCard() {
        return textDateActCard;
    }

    public void setTextDateActCard(String textDateActCard) {
        this.textDateActCard = textDateActCard;
    }

    public Pedidos(String imgCard, String textNameCard, String textDateCard) {
        this.imgCard = imgCard;
        this.textNameCard = textNameCard;
        this.textDateCard = textDateCard;
        this.textDateActCard = textDateActCard;
    }

    public Pedidos() {
    }
}

