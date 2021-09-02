package Tp2;

public class Cajero implements Runnable {
    private String nombre;
    private Cliente cliente;
    private long initialTime;

    public Cajero (String nombre,Cliente cliente, long time){
        this.nombre=nombre;
        this.cliente=cliente;
        this.initialTime=time;
    }
    
    public void run(){
        System.out.println ("El cajero "+this.nombre+" COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "+
        cliente.getNombre()+ " EN EL TIEMPO: "+( System.currentTimeMillis()-this.initialTime)/1000+ "Seg");
        for (int i=0;i< cliente.getCarroCompra().length;i++){
            this.esperarXSegundos(cliente.getCarroCompra()[i]);
            System.out.println ("Cliente "+cliente.getNombre() +"Procesado el producto "+ (i+1)+"--> Tiempo: "+( System.currentTimeMillis()-this.initialTime)/1000+ "Seg");
        }
        System.out.println ("El cajero "+this.nombre +" HA TERMINADO DE PROCESAR "+ cliente.getNombre()+" EN EL TIEMPO: "+ +( System.currentTimeMillis()-this.initialTime)/1000+ "Seg");
    }
    
    public void esperarXSegundos(int cant){
        try{
         Thread.sleep(cant);
        } catch(InterruptedException e){

        }
 }
}
