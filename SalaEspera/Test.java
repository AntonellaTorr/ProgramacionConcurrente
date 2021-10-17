package SalaEspera;

public class Test {

    public static void main(String[] args) {
        RecCompartido c= new RecCompartido();
        Hilos [] h= new Hilos [10];

        for (int j=0;j<h.length;j++){
            if (j%2==0){
                h[j]= new Hilos(c, 'A');
            }
            else{
                h[j]= new Hilos(c, 'B');
            }
           
        }
        for (int j=0;j<h.length;j++){
            h[j].start();
        }
    }
}
