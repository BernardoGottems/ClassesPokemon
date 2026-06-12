package controller;

import model.MapaModel;
import view.MapaView;

public class MapaController { //classe usada para transportar a matriz gerada pelo model para o view
    MapaModel map = new MapaModel();
    MapaView view = new MapaView();
    public void ControllerRodando() {
        map.CriarMapa();
        do {
            if(map.mover(view.Imprimir(map.mapa))){
                //chamar controller de batalha
            }
        } while(true);
    }
}