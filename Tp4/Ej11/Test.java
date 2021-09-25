package Tp4.Ej11;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Thread [] empleados;
        Scanner leer= new Scanner (System.in);
        Comedor c= new Comedor();
        Mozo m1= new Mozo(c);
        Cocinero coc= new Cocinero(c);

        System.out.println ("Ingrese la cantidad de empleados que desean pedir algo para comer");
        int cant=leer.nextInt();
        System.out.println ("Ingrese la cantidad de empleados que desean pedir algo para tomar");
        int n=leer.nextInt();
        System.out.println ("Ingrese la cantidad de empleados que desean pedir algo para comer y tomar");
        int m=leer.nextInt();
        int totalEmp=cant+n+m;
        empleados= new Thread[totalEmp];

        for (int i=0;i<cant;i++){
            empleados[i]=new Thread (new Empleado (c,"Comida"),"Empleado "+i);
        }
        for (int j=cant;j<(n+cant);j++){
            empleados[j]=new Thread (new Empleado (c,"Bebida"),"Empleado "+j);
        }
        for (int p=n;p<totalEmp;p++){
            empleados[p]=new Thread (new Empleado (c,"Ambas"),"Empleado "+p);
        }
        
        
        for (int l=0;l<totalEmp;l++){
            empleados[l].start();
        }
       

        Thread mozo= new Thread(m1, "Mozo");
        Thread cocinero= new Thread (coc, "Cocinero");

        mozo.start();
        cocinero.start();



    }
}
