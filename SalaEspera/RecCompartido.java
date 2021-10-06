package SalaEspera;

import java.util.concurrent.Semaphore;

public class RecCompartido {
    private int cantAsientos;
    private int cantLibres;
    private Semaphore esperarSilla;
    //mutex para proteger la seccion critica, donde pregunto por la variable compartida y actuo 
    private Semaphore mutex;
    private int cantEsperando;


    public RecCompartido(){
        cantAsientos=2;
        cantLibres=2;
        cantEsperando=0;
        mutex= new Semaphore (1);
        esperarSilla= new Semaphore(0);

    }

    public void intentarIngresar(){
        try {
            mutex.acquire();
            if (cantLibres==0){
                System.out.println (Thread.currentThread().getName() +" intenta ingresar pero no hay sillas" );
                cantEsperando++;
                mutex.release();
                System.out.println (Thread.currentThread().getName() +" esta esperando una silla..." );
                esperarSilla.acquire();
                //luego de que se logro hacer el acquiere, quiere decir que alguien libero una silla, entonces entra una persona y ocupa un asiento
                mutex.acquire();
                System.out.println ("Se desocupo una silla "+Thread.currentThread().getName() +" logra ingresar" );
                cantEsperando--;
                cantLibres--;
                mutex.release();
            }
            else{
                System.out.println (Thread.currentThread().getName() +" logra ingresar, cantidad de asientos libres antes de que el lo tome "+cantLibres);
                cantLibres--;
                mutex.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
      
       
    }

    public void irse(){
        try{
            mutex.acquire();
            System.out.println (Thread.currentThread().getName() +" se va");
            //desocupa una silla
            cantLibres++;
            System.out.println ("Cuando " +Thread.currentThread().getName() +" se va hay "+cantEsperando+ " personas esperando");
            //si ademas habia alguien esperando habilita el permiso
            if (cantEsperando>=1){
                esperarSilla.release();
            }
            mutex.release();

        }catch(InterruptedException e){
            e.printStackTrace();

        }
        
  

      

    }
    
}
