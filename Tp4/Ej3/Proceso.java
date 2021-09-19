package Tp4.Ej3;

import java.util.concurrent.Semaphore;

public class Proceso implements Runnable {
    private int id;
    private Semaphore sem1;
    private Semaphore sem2;

    public Proceso (int id,Semaphore sem1, Semaphore sem2){
        this.id=id;
        this.sem1=sem1;
        this.sem2=sem2;
    }
    
    public void run (){
        int cantExito=0;
        while (cantExito<10){
        try{
            
            sem1.acquire();
            System.out.print (Thread.currentThread().getName());
            sem2.release();
            cantExito++;
        }catch (InterruptedException e){}
    }
        
    }
    
}
