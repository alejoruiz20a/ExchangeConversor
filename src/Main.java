package src;

import java.io.IOException;
import java.util.Scanner;

import com.google.gson.JsonObject;


public class Main {
    public static void main(String[] args) {
        Api api = new Api();

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        double cantidad = 0.0;

        while (opcion != 7) {
            System.out.println("Menu de Conversiones de Monedas");
            System.out.println("1. Peso Colombiano a Dólar Estadounidense");
            System.out.println("2. Peso Colombiano a Peso Mexicano");
            System.out.println("3. Dólar Estadounidense a Peso Colombiano");
            System.out.println("4. Dólar Estadounidense a Peso Mexicano");
            System.out.println("5. Peso Mexicano a Peso Colombiano");
            System.out.println("6. Peso Mexicano a Dólar Estadounidense");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            if (opcion!=7) {
                System.out.print("Ingresa la cantidad a convertir: ");
                cantidad = Double.parseDouble(scanner.nextLine());
            }

            switch (opcion) {
                case 1:
                    System.out.println("Resultado: " + api.convertir("COP", "USD", cantidad));
                    break;
                case 2:
                    System.out.println("Resultado: " + api.convertir("COP", "MXN", cantidad));
                    break;
                case 3:
                    System.out.println("Resultado: " + api.convertir("USD", "COP", cantidad));
                    break;
                case 4:
                    System.out.println("Resultado: " + api.convertir("USD", "MXN", cantidad));
                    break;
                case 5:
                    System.out.println("Resultado: " + api.convertir("MXN", "COP", cantidad));
                    break;
                case 6:
                    System.out.println("Resultado: " + api.convertir("MXN", "USD", cantidad));
                    break;
                case 7:
                    System.out.println("Programa terminado.\nDEV: JUAN JOSÉ JARAMILLO VERA");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
            System.out.println("\nPresiona cualquier tecla para continuar...");
            try {
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
