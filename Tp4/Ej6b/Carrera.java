package Tp4.Ej6b;

import java.util.Scanner;

public class Carrera {
    public static void main(String[] args) {
        Scanner leer= new Scanner(System.in);
        System.out.println ("Ingrese la cantidad de atletas");
        int cant= leer.nextInt();
   
        Thread [] atletas= new Thread [cant];

        
        for (int i=0;i<cant;i++){
            atletas[i]= new Thread(new Atleta(i));
        }
        for (int m=0;m<cant;m++){
            atletas[m].start();
        }
     

    }
}
