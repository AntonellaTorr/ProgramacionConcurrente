package Tp2;

public class Prueba {
    public static void main(String[] args) {
        PracticaThreads hilo1= new PracticaThreads("PEPE");
        PracticaThreads hilo2= new PracticaThreads("JUAN");
        
        hilo1.start();
        hilo2.start();
    }
}
