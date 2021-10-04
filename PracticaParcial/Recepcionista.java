package PracticaParcial;



public class Recepcionista implements Runnable {

    private static CentroHemoterapia c= new CentroHemoterapia ();

    public Recepcionista (){
    }
    public void run (){
        while (true){
            System.out.println ("Recepcionista procesando y almacenando sangre...");
            c.recepcionarDonante();
            try{
                //recepciona al donante 
                Thread.sleep(100);
            }catch (InterruptedException e){}
        }
    }
}