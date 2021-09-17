package Tp3;

public class DualSync {
    private Object syncObject = new Object();
    int dato=5;
    public synchronized void f() {
        for(int i = 0; i < 5; i++) {
            System.out.println ("EN EL METODOF");
            dato = dato * 4;
            System.out.println("f()" + dato);
            Thread.yield();
        }
   }
    public synchronized void g() {
        //synchronized(syncObject) {
            for(int i = 0; i < 5; i++) {
            System.out.println ("EN EL METODOG");
            dato = dato + 20;
            System.out.println("g()" + dato);
            Thread.yield();
            }
        //}
    }
}
