package PracticaParcial.EjComedero;

public class Test {
    public static void main(String[] args) {
        Comedor c= new Comedor(2);
        System.out.println ("Ingrese la cantidad de perros que desea crear");
        int cantPerros= TecladoIn.readLineInt();
        System.out.println ("Ingrese la cantidad de gatos que desea crear");
        int cantGatos= TecladoIn.readLineInt();

        Thread [] perros= new Thread [cantPerros];
        Thread [] gatos= new Thread [cantGatos];


        for (int i=0; i<cantPerros;i++){
            perros[i]=new Thread(new Perro(c),"Perro".concat(Integer.toString(i)));
        }
        for (int i=0; i<cantGatos;i++){
            gatos[i]=new Thread(new Gato(c),"Gato".concat(Integer.toString(i)));
            
        }
        for (int j=0;j<cantPerros;j++){
            perros[j].start();
        }
        for (int j=0;j<cantPerros;j++){
            gatos[j].start();
        }

    }
}
