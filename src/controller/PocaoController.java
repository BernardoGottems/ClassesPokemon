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


/* como ficará a parte da main (membro 5):
// Criando o Pokémon (Membro 4)
PokemonBase pikachu = new PokemonBase("Pikachu", 30, 100); // Nome, HP Atual, HP Máximo

// Criando a mochila e adicionando suas poções (Membro 5)
ArrayList<ItemBase> mochila = new ArrayList<>();
Pocao superPocao = new Pocao("Super Potion", 3, 25.00, 50); // Cura 50 de HP
mochila.add(superPocao);

// Exibindo a mochila (Membro 5 - ItemView)
ItemView iv = new ItemView();
iv.exibirMochila(mochila);

// Usando a Poção no Pikachu (Membro 5 - PocaoController)
PocaoController pc = new PocaoController();
pc.aplicarPocao(superPocao, pikachu);/*

