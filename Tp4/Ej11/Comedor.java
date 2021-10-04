package Tp4.Ej11;

import java.util.concurrent.Semaphore;

public class Comedor {
    //semEmpleado alertara al empleado que llego
    //semMozo avisara al empleado que su comida esta lista
    //mutex exclusion mutua entre empleados
    private static Semaphore semEmpleadoC= new Semaphore(0);
    private static Semaphore semEmpleadoB= new Semaphore(0);
    private static Semaphore semCocinero= new Semaphore(0);
    private static Semaphore semMozo= new Semaphore(0);
    private static Semaphore mutex= new Semaphore (1);


    public void solicitarComida (){       
        semEmpleadoC.release();    
    }
    
    public void solicitarBebida (){
        semEmpleadoB.release();    
    }
    public void comenzarAPrepararComida (){
        try{
            //solo si el empleado  le aviso que llego (libero el semaforo )va a poder comenzar a preparar la comida
            semEmpleadoC.acquire();
        }catch (InterruptedException e){}
        
    }
    public void servirComida(){
        //le da al empleado su comida
        semCocinero.release();
        System.out.println ("El cocinero le sirve la comida");
    }
    public void comenzarAPrepararBebida (){
        try{
            //solo si el empleado  le aviso que llego (libero el semaforo )va a poder comenzar a preparar la comida
            semEmpleadoB.acquire();
        }catch (InterruptedException e){}
    }
    public void servirBebida(){
        semMozo.release();
        System.out.println ("El mozo le sirve la bebida");
    }
    

    public void esperarComida (){
        try{
            semCocinero.acquire();
        }catch(InterruptedException e){}
    }
    public void esperarBebida(){
        try{
            semMozo.acquire();
        }catch(InterruptedException e){}
    }
    public void ingresarAlComedor (){
        try{
            mutex.acquire();
        }catch(InterruptedException e){}
    }
    public void irseDelComedor (){
        mutex.release();        
    }
   



}
