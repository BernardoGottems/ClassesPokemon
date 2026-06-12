
package model;

public class MapaModel { // classe que cria os endereços de cada casinha da matriz; uau;

    public char[][] mapa = new char[10][10];
    private int numero;

    private boolean lojaCriada = false;
    private boolean hospitalCriado = false;
    private boolean ginasioCriado = false;
    int posi = 4;
    int posj = 4;


    boolean AtualizarMapa(int posx, int posy, int antiga, boolean horizontal) {
        if(horizontal) {
            mapa[posx][antiga] = '.';
            if(mapa[posx][posy] == '#'){
            boolean batalha = Math.random() < 0.25;
            if(batalha){
                return true;
            }

            }
            mapa[posx][posy] = 'J';
            return false;
        }else {
            mapa[antiga][posy] = '.';
            if(mapa[posx][posy] == '#'){
                boolean batalha = Math.random() < 0.25;
                if(batalha){
                    return true;
                }
            }
            mapa[posx][posy] = 'J';
            return false;
        }
    }
    public boolean mover(char direcao){
        int aux;
        switch(direcao){
            case 'W':
                if(posj - 1 < 0){
                    System.out.println("posição invalida");
                    break;
                } else if (mapa[posi][posj - 1] == 'H' || mapa[posi][posj - 1] == 'G' || mapa[posi][posj - 1] == 'L') {
                    System.out.println("entrando na construção");
                    break;
                }
                aux = posj;
                posj -= 1;
                return AtualizarMapa(posi, posj,aux, true);

            case 'S':
                if(posj + 1 > 9){
                    System.out.println("posição invalida");
                    break;
                } else if (mapa[posi][posj + 1] == 'H' || mapa[posi][posj + 1] == 'G' || mapa[posi][posj + 1] == 'L') {
                    System.out.println("entrando na construção");

                }
                aux = posj;
                posj += 1;
                return AtualizarMapa(posi, posj,aux, true);

            case 'A':
                if(posi - 1 < 0){
                    System.out.println("posição invalida");
                    break;
                } else if (mapa[posi - 1][posj] == 'H' || mapa[posi - 1][posj] == 'G' || mapa[posi - 1][posj] == 'L') {
                    System.out.println("entrando na construção");
                    break;
                }
                posi -= 1;
                aux = posi;
                return AtualizarMapa(posi, posj,aux, false);

            case 'D':
                if(posi + 1 > 9){
                    System.out.println("posição invalida");
                    break;
                } else if (mapa[posi + 1][posj] == 'H' || mapa[posi + 1][posj] == 'G' || mapa[posi + 1][posj] == 'L') {
                    System.out.println("entrando na construção");
                    break;
                }
                posi += 1;
                aux = posi;
                return AtualizarMapa(posi, posj, aux,false);

        }
        return false;
    }
    // codigos = {80, 74, 46, 71, 76, 72, 35}; // P, J, ., G, L, H, # os codigos ascii
    public void CriarMapa(){
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                loop:
                do {

                    numero = (int) (Math.random() * 5);
                    switch(numero){
                        case 0:
                            if(hospitalCriado){
                                break;
                            }
                            numero = 72;
                            hospitalCriado = true;
                            mapa[i][j] = (char) numero;
                            break loop;
                        case 1:
                            if(ginasioCriado){
                                break;
                            }
                            numero = 71;
                            ginasioCriado = true;
                            mapa[i][j] = (char) numero;
                            break loop;
                        case 2:
                            if(lojaCriada){
                                break;
                            }
                            numero = 76;
                            lojaCriada = true;
                            mapa[i][j] = (char) numero;
                            break loop;
                        case 3:
                            numero = 35;
                            mapa[i][j] = (char) numero;
                            break loop;
                        default: //grama baixa;
                            numero = 46;
                            mapa[i][j] =(char) numero;
                            break loop;


                    }


                }while(true);
            }

        }
        mapa[posi][posj] = 'J'; //jogador;
    }

}
