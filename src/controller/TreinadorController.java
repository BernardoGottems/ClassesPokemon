package controller;

import model.PokemonBase;
import model.Treinador;
import model.Pocao;
import view.TreinadorView;
import util.InputHelper;
import java.util.List;

public class TreinadorController {

    private TreinadorView view = new TreinadorView();
    private BatalhaController batalhaController;

    public TreinadorController() {
        this(new InputHelper());
    }

    public TreinadorController(InputHelper input) {
        this.batalhaController = new BatalhaController(input);
    }

    public boolean iniciarDesafio(Treinador treinador, PokemonBase pokemonJogador) {
        return iniciarDesafio(treinador, pokemonJogador, null, null);
    }

    public boolean iniciarDesafio(Treinador treinador, PokemonBase pokemonJogador,
                                  List<Pocao> mochila, PocaoController pocaoController) {
        view.exibirDesafio(treinador);

        for (PokemonBase inimigo : treinador.getEquipe()) {
            view.exibirEnviarPokemon(treinador.getNome(), inimigo.getNome());

            boolean venceuEsta = batalhaController.iniciarBatalha(
                    pokemonJogador, inimigo, false, mochila, pocaoController);

            if (!venceuEsta) {
                view.exibirJogadorDerrotado(treinador.getNome());
                return false;
            }
        }

        view.exibirDerrota(treinador);
        return true;
    }
}
