import java.util.Scanner;

public class ap {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        persona[] personas = new persona[20];
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- CRUD PERSONAS ---");
            System.out.println("1) Alta\n2) Buscar por ID\n3) Baja logica\n4) Listar activas\n5) Actualizar nombre\n0) Salir");
            System.out.print("Seleccione una opcion: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();

                // Switch tradicional para maxima compatibilidad
                switch (opcion) {
                    case 1:
                        alta(sc, personas);
                        break;
                    case 2:
                        buscar(sc, personas);
                        break;
                    case 3:
                        baja(sc, personas);
                        break;
                    case 4:
                        listar(personas);
                        break;
                    case 5:
                        actualizar(sc, personas);
                        break;
                    case 0:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Error: Opcion invalida.");
                        break;
                }
            } else {
                System.out.println("Error: Ingrese un numero valido.");
                sc.nextLine();
            }
        }
    }

    public static void alta(Scanner sc, persona[] personas) {
        System.out.print("ID (>0): ");
        int id = sc.nextInt();
        sc.nextLine();
        if (id <= 0) {
            System.out.println("ID no valido");
            return;
        }
        for (persona p : personas) {
            if (p != null && p.getId() == id) {
                System.out.println("ID ya existe");
                return;
            }
        }
        System.out.print("Nombre: ");
        String nom = sc.nextLine();
        for (int i = 0; i < personas.length; i++) {
            if (personas[i] == null) {
                personas[i] = new persona(id, nom);
                System.out.println("Alta exitosa");
                return;
            }
        }
    }

    public static void buscar(Scanner sc, persona[] personas) {
        System.out.print("ID a buscar: ");
        int id = sc.nextInt();
        for (persona p : personas) {
            if (p != null && p.getId() == id && p.isActiva()) {
                System.out.println("Nombre: " + p.getNombre());
                return;
            }
        }
        System.out.println("no encontrada o inactiva"); //
    }

    public static void baja(Scanner sc, persona[] personas) {
        System.out.print("ID para baja logica: ");
        int id = sc.nextInt();
        for (persona p : personas) {
            if (p != null && p.getId() == id) {
                p.setActiva(false);
                System.out.println("Persona dada de baja");
                return;
            }
        }
        System.out.println("ID no encontrado");
    }

    public static void listar(persona[] personas) {
        System.out.println("--- Lista de Activas ---");
        for (persona p : personas) {
            if (p != null && p.isActiva()) System.out.println(p);
        }
    }

    public static void actualizar(Scanner sc, persona[] personas) {
        System.out.print("ID de persona: ");
        int id = sc.nextInt();
        sc.nextLine();
        for (persona p : personas) {
            if (p != null && p.getId() == id && p.isActiva()) {
                System.out.print("Nuevo nombre: ");
                p.setNombre(sc.nextLine());
                System.out.println("Actualizado");
                return;
            }
        }
        System.out.println("No se pudo actualizar");
    }
}