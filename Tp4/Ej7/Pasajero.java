package Tp4.Ej7;



public class Pasajero implements Runnable {
    private Taxi t;

    public Pasajero (Taxi t){
        this.t=t;
    }

    public void run (){
        System.out.println (Thread.currentThread().getName()+" solicita viajar");
        Taxi.solicitarViaje();
        System.out.println (Thread.currentThread().getName()+" se subio al taxi y comienza a viajar");
        Taxi.bajarseDelTaxi();


        
    }
    
}
