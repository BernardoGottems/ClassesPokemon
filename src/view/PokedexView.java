package view;
import java.util.ArrayList;

public class PokedexView {

    public void exibirPokedex(ArrayList<String> monstrosVistos) {
        System.out.println("=== SUA POKÉDEX ===");

        for(String nome : monstrosVistos){
            System.out.println("- " + nome);
        }

        System.out.println("===================");
    }
}