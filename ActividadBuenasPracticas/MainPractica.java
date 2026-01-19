import java.util.Scanner;

public class MainPractica {
    public static void main(String[] args) {
        int numeroLimite = pedirEntero();
        int resultadoSuma = sumarHastaN(numeroLimite);
        System.out.println("La suma de los números es: " + resultadoSuma);
    }
    public static int pedirEntero() {
        Scanner teclado = new Scanner(System.in);
        System.out.print("ingresa un número entero positivo: ");
        return teclado.nextInt();
    }

    public static int sumarHastaN(int limite) {
        int sumaAcumulada = 0;
        for (int i = 1; i <= limite; i++) {
            sumaAcumulada += i;
        }
        return sumaAcumulada;
    }
}
