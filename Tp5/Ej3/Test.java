import java.util.Scanner;


public class Test {
    public static void main(String[] args) {
        int cantAsientos, cantPasajeros;
        Scanner leer= new Scanner (System.in);
        Thread [] pasajeros;
        
        System.out.println ("Ingrese la cantidad de asientos en el tren");
        cantAsientos= leer.nextInt();
        Atraccion a= new Atraccion(cantAsientos);

        Thread control= new Thread( new ControlTren (a));
        Thread tren= new Thread( new Tren (a));
        Thread vendedorTickets= new Thread( new VendedorTickets (a));


        System.out.println ("Ingrese la cantidad de pasajeros");
        cantPasajeros= leer.nextInt();

        pasajeros= new Thread [cantPasajeros];

        for (int i=0; i<cantPasajeros;i++){
            pasajeros[i]= new Thread ( new Pasajero (a), "Pasajero ".concat(Integer.toString(i)));

        }
        control.start();
        tren.start();
        vendedorTickets.start();
        
        for (int i=0; i<cantPasajeros;i++){
            pasajeros[i].start();
        }
        





       

    }
}
