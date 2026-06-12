package view;

public class MapaView {
    public void atualizarMapa(char[][] matriz, int jogadorX, int jogadorY){
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (j == jogadorX && i == jogadorY) {
                    System.out.print("P ");
                } else {
                    System.out.print(matriz[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
