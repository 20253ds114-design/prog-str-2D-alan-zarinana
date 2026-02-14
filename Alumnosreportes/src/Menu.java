import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Alumno[] alumnos = new Alumno[25];
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("Alaumnos y reportes");
            System.out.println("1 .Alta 2. Buscar 3. Actualizar promedio 4. Baja logica 5. Listar 6. Reportes 0. Salir");
            System.out.print("Opcion: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1: alta(sc, alumnos); break;
                    case 2: buscar(sc, alumnos); break;
                    case 3: actualizar(sc, alumnos); break;
                    case 4: baja(sc, alumnos); break;
                    case 5: listar(alumnos); break;
                    case 6: reportes(alumnos); break;
                    case 0: System.out.println("Saliendo"); break;
                    default: System.out.println("Error"); break;
                }
            } else {
                sc.nextLine();
            }
        }
    }

    public static void alta(Scanner sc, Alumno[] alumnos) {
        System.out.print("ID (>0): ");
        int id = sc.nextInt();
        sc.nextLine();

        if (id <= 0) { System.out.println("id invalido."); return; }
        for (Alumno a : alumnos) {
            if (a != null && a.getId() == id) { System.out.println("id repetido."); return; }
        }

        System.out.print("Nombre: ");
        String nom = sc.nextLine();
        if (nom.isEmpty()) { System.out.println("nombre vacio."); return; }

        System.out.print("promedio (0-10): ");
        double prom = sc.nextDouble();
        if (prom < 0 || prom > 10) { System.out.println(" rango invalido."); return; }

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = new Alumno(id, nom, prom);
                System.out.println("guardado.");
                return;
            }
        }
    }

    public static void buscar(Scanner sc, Alumno[] alumnos) {
        System.out.print("id a buscar: ");
        int id = sc.nextInt();
        for (Alumno a : alumnos) {
            if (a != null && a.getId() == id && a.isActivo()) {
                System.out.println(a);
                return;
            }
        }
        System.out.println("no encontrado.");
    }

    public static void actualizar(Scanner sc, Alumno[] alumnos) {
        System.out.print("id: ");
        int id = sc.nextInt();
        for (Alumno a : alumnos) {
            if (a != null && a.getId() == id && a.isActivo()) {
                System.out.print("nuevo promedio: ");
                double p = sc.nextDouble();
                if (p >= 0 && p <= 10) a.setPromedio(p);
                return;
            }
        }
    }

    public static void baja(Scanner sc, Alumno[] alumnos) {
        System.out.print("id para baja: ");
        int id = sc.nextInt();
        for (Alumno a : alumnos) {
            if (a != null && a.getId() == id) {
                a.setActivo(false);
                System.out.println("baja realizada.");
                return;
            }
        }
    }

    public static void listar(Alumno[] alumnos) {
        for (Alumno a : alumnos) {
            if (a != null && a.isActivo()) System.out.println(a);
        }
    }

    public static void reportes(Alumno[] alumnos) {
        double suma = 0, max = -1, min = 11;
        Alumno aMax = null, aMin = null;
        int cont = 0, excelencia = 0;

        for (Alumno a : alumnos) {
            if (a != null && a.isActivo()) {
                suma += a.getPromedio();
                cont++;
                if (a.getPromedio() > max) { max = a.getPromedio(); aMax = a; }
                if (a.getPromedio() < min) { min = a.getPromedio(); aMin = a; }
                if (a.getPromedio() >= 8.0) excelencia++;
            }
        }

        if (cont == 0) return;
        System.out.println("Promedio general: " + (suma / cont));
        System.out.println("Mayor promedio: " + aMax);
        System.out.println("Menor promedio: " + aMin);
        System.out.println("Alumnos con >= 8.0: " + excelencia);
    }
}
