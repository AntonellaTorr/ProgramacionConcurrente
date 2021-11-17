package Tp5.Ej4;

import java.util.concurrent.Semaphore;

public class Pista {
    private Semaphore aterrizar, despegar, mutex;
    //mutex para proteccion del recurso compartido pista 




    public void aterrizar (){
        try {
            mutex.acquire();


        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void finAterrizaje(){
        try {
            mutex.release();
            

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
