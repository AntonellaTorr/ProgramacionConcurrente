package Tp4.Ej7;



public class Taxista implements Runnable {
    private Taxi t;

    public Taxista (Taxi t){
        this.t=t;
    }

    public void run (){
        while (true){
            Taxi.iniciarViaje();
             try{
                Thread.sleep (10);
             }catch(InterruptedException e){}
             Taxi.finalizarViaje();
        }

        
        
    }




   
}
