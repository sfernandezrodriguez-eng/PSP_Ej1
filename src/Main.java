void main() {
    InformeSistema app = new InformeSistema();


    String resultado1 = app.numProcesadores();
    System.out.println("PROCESADORES\n" +
            "================================================== \n" + resultado1);

    String resultado2 = app.memoriaTotalReservada();
    System.out.println("MEMORIA · ANTES\n" +
            "================================================== \n" + resultado2);

    String resultado3 = app.memoriaTotalReservada2();
    System.out.println("MEMORIA · DESPUES\n" +
            "================================================== \n" + resultado3);







}
