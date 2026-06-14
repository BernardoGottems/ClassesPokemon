package view;

import model.Treinador;

public class TreinadorView {

    public void exibirDesafio(Treinador treinador) {
        System.out.println("\n#####################################");
        System.out.println("👤 TREINADOR " + treinador.getNome().toUpperCase() + " quer batalhar!");
        System.out.println("\"" + treinador.getFalaDesafio() + "\"");
        System.out.println("#####################################");
    }

    public void exibirEnviarPokemon(String nomeTreinador, String nomePokemon) {
        System.out.println("\n👤 " + nomeTreinador + " enviou " + nomePokemon + "!");
    }

    public void exibirDerrota(Treinador treinador) {
        System.out.println("\n#####################################");
        System.out.println("👤 " + treinador.getNome() + " foi derrotado!");
        System.out.println("\"" + treinador.getFalaDerrota() + "\"");
        System.out.println("#####################################");
    }

    public void exibirJogadorDerrotado(String nomeTreinador) {
        System.out.println("\n💀 Você foi derrotado pelo Treinador " + nomeTreinador + "...");
    }
}
