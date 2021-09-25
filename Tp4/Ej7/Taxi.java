package Tp4.Ej7;

import java.util.concurrent.Semaphore;

public class Taxi {
    //semPasajero para la comunicacion entre el pasajero y el taxista a la hora de viajar
    //semTaxista para comunicarle al pasajero que llego
    private static Semaphore semPasajero= new Semaphore (0);
    private static Semaphore semTaxista= new Semaphore(0);
    private static Semaphore mutex=new Semaphore(1);

    public Taxi (){
        

    }

    public static void iniciarViaje(){
        try{
            semPasajero.acquire();            
        }catch (InterruptedException e){}
    }
    public static void finalizarViaje(){
        semTaxista.release();
    }

    public static void solicitarViaje(){
        try{
            mutex.acquire();
            semPasajero.release();
        }catch(InterruptedException e){}
    }
    public static void bajarseDelTaxi(){
        try{
            semTaxista.acquire();
            System.out.println (Thread.currentThread().getName() +" se baja del taxi");
            mutex.release();
        } catch (InterruptedException e){}
    }

}
