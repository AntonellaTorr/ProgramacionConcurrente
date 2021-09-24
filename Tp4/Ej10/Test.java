package Tp4.Ej10;

public class Test {
    public static void main(String[] args) {
        Comedor c= new Comedor();
        Mozo m1= new Mozo(c);
        Empleado e1= new Empleado(c);
        Empleado e2= new Empleado(c);

        Thread mozo= new Thread(m1, "Mozo");
        Thread empleado= new Thread (e1, "Empleado1");
        Thread empleado2= new Thread (e2, "Empleado2");

        mozo.start();
        empleado.start();
        empleado2.start();



    }
}
