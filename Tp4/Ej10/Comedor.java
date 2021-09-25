package Tp4.Ej10;

import java.util.concurrent.Semaphore;

public class Comedor {
    //semEmpleado alertara al empleado que llego
    //semMozo avisara al empleado que su comida esta lista
    //mutex exclusion mutua entre empleados
    private static Semaphore semEmpleado= new Semaphore(0);
    private static Semaphore semMozo= new Semaphore(0);
    private static Semaphore mutex= new Semaphore (1);

    public void comenzarAPrepararComida (){
        try{
            //solo si el empleado  le aviso que llego (libero el semaforo )va a poder comenzar a preparar la comida
            semEmpleado.acquire();
        }catch (InterruptedException e){}
        
    }
    public void servirComida(){
        //le da al empleado su comida
        semMozo.release();
    }

    public void solicitarComida (){
        //lo hago synchronized x si viene mas de un empleado
        //el empleado solicita la comida
        System.out.println (Thread.currentThread().getName()+ "  llego al comedor");
        semEmpleado.release();            

    }
    public void ingresarAlComedor (){
        try{
            mutex.acquire();
        }catch(InterruptedException e){}
    }
    public void irseDelComedor (){
        mutex.release();        
    }
    public void esperarComida (){
        try{
            semMozo.acquire();
        }catch(InterruptedException e){}
    }
   



}
