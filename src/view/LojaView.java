package view;

import controller.LojaController;
import model.ItemBase;
import model.LojaModel;

public class LojaView {
    LojaModel loja;
    LojaController lojaController;
    public void menuLoja(){
        System.out.println("-=Lojinha=-");
        System.out.println(">>itens em estoque:");
        int i = 1;
        for(ItemBase item : loja.getEstoque()){
            System.out.printf(">Item %d\n",i);
            i++;
            System.out.printf("-Quantidade: %d\n",item.getQuantidade());
            System.out.printf("-Preço base: %g\n",item.getPrecoBase());
            System.out.printf("-Nome: %s\n",item.getNome());
            System.out.println("==========================");
        }
        //ainda vou adicionar a chamada do lojaController
    }
}
