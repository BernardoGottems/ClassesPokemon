package view;

import util.InputHelper;

public class MenuView {
    public static int  mostrarMenu() throws InterruptedException {

        System.out.println("======= PokeTerminal =======");
        Thread.sleep(1000);
        System.out.println("Versão: 1.0");
        Thread.sleep(1000);
        String texto = "1- Jogar\n2- Sair\nEscolha uma opção\n";
        for (int i = 0; i < texto.length(); i++) {
            System.out.print(texto.charAt(i));
            Thread.sleep(10);
        }


        InputHelper in = new InputHelper();
        int escolha = in.lerInt("Escolha: ");


        switch (escolha) {
            case 1:
                System.out.println("Iniciando o jogo...");
                return 1;
            case 2:

                return 0;
            default:
                System.out.println("Opção inválida.");
                return mostrarMenu();
        }

    }

}
