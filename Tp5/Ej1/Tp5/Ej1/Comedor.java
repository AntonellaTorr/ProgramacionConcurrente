package Tp5.Ej1;

import java.util.concurrent.Semaphore;

public class Comedor {
    private int cantidadPlatos;
    private char comiendo;
    private Semaphore mutex, platosP, platosG;
    private int cantPerrosEsperando,cantGatosEsperando,cantPerrosComiendo,cantGatosComiendo;

    public Comedor (int cantPlatos){
        this.cantidadPlatos=cantPlatos;
        this.comiendo=randomIngreso();
        System.out.println ("Empiezan a comer-------->"+comiendo);
    
        this.mutex=new Semaphore (1);
        if (comiendo=='P'){
            
            this.platosP=new Semaphore (cantPlatos);
            System.out.println ("permisos semPerros "+platosP.availablePermits());
            this.platosG= new Semaphore(0);
            System.out.println ("permisos semPerros "+platosG.availablePermits());
        }else{
           
            this.platosG=new Semaphore (cantPlatos);
            System.out.println ("permisos semPerros "+platosP.availablePermits());
           
            this.platosP= new Semaphore(0);
            System.out.println ("permisos semPerros "+platosG.availablePermits());

        }
    }
    public char randomIngreso (){
        char com='G';
        if ((int)Math.random()*11%2==0){
            com='P';
        }
        return com;
    }
    public void ingresarAComerPerro(){
        try {
            mutex.acquire();
            if (comiendo =='P'){
                mutex.release();

            }else{
                cantPerrosEsperando++;
                mutex.release();
            }
            System.out.println ("permisos antes de acquire" +platosP.availablePermits());
            platosP.acquire();
            System.out.println ("permisos despues de acquire" +platosP.availablePermits());
            incrementarCantPerroComiendo();
        } catch (Exception e) {}

    }
    public void incrementarCantPerroComiendo(){
        try {
            mutex.acquire();
            cantPerrosComiendo++;
            mutex.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ingresarAComerGato(){
        try {
            mutex.acquire();
            if (comiendo =='G'){
                mutex.release();
            }else{
                cantGatosEsperando++;
                mutex.release();
                //espera que el ultimo perro que se vaya le libere el permiso
            }
            System.out.println ("metodo comer gato, permisos sem antes del acquire" +platosG.availablePermits());
            platosG.acquire();
            incrementarCantGatoComiendo();
        } catch (Exception e) {}

    }
    public void incrementarCantGatoComiendo(){
        try {
            mutex.acquire();
            cantGatosComiendo++;
            mutex.release();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public void liberarPlatoPerro(){
        try {
            //acquire de mutex para 

            platosP.release();
            System.out.println (Thread.currentThread().getName()+ "deja el plato y se va ");

            mutex.acquire();
            cantPerrosComiendo--;
            if (cantPerrosComiendo==0 && cantGatosEsperando>=1){
                cantGatosEsperando--;
                comiendo='G';
                mutex.release();
                System.out.println ("Habain gatos esperando cantidad de permisos de su semaforo "+platosG.availablePermits());
                platosG.release(cantidadPlatos);
                System.out.println ("Habain gatos esperando cantidad de permisos de su semaforo luego de liberar "+platosG.availablePermits());
              
            }else{
                //sino entran los perros
                mutex.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void liberarPlatoGato(){
        try {
            mutex.acquire();
            platosG.release();
            System.out.println (Thread.currentThread().getName()+ "deja el plato y se va ");

            cantGatosComiendo--;
            if (cantGatosComiendo==0 && cantPerrosEsperando>=1){
                cantPerrosEsperando--;
                comiendo='P';
                mutex.release();
               
                platosP.release(cantidadPlatos);

            }else{
                //entran de nuevo los gatos
                mutex.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void liberarPlatoGato2(){
        try {
            if (cantGatosComiendo==cantidadPlatos && cantPerrosEsperando>=1){

            }
            mutex.acquire();
            platosG.release();
            System.out.println (Thread.currentThread().getName()+ "deja el plato y se va ");

            cantGatosComiendo--;
            if (cantGatosComiendo==0 && cantPerrosEsperando>=1){
                cantPerrosEsperando--;
                comiendo='P';
                mutex.release();
               
                platosP.release(cantidadPlatos);

            }else{
                //entran de nuevo los gatos
                mutex.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

