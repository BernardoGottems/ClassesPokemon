package controller;

import model.Pocao;
import model.PokemonBase;
import view.PocaoView;

public class PocaoController {

    private controller.ItemController itemController;
    private PocaoView view;

    public PocaoController(){
        this.itemController = new controller.ItemController();
        this.view = new PocaoView();

    }

    public void AplicarPocao(Pocao pocao, PokemonBase pokemon){
        if(pocao.getQuantidade() <= 0){
            view.exibirErroSemPocoes();
            return;
        }

        itemController.consumirItem(pocao);


        pokemon.receberCura(pocao.getPontosDeCura());

        view.exibirUsoDePocao(pokemon.getNome(), pocao);

    }

}



