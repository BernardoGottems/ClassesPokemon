package controller;

import model.MenuModel;
import view.MenuView;

public class MenuController {
    private final MenuModel model = new MenuModel();
    private final MenuView view = new MenuView();
    private final ExploracaoController exploracaoController = new ExploracaoController();

    public void iniciar() throws InterruptedException {
        boolean rodando = true;

        while (rodando) {
            int escolha = view.mostrarMenu();

            if (model.rodando(escolha)) {
                exploracaoController.iniciarExploracao();
            } else {
                System.out.println("Saindo...");
                rodando = false;
            }
        }
    }
}