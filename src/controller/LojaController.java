package controller;

import model.ItemBase;
import model.JogadorModel;
import model.LojaModel;
import model.Pocao;

import java.util.ArrayList;

public class LojaController {
    JogadorModel jogador;
    LojaModel loja;

    public LojaController(JogadorModel jogador, LojaModel loja) {
        this.jogador = jogador;
        this.loja = loja;
    }

    public boolean lojaComprar(ArrayList<ItemBase> mochila, ItemBase item) {
        if (jogador.getDinheiro() < item.getPrecoBase()) return false;
        jogador.gastarDinheiro(item.getPrecoBase());
        jogador.adicionarItem(new Pocao(item.getNome(), 1, item.getPrecoBase(), ((Pocao) item).getPontosDeCura()));
        return true;
    }
}
