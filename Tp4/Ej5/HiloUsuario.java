package Tp4.Ej5;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class HiloUsuario implements Runnable {
    private static CentroImpresion p= new CentroImpresion(1, 1);
    Semaphore semA;
    Semaphore semB;
    
    public HiloUsuario ( Semaphore semA, Semaphore semB){
        this.semA=semA;
        this.semB=semB;
    }


    public void run (){
        int i=0;
        while (i<5){
            String rta= registrarSolicitud();
            if (rta.equals("A")){
                try{
                    semA.acquire();
                    p.imprimir("A", "A");
                    semA.release();
                } catch (InterruptedException e){}
            }else{
                if (rta.equals("B")){
                    try{
                        semB.acquire();
                        p.imprimir("B", "B");
                        semB.release();
                    } catch (InterruptedException e){}
                }
            }
    }



    }
    
    public synchronized String registrarSolicitud(){
        Scanner leer= new Scanner(System.in);
        System.out.println ("Ingrese el tipo de trabajo que desea imprimir, A-B-I");
        String rta=leer.nextLine();
        return rta;
    }



    
}
