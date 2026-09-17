import java.util.Properties;
import java.util.Scanner;
import java.util.TreeMap;

public class InformeSistema {


    public String numProcesadores(){
        int nucleos = Runtime.getRuntime().availableProcessors();
        return ("Disponibles JVM: " +  nucleos);
    }

    public String memoriaTotalReservada() {
        Runtime runtime = Runtime.getRuntime();


        long memoriaTotal = runtime.totalMemory() / (1024 * 1024);
        long memoriaLibre = runtime.freeMemory() / (1024 * 1024);
        long memoriaMax = runtime.maxMemory() / (1024 * 1024);
        long memoriaUsada = memoriaTotal - memoriaLibre;
        long mPorcentaje = (memoriaUsada * 100) / memoriaTotal;


        String respuesta = String.format("%-17s %d MiB\n", "Total reservada:", memoriaTotal) +
                String.format("%-17s %d MiB\n", "Libre:", memoriaLibre) +
                String.format("%-17s %d MiB (%d %% de la total)\n", "En uso:", memoriaUsada, mPorcentaje) +
                String.format("%-17s %d MiB\n", "Máxima (-Xmx):", memoriaMax);

        return respuesta;
    }

    public String memoriaTotalReservada2() {
        Runtime runtime = Runtime.getRuntime();
        long[] reservado = new long[8 * 1024 * 1024]; // 8 M · 8 bytes = 64 MiB


        long memoriaTotal = runtime.totalMemory() / (1024 * 1024);
        long memoriaLibre = runtime.freeMemory() / (1024 * 1024);
        long memoriaMax = runtime.maxMemory() / (1024 * 1024);
        long memoriaUsada = memoriaTotal - memoriaLibre;
        long mPorcentaje = (memoriaUsada * 100) / memoriaTotal;


        String respuesta = String.format("%-17s %d MiB\n", "Total reservada:", memoriaTotal) +
                String.format("%-17s %d MiB\n", "Libre:", memoriaLibre) +
                String.format("%-17s %d MiB (%d %% de la total)\n", "En uso:", memoriaUsada, mPorcentaje) +
                String.format("%-17s %d MiB\n", "Máxima (-Xmx):", memoriaMax);

        return respuesta;
    }

    public void informeSistema(){

            // 1. Mostrar información básica del sistema
            String osName = System.getProperty("os.name");
            String fileSep = System.getProperty("file.separator");
            String userHome = System.getProperty("user.home");
            String ruta = userHome + fileSep + "psp" + fileSep + "informe.txt";

            System.out.println("SISTEMA");
            System.out.println("===================================================");
            System.out.println("  os.name:        " + osName);
            System.out.println("  file.separator: \"" + fileSep + "\"");
            System.out.println("  Ruta construida con las propiedades:");
            System.out.println("    " + ruta);
            System.out.println();

            // 2. Filtrar y ordenar propiedades del sistema
            System.out.println("PROPIEDADES QUE EMPIEZAN POR os., user., java.version");
            System.out.println("===================================================");

            Properties props = System.getProperties();
            TreeMap<String, String> sortedProps = new TreeMap<>();

            for (String name : props.stringPropertyNames()) {
                if (name.startsWith("os.") || name.startsWith("user.") || name.startsWith("java.version")) {
                    sortedProps.put(name, props.getProperty(name));
                }
            }

            for (var entry : sortedProps.entrySet()) {
                System.out.println("  " + entry.getKey() + " = " + entry.getValue());
            }
            System.out.println();

            // 3. Pausar la ejecución para inspección del proceso
            System.out.println("PROCESO EN ESPERA");
            System.out.println("===================================================");
            System.out.println("  Buscame desde otra terminal con:");
            System.out.println("    ps -ef | grep InformeSistema");
            System.out.println();
            System.out.print("  Pulsa INTRO para terminar...");

            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();

            System.out.println("  Fin del programa.");
        }


}
