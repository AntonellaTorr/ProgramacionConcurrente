package TpO3.LectorEscritor;

import java.util.concurrent.Semaphore;

public class Libro {
    private boolean libroFinalizado;
    private int cantPaginas,cantPaginasEscritas;
    private Semaphore sem1,mutex,mutex2;
    //sem1 funcionara como comunicacion entre el primer escritor y el primer lector. Luego de que algun escritor escriba podran leer
    //mutex para exclusion mutua
    

    public boolean finalizado(){
        return libroFinalizado;
    }
    public void empezarALeer(){
        try{
            mutex.acquire();
            if(cantPaginasEscritas==0){
                mutex.release();
                sem1.acquire();
                mutex.acquire();
            }
        }
        catch(InterruptedException e){

        }      

    }
    public void empezarAEscribir(){
        try {
            mutex.acquire();
            //Escribe
            cantPaginasEscritas++;
            
          
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public boolean hayEscrito(){
        return true;
    }
    public void terminarDeEscribir(){
        //si luego de escribir la cantidad de paginas es 1 le comunica al primer lector que ya puede leer
        if (cantPaginasEscritas==1){
            sem1.release();
        }else{
            //sino si la cantidad de paginas escritas es igual a la cantidad total de paginas del libro el libro se finalizo
            if (cantPaginasEscritas==cantPaginas){
                libroFinalizado=true;
            }
        }
        mutex.release();
    }
    public void terminarDeLeer(){
        mutex.release();

    }
}
