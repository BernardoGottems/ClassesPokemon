package model;

public class Batalha {

    private int turno;
    private PokemonBase pokemonJogador;
    private PokemonBase pokemonInimigo;
    private boolean emAndamento;

    public Batalha(PokemonBase pokemonJogador, PokemonBase pokemonInimigo) {
        this.pokemonJogador = pokemonJogador;
        this.pokemonInimigo = pokemonInimigo;
        this.turno = 1;
        this.emAndamento = true;
    }

    public int getTurno() {
        return turno;
    }

    public void avancarTurno() {
        this.turno++;
    }

    public PokemonBase getPokemonJogador() {
        return pokemonJogador;
    }

    public PokemonBase getPokemonInimigo() {
        return pokemonInimigo;
    }

    public boolean isEmAndamento() {
        return emAndamento;
    }

    public void encerrar() {
        this.emAndamento = false;
    }

    public boolean jogadorPerdeu() {
        return pokemonJogador.getVidaAtual() <= 0;
    }

    public boolean inimigoDerrotado() {
        return pokemonInimigo.getVidaAtual() <= 0;
    }
}
