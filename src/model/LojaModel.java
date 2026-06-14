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
    public LojaModel() {
        estoque.add(new Pocao("Poção", 1, 200, 20));
        estoque.add(new Pocao("Super Poção", 1, 500, 50));
    }

}
