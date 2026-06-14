package model;

import java.util.ArrayList;

public class LojaModel {
    private ArrayList<ItemBase> estoque = new ArrayList<>();

    public ArrayList<ItemBase> getEstoque() {
        return estoque;
    }

    public void setEstoque(ArrayList<ItemBase> estoque) {
        this.estoque = estoque;
    }

}
