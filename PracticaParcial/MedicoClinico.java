package PracticaParcial;

public class MedicoClinico implements Runnable {
    private static  CentroHemoterapia c= new CentroHemoterapia(); 
    public MedicoClinico (){
        
    }

    public void run (){
        while (true){
            c.entrevistarDonante();
            try{
                //simula entrevista
                Thread.sleep(100);
            }catch (InterruptedException e){}

        }
    }

}