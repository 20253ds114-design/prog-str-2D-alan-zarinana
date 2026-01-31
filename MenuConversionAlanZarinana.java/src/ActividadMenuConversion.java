import java.util.Scanner;

public class ActividadMenuConversion {
    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);
        int opcion = 0;


        int c1 = 0, c2 = 0, c3 = 0, c4 = 0;

        do {
            System.out.println("MENÚ DE CONVERSION");
            System.out.println("1) °C a °F\n2) °F a °C\n3) Km a Millas\n4) Millas a Km\n5) Salir");
            System.out.print("Elige una opciOn: ");


            if (!lector.hasNextInt()) {
                System.out.println("Error: La opción debe ser un número.");
                lector.next();
                continue;
            }
            opcion = lector.nextInt();

            if (opcion >= 1 && opcion <= 4) {
                System.out.print("Ingresa  valor a convertir: ");


                if (!lector.hasNextDouble()) {
                    System.out.println("Error: Debes ingresar un valor numérico.");
                    lector.next();
                    continue;
                }
                double valor = lector.nextDouble();
                double resultado = 0;

                switch (opcion) {
                    case 1:
                        resultado = (valor * 9/5) + 32;
                        System.out.println(valor + " °C equivale a " + resultado + " °F");
                        c1++;
                        break;
                    case 2:
                        resultado = (valor - 32) * 5/9;
                        System.out.println(valor + " °F equivale a " + resultado + " °C");
                        c2++;
                        break;
                    case 3:
                        resultado = valor * 0.621371;
                        System.out.println(valor + " Km equivale a " + resultado + " Millas");
                        c3++;
                        break;
                    case 4:
                        resultado = valor / 0.621371;
                        System.out.println(valor + " Millas equivale a " + resultado + " Km");
                        c4++;
                        break;
                }
            } else if (opcion != 5) {
                System.out.println("Opción inválida, intenta de nuevo.");
            }

        } while (opcion != 5); // Repetir hasta que elija Salir


        int total = c1 + c2 + c3 + c4;
        System.out.println("RESUMEN DE SESION");
        System.out.println("Total de conversiones: " + total);
        System.out.println("°C a °F: " + c1);
        System.out.println("°F a °C: " + c2);
        System.out.println("Km a Millas: " + c3);
        System.out.println("Millas a Km: " + c4);
        System.out.println("Adiós");
    }
}