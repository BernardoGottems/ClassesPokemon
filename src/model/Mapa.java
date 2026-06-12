package model;

public class Mapa {
    private char[][] matriz;
    private final int LAR = 12;
    private final int ALT = 8;

    public Mapa(){
        matriz = new char[ALT][LAR];
        ConstruirMapa();
    }

    private void ConstruirMapa() {
        for (int i = 0; i < ALT; i++) {
            for (int j = 0; j < LAR; j++) {
                matriz[i][j] = '.';
            }
        }
        matriz[2][3] = '#';
        matriz[2][4] = '#';
    }

    public  char[][] getMatriz() {
        return matriz;
    }
}
