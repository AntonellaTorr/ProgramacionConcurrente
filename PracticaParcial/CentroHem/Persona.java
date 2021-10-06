package PracticaParcial.CentroHem;

public class Persona implements Runnable {

    private static CentroHemoterapia c= new CentroHemoterapia ();

    public Persona (){
 
    }
    public void run (){
        System.out.println (Thread.currentThread().getName() +" llamando al centro para avisar que desea donar sangre");
        c.llamarCentro();
        System.out.println (Thread.currentThread().getName() +" ingreso al centro");
        c.ingresarAlCentro();
        
        c.ingresarAEntrevistaMedica();
        
        c.salirDeEntrevistaMedica();

        
        c.donarSangre();
        c.irADesayunar();

        c.abandonarCentro();
        System.out.println (Thread.currentThread().getName() +" abandona el centro");
    }

}