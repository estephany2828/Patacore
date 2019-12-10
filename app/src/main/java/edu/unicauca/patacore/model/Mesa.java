package edu.unicauca.patacore.model;

public class Mesa {
    String imgCardMesa;
    String txtCardMesa;

    public Mesa(String imgCardMesa, String txtCardMesa) {
        this.imgCardMesa = imgCardMesa;
        this.txtCardMesa = txtCardMesa;
    }

    public String getImgCardMesa() {
        return imgCardMesa;
    }

    public void setImgCardMesa(String imgCardMesa) {
        this.imgCardMesa = imgCardMesa;
    }

    public String getTxtCardMesa() {
        return txtCardMesa;
    }

    public void setTxtCardMesa(String txtCardMesa) {
        this.txtCardMesa = txtCardMesa;
    }
}
