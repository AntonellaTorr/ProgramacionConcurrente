package Tp4.Ej6b;

import java.util.concurrent.Semaphore;

public class Testigo {
    private static Semaphore semTestigo= new Semaphore(1);
    private static Semaphore mutex=new Semaphore(1);
    
    public Testigo(){

    }

    public void entregarTestigo(){
        semTestigo.release();
    
        System.out.println (Thread.currentThread().getName()+ " libera el testigo");
    
    }
    public boolean agarrarTestigo(){
        boolean exito=false;
        try{
            semTestigo.acquire();
            System.out.println (Thread.currentThread().getName()+ " Agarro el testigo y comienza a correr");
            exito=true;
        } catch (InterruptedException e){}
        return exito;

    }
}
