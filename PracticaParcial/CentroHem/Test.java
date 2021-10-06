package PracticaParcial.CentroHem;



public class Test {
    
    public static void main(String[] args) {
        Thread recepcionista= new Thread(new Recepcionista());
        Thread medicoClinico= new Thread(new MedicoClinico());
        Thread medicoSangre= new Thread(new MedicoSangre());
        System.out.println ("Ingrese la cantidad de donantes");
        int cant=TecladoIn.readInt();

        Thread [] donantes= new Thread[cant];

        for (int i=0;i<cant;i++){
            System.out.println ("Ingrese el nombre");
            String nombre= TecladoIn.readLine();
            donantes[i]= new Thread(new Persona (), nombre);
        }
        for (int j=0;j<cant;j++){
            donantes[j].start();
        }
        recepcionista.start();
        medicoClinico.start();
        medicoSangre.start();


        

    }
}
