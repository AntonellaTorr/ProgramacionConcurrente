package Tp4.Ej10;

import java.util.concurrent.Semaphore;

public class Comedor {
    //semEmpleado alertara al empleado que llego
    //semMozo avisara al empleado que su comida esta lista
    private static Semaphore semEmpleado= new Semaphore(0);
    private static Semaphore semMozo= new Semaphore(0);

    public void servirComida (){
        while (true){
            try{
                //solo si el empleado  le aviso que llego (libero el semaforo )va a poder comenzar a preparar la comida
                semEmpleado.acquire();
                System.out.println ("El mozo comienza a preparar la comida");
                //simula proceso de preparacion de la comida 
                Thread.sleep(100);
                //le da al empleado su comida
                semMozo.release();

            }catch (InterruptedException e){}
        }
    }

    public synchronized void solicitarComida (){
        //lo hago synchronized x si viene mas de un empleado
        //el empleado solicita la comida
        System.out.println (Thread.currentThread().getName()+ "  llego al comedor");
        semEmpleado.release();      
        try{
            semMozo.acquire();
            System.out.println (Thread.currentThread().getName()+"  termino de comer");
            
        }catch (InterruptedException e){}

    }
   



}
