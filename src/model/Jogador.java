package model;

import java.util.ArrayList;

public class Jogador {
    private int x;
    private int y;

    private ArrayList<PokemonBase> equipe = new ArrayList<>();

    public Jogador(int XInicial, int YInicial) {
        this.x = XInicial;
        this.y = YInicial;
    }

    public void adicionarPokemon(PokemonBase pokemon){
        this.equipe.add(pokemon);
    }

    public ArrayList<PokemonBase> getEquipe() {
        return this.equipe;
    }


    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
}

