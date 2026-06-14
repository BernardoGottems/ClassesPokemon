package model;

import java.util.ArrayList;

public class Treinador {

    private String nome;
    private String falaDesafio;
    private String falaDerrota;
    private ArrayList<PokemonBase> equipe = new ArrayList<>();

    public Treinador(String nome, String falaDesafio, String falaDerrota) {
        this.nome = nome;
        this.falaDesafio = falaDesafio;
        this.falaDerrota = falaDerrota;
    }

    public void adicionarPokemon(PokemonBase pokemon) {
        this.equipe.add(pokemon);
    }

    public ArrayList<PokemonBase> getEquipe() {
        return this.equipe;
    }

    public boolean aindaTemPokemon() {
        for (PokemonBase pokemon : equipe) {
            if (pokemon.getVidaAtual() > 0) {
                return true;
            }
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public String getFalaDesafio() {
        return falaDesafio;
    }

    public String getFalaDerrota() {
        return falaDerrota;
    }
}
