package edu.unicauca.patacore.model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class Pedidos {
    private int imgCard;
    private String textDateCard;
    private String textDateActCard;


    public int getImgCard() {
        return imgCard;
    }

    public void setImgCard(int imgCard) {
        this.imgCard = imgCard;
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

    public Pedidos(int imgCard, String textNameCard, String textDateCard, String textDateActCard) {
        this.imgCard = imgCard;
        this.textDateCard = textDateCard;
        this.textDateActCard = textDateActCard;
    }



}

