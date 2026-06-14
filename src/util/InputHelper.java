package util;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputHelper {
    public static Scanner scanner = new Scanner(System.in);

    public static int lerInt(String texto){
        while (true) {
            try {
                System.out.print(texto);
                int numero = scanner.nextInt();
                scanner.nextLine(); // "Limpa" o Enter fantasma do buffer!
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("❌ Erro: Por favor, digite apenas números!");
                scanner.nextLine(); // Limpa a letra errada que o usuário digitou
            }
        }
    }



    public static String lerTexto(){
        return scanner.nextLine();
    }
    public static int lerOpt(String texto){
        System.out.printf(texto);
        return Integer.parseInt(scanner.nextLine());
    }


    public static void lerMovimento(String texto){
        System.out.println(texto);
        return;
    }


}
