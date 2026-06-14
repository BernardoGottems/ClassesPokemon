package model;

public class PokemonBase {
    private String nome;
    private int nivel;
    private TipoPokemon tipo;
    private int vidaMaxima;
    private int vidaAtual;
    private int ataque;

    public PokemonBase(String nome, int nivel, TipoPokemon tipo, int hpBase, int ataqueBase) {
        this.nome = nome;
        this.nivel = nivel;
        this.tipo = tipo;
        this.vidaMaxima = hpBase + (nivel * 10);
        this.vidaAtual = this.vidaMaxima;
        this.ataque = ataqueBase + (nivel * 2);
    }

    public String getNome()        { return nome; }
    public int getNivel()          { return nivel; }
    public TipoPokemon getTipo()   { return tipo; }
    public int getVidaAtual()      { return vidaAtual; }
    public int getVidaMaxima()     { return vidaMaxima; }
    public int getAtaque()         { return ataque; }

    public void receberDano(int dano) {
        this.vidaAtual -= dano;
        if (this.vidaAtual < 0) this.vidaAtual = 0;
    }

    public void receberCura(int quantidadeCura) {
        this.vidaAtual += quantidadeCura;
        if (this.vidaAtual > this.vidaMaxima) this.vidaAtual = this.vidaMaxima;
    }

    public void curar() {
        this.vidaAtual = this.vidaMaxima;
    }
}