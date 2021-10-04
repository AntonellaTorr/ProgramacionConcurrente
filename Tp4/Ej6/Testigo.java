package Tp4.Ej6;

import java.util.concurrent.Semaphore;

public class Testigo {
    private String ladoActual;
    private static Semaphore semTestigo= new Semaphore(1);
    private static Semaphore mutex=new Semaphore(1);
    
    public Testigo(){
        ladoActual="A";

    }

    public void entregarTestigo(String ladoActualAtleta, String ladoLlegadaAtleta){
        ladoActual=ladoLlegadaAtleta;
        semTestigo.release();
        mutex.release();       
        System.out.println (Thread.currentThread().getName()+ " libera el testigo");
    
    }
    public boolean agarrarTestigo(String ladoActualAtleta, String ladoLlegadaAtleta){
        boolean exito=false;
        try{
            mutex.acquire();
            if (ladoActualAtleta.equals(ladoActual)){
                semTestigo.acquire();
                System.out.println (Thread.currentThread().getName()+ " Agarro el testigo y comienza a correr");
                exito=true;
            
            }
            else{
                mutex.release();
            }
        } catch (InterruptedException e){}
        return exito;

    }
}
