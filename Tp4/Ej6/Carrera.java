package Tp4.Ej6;

import java.util.Scanner;

public class Carrera {
    public static void main(String[] args) {
        Scanner leer= new Scanner(System.in);
        System.out.println ("Ingrese la cantidad de atletas");
        int cant= leer.nextInt(), mitad=cant/2;
        Thread [] atletas= new Thread [cant];

        
        for (int i=0;i<mitad;i++){
            atletas[i]= new Thread(new Atleta(i,"A","B"));
        }
        for(int j=mitad;j<cant;j++){
            atletas[j]= new Thread(new Atleta(j,"B","A"));
        }
        for (int m=0;m<cant;m++){
            atletas[m].start();
        }


    }
}
