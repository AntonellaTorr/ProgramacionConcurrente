package Tp4.Ej4;
import java.util.concurrent.Semaphore;

public class Test {

    public static void main(String[] args) {
        Semaphore sem3_1= new Semaphore (1);
        Semaphore sem1_2= new Semaphore (0);
        Semaphore sem2_3= new Semaphore (0);
    
        HilLetra a= new HilLetra(sem3_1, sem1_2,1,'A');
        HilLetra b= new HilLetra(sem1_2, sem2_3,4,'B');
        HilLetra c= new HilLetra(sem2_3,sem3_1,3,'C');
    
        Thread hiloA= new Thread (a, "HiloA");
        Thread hiloB= new Thread (b, "HiloB");
        Thread hiloC= new Thread (c, "HiloC");
        
        hiloA.start();
        hiloB.start();
        hiloC.start();
    
    }
   
   
    
}
