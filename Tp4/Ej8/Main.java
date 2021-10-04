package Tp4.Ej8;

public class Main {
    public static void main(String[] args) {
        long initialTime= System.currentTimeMillis();
        Cajero cajero= new Cajero ("Cajero", initialTime);
        Cliente cliente1= new Cliente ("Cliente 1", new int [] {1,2,3,4},cajero);
        Cliente cliente2= new Cliente ("Cliente 2", new int [] {1,2,3,4,5,6},cajero);
        
        cliente1.run();
        cliente2.run();
        
        
        //Cajero a= new Cajero()
    }
}
