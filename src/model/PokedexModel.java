package model;
import model.PokemonBase;

import java.util.ArrayList;

public class PokedexModel {
    ArrayList<String> monstrosVistos;


    public PokedexModel(ArrayList<String> monstrosVistos) {
        this.monstrosVistos = new ArrayList<>();
    }

    public void registrarEncontro(String nomeDoPokemon){
        if(!this.monstrosVistos.contains(nomeDoPokemon)){
            this.monstrosVistos.add(nomeDoPokemon);
        }
    }

    public ArrayList<String> getMonstrosVistos() {
        return monstrosVistos;
    }
}
