package Tp4.Ej5;

import java.util.concurrent.Semaphore;

public class Test {
    public static void main(String[] args) {;
        Semaphore semA= new Semaphore(1);
        Semaphore semB= new Semaphore(1);

        HiloUsuario hilo1= new HiloUsuario( semA, semB);
        HiloUsuario hilo2= new HiloUsuario(semA, semB);

        Thread h1= new Thread (hilo1,"1");
        Thread h2= new Thread (hilo2,"1");

        h1.start();
        h2.start();
    }
}
