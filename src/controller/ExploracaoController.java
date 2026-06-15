package controller;

import factory.GeradorDePokemons;
import model.*;
import util.InputHelper;
import util.SaveManager;
import view.LojaView;

public class ExploracaoController {

    private final MapaController mapaController = new MapaController();
    private final BatalhaController batalhaController;
    private final TreinadorController treinadorController;
    private final JogadorModel jogador = new JogadorModel(4, 4, 1000);
    private final JogadorController jogadorController = new JogadorController(jogador);
    private final PocaoController pocaoController = new PocaoController();

    private final LojaModel lojaModel = new LojaModel();
    private final LojaController lojaController = new LojaController(jogador, lojaModel);
    private final LojaView lojaView = new LojaView(jogador, lojaModel, lojaController);

    private final PokedexModel pokedexModel = new PokedexModel();         // NOVO
    private final PokedexController pokedexController = new PokedexController(); // NOVO

    private boolean ginasioVencido = false;

    public ExploracaoController() {
        this.batalhaController = new BatalhaController();
        this.treinadorController = new TreinadorController();
    }

    public ExploracaoController(InputHelper input) {
        this.batalhaController = new BatalhaController(input);
        this.treinadorController = new TreinadorController(input);
    }

    public void iniciarExploracao() {
        mapaController.inicializar();
        SaveManager.carregar(jogador);
        System.out.println("Bem-vindo ao mundo Pokémon!");
        if(jogadorController.getPokemonAtivo() == null){
            escolherStarter();
        }

        boolean rodando = true;
        while (rodando) {
            int jogX = jogador.getX();
            int jogY = jogador.getY();
            mapaController.desenhar(jogX, jogY);

            System.out.print("Mova com W/A/S/D | P - Pokédex | X - Sair: "); // NOVO texto
            String comando = InputHelper.lerTexto().toUpperCase();

            if (comando.equals("X")) {
                System.out.println("Saindo...");
                SaveManager.salvar(jogador);
                rodando = false;
                continue;
            }

            if (comando.equals("P")) {                                          // NOVO
                pokedexController.exibirPokedex(pokedexModel.getMonstrosVistos());
                continue;
            }

            int destinoX = jogX, destinoY = jogY;
            if      (comando.equals("W")) destinoY--;
            else if (comando.equals("S")) destinoY++;
            else if (comando.equals("A")) destinoX--;
            else if (comando.equals("D")) destinoX++;
            else { System.out.println("Comando inválido!"); continue; }

            if (mapaController.temConstrucao(destinoX, destinoY)) {
                interagirComConstrucao(mapaController.getTipoConstrucao(destinoX, destinoY));
                continue;
            }

            if (!mapaController.moverJogador(jogX, jogY, comando)) {
                System.out.println("Você bateu na borda do mapa!");
                continue;
            }

            jogador.setX(destinoX);
            jogador.setY(destinoY);
            verificarGramaAlta();
        }
    }

    private void interagirComConstrucao(char tipo) {
        switch (tipo) {
            case 'H': entrarNoHospital();       break;
            case 'G': perguntarEntrarGinasio(); break;
            case 'L': lojaView.menuLoja(jogador.getMochila()); break;
        }
    }

    private void entrarNoHospital() {
        System.out.println("\n🏥 ===== HOSPITAL POKÉMON ===== 🏥");
        System.out.println("Enfermeira Joy: Olá! Deixa eu curar seus Pokémon!");
        PokemonBase meuPokemon = jogadorController.getPokemonAtivo();
        meuPokemon.curar();
        System.out.println("✅ " + meuPokemon.getNome() + " foi totalmente curado!");
        System.out.println("Enfermeira Joy: Seus Pokémon estão prontos para batalhar!");
        System.out.println("==============================\n");
    }

    private void perguntarEntrarGinasio() {
        System.out.println("\n🏟️ ===== GINÁSIO POKÉMON ===== 🏟️");
        if (ginasioVencido) {
            System.out.println("Você já conquistou este ginásio! 🥇");
            System.out.println("==============================\n");
            return;
        }
        System.out.print("Deseja entrar? (S/N): ");
        if (InputHelper.lerTexto().toUpperCase().equals("S")) entrarNoGinasio();
        else System.out.println("Você decidiu não entrar por agora.");
        System.out.println("==============================\n");
    }

    private void entrarNoGinasio() {
        PokemonBase meuPokemon = jogadorController.getPokemonAtivo();
        if (meuPokemon == null) {
            System.out.println("Você não tem Pokémon para batalhar!");
            return;
        }

        Treinador lider = new Treinador(
                "Giovanni",
                "Você não tem chance contra mim!",
                "Impossível... Fui derrotado por um iniciante!"
        );
        PokemonBase pokemonLider = GeradorDePokemons.gerarPokemon(TipoPokemon.TERRA, 10);
        lider.adicionarPokemon(pokemonLider);
        pokedexModel.registrarEncontro(pokemonLider.getNome());              // NOVO

        boolean venceu = treinadorController.iniciarDesafio(
                lider, meuPokemon, jogador.getPocoes(), pocaoController);

        meuPokemon.curar();

        if (venceu) {
            jogador.adicionarInsignia("Insígnia Terra");
            ginasioVencido = true;
            System.out.println("🥇 Parabéns! Você derrotou " + lider.getNome() + " e ganhou a Insígnia Terra!");
            System.out.println("🎉 Você completou o desafio do ginásio! Continue explorando ou pressione X para sair.");
        } else {
            System.out.println("😔 Você foi derrotado... Treine mais e volte!");
        }
    }

    private void verificarGramaAlta() {
        int x = jogador.getX(), y = jogador.getY();
        if (mapaController.temGramaAlta(x, y) && Math.random() < 0.3) {
            System.out.println("\n⚠️ UM POKÉMON SELVAGEM APARECEU! ⚠️");
            PokemonBase selvagem = GeradorDePokemons.gerarPokemon(
                    TipoPokemon.values()[(int)(Math.random() * TipoPokemon.values().length)],
                    (int)(Math.random() * 5) + 3
            );
            System.out.println("É um " + selvagem.getNome() + "! (Nível " + selvagem.getNivel() + ")");
            pokedexModel.registrarEncontro(selvagem.getNome());              // NOVO

            PokemonBase meuPokemon = jogadorController.getPokemonAtivo();
            if (meuPokemon == null) { System.out.println("O inimigo foi embora..."); return; }

            boolean venceu = batalhaController.iniciarBatalha(
                    meuPokemon, selvagem, true, jogador.getPocoes(), pocaoController);

            meuPokemon.curar();
            System.out.println(venceu ? "\n🏆 Você venceu!" : "\n💀 Seu Pokémon desmaiou... mas se recuperou.");
        }
    }

    private void escolherStarter() {
        boolean escolhendo = true;
        while (escolhendo) {
            System.out.println("Escolha o seu Pokemon:");
            System.out.println("1 - Charmander (Fogo)");
            System.out.println("2 - Squirtle (Água)");
            System.out.println("3 - Bulbasaur (Planta)");
            System.out.print("Sua escolha: ");
            String opt = InputHelper.lerTexto();
            switch (opt) {
                case "1": jogadorController.adicionarPokemon("Charmander", 5, TipoPokemon.FOGO,   39, 52); escolhendo = false; break;
                case "2": jogadorController.adicionarPokemon("Squirtle",   5, TipoPokemon.AGUA,   44, 48); escolhendo = false; break;
                case "3": jogadorController.adicionarPokemon("Bulbasaur",  5, TipoPokemon.PLANTA, 45, 49); escolhendo = false; break;
                default: System.out.println("Opção inválida!");
            }
        }
        pokedexModel.registrarEncontro(jogadorController.getPokemonAtivo().getNome());
    }
}