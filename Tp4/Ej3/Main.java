package Tp4.Ej3;

import java.util.concurrent.Semaphore;

public class Main {
     public static void main(String[] args) {
        Semaphore sem2_1= new Semaphore (1);
        Semaphore sem1_3= new Semaphore (0);
        Semaphore sem3_2= new Semaphore (0);

        Proceso p1= new Proceso (1,sem2_1,sem1_3);
        Proceso p3= new Proceso (2,sem1_3,sem3_2);
        Proceso p2= new Proceso (3,sem3_2,sem2_1);

        Thread P1= new Thread (p1, "P1");
        Thread P2= new Thread (p2, "P2");
        Thread P3= new Thread (p3, "P3");

        P1.start();
        P2.start();
        P3.start();


    }
    
}
