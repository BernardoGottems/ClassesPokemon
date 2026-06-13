package controller;

import view.PokedexView;
import java.util.ArrayList;

public class PokedexController {
    private PokedexView view;

    public PokedexController(){
        this.view = new PokedexView();
    }
    public void exibirPokedex(ArrayList<String> monstrosVistos) {
        view.exibirPokedex(monstrosVistos);
    }
}
