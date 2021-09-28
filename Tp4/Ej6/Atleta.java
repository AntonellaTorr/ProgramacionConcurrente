package Tp4.Ej6;

public class Atleta implements Runnable {
    private int nro;
    private static Testigo t= new Testigo ();
    private String lado;
    private String ladoLlegada;

    public Atleta(int nro, String lado, String ladoLlegada){
        this.nro=nro;
        this.lado=lado;
        this.ladoLlegada=ladoLlegada;
    }

    public void run(){
        while (!t.agarrarTestigo(lado, ladoLlegada)){
        }
        try{
           System.out.println ("corriendo");
            Thread.sleep((int)Math.random()*100);
        }catch (InterruptedException e){}
        t.entregarTestigo(lado, ladoLlegada);
        
        
      
        
        
        
        
    
    }
    
}
