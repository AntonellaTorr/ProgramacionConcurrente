package Tp2;



public class testeoRecurso {
  public static void main(String[] args) {
        
    
        Cliente cliente1 = new Cliente ("1 ", new int[]{2,2,1,5,2,3});
        Cliente cliente2 = new Cliente (" 2 ", new int[]{1,3,5,1,1});
       
        Cajero caj1= new Cajero("1", cliente1,0);
        Cajero caj2= new Cajero("2", cliente2,102);

        Thread cajero1= new Thread (caj1);
        Thread cajero2= new Thread (caj2);

        cajero1.start();
        cajero2.start();

   }
   /*
   public static void main (String [] args) throws InterruptedException{
        System.out.println ("Hilo principal iniciando");
        unHilo nuevoHilo= new unHilo ("#1");
        nuevoHilo.start();
        for (int i=0;i<1000;i++){
            System.out.println (" ,");
        }try{
            System.out.println ("Hilo a dormir");
           Thread.sleep(100);
        }catch(InterruptedException e){
            System.out.println ("Hilo principal interrumpido");
        }
        System.out.println ("Hilo principal finalizado");


    }
    */
}
