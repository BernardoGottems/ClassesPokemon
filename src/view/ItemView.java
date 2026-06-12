package view;

import model.ItemBase;

import java.util.ArrayList;

public class ItemView {

    public void exibirMochila(ArrayList<ItemBase> mochila){
        System.out.println("----- MOCHILA DE ITENS -----");
        if(mochila.isEmpty()){
            System.out.println("Sua mochila está completamente vazia.");

        } else {
            for(int i = 0; i < mochila.size(); i++){
                ItemBase item = mochila.get(i);
                System.out.printf("[%d] %s x%d (Preço original: $%.2f)\n", i, item.getNome(), item.getQuantidade(), item.getPrecoBase());            }
        }

        System.out.println("========================");
    }
}
