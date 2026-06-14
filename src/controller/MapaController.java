package controller;

import model.MapaModel;
import view.MapaView;

public class MapaController {
    private MapaModel map = new MapaModel();
    private MapaView view = new MapaView();

    public void inicializar() {
        map.CriarMapa();
    }

    public void desenhar(int jogX, int jogY) {
        view.Imprimir(map.getMatriz(), jogX, jogY);
    }

    public boolean moverJogador(int x, int y, String comando) {
        int novoX = x, novoY = y;

        if      (comando.equals("W")) novoY = y - 1;
        else if (comando.equals("S")) novoY = y + 1;
        else if (comando.equals("A")) novoX = x - 1;
        else if (comando.equals("D")) novoX = x + 1;
        else return false;

        if (!dentroDoMapa(novoX, novoY))    return false;
        if (map.isBlocked(novoX, novoY))    return false;

        return true;
    }

    public boolean temGramaAlta(int x, int y) {
        return map.temGramaAlta(x, y);
    }

    public int[] getLimites() {
        char[][] m = map.getMatriz();
        return new int[]{ m[0].length - 1, m.length - 1 }; // maxX, maxY
    }

    private boolean dentroDoMapa(int x, int y) {
        int[] lim = getLimites();
        return x >= 0 && x <= lim[0] && y >= 0 && y <= lim[1];
    }
    public boolean temConstrucao(int x, int y) {
        int[] lim = getLimites();
        if (x < 0 || x > lim[0] || y < 0 || y > lim[1]) return false;
        return map.isBlocked(x, y);
    }

    public char getTipoConstrucao(int x, int y) {
        return map.getTileConstrucao(x, y);
    }
}