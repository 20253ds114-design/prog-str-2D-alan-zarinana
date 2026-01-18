import java.util.Scanner;
import java.util.concurrent.SubmissionPublisher;

public class Main {
    public static double IVA=0.16;
    public static double DESCUENTO= 0.10;
    public static double LIMITE_DESCUENTO=1000;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double subtotal = obtenerDouble(sc, "Ingresa el subtotal de la compra");
        double totalConIva= calcularTotal(subtotal);

        System.out.println("Total: "+totalConIva);
    }

    public static double obtenerDouble(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    public static double calcularTotal(double subtotal){
        double totalConIva = subtotal+(subtotal*IVA);
        return calcularDescuento(totalConIva);
    }
    public static double calcularDescuento(double totalConIva){
        if(totalConIva>LIMITE_DESCUENTO){
            totalConIva= totalConIva-(totalConIva*DESCUENTO);
        }
        return totalConIva;
    }

}
