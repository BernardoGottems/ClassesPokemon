package view;

import model.PokemonBase;

import java.util.ArrayList;

public class PokemonView {

    public void verEquipe(ArrayList<PokemonBase> equipe){
        for (PokemonBase pokemon : equipe) {
            System.out.println("\n\n" + pokemon.getNome());
            System.out.println(pokemon.getNivel());
            System.out.println(pokemon.getTipo());
            System.out.println(pokemon.getVidaMaxima());

        }

    }
}
