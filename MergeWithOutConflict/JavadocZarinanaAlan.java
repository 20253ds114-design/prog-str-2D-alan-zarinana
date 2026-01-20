import java.util.Scanner;

public class JavadocZarinanaAlan {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        int op;

        do {
            System.out.println("/n MENU ");
            System.out.println("1. IMC");
            System.out.println("2. Area Rectangulo");
            System.out.println("3. Celsius a Fahrenheit");
            System.out.println("4. Area Circulo");
            System.out.println("5. Salir");
            System.out.print("Elige una opcion: ");
            op = leer.nextInt();

            switch (op) {
                case 1:
                    System.out.print("Peso: "); double p = leer.nextDouble();
                    System.out.print("Altura: "); double a = leer.nextDouble();
                    System.out.println("Resultado: " + calcularIMC(p, a));
                    break;
                case 2:
                    System.out.print("Base: "); double b = leer.nextDouble();
                    System.out.print("Altura: "); double h = leer.nextDouble();
                    System.out.println("Resultado: " + calcularAreaRectangulo(b, h));
                    break;
                case 3:
                    System.out.print("Grados C: "); double c = leer.nextDouble();
                    System.out.println("Resultado en F: " + convertirCelsiusFahrenheit(c));
                    break;
                case 4:
                    System.out.print("Radio: "); double r = leer.nextDouble();
                    System.out.println("Resultado: " + calcularAreaCirculo(r));
                    break;
                case 5:
                    System.out.println("Fin del programa");
                    break;
                default:
                    System.out.println("No existe esa opcion");
            }
        } while (op != 5);
    }

    /**
     * Metodo para calcular el IMC
     * @param peso en kilogramos
     * @param altura en metros
     * @return el imc calculado
     */
    public static double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    /**
     * Metodo para sacar el area del rectangulo
     * @param b base
     * @param a altura
     * @return area total
     */
    public static double calcularAreaRectangulo(double b, double a) {
        return b * a;
    }

    /**
     * Metodo para conversion de temperatura
     * @param c grados celsius
     * @return grados fahrenheit
     */
    public static double convertirCelsiusFahrenheit(double c) {
        return (c * 1.8) + 32;
    }

    /**
     * Metodo para sacar el area del circulo
     * @param r radio
     * @return area total
     */
    public static double calcularAreaCirculo(double r) {
        return 3.1416 * (r * r);
    }
}
