package controller;

import model.JogadorModel;
import model.PokemonBase;
import model.TipoPokemon;

import java.awt.*;

public class JogadorController {
    JogadorModel jogador;

    public JogadorController(JogadorModel jogador) {
        this.jogador = jogador;
    }

    public void adicionarPokemon(String nome, int nivel, TipoPokemon tipo, int hpBase, int ataqueBase) {
        jogador.adicionarPokemon(nome, nivel, tipo, hpBase, ataqueBase);
    }

    public boolean removePokemon(String nome) {
        return jogador.removerPokemon(nome);
    }

    public PokemonBase getPokemonAtivo() {
        if (jogador.getEquipeJogador().isEmpty()) return null;
        return jogador.getEquipeJogador().get(0);
    }


}