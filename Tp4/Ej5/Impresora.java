package Tp4.Ej5;

import java.util.concurrent.Semaphore;

public class Impresora {
    private String tipo;
    private String estado;
    private static Semaphore semImpresion;

    public Impresora(String tipo, String estado){
        this.tipo=tipo;
        this.estado=estado;
    }
    public void setEstado(String nuevoEstado){
        this.estado=nuevoEstado;
    }
    public String getEstado(){
        return estado;
    }
    public void imprimir(String cadena){
        try{
            semImpresion.acquire();
            System.out.println (cadena);
            semImpresion.release();
        }catch(InterruptedException e){}

    }
   
    
}
