import java.util.Arrays;
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

    public void informeSistema(String[] args) {
        // 1. SISTEMA
        String osName = System.getProperty("os.name");
        String fileSep = System.getProperty("file.separator");
        String userHome = System.getProperty("user.home");
        String ruta = userHome + fileSep + "psp" + fileSep + "informe.txt";

        System.out.println("SISTEMA");
        System.out.println("==================================================");
        System.out.println("os.name: " + osName);
        System.out.println("file.separator: \"" + fileSep + "\"");
        System.out.println("Ruta construida con las propiedades:");
        System.out.println(ruta);

        // 2. PROPIEDADES QUE EMPIEZAN POR
        String[] prefijos = (args != null && args.length > 0)
                ? args
                : new String[]{"os.", "user.", "java.version"};

        System.out.println("PROPIEDADES QUE EMPIEZAN POR " + String.join(", ", prefijos));
        System.out.println("==================================================");

        Properties props = System.getProperties();
        TreeMap<String, String> sortedProps = new TreeMap<>();

        // Filtrar según los prefijos recibidos o los de por defecto
        for (String name : props.stringPropertyNames()) {
            if (Arrays.stream(prefijos).anyMatch(name::startsWith)) {
                sortedProps.put(name, props.getProperty(name));
            }
        }

        // Mostrar las propiedades ordenadas alfabéticamente
        for (var entry : sortedProps.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }

        // 3. PROCESO EN ESPERA
        System.out.println("PROCESO EN ESPERA");
        System.out.println("==================================================");
        System.out.println("Buscame desde otra terminal con:");
        System.out.println("ps -ef | grep InformeSistema");
        System.out.println("Pulsa INTRO para terminar...");

        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        System.out.println("Fin del programa.");
    }


}
