package Tp6;

public class Test {
    public static void main(String[] args) {
        Thread [] autos= new Thread [10];
        GestionaTrafico g= new GestionaTrafico();
        for (int i=0; i<5; i++){
            autos[i]= new Thread( new Auto ('S',g), "Auto".concat(Integer.toString(i)));
        }
        for (int i=5; i<10; i++){
            autos[i]= new Thread( new Auto ('N',g),"Auto".concat(Integer.toString(i)));
        }
        for (int i=0; i<10; i++){
            autos[i].start();
        }
    }
}
