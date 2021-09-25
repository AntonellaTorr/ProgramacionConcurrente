package Tp4.Ej10;

public class Empleado implements Runnable {
    private Comedor c;
    public Empleado (Comedor c){
        this.c=c;
    }
    public void run (){
        c.ingresarAlComedor();
        c.solicitarComida();
        c.esperarComida();
        c.irseDelComedor();
        //sleep para simular que come

    }
}
