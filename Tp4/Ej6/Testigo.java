package Tp4.Ej6;

import java.util.concurrent.Semaphore;

public class Testigo {
    private String lado;
    private static Semaphore semTestigo= new Semaphore(1);
    
    public Testigo(){
        lado="A";
    }

    public synchronized String getLado(){
        return lado;
    }
    public synchronized void setLado(String lado){
        this.lado=lado;
    }
    public void correr(String ladoLlegada){
        while (!semTestigo.tryAcquire()){
            semTestigo.tryAcquire();
        }       

        //uso tryacquiere para que el atleta de mi mismo lado que no alcanzo a agarrarlo no se queda en la cola 
        //de espera
        //simula atleta corriendo
        System.out.println (Thread.currentThread().getName()+" agarro el testigo" );
        System.out.println ("Lado del Testigo antes de correr "+lado);
        
        this.setLado(ladoLlegada);
        System.out.println ("Lado del Testigo despues de correr "+lado);
        semTestigo.release();  
        System.out.println (Thread.currentThread().getName()+" libero el testigo");         
        
    
    }
}
