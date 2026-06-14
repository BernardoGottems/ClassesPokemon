package view;

import model.Batalha;
import model.PokemonBase;
import model.Pocao;
import java.util.List;

public class BatalhaView {

    public void exibirInicioBatalha(PokemonBase jogador, PokemonBase inimigo) {
        System.out.println("\n=====================================");
        System.out.println("  A BATALHA COMEÇOU!  ");
        System.out.println(inimigo.getNome() + " (Nv." + inimigo.getNivel() + ") desafiou você!");
        System.out.println("Vai, " + jogador.getNome() + "!");
        System.out.println("=====================================");
    }

    public void exibirStatusTurno(Batalha batalha) {
        PokemonBase jogador = batalha.getPokemonJogador();
        PokemonBase inimigo = batalha.getPokemonInimigo();

        System.out.println("\n---------- TURNO " + batalha.getTurno() + " ----------");
        imprimirLinhaHp("INIMIGO", inimigo);
        imprimirLinhaHp("VOCÊ   ", jogador);
        System.out.println("--------------------------------");
    }

    public void exibirMenuAcoes() {
        System.out.println("O que você quer fazer?");
        System.out.println("  1 -  Atacar");
        System.out.println("  2 -  Bolsa");
        System.out.println("  3 -  Fugir");
    }

    public void exibirTurnoJogador() {
        System.out.println("\n--- SEU TURNO ---");
    }

    public void exibirTurnoInimigo() {
        System.out.println("\n--- TURNO DO INIMIGO ---");
    }

    public void exibirAtaque(PokemonBase atacante, PokemonBase defensor) {
        System.out.println(" " + atacante.getNome() + " atacou " + defensor.getNome() + "!");
    }

    public void exibirSuperEfetivo() {
        System.out.println(" É SUPER EFETIVO! Dano em dobro!");
    }

    public void exibirPoucoEfetivo() {
        System.out.println(" Não é muito efetivo... Dano cortado pela metade.");
    }

    public void exibirDanoCausado(PokemonBase defensor, int dano) {
        System.out.println(defensor.getNome() + " perdeu " + dano + " de HP!");
        System.out.println("HP restante de " + defensor.getNome() + ": "
                + defensor.getVidaAtual() + " / " + defensor.getVidaMaxima());
    }

    public void exibirVitoria(String nomeInimigo) {
        System.out.println("\n " + nomeInimigo + " desmaiou! Você venceu a batalha!");
    }

    public void exibirDerrota(String nomePokemon) {
        System.out.println("\n " + nomePokemon + " desmaiou! Você perdeu a batalha...");
    }

    public void exibirAcaoBolsa() {
        System.out.println(" Você abriu a bolsa...");
    }

    public void exibirBolsa(List<Pocao> mochila) {
        System.out.println("\n ---- SUA BOLSA ----");
        for (int i = 0; i < mochila.size(); i++) {
            Pocao p = mochila.get(i);
            System.out.printf("  %d - %s (cura %d HP)  x%d%n",
                    i + 1, p.getNome(), p.getPontosDeCura(), p.getQuantidade());
        }
        System.out.println("  0 - Voltar");
    }

    public void exibirMochilaVazia() {
        System.out.println(" Sua bolsa está vazia! Nenhum item para usar.");
    }

    public void exibirVoltouBolsa() {
        System.out.println("Você fechou a bolsa sem usar nada.");
    }

    public void exibirItemSemEstoque(Pocao pocao) {
        System.out.println("Você não tem mais " + pocao.getNome() + "!");
    }

    public void exibirFugaComSucesso() {
        System.out.println(" Você fugiu da batalha com sucesso!");
    }

    public void exibirFugaFalhou() {
        System.out.println(" Não deu para fugir! O inimigo bloqueou a sua saída!");
    }

    public void exibirFugaBloqueada() {
        System.out.println(" Você não pode fugir de uma batalha contra um Treinador!");
    }

    public void exibirOpcaoInvalida() {
        System.out.println("Opção inválida! Escolha 1, 2 ou 3.");
    }

    private void imprimirLinhaHp(String rotulo, PokemonBase p) {
        int totalBarras = 20;
        int cheias = 0;
        if (p.getVidaMaxima() > 0) {
            cheias = (int) ((double) p.getVidaAtual() / p.getVidaMaxima() * totalBarras);
        }

        StringBuilder barra = new StringBuilder();
        for (int i = 0; i < totalBarras; i++) {
            barra.append(i < cheias ? "#" : "-");
        }

        System.out.printf("%s %-15s HP: [%s] %d/%d%n",
                rotulo, p.getNome(), barra, p.getVidaAtual(), p.getVidaMaxima());
    }
}
