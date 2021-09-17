package Tp4.Ej1;

public class SynchronizedCounter {
    private int c = 0;
    public synchronized void increment() {c++;}
    public void decrement() { /*try{ Thread.sleep(10);}catch(InterruptedException e){} */c--;}
    public synchronized int value() {return c;}
    public static void main(String[] args) {
        SynchronizedCounter synCoun= new SynchronizedCounter();
        TestThread hilo1= new TestThread(synCoun,"Hilo1");
        TestThread hilo2= new TestThread(synCoun,"Hilo2");
        TestThread hilo3= new TestThread(synCoun,"Hilo3");
        TestThread hilo4= new TestThread(synCoun,"Hilo4");

        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
    }
    
}
