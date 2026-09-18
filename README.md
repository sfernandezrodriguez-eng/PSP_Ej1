
1. El programa (Aqui explico los metodos un poco):

numProcesadores():

Este método mira cuántos núcleos o motores de procesamiento tiene disponibles tu ordenador para trabajar y 
te devuelve esa cantidad en un mensaje muy claro.

memoriaTotalReservada():

Este método calcula la memoria RAM que está usando el programa en megas, calculando cuánto espacio tiene ocupado,
cuánto le queda libre y su límite máximo para mostrártelo todo bien organizado.

memoriaTotalReservada2():

Este método hace la misma cuenta de memoria pero guardando antes una lista enorme de datos que ocupa 
unos 64 megas, lo que permite ver cómo sube el espacio ocupado al añadir esa información.

informeSistema():

Este método enseña datos de tu sistema operativo para armar la ruta a un archivo que funcione tanto en Windows 
como en Linux, ordena información de tu equipo por orden alfabético y se queda congelado hasta que pulses Enter 
para que la ventana no se cierre de golpe.



2. El proceso, desde fuera:

Localización del proceso (PID, PPID y proceso padre):

Al ejecutar ps -ef | grep InformeSistema se obtiene un PID 12339 y un PPID 12325, siendo el proceso padre 
la propia consola/shell interactiva de Linux (bash/pts/0) desde la que se lanzó la orden de ejecución.

Diferencia de PPID entre Terminal e IDE:

El PPID sí cambia porque al ejecutar el programa desde la terminal el proceso padre es el shell del sistema,
mientras que al lanzarlo desde el IDE el padre pasa a ser el gestor de ejecuciones de IntelliJ IDEA (BuildMain),
que actúa como proceso supervisor instanciando la JVM.

Comparación de cifras de memoria con -Xmx128m:

Cambian la memoria máxima (de 3822 MiB a 128 MiB al fijar el límite del Heap) y la total reservada
(de 242 MiB a 128 MiB al no poder superar la máxima), ajustándose en consecuencia la memoria libre y 
en uso (que pasa del 32% al 52% tras reservar los 64 MiB).

Rutas multiplataforma y origen de la diferencia:

El programa genera /home/dam26/psp/informe.txt en Linux y generaría C:\Users\dam26\psp\informe.txt en Windows, 
saliendo la diferencia del valor que toman las propiedades del sistema user.home (directorio del usuario) y
file.separator (/ en Unix frente a \ en Windows).




3. Qué tipo de programación encaja:

a) Un servidor web que atiende 500 peticiones a la vez en una máquina de 8 núcleos:

Encaja la programación concurrente a nivel de software para gestionar las 500 peticiones intercalando tareas y
la paralela a nivel de hardware para ejecutar 8 hilos a la vez en los núcleos, teniendo como inconveniente la sobrecarga
por cambios de contexto y el riesgo de condiciones de carrera.

b) Renderizar una película de animación en un plazo de tres meses:

Encaja la programación distribuida para repartir fotogramas entre un clúster de máquinas en red y la paralela para
usar los núcleos de cada equipo, asumiendo como inconveniente la alta latencia en la transferencia de archivos y la complejidad
ante fallos en los nodos.

c) Una app de móvil que descarga un fichero mientras seguís navegando:

Encaja la programación concurrente porque permite ejecutar la descarga en un hilo secundario sin congelar la interfaz
del hilo principal, asumiendo el inconveniente de tener que sincronizar la interfaz de usuario de forma segura entre distintos hilos.

d) Un cálculo que no cabe en la RAM de un solo equipo:

Encaja la programación distribuida porque permite fragmentar y procesar los datos utilizando la memoria RAM combinada
de múltiples ordenadores, asumiendo como inconveniente el cuello de botella que supone la velocidad de la red en comparación
con la memoria RAM local.


4. Uso de IA:
