package TORRESFAI2991.Ej1;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner p= new Scanner (System.in);
        String [] actividades = {"Aro", "Telas", "Acrobacia"};
        System.out.println ("Ingrese el cupo para cada actividad");
        int cupo=p.nextInt();
        Salon s= new Salon(cupo);

  
        System.out.println ("Ingrese la cantidad de personas");
        int cant=p.nextInt();

        Thread [] personas = new Thread [cant];
        Thread c= new Thread(new HiloControlador(s));
        c.start();

        int j=1;
        for (int i=0; i<cant; i++){
            personas[i]= new Thread(new Persona(s,actividades[j--],actividades[j] ), "Visitante ".concat(Integer.toString(i)));
            j++;
            if (j==3){
                j=1;
            }
        }
        for (int l=0;l<cant;l++){
            personas[l].start();
        }
    }
  
    
}
