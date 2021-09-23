package Tp4.Ej7;

import java.util.concurrent.Semaphore;

public class Taxi {
    //semPasajero para la comunicacion entre el pasajero y el taxista a la hora de viajar
    //semTaxista para comunicarle al pasajero que llego
    private static Semaphore semPasajero= new Semaphore (0);
    private static Semaphore semTaxista= new Semaphore(0);

    public Taxi (){
        

    }

    public static void usarTaxi(){
        //el pasajero le avisa al taxista que quiere viajar 
        try{
            semPasajero.acquire();
            //simular el viaje
            System.out.println ("Iniciando el viaje");
            try{
                Thread.sleep(100);
            }catch (InterruptedException e){}
            System.out.println ("llego a destino");
            semTaxista.release();
            
            
        }catch (InterruptedException e){}
    }
    public synchronized static void solicitarViaje(){
        semPasajero.release();
        System.out.println(Thread.currentThread().getName()+" subiendo al taxi");
        try{
            //sirve para que el taxista le avise que llego
            semTaxista.acquire();
            System.out.println (Thread.currentThread().getName()+" bajandose del taxi");
        } catch (InterruptedException e){};
    }

}
