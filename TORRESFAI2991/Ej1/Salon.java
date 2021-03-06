package TORRESFAI2991.Ej1;

import java.util.concurrent.Semaphore;

public class Salon {
    private Actividad telas;
    private Actividad acrobacia;
    private Actividad aro;
    //inicio de actividades para comunicar cuando todas las actividades estan completas
    //turno para controlar que por cada turno solo ingresen 12 personas
    //rotacion para que roten los 
    private Semaphore inicioActividades, comInicio,turno, mutex, rotacion, rendevouz;
    private int cantPersonasSaliendo;
    private boolean yaSeHizoRotacion;

    public Salon (int cupo){
        telas= new Actividad (cupo);
        acrobacia= new Actividad (cupo);
        aro= new Actividad (cupo);
        inicioActividades= new Semaphore(0);
        comInicio= new Semaphore(0);
        turno= new Semaphore(12);
        mutex= new Semaphore(1);
        rotacion= new Semaphore(0);
        rendevouz= new Semaphore(0);
        cantPersonasSaliendo=0;
        yaSeHizoRotacion=false;

    }
    public void esperarInicioTurno(){
        try {
            comInicio.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void comenzarActividad() {
        //
        try {
            inicioActividades.acquire(3);
            comInicio.release(12);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
   
    public void rotar(){
        try {
            mutex.acquire();
    
            telas.setCantAdentro(0);
            aro.setCantAdentro(0);
            acrobacia.setCantAdentro(0);
            yaSeHizoRotacion=true;
            mutex.release();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
     
        rotacion.release(12);
    }
      
    public void actualizarCantPersonasEnActividades (){
        try {
            rendevouz.acquire(12);
            
            mutex.acquire();
            telas.setCantAdentro(0);
            aro.setCantAdentro(0);
            acrobacia.setCantAdentro(0);
            mutex.release();

        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public void preparseParaProximoTurno(){
        try {
            mutex.acquire();
            yaSeHizoRotacion= false;
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    //METODOS DE LA PERSONA
    public void ingresarTurno(){
        try {
           
            turno.acquire();
            
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void hacerAcrobacias(){
        try {
            mutex.acquire();
            if (acrobacia.getCantAdentro()<acrobacia.getCupo()){
                acrobacia.setCantAdentro(acrobacia.getCantAdentro()+1);
                if (!yaSeHizoRotacion && acrobacia.getCantAdentro()==acrobacia.getCupo()){
                    inicioActividades.release();
                }
                mutex.release();
            }
            else{
                if (aro.getCantAdentro()<aro.getCupo()){
                    aro.setCantAdentro(aro.getCantAdentro()+1);
                    if (!yaSeHizoRotacion && aro.getCantAdentro()==aro.getCupo()){
                        inicioActividades.release();
                    }
                    mutex.release();
                }
                else{
                    if (telas.getCantAdentro()<telas.getCupo()){
                        telas.setCantAdentro(telas.getCantAdentro()+1);
                        if (!yaSeHizoRotacion &&  telas.getCantAdentro()==telas.getCupo()){
                            inicioActividades.release();
                        }
                        mutex.release();
                    }
                }

            }
           
        

        } catch (Exception e) {
            //TODO: handle exception
        }
    

      
        
    }
    public void hacerAro(){
        try {
            mutex.acquire();
            //si hay espacio ingresa sino busca una actividad libre
            if (aro.getCantAdentro()<aro.getCupo()){
                aro.setCantAdentro(aro.getCantAdentro()+1);
                if (!yaSeHizoRotacion &&  aro.getCantAdentro()==aro.getCupo()){
                    inicioActividades.release();
                }
                mutex.release();
            }
            else{
                if (telas.getCantAdentro()<telas.getCupo()){
                    telas.setCantAdentro(telas.getCantAdentro()+1);
                    if (!yaSeHizoRotacion &&  telas.getCantAdentro()==telas.getCupo()){
                        inicioActividades.release();
                    }
                    mutex.release();
                }
                else{
                    if (acrobacia.getCantAdentro()<acrobacia.getCupo()){
                        acrobacia.setCantAdentro(acrobacia.getCantAdentro()+1);
                        if (!yaSeHizoRotacion &&  acrobacia.getCantAdentro()==acrobacia.getCupo()){
                            inicioActividades.release();
                        }
                        mutex.release();
                    }
                }
            }
           
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }
    public void hacerTelas(){
        try {
            mutex.acquire();
            if (telas.getCantAdentro()<telas.getCupo()){
                telas.setCantAdentro(telas.getCantAdentro()+1);
                if (!yaSeHizoRotacion && telas.getCantAdentro()==telas.getCupo()){
                    inicioActividades.release();
                }
                mutex.release();
            }
            else{
                if (acrobacia.getCantAdentro()<acrobacia.getCupo()){
                    acrobacia.setCantAdentro(acrobacia.getCantAdentro()+1);
                    if (!yaSeHizoRotacion &&  acrobacia.getCantAdentro()==acrobacia.getCupo()){
                        inicioActividades.release();
                    }
                    mutex.release();
                }
                else{
                    if (aro.getCantAdentro()<aro.getCupo()){
                        aro.setCantAdentro(aro.getCantAdentro()+1);
                        if (!yaSeHizoRotacion &&  aro.getCantAdentro()==aro.getCupo()){
                            inicioActividades.release();
                        }
                        mutex.release();
                    }
                }

            }
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
       
       
    }
    public void irseTurno(){
        try {
            rendevouz.release();
            mutex.acquire();
            cantPersonasSaliendo++;
            System.out.println ("Cuando "+ Thread.currentThread().getName()+ "se fue habia "+cantPersonasSaliendo + "saliendo");
            if (cantPersonasSaliendo==12){
                turno.release(12);
                cantPersonasSaliendo=0;
            }
            mutex.release();
           
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public void rotarPersona(){
        try {
            rotacion.acquire();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


  
    
}


/*Hay un sal??n donde se practican distintas actividades de acrobacia a??rea. Acro telas, Lyra
acrob??tica y yoga en aro.
Cada actividad tiene cupo para 4 personas. Y cada persona puede optar por realizar dos de
ellas por turno, puesto que cada actividad es de media hs. Cada turno es de 1hs y tiene
capacidad para 12 personas.
La actividad comienza cuando est??n los cupos llenos de las 3 actividades. Luego, cuando
rotan de actividad, puede ocurrir que m??s de 4 personas quieran realizar una actividad, en
ese caso, la persona debe optar por una de las actividades que queden disponibles,
evitando (en lo posible) realizar la misma actividad inicial.*/