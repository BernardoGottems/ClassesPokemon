package controller;

import model.MenuModel;
import view.MenuView;

public class MenuController {
    private final MenuModel model = new MenuModel();
    private final MenuView view = new MenuView();

    public MenuController() throws InterruptedException {

        if(!model.rodando(view.mostrarMenu())){
            System.out.println("Saindo");
            System.exit(0);
        }

    }
}
