package model;

import java.util.ArrayList;

public class JogadorModel {
    private int x;
    private int y;


    private String[] insignias = new String[8];
    private double dinheiro;

    private ArrayList<PokemonBase> equipeJogador = new ArrayList<>();

    public JogadorModel(int XInicial, int YInicial, double dinheiro) {
        this.x = XInicial;
        this.y = YInicial;
        this.dinheiro = dinheiro;
    }

    //region getterSetters
    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public double getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }

    public String[] getInsignias() {
        return insignias;
    }

    public void setInsignias(String[] insignias) {
        this.insignias = insignias;
    }

    public ArrayList<PokemonBase> getEquipeJogador() {
        return equipeJogador;
    }

    //endregion getterSetter

    public void adicionarPokemon(String nome, int nivel, TipoPokemon tipo, int hpBase, int ataqueBase){
        equipeJogador.add(new PokemonBase(nome,nivel,tipo,hpBase,ataqueBase));
    }
    public boolean removerPokemon(String nome){
        for(PokemonBase p : equipeJogador){
            if(p.getNome().equals(nome)){
                equipeJogador.remove(p);
                return true;
            }
        }
        return false;
    }


}



