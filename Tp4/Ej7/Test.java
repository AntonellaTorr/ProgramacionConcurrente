package Tp4.Ej7;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner a= new Scanner(System.in);
        Taxi t= new Taxi();
       
        Taxista tax= new Taxista (t);
        Thread taxista= new Thread (tax);
        

        System.out.println ("Ingrese la cantidad de pasajeros");
        int cant=a.nextInt();
        Thread [] arregloPasajeros= new Thread [cant];

      
        for (int j=0;j<cant;j++){
            arregloPasajeros[j]= new Thread(new Pasajero(t),"Pasajero "+j);
        }

        for (int i=0;i<cant;i++){
            arregloPasajeros[i].start();
        }

        taxista.start();
    }
}
