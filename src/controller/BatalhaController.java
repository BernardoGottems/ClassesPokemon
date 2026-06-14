package controller;

import model.PokemonBase;
import model.TipoPokemon;

public class BatalhaController {

    // 1. O GERENTE: Controla o fluxo de quem bate e quem apanha
    public void executarTurno(PokemonBase meuPokemon, PokemonBase inimigo, int acaoEscolhida) {

        // --- TURNO DO JOGADOR ---
        if (acaoEscolhida == 1) { // Ação 1 é "Atacar"
            System.out.println("\n--- SEU TURNO ---");
            // O Gerente chama a Calculadora
            calcularDano(meuPokemon, inimigo);
        }
        else {
            System.out.println("Você fez outra ação (Bolsa, Fugir...)");
            // (Outras lógicas entrariam aqui depois)
        }

        // Verifica se o inimigo desmaiou com o seu ataque
        if (inimigo.getVidaAtual() <= 0) {
            System.out.println("\n🏆 " + inimigo.getNome() + " desmaiou! Você venceu!");
            return; // O return vazio encerra o método na hora. O inimigo não revida!
        }

        // --- TURNO DO INIMIGO ---
        // Se o inimigo sobreviveu, ele ataca de volta automaticamente
        System.out.println("\n--- TURNO DO INIMIGO ---");
        // O Gerente chama a Calculadora de novo, mas invertendo quem bate e quem apanha!
        calcularDano(inimigo, meuPokemon);

        // Verifica se o seu Pokémon desmaiou
        if (meuPokemon.getVidaAtual() <= 0) {
            System.out.println("\n💀 " + meuPokemon.getNome() + " desmaiou! Você perdeu a batalha...");
        }
    }

    // 2. A CALCULADORA: O seu código fundido perfeito (fica como private, pois só o Gerente usa)
    private void calcularDano(PokemonBase atacante, PokemonBase defensor) {
        System.out.println("⚔️ " + atacante.getNome() + " atacou " + defensor.getNome() + "!");

        int danoReal = (atacante.getAtaque() / 2) + 5;
        TipoPokemon tipoAtk = atacante.getTipo();
        TipoPokemon tipoDef = defensor.getTipo();

        if (tipoAtk.temVantagemContra(tipoDef) || tipoDef.temFraquezaContra(tipoAtk)) {
            System.out.println("🔥 É SUPER EFETIVO! Dano em dobro!");
            danoReal = danoReal * 2;
        }
        else if (tipoDef.temVantagemContra(tipoAtk) || tipoAtk.temFraquezaContra(tipoDef)) {
            System.out.println("🛡️ Não é muito efetivo... Dano cortado pela metade.");
            danoReal = danoReal / 2;
        }

        defensor.receberDano(danoReal);
        System.out.println(defensor.getNome() + " perdeu " + danoReal + " de HP!");
        System.out.println("HP restante de " + defensor.getNome() + ": " + defensor.getVidaAtual() + " / " + defensor.getVidaMaxima());

    }
}