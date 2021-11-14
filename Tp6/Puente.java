package Tp6;

import java.util.concurrent.Semaphore;

public class Puente {
    private char pasando;
    private int cantPasando, cantEsperando;
    //mutex para acceso a variables compartidas
    //espera: los autos quedan trabados 
    private Semaphore mutex, espera;

    public Puente(){
        cantPasando=0;
        cantEsperando=0;
        mutex= new Semaphore(1);
        espera= new Semaphore(0);
        pasando='S';
    }
    public void llegarAlPuente(char lado){
        try {
            //mutex para acceso a seccion critica
            mutex.acquire();
            //si estan pasando los autos de su lado pasa
            if (pasando==lado){
                cantPasando++;
                mutex.release();
            }else{
                //sino espera
                System.out.println (Thread.currentThread().getName() +"no pudo pasar, espera");
                cantEsperando++;
                mutex.release();
                espera.acquire();

                //una vez que logro pasar modifica 
                mutex.acquire();
                System.out.println (Thread.currentThread().getName() +"puede pasar");
                //cambia la variable de quien pasa
                pasando=lado;
                cantPasando++;
                cantEsperando--;
                mutex.release();
               
            }
        
    

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void irse(char lado){
        try {
            mutex.acquire();
            //si es el ultimo que esta pasando libera el paso para los demas
            cantPasando--;
            System.out.println (Thread.currentThread().getName() +" se va");
            if (cantPasando==0){
                espera.release(cantEsperando);
            }
         
            mutex.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
