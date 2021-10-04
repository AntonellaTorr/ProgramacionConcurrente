package PracticaParcial;

public class MedicoSangre implements Runnable {
    private static  CentroHemoterapia c= new CentroHemoterapia(); 

    public MedicoSangre (){

    }

    public void run (){
        while (true){
            c.sacarSangre();
            try{
                //simula extraccion
                Thread.sleep(100);
            }catch (InterruptedException e){}

            c.entregarCertificadoADonante();
        }
    }
}
