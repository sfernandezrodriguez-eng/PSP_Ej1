void main() {
    InformeSistema app = new InformeSistema();


    Integer resultado1 = app.numProcesadores();
    System.out.println("Resultado Prueba 1: " + resultado1);

    String resultado2 = app.MemoriaTotalReservada();
    System.out.println("Resultado Prueba 2: " + resultado2);
}
