package controller;

import model.ItemBase;
import model.JogadorModel;
import model.LojaModel;

import java.util.ArrayList;

public class LojaController {
    LojaModel loja;
    public void lojaComprar(ArrayList<ItemBase> mochila, int index){
        ArrayList<ItemBase> itemLoja = loja.getEstoque();
        mochila.add(new ItemBase(itemLoja.get(index).getNome(),itemLoja.get(index).getQuantidade(),itemLoja.get(index).getPrecoBase()));
    }
}
