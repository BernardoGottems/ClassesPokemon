package view;

import model.Pocao;

public class PocaoView {

    public void exibirUsoDePocao(String nomePokemon, Pocao pocao){
        System.out.println("\\n✨ [EFEITO DE ITEM] ✨");
        System.out.println("Você utilizou uma \" + pocao.getNome() + \"!");
        System.out.println("Restaurando até \" + pocao.getPontosDeCura() + \" de HP de \" + nomePokemon + \".");
        System.out.println("Os pontos de vida aumentaram!");

    }
    public void exibirErroSemPocoes(){
        System.out.println("ERRO: Voce não possui mais unidades desta pocao!");
    }
}
