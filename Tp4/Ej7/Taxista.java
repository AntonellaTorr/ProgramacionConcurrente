package Tp4.Ej7;



public class Taxista implements Runnable {
    private Taxi t;

    public Taxista (Taxi t){
        this.t=t;
    }

    public void run (){
        while (true){

        Taxi.usarTaxi();
        }

        
        
    }




   
}
