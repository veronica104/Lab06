package laboratorio6;

import java.util.Random;
import java.util.Scanner;

public class Laboratorio6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione un juego:");
            System.out.println("1. Juego de Dados");
            System.out.println("2. Juego de Tragamonedas");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    Thread juegoDados = new Thread(new JuegoDados());
                    juegoDados.start();
                    break;
                case 2:
                    Thread juegoTragamonedas = new Thread(new JuegoTragamonedas());
                    juegoTragamonedas.start();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion inválida. Intente de nuevo.");
            }

            try {
                // Pausa para esperar que el hilo complete antes de reiniciar el menú
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (opcion != 3);

        scanner.close();
    }
}

// Clase para el juego de Dados
class JuegoDados implements Runnable {
    @Override
    public void run() {
        Random random = new Random();
        int dado1 = random.nextInt(6) + 1; // Dado 1
        int dado2 = random.nextInt(6) + 1; // Dado 2
        int resultado = dado1 + dado2;
        System.out.println("Juego de Dados:");
        System.out.println("Dado 1: " + dado1 + " | Dado 2: " + dado2);
        System.out.println("Resultado: " + resultado + "\n");
    }
}

// Clase para el juego de Tragamonedas
class JuegoTragamonedas implements Runnable {
    @Override
    public void run() {
        Random random = new Random();
        String[] simbolos = {"trebol","corazon","pica","diamante"};
        String simbolo1 = simbolos[random.nextInt(simbolos.length)];
        String simbolo2 = simbolos[random.nextInt(simbolos.length)];
        String simbolo3 = simbolos[random.nextInt(simbolos.length)];

        System.out.println("Juego de Tragamonedas:");
        System.out.println("Resultado: " + simbolo1 + " | " + simbolo2 + " | " + simbolo3);

        if (simbolo1.equals(simbolo2) && simbolo2.equals(simbolo3)) {
            System.out.println("¡Ganaste!\n");
        } else {
            System.out.println("Intenta de nuevo.\n");
        }
    }
}

    
    

