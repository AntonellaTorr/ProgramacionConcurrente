package Tp4.Ej11;

public class Test {
    public static void main(String[] args) {
        Comedor c= new Comedor();
        Mozo m1= new Mozo(c);
        Empleado e1= new Empleado(c, "Comida");
        Empleado e2= new Empleado(c, "Bebida");
        Empleado e3= new Empleado(c, "Ambas");
        Cocinero coc= new Cocinero(c);

        Thread mozo= new Thread(m1, "Mozo");
        Thread empleado= new Thread (e1, "Empleado1");
        Thread empleado2= new Thread (e2, "Empleado2");
        Thread empleado3= new Thread (e3, "Empleado3");
        Thread cocinero= new Thread (coc, "Cocinero");

        mozo.start();
        empleado.start();
        empleado2.start();
        empleado3.start();
        cocinero.start();



    }
}
