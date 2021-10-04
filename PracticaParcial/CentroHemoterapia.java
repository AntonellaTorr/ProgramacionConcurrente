package PracticaParcial;

import java.util.concurrent.Semaphore;

public class CentroHemoterapia {
    //donante comunica al recepcionaste que desea donar
    private static Semaphore donante= new Semaphore (0);
    //medico es para comunicacion entre el donante y el medico que le extrajo sangre, para avisarle que ya se puede ir
    private static Semaphore medico= new Semaphore (0);
    //donanteMedico es para comunicacion entre el medicoClinico y el medico que extrae sangre
    private static Semaphore donanteMedico= new Semaphore (0);
    //donanteMedicoClinico es para comunicacion entre el donante y el medicoClinico para avisar que ya esta listo para la entrevista
    private static Semaphore donanteMedicoClinico= new Semaphore (0);
    //los mutex son para exclusion mutua en el proceso de ingresar a una entrevista y para el proceso de donar sangre 
    private static Semaphore mutex1= new Semaphore (1);
    private static Semaphore mutex2= new Semaphore (1);

    
    public void recepcionarDonante(){
        try{
            donante.acquire();
            System.out.println("Recepcionando donante");
        }catch (InterruptedException e){}
    }
    public void sacarSangre (){
        try{
            //si ya termino con la entrevista el paciente, se le extrae sangre
            donanteMedico.acquire();
        }catch (InterruptedException e){}
    }
    public void entregarCertificadoADonante (){
        medico.release();
    }
    public void llamarCentro(){
        donante.release();
    }    
    public void ingresarAlCentro(){
        //una vez q ingresa al centro ya esta listo para ser entrevistado
        donanteMedicoClinico.release();
    }
    public void entrevistarDonante(){
        try{
            donanteMedicoClinico.acquire();
           } catch (InterruptedException e){e.printStackTrace();}
    }
    public void ingresarAEntrevistaMedica(){
        try{
            mutex1.acquire();
            System.out.println (Thread.currentThread().getName() +" ingreso a la entrevista medica");
           } catch (InterruptedException e){e.printStackTrace();}
    }
    public void salirDeEntrevistaMedica(){
        mutex1.release();
        System.out.println (Thread.currentThread().getName() +" sale de la entrevista medica");
        //el medico que extrae sangre ya puede comenzar
        donanteMedico.release();
    }
    public void donarSangre(){
        try{
            mutex2.acquire();
            System.out.println (Thread.currentThread().getName() +" donando sangre");
        } catch (InterruptedException e){e.printStackTrace();}
    }
    public void irADesayunar (){
        mutex2.release();
        System.out.println (Thread.currentThread().getName() +" desayunando");
    }
    public void abandonarCentro(){
       try{
         medico.acquire();
       } catch (InterruptedException e){e.printStackTrace();}
    }
}
