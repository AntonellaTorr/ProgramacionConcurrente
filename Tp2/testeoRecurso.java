package Tp2;

public class testeoRecurso {
    public static void main (String [] args) throws InterruptedException{
        System.out.println ("Hilo principal iniciando");
        unHilo nuevoHilo= new unHilo ("#1");
        unHilo nuevoHilo2= new unHilo ("#2");
        unHilo nuevoHilo3= new unHilo ("#3");
        nuevoHilo.start();
        for (int i=0;i<50;i++){
            System.out.println (" ,");
        }
        nuevoHilo2.start();
        
       try{
           Thread.sleep(100);
        }catch(InterruptedException e){
            System.out.println ("Hilo principal interrumpido");
        }
        nuevoHilo3.start();
        System.out.println ("Hilo principal finalizado");


    }
}
