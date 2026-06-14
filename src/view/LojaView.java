package view;

import controller.LojaController;
import model.ItemBase;
import model.LojaModel;
import util.InputHelper;

import java.util.ArrayList;

public class LojaView {
    LojaModel loja;
    LojaController lojaController;

    public LojaView(LojaModel loja, LojaController lojaController) {
        this.loja = loja;
        this.lojaController = lojaController;
    }

    public void menuLoja(ArrayList<ItemBase> mochila){
        System.out.println("-=Lojinha=-");
        System.out.println(">>itens em estoque:");
        int i = 0;
        for(ItemBase item : loja.getEstoque()){
            System.out.printf(">Item %d\n",i+1);
            i++;
            System.out.printf("-Quantidade: %d\n",item.getQuantidade());
            System.out.printf("-Preço base: %g\n",item.getPrecoBase());
            System.out.printf("-Nome: %s\n",item.getNome());
            System.out.println("==========================");
        }
        int escolha = InputHelper.lerOpt("OPT:");
        boolean venda = false;

        escolha -= 1;
        if(escolha >= 0 && escolha < loja.getEstoque().size()){
       venda = lojaController.lojaComprar(mochila, escolha);
       }
       if(venda){
           System.out.println(">Compra realizada com sucesso!");
       }else{
           System.out.println(">Saldo insuficiente!");
       }
    }
}
