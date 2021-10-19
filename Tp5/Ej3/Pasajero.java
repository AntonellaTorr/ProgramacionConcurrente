public class Pasajero implements Runnable {
    private Atraccion a;
    
    public Pasajero (Atraccion a){
        this.a=a;
    }

    public void run (){
        a.comprarTicket();
        //System.out.println ("El pasajero "+Thread.currentThread().getName() +" compro un ticket");
        
        a.iniciarViaje();
        try {
            Thread.sleep(100);
        } catch (Exception e) {}
        a.finalizarViaje();
        

    }
}
