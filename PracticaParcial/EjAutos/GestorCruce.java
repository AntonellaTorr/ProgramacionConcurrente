package PracticaParcial.EjAutos;

import java.util.concurrent.Semaphore;

public class GestorCruce {
    //generar la fila de autos de cada lado
    private static Semaphore mutexNorte= new Semaphore (1,true);
    private static Semaphore mutexOeste= new Semaphore (1,true);
    //sincronizacion al momento de preguntar por el lado
    private static Semaphore mutex= new Semaphore (1);
    
    
    private String ladoSemEnVerde;

    public GestorCruce (){
        
        ladoSemEnVerde="Oeste";        
       
    }   
    public void llegaNorte(){
        try {
            mutex.acquire();
            if (ladoSemEnVerde.equals("Norte")){
                mutex.release();
                System.out.println (Thread.currentThread().getName()+" Cruzando...");
            
            }
            else{
                try{
                    mutex.release();
                    System.out.println (Thread.currentThread().getName() +" espera que el semaforo se ponga es verde");
                    mutexNorte.acquire();
                    System.out.println ("Ya se habilito el semaforo, " +Thread.currentThread().getName() +" pasando");
                }catch(InterruptedException e){}
            }
        } catch (Exception e) {}
    }
    
    public void llegaOeste(){
        try {
            mutex.acquire();
            if (ladoSemEnVerde.equals("Oeste")){
                mutex.release();
                System.out.println (Thread.currentThread().getName()+" Cruzando...");
            }
            else{
                try{
                    mutex.release();
                    System.out.println (Thread.currentThread().getName() +"  espera que el semaforo se ponga es verde");
                    mutexOeste.acquire();
                    System.out.println (Thread.currentThread().getName() +" pasando");
                }catch(InterruptedException e){}
            }
        }catch (InterruptedException e){}
    }
    public void salePorLadoSur(){
        mutexNorte.release();
        System.out.println (mutexNorte.availablePermits());
    }
    public void salePorLadoEste(){
        mutexOeste.release();
        System.out.println (mutexOeste.availablePermits());
    }
    public void cambiarSemaforo(){
        try{
            mutex.acquire();
            if (ladoSemEnVerde.equals("Oeste")){
                mutex.release();
                ladoSemEnVerde="Norte";
                System.out.println ("El controlador cambio el semaforo, ahora pueden pasar los autos del lado norte");
            }
            else{
                mutex.release();
                ladoSemEnVerde="Oeste";
                System.out.println ("El controlador cambio el semaforo, ahora pueden pasar los autos del lado oeste");
            }
            
        }catch (InterruptedException e){}
        
        
        
    }
}
