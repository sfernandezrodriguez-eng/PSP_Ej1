public class InformeSistema {


    public Integer numProcesadores(){
        int nucleos = Runtime.getRuntime().availableProcessors();
        return nucleos;
    }

    public String MemoriaTotalReservada(){
        Runtime runtime = Runtime.getRuntime();

        long memoriaTotal = runtime.totalMemory();
        long memoriaLibre = runtime.freeMemory();
        long memoriaUsada = memoriaTotal - memoriaLibre;
        String respuesta = ("Memoria usada: " + (memoriaUsada / (1024 * 1024)) + " MB");
        return respuesta;
    }
}
