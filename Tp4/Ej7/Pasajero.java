package Tp4.Ej7;


public class Pasajero implements Runnable {
    private Taxi t;

    public Pasajero (Taxi t){
        this.t=t;
    }

    public void run (){
       Taxi.solicitarViaje();
        
    }
    
}
