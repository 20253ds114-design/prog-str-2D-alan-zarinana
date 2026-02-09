 import java.util.Scanner;

public class Appp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        inptDataValidator validator = new inptDataValidator();
        shippingcalculator calculator = new shippingcalculator();

        //  INPUT
        double peso = validator.getValidDouble(sc, "Ingrese el peso (0.1 - 50.0 kg):", 0.1, 50.0);
        int distancia = validator.getValidInt(sc, "Ingrese la distancia (1 - 2000 km):", 1, 2000);
        int servicio = validator.getValidInt(sc, "Seleccione servicio (1. Estándar, 2. Express):", 1, 2);
        boolean remota = validator.getValidBoolean(sc, "¿Es zona remota? (true/false):");

        //  PROCESS
        calculator.process(peso, distancia, servicio, remota);

        // OUTPUT
        imprimirTicket(servicio, peso, distancia, remota, calculator);
    }


    public static void imprimirTicket(int servicio, double peso, int distancia, boolean remota, shippingcalculator calc) {

        System.out.println("Ticket");
        System.out.println("Servicio: " + (servicio == 1 ? "Estándar" : "Express"));
        System.out.println("Peso: " + peso + " kg");
        System.out.println("Distancia: " + distancia + " km");
        System.out.println("Zona Remota: " + (remota ? "Sí" : "No"));
        System.out.println("Subtotal: $" + calc.subtotal);
        System.out.println("Iva : $" + calc.iva);
        System.out.println("Total a pagar: $" + calc.total);

    }
}