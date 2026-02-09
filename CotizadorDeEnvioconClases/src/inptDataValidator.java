import java.util.Scanner;

public class inptDataValidator {

    //  para el Peso (Double)
    public double getValidDouble(Scanner sc, String msg, double min, double max) {
        double valor;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextDouble()) {
                valor = sc.nextDouble();
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.println("Error: El peso debe estar entre " + min + " y " + max);
            } else {
                System.out.println("Dato no numerico");
                sc.next();
            }
        }
    }

    // Validador para Distancia y Servicio (Int)
    public int getValidInt(Scanner sc, String msg, int min, int max) {
        int valor;
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.println("Error: Fuera de rango (" + min + "-" + max + ")");
            } else {
                System.out.println("Dato no numerico");
                sc.next();
            }
        }
    }

    // validador de tru o false
    public boolean getValidBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.println(msg + " (true/false)");
            if (sc.hasNextBoolean()) {
                return sc.nextBoolean();
            } else {
                System.out.println("Error: Ingresa true o false");
                sc.next();
            }
        }
    }
}