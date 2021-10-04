package PracticaParcial.EjAutos;

public class Test {
    public static void main(String[] args) {
        Thread hiloControl= new Thread (new HiloDeControl());
        System.out.println ("Ingrese la cantidad de autos");
        int cant=TecladoIn.readInt();
        String lados[]= new String[2];
        lados[0]="Norte";
        lados[1]="Oeste";
        int m=0;
 
        Thread [] autos= new Thread[cant];
        hiloControl.start();
        for (int i=0;i<cant;i++){
            autos[i]= new Thread(new Auto(lados[m]));
            if ((i%2) == 0){
                m=1;
            }
            else{
                m=0;
            }
        }
        for (int j=0;j<cant;j++){
            autos[j].start();
        }
     
    }
}
