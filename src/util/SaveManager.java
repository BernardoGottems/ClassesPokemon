package util;
import model.JogadorModel;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class SaveManager {


    public static void salvar(JogadorModel jogador) {

        try {

            FileWriter writer = new FileWriter("save.txt");

            writer.write("Dinheiro=" + jogador.getDinheiro() + "\n");

            writer.write("Insignias=");

            for(String insignia : jogador.getInsignias()) {

                if(insignia != null) {
                    writer.write(insignia + ",");
                }
            }

            writer.write("\n");

            writer.close();

        } catch(Exception e) {
            System.out.println("Erro ao salvar.");
        }
    }

    public static void carregar(JogadorModel jogador) {

        try {

            Scanner leitor = new Scanner(new File("save.txt"));

            while(leitor.hasNextLine()) {

                String linha = leitor.nextLine();

                String[] partes = linha.split("=");

                if(partes.length < 2)
                    continue;

                String chave = partes[0];
                String valor = partes[1];

                switch(chave) {

                    case "Dinheiro":
                        jogador.setDinheiro(
                                Double.parseDouble(valor)
                        );
                        break;

                    case "Insignias":

                        String[] insignias = valor.split(",");

                        for(String insignia : insignias) {

                            if(!insignia.isEmpty()) {
                                jogador.adicionarInsignia(insignia);
                            }
                        }

                        break;
                }
            }

            leitor.close();

        } catch(Exception e) {
            System.out.println("\n");
        }
    }
}
