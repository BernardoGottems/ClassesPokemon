package controller;
import java.util.ArrayList;
import model.PokemonBase;
import view.PokemonView;

public class PokemonController {
    private PokemonView view;
    public PokemonController(){
        this.view = new PokemonView();
    }
    public void gerenciarExibicaoDaEquipe(ArrayList<PokemonBase> equipe) {
        view.verEquipe(equipe);
    }


}
