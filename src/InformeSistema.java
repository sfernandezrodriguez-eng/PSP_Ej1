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


}
