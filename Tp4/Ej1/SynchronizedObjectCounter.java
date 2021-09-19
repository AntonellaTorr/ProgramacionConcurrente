package Tp4.Ej1;

public class SynchronizedObjectCounter {
    private int c = 0 ;
    public void increment(){
        synchronized ((Integer)c) { //Este elemento debe ser casteado a Integer
            c++;
        }
    }
    public void decrement() {
        synchronized (this) {
            c--;
        }
    }
    public int value() { 
        return c ;
    }
    /*se estan sincronizando dos variables distintas en este caso por lo tanto no se asegura la consitencia, para lograr esto se podria:
    1-Sincronizar todos los metodos, increment, decrement y value 
    2- En todos los metodos castear la variable c a integer y sincronizarla

    1C- Para este caso creo que da lo mismo utilizar el metodo o un bloque sincronizado ya que la seccion critica es todo el metodo
    no hay partes que no lo sean. Por eso el usar bloques no tendria mucho sentido ya que no hay nada mas que se pueda ejecutar 
    sin sincronizacion
    */
    public static void main(String[] args) {
        SynchronizedObjectCounter synCoun= new SynchronizedObjectCounter();
        TestSync hilo1= new TestSync(synCoun,"Hilo1");
        TestSync hilo2= new TestSync(synCoun,"Hilo2");
        TestSync hilo3= new TestSync(synCoun,"Hilo3");
        TestSync hilo4= new TestSync(synCoun,"Hilo4");

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }
}
