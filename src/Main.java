import controller.*;
import model.*;
import view.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        ExploracaoController jogo = new ExploracaoController();
        jogo.iniciarExploracao();


        // Criando o Pokémon (Membro 4)
        PokemonBase pikachu = new PokemonBase("Pikachu", 30, TipoPokemon.ELETRICO,100, 20); // Nome, HP Atual, HP Máximo


        ArrayList<ItemBase> mochila = new ArrayList<>();
        Pocao superPocao = new Pocao("Super Potion", 3, 25.00, 50); // Cura 50 de HP
        mochila.add(superPocao);


        ItemView iv = new ItemView();
        iv.exibirMochila(mochila);


        PocaoController pc = new PocaoController();
        pc.AplicarPocao(superPocao, pikachu);


    }



}