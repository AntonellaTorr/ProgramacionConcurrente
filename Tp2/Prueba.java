package Tp2;

public class Prueba {
    public static void main(String[] args) {
        PracticaThreads hilo1= new PracticaThreads("PEPE");
        PracticaThreads hilo2= new PracticaThreads("JUAN");
        
        try {
            hilo1.join();
        } catch (InterruptedException e) {
            System.out.println ("En el join");
            e.printStackTrace();
        }
        System.out.println ("Main");

    }
}
