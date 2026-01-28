public class ActividadSwitchCalculadora {
    public static void main(String[] args) {
        java.util.Scanner lector = new java.util.Scanner(System.in);

        System.out.println("1) Sumar\n 2) Restar\n 3) Multiplicarm \n4) Dividir");
        System.out.print("Elige una opción con numero: ");
        int opcion = lector.nextInt();

        System.out.print("Asignale valor a A : ");
        double a = lector.nextDouble();
        System.out.print("Asignale valor a B : ");
        double b = lector.nextDouble();

        double resultado = 0;
        boolean error = false;

        switch (opcion) {
            case 1: resultado = a + b; break;
            case 2: resultado = a - b; break;
            case 3: resultado = a * b; break;
            case 4:
                if (b == 0) {
                    System.out.println("No se puede dividir ");
                    error = true;
                } else {
                    resultado = a / b;
                }
                break;
            default:
                System.out.println("Opción inválida");
                error = true;
                break;
        }

        if (!error) {
            System.out.println("Resultado: " + resultado);
        }
    }
}
