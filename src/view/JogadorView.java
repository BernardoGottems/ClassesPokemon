package view;

import controller.JogadorController;
import model.JogadorModel;
import util.InputHelper;

public class JogadorView {
    JogadorModel jogador;
    JogadorController jogadorController;

    public JogadorView(JogadorModel jogador, JogadorController jogadorController) {
        this.jogador = jogador;
        this.jogadorController = jogadorController;
    }

    public void status(){
        System.out.println("-=STATUS=-");
        System.out.println("Insignias do jogador.");
        for (String i: jogador.getInsignias()) {
            System.out.print(">>%s.\n");
        }
        System.out.println("-=DINHEIRO=-");
        System.out.print("R$:%g.\n" + jogador.getDinheiro());
    }
    public void removerPokemon(){
        System.out.print("Qual pokemon quer remover:");
        String nome = InputHelper.lerTexto();
        if(jogadorController.removePokemon(nome)){
            System.out.println("Pokémon removido com sucesso!");
        }else{
            System.out.println("Pokémon não encontrado, tente novamente!");
        }
    }

}
