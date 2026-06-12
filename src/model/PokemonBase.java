package model;

// 1. Tiramos o "abstract" daqui! Agora ela é uma classe normal.
public class PokemonBase {
    private String nome;
    private int nivel;
    private TipoPokemon tipo;
    private int vidaMaxima;
    private int vidaAtual;
    private int ataque;

    // 2. O construtor volta a pedir o TipoPokemon para saber quem é quem
    public PokemonBase(String nome, int nivel, TipoPokemon tipo, int hpBase, int ataqueBase) {
        this.nome = nome;
        this.nivel = nivel;
        this.tipo = tipo;

        // Matemática de status baseada no nível
        this.vidaMaxima = hpBase + (nivel * 10);
        this.vidaAtual = this.vidaMaxima;
        this.ataque = ataqueBase + (nivel * 2);
    }

    // Getters para a Batalha e Views usarem
    public String getNome() { return nome; }
    public int getNivel() { return nivel; }
    public TipoPokemon getTipo() { return tipo; }
    public int getVidaAtual() { return vidaAtual; }
    public int getVidaMaxima() { return vidaMaxima; }
    public int getAtaque() { return ataque; }

    public void receberDano(int dano) {
        this.vidaAtual -= dano;
        if (this.vidaAtual < 0) {
            this.vidaAtual = 0;
        }
    }

    // 3. Como não temos mais as classes filhas, o ataque precisa ser genérico
    public void atacar() {
        System.out.println("💥 " + this.nome + " usou um golpe do tipo " + this.tipo + "!");
    }
}