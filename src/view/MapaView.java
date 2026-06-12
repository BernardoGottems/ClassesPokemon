package view;

import java.util.Scanner;

public class MapaView {
    Scanner scan = new Scanner(System.in);
    public static final String RESET = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARELO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String ROXO = "\u001B[35m";
    public static final String CIANO = "\u001B[36m";

    public char Imprimir(char[][] mapa){
        for(int i = 0; i< 10; i++){
            for(int j = 0; j < 10; j++){
                if(mapa[i][j] == 'H'){
                    System.out.print(VERMELHO + mapa[i][j]);

                }else if(mapa[i][j] == 'L'){
                    System.out.print(AMARELO + mapa[i][j]);
                }else if(mapa[i][j] == 'G'){
                    System.out.print(ROXO + mapa[i][j]);
                }else if(mapa[i][j] == '#'){
                    System.out.print(VERDE + mapa[i][j]);
                }
                else {
                    System.out.print(mapa[i][j]);
                }
            }
            System.out.print("\n");
        }
        System.out.println("Escolha para que direção voce quer ir(W/A/S/D)");
        String escolha;
        do {
            escolha = scan.nextLine().toUpperCase();
            if(escolha.length() != 1){
                System.out.println("coloque apenas um caractere");
            }else if(escolha.equals("W") || escolha.equals("A") || escolha.equals("D") || escolha.equals("S")){
                return escolha.charAt(0);

            } else{
                System.out.println("entrada invalida");
            }
        }while(true);

    }
}