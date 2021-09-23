package Tp4.Ej4;

import java.util.concurrent.Semaphore;

public class HilLetra implements Runnable {
    private char letra;
    private int cantImpresiones;
    private Semaphore sem1;
    private Semaphore sem2;

    
    public HilLetra (Semaphore sem1, Semaphore sem2,int cant, char letra){
        this.sem1=sem1;
        this.sem2=sem2;
        this.cantImpresiones=cant;
        this.letra=letra;
       
    }
    public void run (){
        int cantExito=0;
        while (cantExito<3){
                try{
                    sem1.acquire();
                    imprimir();
                    cantExito++;
                    sem2.release();
                }catch (InterruptedException e){}
            }
            
        }
    
        
    public void imprimir(){
        for (int i=0;i<cantImpresiones;i++){
            System.out.print(letra);
            
        }
   } 

    
}