public class VendedorTickets implements Runnable {
    private Atraccion a;
    public VendedorTickets (Atraccion a){
        this.a=a;
    }
    public void run (){
        while (true){
            a.venderTicket();
            a.trenLleno();
        }
       
    }
}
