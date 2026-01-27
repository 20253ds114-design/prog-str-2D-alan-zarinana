package src;

import java.util.Scanner;

public class ActividadIfElseTarifa {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        System.out.print("Ingresa tu edad: ");
        int edad = lector.nextInt();


        if (edad < 0 || edad > 120) {
            System.out.println("Edad inválida");
            return;
        }

        System.out.print("¿Eres estudiante? (true/false): ");
        boolean esEstudiante = lector.nextBoolean();
        int tarifa = 0;


        if (edad < 12) {
            tarifa = 50;
        }

        else if (edad >= 12 && edad <= 17) {
            if (esEstudiante) {
                tarifa = 60;
            } else {
                tarifa = 80;
            }
        }

        else {
            if (esEstudiante) {
                tarifa = 90;
            } else {
                tarifa = 120;
            }
        }

        System.out.println("\nEdad ingresada: " + edad);
        System.out.println("Si es estudiante o no: " + (esEstudiante ? "Sí" : "No"));
        System.out.println("Tarifa final: " + tarifa);
    }
}
