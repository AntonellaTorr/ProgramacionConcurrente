import java.util.concurrent.Semaphore;

public class Atraccion {
    private int asientos;
    private int ticketsVendidos;
    //private int ticketsDisponibles;
    private Semaphore trenPasajero, controlTren,vendedorControl, pasajeroVendedor, mutexPasajeros, pasajeroControl;

    public Atraccion (int cantAsientos){
        this.asientos=cantAsientos;
        this.ticketsVendidos=0;
        this.trenPasajero= new Semaphore (0);
        this.controlTren= new Semaphore (0);
        this.vendedorControl= new Semaphore(0);
        this.pasajeroVendedor= new Semaphore (0);
        this.pasajeroControl= new Semaphore (0);
        this.mutexPasajeros= new Semaphore (1);
        this.trenPasajero= new Semaphore (0);
    }
    public void comprarTicket(){
        //metodo de pasajero
        try {
            //genera exclusion mutua en su compra
            mutexPasajeros.acquire();
            //le avisa al vendedor que necesita un ticket
            pasajeroVendedor.release();

        } catch (Exception e) {e.printStackTrace();}

    }
    public void iniciarViaje (){
        try{
            pasajeroControl.acquire();
            System.out.println ("El pasajero "+Thread.currentThread().getName() +" comienza a viajar");
        }catch (InterruptedException e){}
    }
    public void finalizarViaje(){
        //metodo del pasajero
        try{
            trenPasajero.acquire();
            System.out.println ("El pasajero "+Thread.currentThread().getName() +" se baja del tren y se va");
        }catch(InterruptedException e){e.printStackTrace();}
    }
    public void avisarTrenOcupacion (){
        try {
            //espera que el vendedor le avise que ya vendio los tickets para un viaje
            vendedorControl.acquire();
            //le avisa al tren
            controlTren.release();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    public void venderTicket (){
        //metodo de vendedor
        try {
            //el vendedor solo vende un ticket cuando un pasajero le avisa que llego
            pasajeroVendedor.acquire();
            ticketsVendidos++;
            mutexPasajeros.release();         

        } catch (Exception e) {e.printStackTrace();}
    }
    public void trenLleno(){
        if (ticketsVendidos==asientos){
            pasajeroControl.release(asientos);
            ticketsVendidos=0;
            //si el vendedor ya vendio la cantidad de tickets para llenar un tren le avisa al control
            vendedorControl.release();
            //los pasajeros van a poder comenzar a viajar
         
            

        }else{  }
    }
    public void salir(){
        //metodo de tren
        try{
            //espera que el control le avisa que puede salir 
            controlTren.acquire();
            System.out.println ("El tren inicia su recorrido");

        }catch (InterruptedException e){e.printStackTrace();}
    }
    public void avisarLlegadaPasajeros(){
        //metodo de tren
        //cuando el tren llega a destino le avisa a los pasajeros para que se bajen 
        System.out.println ("El tren llego a destino");
        trenPasajero.release(asientos);

        
    }
}
