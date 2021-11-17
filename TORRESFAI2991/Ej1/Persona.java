package TORRESFAI2991.Ej1;

public class Persona implements Runnable {
    private Salon s;
    private String primerActividad, segundaActividad;
    public Persona (Salon s,String primerActividad, String segundaActividad){
        this.s=s;
        this.primerActividad=primerActividad;
        this.segundaActividad=segundaActividad;

    }
    public void run (){
        //la persona llega al salon
        System.out.println (Thread.currentThread().getName() +" llego");
        s.ingresarTurno();
        System.out.println (Thread.currentThread().getName() +" logro ingresar en el turno");
        //ingresa a la 1 actividad
        ingresarAActividad(primerActividad);
     
        //realiza la actividad
        s.esperarInicioTurno();
        System.out.println (Thread.currentThread().getName() +" comienza  la primeractividad");
        realizarActividad();
        System.out.println (Thread.currentThread().getName() +" finalizo la primer actividad y  rota");
        //rota
        s.rotarPersona();
        //ingresa a realizar la segunda actividad
        System.out.println (Thread.currentThread().getName() +" ingresa a la segunda ctividad");
        ingresarAActividad(segundaActividad);
        //la realiza
        realizarActividad();
        //se va
       
        s.irseTurno();
        System.out.println (Thread.currentThread().getName() +" se va ");



    }
    public void realizarActividad(){
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void ingresarAActividad(String act){
        if (act.equalsIgnoreCase("Aro")){
            s.hacerAro();
        }
        else{
            if (act.equalsIgnoreCase("Telas")){
                s.hacerTelas();
            }
            else{
                if (act.equalsIgnoreCase("Acrobacia")){
                    s.hacerAcrobacias();
                }
            }
        }

    }



}
