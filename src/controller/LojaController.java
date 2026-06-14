package controller;

import model.ItemBase;
import model.JogadorModel;
import model.LojaModel;

import java.util.ArrayList;

public class LojaController {
    JogadorModel jogador;
    LojaModel loja;

    public LojaController(JogadorModel jogador, LojaModel loja) {
        this.jogador = jogador;
        this.loja = loja;
    }

    public boolean lojaComprar(ArrayList<ItemBase> mochila, int index){
        ArrayList<ItemBase> itemLoja = loja.getEstoque();
            if(jogador.getDinheiro() >= (itemLoja.get(index).getPrecoBase() * itemLoja.get(index).getQuantidade())) {
                jogador.setDinheiro(jogador.getDinheiro() - itemLoja.get(index).getPrecoBase() * itemLoja.get(index).getQuantidade());
                mochila.add(new ItemBase(itemLoja.get(index).getNome(), itemLoja.get(index).getQuantidade(), itemLoja.get(index).getPrecoBase()));
            return true;
            }
            return false;
        }
}
