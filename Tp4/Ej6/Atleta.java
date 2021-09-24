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
        while (!lado.equals(t.getLado())){
            try{Thread.sleep(10);}catch (InterruptedException e){}
            //System.out.println ("Lado testigo "+t.getLado()+ "lado del hilo con nombre "+Thread.currentThread().getName()+" "+this.lado); 
        }
        t.correr(ladoLlegada);
        
      
        
        
        
        
    
    }
    
}
