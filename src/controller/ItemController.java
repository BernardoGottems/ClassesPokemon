package controller;

import model.ItemBase;

public class ItemController {

    public boolean consumirItem(ItemBase item){
        if(item.getQuantidade() > 0){
            item.setQuantidade(item.getQuantidade() - 1);
            return true;
        }
        return false;
    }

}

