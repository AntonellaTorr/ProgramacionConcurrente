package Tp4.Ej6;

import java.util.Scanner;

public class Carrera {
    public static void main(String[] args) {
        Scanner leer= new Scanner(System.in);
        System.out.println ("Ingrese la cantidad de atletas");
        int cant= leer.nextInt(), mitad=cant/2;
        String salida="A", llegada="B";
    
    
        Thread [] atletas= new Thread [cant];

        
        for (int i=0;i<cant;i++){
            if (i==mitad){
                salida="B";
                llegada="A";
            }
            atletas[i]= new Thread(new Atleta(i,salida,llegada));
        }
        for (int m=0;m<cant;m++){
            atletas[m].start();
        }
     

    }
}
