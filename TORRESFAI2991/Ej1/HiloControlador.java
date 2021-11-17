package TORRESFAI2991.Ej1;

public class HiloControlador implements Runnable {
    private Salon s;

    public HiloControlador(Salon s){
        this.s=s;
    }
    public void run (){

        while (true){
         
            s.comenzarActividad();
            System.out.println ("--------------------------------EMPLEADO HABILITA AL INICIO DE ACTIVIDADES----------------------------------");
            esperarTiempoActividad();
            s.rotar();
            esperarTiempoActividad();
            s.actualizarCantPersonasEnActividades();
            s.preparseParaProximoTurno();
        }
       



    }
    public void esperarTiempoActividad (){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
