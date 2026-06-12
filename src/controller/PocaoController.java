package controller;

import model.Pocao;
import view.PocaoView;

public class PocaoController {

    private Controller.ItemController itemController;
    private PocaoView view;

    public PocaoController(){
        this.itemController = new Controller.ItemController();
        this.view = new PocaoView();

    }

    public void AplicarPocao(Pocao pocao, PokemonBase pokemon){
        if(pocao.getQuantidade() <= 0){
            view.exibirErroSemPocoes();
            return;
        }

        itemController.consumirItem(pocao);

        int hpAtual = pokemon.getHp();
        int hpMaximo = pokemon.getHpMaximo();

        int novoHp = hpAtual + pocao.getPontosDeCura();

        if(novoHp > hpMaximo){
            novoHp = hpMaximo;
        }

        pokemon.setHp(novoHp);

        view.exibirUsoDePocao(pokemon.getNome(), pocao);
    }

}



