package model;

public class MapaModel {

    private char[][] mapa = new char[10][10];
    private int numero;

    private boolean lojaCriada    = false;
    private boolean hospitalCriado = false;
    private boolean ginasioCriado  = false;

    int posi = 4;
    int posj = 4;

    // Métodos que o MapaController precisa >:c

    public char[][] getMatriz() {
        return mapa;
    }

    public boolean isBlocked(int x, int y) {
        char c = mapa[y][x];
        return c == 'H' || c == 'G' || c == 'L';
    }

    public boolean temGramaAlta(int x, int y) {
        return mapa[y][x] == '#';
    }



    public void CriarMapa() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                loop:
                do {
                    numero = (int) (Math.random() * 5);
                    switch (numero) {
                        case 0:
                            if (hospitalCriado) break;
                            mapa[i][j] = 'H';
                            hospitalCriado = true;
                            break loop;
                        case 1:
                            if (ginasioCriado) break;
                            mapa[i][j] = 'G';
                            ginasioCriado = true;
                            break loop;
                        case 2:
                            if (lojaCriada) break;
                            mapa[i][j] = 'L';
                            lojaCriada = true;
                            break loop;
                        case 3:
                            mapa[i][j] = '#';
                            break loop;
                        default:
                            mapa[i][j] = '.';
                            break loop;
                    }
                } while (true);
            }
        }

    }
    public char getTileConstrucao(int x, int y) {
        char c = mapa[y][x];
        if (c == 'H' || c == 'G' || c == 'L') return c;
        return '\0';
    }
}