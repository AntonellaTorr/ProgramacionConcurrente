package Practica2Parcial;

import java.util.concurrent.Semaphore;

public class Transbordador {
    //puedeIrse lo utilizare para que el transbordador pase al otro lado recien cuando esta lleno 
    //puedeVolver lo utilizare para que el transbordador vuelva recien cuando todos los autos se han bajado
    //avisarControl para comunicacion entre los autos que llegan al tren y un controlador
    //bajarse lo utilizo para que una vez que los autos lleguen al otro lado del rio se bajen uno a uno 
    private Semaphore puedeIrse, puedeVolver, avisarControl, cantLugares, mutex, bajarse;
    private int cantLugaresOcupados;
    public void ir (){
        //solamente puede ir cuando esta lleno con 10 autos
        try {
            puedeIrse.acquire();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void volver (){
        try {
            puedeVolver.acquire();
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void llegar(){
        //llega y espera que le digann que hacer 
        avisarControl.release();
        try {
            cantLugares.acquire();
         
        } catch (Exception e) {
            //TODO: handle exception
        }
      
    }
    public void irse(){
        try {
            bajarse.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void controlLlegada(){
        try {
            //espera a que se requiera su control sobre algun auto 
            avisarControl.acquire();
            //si la cantidad de lugares ocupados es menor a 10 le permite al auto que pase al transbordador 
            mutex.acquire();
            if (cantLugaresOcupados<10){
                cantLugares.release();
                cantLugaresOcupados++;
                
            }
            if (cantLugaresOcupados==10){
                //Si se llego a los 10 lugares le avisa al transbordador que puede salir
                puedeIrse.release();
            
            }
            mutex.release();


        } catch (Exception e) {
            //TODO: handle exception
        }

    }
    public void controlRegreso(){
        try {

            //los autos se van bajan uno a uno
            for (int i=0;i<10;i++){
                System.out.println ("Se baja el auto "+Thread.currentThread().getName());
                bajarse.release();
            }

            mutex.acquire();
            //reestablece la variable de ocupados
            cantLugaresOcupados=0;
            mutex.release();


            //le avisa al transbordador que puede volver
            puedeVolver.release();
            
        } catch (Exception e) {
           
        }
    }
}
