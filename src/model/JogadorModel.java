package model;

import java.util.ArrayList;
import java.util.List;

public class JogadorModel {
    private int x;
    private int y;

    private String[] insignias = new String[8];
    private double dinheiro;

    private ArrayList<PokemonBase> equipeJogador = new ArrayList<>();
    private ArrayList<ItemBase> mochila = new ArrayList<>();

    public JogadorModel(int XInicial, int YInicial, double dinheiro) {
        this.x = XInicial;
        this.y = YInicial;
        this.dinheiro = dinheiro;

        // Itens iniciais (opcional, para teste)
        mochila.add(new Pocao("Poção", 2, 100, 20));
    }

    // region getterSetters
    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    public double getDinheiro() { return dinheiro; }
    public void setDinheiro(double dinheiro) { this.dinheiro = dinheiro; }

    public String[] getInsignias() { return insignias; }

    public ArrayList<PokemonBase> getEquipeJogador() { return equipeJogador; }
    public ArrayList<ItemBase> getMochila() { return mochila; }
    // endregion

    // Métodos originais
    public void adicionarPokemon(String nome, int nivel, TipoPokemon tipo, int hpBase, int ataqueBase){
        equipeJogador.add(new PokemonBase(nome, nivel, tipo, hpBase, ataqueBase));
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


    public void adicionarItem(ItemBase item) {
        for (ItemBase i : mochila) {
            if (i.getNome().equals(item.getNome())) {
                i.setQuantidade(i.getQuantidade() + item.getQuantidade());
                return;
            }
        }
        mochila.add(item);
    }



    public boolean gastarDinheiro(double valor) {
        if (dinheiro < valor) return false;
        dinheiro -= valor;
        return true;
    }

    public boolean adicionarInsignia(String nomeInsignia) {
        for (int i = 0; i < insignias.length; i++) {
            if (insignias[i] == null) {
                insignias[i] = nomeInsignia;
                return true;
            }
        }
        return false;
    }

    public List<Pocao> getPocoes() {
        List<Pocao> pocoes = new ArrayList<>();
        for (ItemBase item : mochila) {
            if (item instanceof Pocao) pocoes.add((Pocao) item);
        }
        return pocoes;
    }
}