import java.util.Scanner;


public class Main {
    public static double RANGO_BAJO=18.5;
    public static double RANGO_MEDIO=25;
    public static double RANGO_ALTO=30;
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        double pesoKg = obtenerDouble(scanner, "Ingresa el peso en Kilogramos -> 80");
        double alturaM = obtenerDouble(scanner,"Ingresa la altura en M -> 1.80");
        double imc = calcularImc(pesoKg,alturaM);
        System.out.println("Tu IMC es de: "+imc);

        System.out.println("Clasificacion: " + obtenerClasificacion(imc) );
        scanner.close();
    }

    /** * Metodo para capturar un double desde consola * @param sc -> Previamente instanciado desde el main * @param mensaje -> String enviado como parametro * @return double */ public static double obtenerDouble(Scanner sc, String mensaje){
        System.out.println(mensaje);
        return sc.nextDouble();
    }

    /** * Metodo para calcular IMC usando la formula pesoKG/alturaM² * @param pesoKG -> expresado en kilogramos * @param alturaM -> expresado en metros * @return double imc */ public static double calcularImc(double pesoKG, double alturaM){
        return pesoKG/(alturaM*alturaM);
    }

    /** * Metodo para obtener una clasificacion del IMC, segun las reglas de negocio * @param imc -> previamente calculado * @return -> String de clasificacion en relacion al imc */ public static String obtenerClasificacion(double imc){
        if(imc<18.5) return "Bajo peso";
        else if(imc<25) return "Peso medio";
        else if(imc<30) return "Sobre peso";
        else return "Obesidad";
    }
}
