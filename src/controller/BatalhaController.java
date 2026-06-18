package controller;

import model.*;
import view.BatalhaView;
import util.InputHelper;
import java.util.List;

public class BatalhaController {

    private BatalhaView view = new BatalhaView();
    private InputHelper input;

    private List<Pocao> mochila;
    private PocaoController pocaoController;

    public BatalhaController() {
        this.input = new InputHelper();
    }

    public BatalhaController(InputHelper input) {
        this.input = input;
    }

    public boolean iniciarBatalha(PokemonBase pokemonJogador, PokemonBase inimigo, boolean permitirFuga) {
        Batalha batalha = new Batalha(pokemonJogador, inimigo);
        view.exibirInicioBatalha(pokemonJogador, inimigo);

        while (batalha.isEmAndamento()) {
            view.exibirStatusTurno(batalha);
            view.exibirMenuAcoes();
            int acao = input.lerInt("Sua ação: ");

            executarTurno(batalha, acao, permitirFuga);
        }

        return batalha.inimigoDerrotado();
    }

    public boolean iniciarBatalha(PokemonBase pokemonJogador, PokemonBase inimigo) {
        return iniciarBatalha(pokemonJogador, inimigo, true);
    }

    public boolean iniciarBatalha(PokemonBase pokemonJogador, PokemonBase inimigo,
                                  boolean permitirFuga, List<Pocao> mochila,
                                  PocaoController pocaoController) {
        this.mochila = mochila;
        this.pocaoController = pocaoController;
        return iniciarBatalha(pokemonJogador, inimigo, permitirFuga);
    }

    public boolean iniciarBatalha(PokemonBase pokemonJogador, PokemonBase inimigo,
                                  List<Pocao> mochila, PocaoController pocaoController) {
        return iniciarBatalha(pokemonJogador, inimigo, true, mochila, pocaoController);
    }

    public void executarTurno(PokemonBase meuPokemon, PokemonBase inimigo, int acaoEscolhida) {
        if (acaoEscolhida != 1) {
            view.exibirOpcaoInvalida();
            return;
        }

        view.exibirTurnoJogador();
        calcularDano(meuPokemon, inimigo, true);

        if (inimigo.getVidaAtual() <= 0) {
            view.exibirVitoria(inimigo.getNome());
            return;
        }

        view.exibirTurnoInimigo();
        calcularDano(inimigo, meuPokemon, false);

        if (meuPokemon.getVidaAtual() <= 0) {
            view.exibirDerrota(meuPokemon.getNome());
        }
    }

    private void executarTurno(Batalha batalha, int acaoEscolhida, boolean permitirFuga) {
        PokemonBase meuPokemon = batalha.getPokemonJogador();
        PokemonBase inimigo = batalha.getPokemonInimigo();


        if (acaoEscolhida == 1) {
            view.exibirTurnoJogador();
            calcularDano(meuPokemon, inimigo, true);
        }
        else if (acaoEscolhida == 2) {
            boolean usouItem = abrirBolsa(meuPokemon);
            if (!usouItem) {
                return;
            }
        }
        else if (acaoEscolhida == 3) {
            if (!permitirFuga) {
                view.exibirFugaBloqueada();
            } else if (Math.random() < 0.5) {
                view.exibirFugaComSucesso();
                batalha.encerrar();
                return;
            } else {
                view.exibirFugaFalhou();
            }
        }
        else {
            view.exibirOpcaoInvalida();
            return;
        }

        if (batalha.inimigoDerrotado()) {
            view.exibirVitoria(inimigo.getNome());
            meuPokemon.treinar();
            batalha.encerrar();
            return;
        }

        view.exibirTurnoInimigo();
        calcularDano(inimigo, meuPokemon, false);

        if (batalha.jogadorPerdeu()) {
            view.exibirDerrota(meuPokemon.getNome());
            batalha.encerrar();
            return;
        }

        batalha.avancarTurno();
    }

    private boolean abrirBolsa(PokemonBase alvo) {
        if (mochila == null || mochila.isEmpty()) {
            view.exibirMochilaVazia();
            return false;
        }

        view.exibirBolsa(mochila);
        int escolha = input.lerInt("Escolha o item (0 = voltar): ");

        if (escolha <= 0 || escolha > mochila.size()) {
            view.exibirVoltouBolsa();
            return false;
        }

        Pocao escolhida = mochila.get(escolha - 1);
        if (escolhida.getQuantidade() <= 0) {
            view.exibirItemSemEstoque(escolhida);
            return false;
        }

        obterPocaoController().AplicarPocao(escolhida, alvo);
        return true;
    }

    private PocaoController obterPocaoController() {
        if (pocaoController == null) {
            pocaoController = new PocaoController();
        }
        return pocaoController;
    }

    private static final double BONUS_DANO_JOGADOR  = 1.4;
    private static final int    DIVISOR_TETO_JOGADOR = 5;

    private void calcularDano(PokemonBase atacante, PokemonBase defensor, boolean atacanteEhJogador) {
        view.exibirAtaque(atacante, defensor);

        int danoReal = (atacante.getAtaque() / 2) + 5;
        TipoPokemon tipoAtk = atacante.getTipo();
        TipoPokemon tipoDef = defensor.getTipo();

        if (tipoAtk.temVantagemContra(tipoDef) || tipoDef.temFraquezaContra(tipoAtk)) {
            view.exibirSuperEfetivo();
            danoReal = danoReal * 2;
        }
        else if (tipoDef.temVantagemContra(tipoAtk) || tipoAtk.temFraquezaContra(tipoDef)) {
            view.exibirPoucoEfetivo();
            danoReal = danoReal / 2;
        }

        if (atacanteEhJogador) {
            danoReal = (int) (danoReal * BONUS_DANO_JOGADOR);
        } else {
            int teto = Math.max(1, defensor.getVidaMaxima() / DIVISOR_TETO_JOGADOR);
            if (danoReal > teto) danoReal = teto;
        }

        if (danoReal < 1) danoReal = 1;

        defensor.receberDano(danoReal);
        view.exibirDanoCausado(defensor, danoReal);
    }
}
