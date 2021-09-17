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
