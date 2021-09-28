package Tp4.Ej6b;

public class Atleta implements Runnable {
    private int nro;
    private static Testigo t= new Testigo ();


    public Atleta(int nro){
        this.nro=nro;
    }

    public void run(){
        
        try{
            t.agarrarTestigo();
            System.out.println ("corriendo");
            Thread.sleep((int)Math.random()*100);
        }catch (InterruptedException e){}
        t.entregarTestigo();
        
        
      
        
        
        
        
    
    }
    
}
