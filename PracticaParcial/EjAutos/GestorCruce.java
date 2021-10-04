package PracticaParcial.EjAutos;

import java.util.concurrent.Semaphore;

public class GestorCruce {
    //generar la fila de autos de cada lado
    private static Semaphore mutexNorte= new Semaphore (1);
    private static Semaphore mutexOeste= new Semaphore (1);
    
    private String ladoSemEnVerde;

    public GestorCruce (){
        ladoSemEnVerde="Oeste";
    }   
    public void llegaNorte(){
        if (ladoSemEnVerde.equals("Norte")){
            System.out.println (Thread.currentThread().getName()+" Cruzando...");
        }
        else{
            try{
                System.out.println (Thread.currentThread().getName() +" espera que el semaforo se ponga es verde");
                mutexNorte.acquire();
                System.out.println ("Ya se habilito el semaforo, " +Thread.currentThread().getName() +" pasando");
            }catch(InterruptedException e){}
        }
    }
    
    public void llegaOeste(){
        if (ladoSemEnVerde.equals("Oeste")){
            System.out.println (Thread.currentThread().getName()+" Cruzando...");
        }
        else{
            try{
                System.out.println (Thread.currentThread().getName() +"  espera que el semaforo se ponga es verde");
                mutexOeste.acquire();
                System.out.println (Thread.currentThread().getName() +" pasando");
            }catch(InterruptedException e){}
        }
    }
    public void salePorLadoSur(){
        mutexNorte.release();
    }
    public void salePorLadoEste(){
        mutexOeste.release();
    }
    public void cambiarSemaforo(){
        if (ladoSemEnVerde.equals("Oeste")){
            ladoSemEnVerde="Norte";
            
            System.out.println ("El controlador cambio el semaforo, ahora pueden pasar los autos del lado norte");
        }
        else{
            ladoSemEnVerde="Oeste";
            System.out.println ("El controlador cambio el semaforo, ahora pueden pasar los autos del lado oeste");
        }
        
    }
}
