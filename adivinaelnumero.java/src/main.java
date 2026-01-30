import java.util.Random;
import java.util.Scanner;

public class main {

    static int contadorFueraRango = 0;
    static int contadorNoNumerico = 0;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int max = 100;
        int min = 1;

        // CORRECCIÓN: Rango de 1 a 100
        int secreto = random.nextInt(100) + 1;

        int intentos = 0;
        int limiteIntentos = 7; // Límite de 7 intentos
        boolean gano = false; // Bandera booleana obligatoria

        System.out.println("JUEGO ADIVINA EL NUMERO  ");
        System.out.println(secreto);

        while (intentos < limiteIntentos) {
            int numero = obtenerNumeroValido(sc, "Adivina el numero (1-100). Intento " + (intentos + 1) + ":", min, max);
            intentos++;

            if (numero == secreto) {
                System.out.println(" Ganaste ");
                gano = true;
                break;
            } else if (numero > secreto) {
                System.out.println("El numero secreto es menor.");
            } else {
                System.out.println("El numero secreto es mayor.");
            }
        }

        if (!gano) {
            System.out.println("Se agotaron los intentos ");

        }


        System.out.println("RESULTADO FINAL");
        System.out.println("Perdiste, el numero secreto era: " + secreto);
        System.out.println("Veces fuera de rango: " + contadorFueraRango);
        System.out.println("Entradas no numéricas: " + contadorNoNumerico);
    }

    public static int obtenerNumeroValido(Scanner sc, String mensaje, int min, int max) {
        int valor;
        while (true) {
            System.out.println(mensaje);
            if (sc.hasNextInt()) {
                valor = sc.nextInt();
                if (valor >= min && valor <= max) {
                    return valor;
                }

                System.out.println( " Numero fuera de rango.");
                contadorFueraRango++;
            } else {

                System.out.println("El dato no es numérico.");
                contadorNoNumerico++;
                sc.next();
            }
        }
    }
}