package controller;
import model.*;

import view.JogadorView;
import view.MapaView;
import util.InputHelper;

public class ExploracaoController {
    private Mapa mapa = new Mapa();

    private final JogadorModel jogador = new JogadorModel(0, 0);
    private final JogadorController jogadorController = new JogadorController(jogador);
    private final JogadorView jogadorView = new JogadorView(jogador,jogadorController);

    private MapaView mapaView = new MapaView();
    private InputHelper inputHelper = new InputHelper();
    private int opt;

    // Método principal que a sua Main vai chamar
    public void iniciarExploracao() {

        System.out.println("Bem-vindo ao mundo Pokémon!");
        escolherStarter();

        boolean rodando = true;


        while (rodando) {
            // 1. O SEU CÓDIGO AQUI: Pega os dados e manda a view desenhar
            char[][] matrizPronta = mapa.getMatriz();
            int jogX = jogador.getX();
            int jogY = jogador.getY();
            mapaView.atualizarMapa(matrizPronta, jogX, jogY);

            // 2. LER O MOVIMENTO
            System.out.print("Mova com W/A/S/D (ou X para sair): ");
            String comando = inputHelper.lerTexto().toUpperCase();

            // 3. ATUALIZAR A POSIÇÃO (Com trava de segurança das bordas)
            if (comando.equals("W") && jogY > 0) {
                jogador.setY(jogY - 1);
            }
            else if (comando.equals("S") && jogY < matrizPronta.length - 1) {
                jogador.setY(jogY + 1);
            }
            else if (comando.equals("A") && jogX > 0) {
                jogador.setX(jogX - 1);
            }
            else if (comando.equals("D") && jogX < matrizPronta[0].length - 1) {
                jogador.setX(jogX + 1);
            }
            else if (comando.equals("X")) {
                System.out.println("Saindo da exploração...");
                rodando = false;
                continue; // Pula para fora do loop
            }
            else {
                System.out.println("Comando inválido ou você bateu na borda do mapa!");
            }

            // 4. VERIFICAR SE PISOU NA GRAMA ALTA
            verificarGramaAlta();
        }
    }

    private void escolherStarter(){
        boolean escolhendo = true;

        while (escolhendo) {
            System.out.println("Escolha o seu Pokemon:");
            System.out.println("1 - Charmander (Fogo)");
            System.out.println("2 - Squirtle (Água)");
            System.out.println("3 - Bulbassaur (Planta)");
            System.out.print("Sua escolha: ");

            // Usando seu InputHelper (Supondo que você criou um lerInteiro nele)
            String optStr = inputHelper.lerTexto();


            if (optStr.equals("1")) {
                System.out.println("Você escolheu Charmander!");
                // Aqui está a mágica: em vez de return, você GUARDA no jogador!
                jogadorController.adicionarPokemon("Charmander", 5, TipoPokemon.FOGO , 8, 5);
                escolhendo = false; // Quebra o loop
            }
            else if (optStr.equals("2")) {
                System.out.println("Você escolheu Squirtle!");
                jogadorController.adicionarPokemon("Squirtle", 5, TipoPokemon.AGUA, 5, 6);
                escolhendo = false;
            }
            else if (optStr.equals("3")) {
                System.out.println("Você escolheu Bulbassaur!");
                jogadorController.adicionarPokemon("Bulbassaur", 5, TipoPokemon.PLANTA,  10, 5);
                escolhendo = false;
            }
            else {
                System.out.println("Opção inválida! Digite 1, 2 ou 3.");
            }
        }
    }

    // Método privado auxiliar (só o Controller usa)
    private void verificarGramaAlta() {
        char[][] grid = mapa.getMatriz();
        int x = jogador.getX();
        int y = jogador.getY();

        // Se o caractere na posição nova do jogador for '#'
        if (grid[y][x] == '#') {
            // Roda um dado de 0.0 a 1.0. Se der menos de 0.3 (30% de chance)
            if (Math.random() < 0.3) {
                System.out.println("\n⚠️ AVISO: UM POKÉMON SELVAGEM APARECEU NA GRAMA ALTA! ⚠️");
                // Futuramente, chamaremos o BatalhaController aqui
            }
        }
    }

    private PokemonBase gerarPokemonSelvagem() {
        // Sorteia um número de 0 a 2
        int sorteio = (int) (Math.random() * 3);
        int nivelAleatorio = (int) (Math.random() * 5) + 3;

        // Instancia uma das nossas subclasses dependendo do sorteio
        switch (sorteio) {
            case 0: // TIPO FOGO
                String[] nomesFogo = {"Growlithe", "Vulpix", "Ponyta"};
                int[] hpFogo       = {55,          38,       50};
                int[] atqFogo      = {70,          41,       85};

                int indFogo = (int) (Math.random() * nomesFogo.length);

                // 👇 A MÁGICA ACONTECE AQUI 👇
                // Em vez de "new PokemonFogo", chamamos a Base e passamos TipoPokemon.FOGO
                return new PokemonBase(
                        nomesFogo[indFogo] + " Selvagem",
                        nivelAleatorio,
                        TipoPokemon.FOGO, // <- O tipo entra aqui!
                        hpFogo[indFogo],
                        atqFogo[indFogo]
                );

            case 1: // TIPO ÁGUA
                String[] nomesAgua = {"Psyduck", "Poliwag", "Marill"};
                int[] hpAgua       = {50,         40,        70};
                int[] atqAgua      = {52,         50,        20};

                int indAgua = (int) (Math.random() * nomesAgua.length);

                return new PokemonBase(
                        nomesAgua[indAgua] + " Selvagem",
                        nivelAleatorio,
                        TipoPokemon.AGUA, // <- O tipo entra aqui!
                        hpAgua[indAgua],
                        atqAgua[indAgua]
                );

            default:
                return new PokemonBase("ji", 6, TipoPokemon.PLANTA, 30, 10);
        }
    }
}