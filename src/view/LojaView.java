package view;

import controller.LojaController;
import model.ItemBase;
import model.JogadorModel;
import model.LojaModel;
import model.Pocao;
import util.InputHelper;

import java.util.ArrayList;

public class LojaView {
    LojaModel loja;
    LojaController lojaController;
    JogadorModel jogador;

    public LojaView(JogadorModel jogador, LojaModel loja, LojaController lojaController) {
        this.jogador = jogador;
        this.loja = loja;
        this.lojaController = lojaController;
    }

    public void menuLoja(ArrayList<ItemBase> mochila) {
        boolean naLoja = true;
        while (naLoja) {
            System.out.println("\n-=Lojinha=-");
            System.out.printf("💰 Dinheiro: R$%.0f%n", jogador.getDinheiro());
            System.out.println(">>Itens disponíveis:");
            int i = 0;
            for (ItemBase item : loja.getEstoque()) {
                i++;
                System.out.printf(">Item %d - %s | Cura: %d HP | Preço: R$%.0f%n",
                        i, item.getNome(),
                        ((Pocao) item).getPontosDeCura(),
                        item.getPrecoBase());
            }
            System.out.println("0 - Sair");
            System.out.println("==========================");

            int escolha = InputHelper.lerInt("OPT: ");

            if (escolha == 0) {
                System.out.println("Volte sempre!");
                naLoja = false;
            } else if (escolha >= 1 && escolha <= loja.getEstoque().size()) {
                boolean venda = lojaController.lojaComprar(mochila, loja.getEstoque().get(escolha - 1));
                System.out.println(venda ? ">Compra realizada!" : ">Saldo insuficiente!");
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
}
