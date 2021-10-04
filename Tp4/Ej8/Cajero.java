package Tp4.Ej8;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cajero{
    private String nombre;
    private long initialTime;
    private static Lock caj= new ReentrantLock();


    public Cajero (String nombre, long time){
        this.nombre=nombre;
        this.initialTime=time;
    }

    public void llegarALaCaja(String nombre){
        caj.lock();
        System.out.println ("El cajero "+this.nombre+" COMIENZA A PROCESAR LA COMPRA DEL CLIENTE "+nombre);
    }
    
    public void pasarProducto(int producto, int i){
       System.out.println ("Procesado el producto "+ (i+1)+"--> Tiempo: "+( System.currentTimeMillis()-this.initialTime)/1000+ "Seg");
    }
      
    
    public void irseDeLaCaja(String nombreC){
        System.out.println (("El cajero "+this.nombre +" HA TERMINADO DE PROCESAR "+ nombreC)+" EN EL TIEMPO: "+ +( System.currentTimeMillis()-this.initialTime)/1000+ "Seg");
        caj.unlock();
    }
    
   
 }

