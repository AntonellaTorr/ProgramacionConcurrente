package Tp2;

public class testeoRecurso {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente ("1 ", new int[]{2,2,1,5,2,3});
        Cliente cliente2 = new Cliente (" 2 ", new int[]{1,3,5,1,1});
        Cajero caj1= new Cajero ("1", cliente1, 100);
        Cajero caj2= new Cajero ("2",cliente2, 100);
        Thread cajero1= new Thread (caj1,"1");
        Thread cajero2= new Thread (caj2,"2");
        cajero1.start();
        cajero2.start();
        
   }
   /* public static void main (String [] args) throws InterruptedException{
        System.out.println ("Hilo principal iniciando");
        unHilo nuevoHilo= new unHilo ("#1");
        unHilo nuevoHilo2= new unHilo ("#2");
        unHilo nuevoHilo3= new unHilo ("#3");
        nuevoHilo.start();
        for (int i=0;i<50;i++){
            System.out.println (" ,");
        }
        /*hasta este punto solo se podrian mezclar  las sentencias del for con las del
        run del hilo?

        nuevoHilo2.start();
        
       try{
           Thread.sleep(100);
        }catch(InterruptedException e){
            System.out.println ("Hilo principal interrumpido");
        }
        nuevoHilo3.start();
        System.out.println ("Hilo principal finalizado");


    }*/
}
