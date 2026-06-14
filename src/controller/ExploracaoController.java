package controller;

import model.*;
import util.InputHelper;

public class ExploracaoController {

    private final MapaController mapaController = new MapaController();
    private final BatalhaController batalhaController = new BatalhaController();
    private final JogadorModel jogador = new JogadorModel(4, 4, 1.000);
    private final JogadorController jogadorController = new JogadorController(jogador);


    public void iniciarExploracao() {
        mapaController.inicializar();

        System.out.println("Bem-vindo ao mundo Pokémon!");
        escolherStarter();

        boolean rodando = true;

        while (rodando) {
            int jogX = jogador.getX();
            int jogY = jogador.getY();

            mapaController.desenhar(jogX, jogY);

            System.out.print("Mova com W/A/S/D (ou X para sair): ");
            String comando = InputHelper.lerTexto().toUpperCase();

            if (comando.equals("X")) {
                System.out.println("Saindo da exploração...");
                rodando = false;
                continue;
            }

            boolean movimentoValido = mapaController.moverJogador(jogX, jogY, comando);

            if (!movimentoValido) {
                System.out.println("Comando inválido ou você bateu na borda do mapa!");
                continue;
            }

            if      (comando.equals("W")) jogador.setY(jogY - 1);
            else if (comando.equals("S")) jogador.setY(jogY + 1);
            else if (comando.equals("A")) jogador.setX(jogX - 1);
            else if (comando.equals("D")) jogador.setX(jogX + 1);

            verificarGramaAlta();
        }
    }

    private void verificarGramaAlta() {
        int x = jogador.getX();
        int y = jogador.getY();

        if (mapaController.temGramaAlta(x, y) && Math.random() < 0.3) {
            System.out.println("\n⚠️ AVISO: UM POKÉMON SELVAGEM APARECEU NA GRAMA ALTA! ⚠️");
            PokemonBase selvagem = gerarPokemonSelvagem();
            System.out.println("É um " + selvagem.getNome() + "! (Nível " + selvagem.getNivel() + ")");
            executarBatalha(selvagem);
        }
    }

    private void executarBatalha(PokemonBase inimigo) {
        PokemonBase meuPokemon = jogadorController.getPokemonAtivo();

        if (meuPokemon == null) {
            System.out.println("Você não tem pokémons! O inimigo foi embora...");
            return;
        }

        System.out.println("\n⚔️ BATALHA INICIADA: " + meuPokemon.getNome() + " vs " + inimigo.getNome());

        while (meuPokemon.getVidaAtual() > 0 && inimigo.getVidaAtual() > 0) {
            System.out.println("\n--- O que você quer fazer? ---");
            System.out.println("1 - Atacar");
            System.out.println("2 - Fugir");
            System.out.print("Sua escolha: ");

            String opt = InputHelper.lerTexto();

            if (opt.equals("2")) {
                System.out.println("Você fugiu da batalha!");
                meuPokemon.curar(); // restaura mesmo ao fugir
                return;
            }

            if (!opt.equals("1")) {
                System.out.println("Opção inválida!");
                continue;
            }

            batalhaController.executarTurno(meuPokemon, inimigo, 1);
        }

        // Restaura HP para a próxima batalha independente do resultado
        meuPokemon.curar();
    }

    private void escolherStarter() {
        boolean escolhendo = true;

        while (escolhendo) {
            System.out.println("Escolha o seu Pokemon:");
            System.out.println("1 - Charmander (Fogo)");
            System.out.println("2 - Squirtle (Água)");
            System.out.println("3 - Bulbassaur (Planta)");
            System.out.print("Sua escolha: ");

            String optStr = InputHelper.lerTexto();

            if (optStr.equals("1")) {
                System.out.println("Você escolheu Charmander!");
                jogadorController.adicionarPokemon("Charmander", 5, TipoPokemon.FOGO, 8, 5);
                escolhendo = false;
            } else if (optStr.equals("2")) {
                System.out.println("Você escolheu Squirtle!");
                jogadorController.adicionarPokemon("Squirtle", 5, TipoPokemon.AGUA, 5, 6);
                escolhendo = false;
            } else if (optStr.equals("3")) {
                System.out.println("Você escolheu Bulbassaur!");
                jogadorController.adicionarPokemon("Bulbassaur", 5, TipoPokemon.PLANTA, 10, 5);
                escolhendo = false;
            } else {
                System.out.println("Opção inválida! Digite 1, 2 ou 3.");
            }
        }
    }

    private PokemonBase gerarPokemonSelvagem() {
        int sorteio = (int) (Math.random() * 3);
        int nivel = (int) (Math.random() * 5) + 3;

        switch (sorteio) {
            case 0:
                String[] nomesFogo = {"Growlithe", "Vulpix", "Ponyta"};
                int[] hpFogo  = {55, 38, 50};
                int[] atqFogo = {70, 41, 85};
                int i = (int) (Math.random() * nomesFogo.length);
                return new PokemonBase(nomesFogo[i] + " Selvagem", nivel, TipoPokemon.FOGO, hpFogo[i], atqFogo[i]);

            case 1:
                String[] nomesAgua = {"Psyduck", "Poliwag", "Marill"};
                int[] hpAgua  = {50, 40, 70};
                int[] atqAgua = {52, 50, 20};
                int j = (int) (Math.random() * nomesAgua.length);
                return new PokemonBase(nomesAgua[j] + " Selvagem", nivel, TipoPokemon.AGUA, hpAgua[j], atqAgua[j]);

            default:
                String[] nomesPlanta = {"Oddish", "Bellsprout"};
                int[] hpPlanta  = {45, 50};
                int[] atqPlanta = {50, 75};
                int k = (int) (Math.random() * nomesPlanta.length);
                return new PokemonBase(nomesPlanta[k] + " Selvagem", nivel, TipoPokemon.PLANTA, hpPlanta[k], atqPlanta[k]);
        }
    }
}