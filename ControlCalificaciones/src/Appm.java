import java.util.Scanner;

public class Appm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GradeService service = new GradeService();

        // INPUT
        String nombre = leerTextoNoVacio(sc, "Nombre del alumno:");
        double p1 = leerDoubleEnRango(sc, "Calificación parcial 1 (0-100):", 0, 100);
        double p2 = leerDoubleEnRango(sc, "Calificación parcial 2 (0-100):", 0, 100);
        double p3 = leerDoubleEnRango(sc, "Calificación parcial 3 (0-100):", 0, 100);
        int asistencia = leerIntEnRango(sc, "Asistencia (0-100):", 0, 100);
        boolean proyecto = leerBoolean(sc, "¿Entregó proyecto?");

        // PROCESS
        double promedio = service.calcularPromedio(p1, p2, p3);
        double calFinal = service.calcularFinal(promedio, asistencia);
        String estado = service.determinarEstado(calFinal, asistencia, proyecto);

        // OUTPUT
        imprimirReporte(nombre, p1, p2, p3, promedio, asistencia, proyecto, calFinal, estado);
    }

    // Métodos de validación obligatorios
    public static String leerTextoNoVacio(Scanner sc, String msg) {
        String texto = "";
        while (texto.isEmpty()) {
            System.out.println(msg);
            texto = sc.nextLine().trim();
        }
        return texto;
    }

    public static double leerDoubleEnRango(Scanner sc, String msg, double min, double max) {
        while (true) {
            System.out.println(msg);
            if (sc.hasNextDouble()) {
                double val = sc.nextDouble();
                if (val >= min && val <= max) return val;
            }
            sc.nextLine();
            System.out.println("Error: Valor inválido.");
        }
    }

    public static int leerIntEnRango(Scanner sc, String msg, int min, int max) {
        while (true) {
            System.out.println(msg);
            if (sc.hasNextInt()) {
                int val = sc.nextInt();
                if (val >= min && val <= max) return val;
            }
            sc.nextLine();
            System.out.println("Valor inválido.");
        }
    }

    public static boolean leerBoolean(Scanner sc, String msg) {
        while (true) {
            System.out.println(msg + " (true/false)");
            if (sc.hasNextBoolean()) return sc.nextBoolean();
            sc.nextLine();
            System.out.println("Error: Use true o false.");
        }
    }

    public static void imprimirReporte(String nom, double p1, double p2, double p3, double pro, int asis, boolean proy, double fin, String est) {
        System.out.println("Reporte");
        System.out.println("Alumno: " + nom);
        System.out.println("Parciales: " + p1 + ", " + p2 + ", " + p3);
        System.out.println("Promedio Parciales: " + pro);
        System.out.println("Asistencia: " + asis + "%");
        System.out.println("Proyecto: " + (proy ? "Entregado" : "No entregado"));
        System.out.println("Calificación Final: " + fin);
        System.out.println("Estado: " + est);
    }
}