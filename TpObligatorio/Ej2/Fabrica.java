package Ej2;

import java.util.concurrent.Semaphore;

public class Fabrica {
    /**/
    
    private Semaphore semEmb, semCaja, mutex;
    private int cantBotellas;

    public Fabrica(){
        cantBotellas=0;
        semEmb= new Semaphore (0);
        semCaja= new Semaphore(0);
        mutex=new Semaphore(1);
    }
    public void embotellar (){
        try {
            //acquire de mutex para la exclusion mutua
            mutex.acquire();
            System.out.println ("Embotellando...");
            //embotella 
            cantBotellas++;
            //si se llego a la cantidad para completar una caja
            if (cantBotellas%10==0){
                //le comunica al empaquetador
                semEmb.release();
                mutex.release();
               
                //espera reposicion de la caja
                semCaja.acquire();

            }else{  mutex.release();}
       
            
        } catch (Exception e) {
            e.printStackTrace();
        }
     

    }
    public void empaquetar (){
        try {
            //espera la señal de que la caja se lleno
            semEmb.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void reponerCaja (){
        //le avisa al embotellador que repuso la caja 
        semCaja.release();
        System.out.println ("El empaquetador repone caja");
    }
}
