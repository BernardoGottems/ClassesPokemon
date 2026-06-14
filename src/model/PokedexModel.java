package model;

import java.util.ArrayList;

public class PokedexModel {
    private ArrayList<String> monstrosVistos;

    public PokedexModel() {
        this.monstrosVistos = new ArrayList<>();
    }

    public void registrarEncontro(String nomeDoPokemon) {
        if (!this.monstrosVistos.contains(nomeDoPokemon)) {
            this.monstrosVistos.add(nomeDoPokemon);
        }
    }

    public ArrayList<String> getMonstrosVistos() {
        return monstrosVistos;
    }
}