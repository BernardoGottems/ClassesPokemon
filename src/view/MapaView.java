package view;

public class MapaView {
    public static final String RESET   = "\u001B[0m";
    public static final String VERMELHO = "\u001B[31m";
    public static final String VERDE   = "\u001B[32m";
    public static final String AMARELO = "\u001B[33m";
    public static final String AZUL    = "\u001B[34m";
    public static final String ROXO    = "\u001B[35m";


    public void Imprimir(char[][] mapa, int jogX, int jogY) {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {

                // Jogador sobrepõe o tile da posição atual
                if (i == jogY && j == jogX) {
                    System.out.print(AZUL + "J" + RESET);
                    continue;
                }

                switch (mapa[i][j]) {
                    case 'H': System.out.print(VERMELHO + " H " + RESET); break;
                    case 'L': System.out.print(AMARELO  + " L " + RESET); break;
                    case 'G': System.out.print(ROXO     + " G " + RESET); break;
                    case '#': System.out.print(VERDE    + " # " + RESET); break;
                    case '.':   System.out.print(" . "); break;
                    default:  System.out.print(mapa[i][j]);              break;
                }
            }
            System.out.println();
        }
    }
}