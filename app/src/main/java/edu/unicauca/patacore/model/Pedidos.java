package edu.unicauca.patacore.model;

public class Pedidos {
    private int iconCard;
    private String textNameCard;
    private String textDateCard;
    private String textDateActCard;

    public Pedidos(int iconCard, String textNameCard, String textDateCard, String textDateActCard) {
        this.iconCard = iconCard;
        this.textNameCard = textNameCard;
        this.textDateCard = textDateCard;
        this.textDateActCard = textDateActCard;
    }

    public int getIconCard() {
        return iconCard;
    }

    public void setIconCard(int iconCard) {
        this.iconCard = iconCard;
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
}

