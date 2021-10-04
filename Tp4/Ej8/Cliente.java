package Tp4.Ej8;

public class Cliente extends Thread {
    private String nombre;
    private int carroCompra[]= new int [20];
    private Cajero caj;

    public Cliente (String nombre, int [] carro,Cajero caj){
        this.nombre=nombre;
        carroCompra= carro;
        this.caj=caj;
    }
 
  
    public void run (){
        caj.llegarALaCaja(nombre);
        for (int i=0; i<carroCompra.length;i++){
            caj.pasarProducto(carroCompra[i],i);
            esperarXSegundos(carroCompra[i]);           
        }
        caj.irseDeLaCaja(this.nombre);
        
      
    }
    public void esperarXSegundos(int cant){
        try{
         Thread.sleep(cant);
        } catch(InterruptedException e){

        }
    }

}

