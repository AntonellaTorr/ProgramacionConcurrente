package Tp5.Ej1;

import java.util.concurrent.Semaphore;

public class Comedor {
    private int cantidadPlatos;
    private char comiendo;
    private Semaphore mutex, platosP, platosG, rendezvous;
    private int cantPerrosEsperando,cantGatosEsperando,cantPerrosComiendo,cantGatosComiendo;

    public Comedor (int cantPlatos){
        this.cantidadPlatos=cantPlatos;
        this.comiendo=randomIngreso();
        System.out.println ("Empiezan a comer-------->"+comiendo);
        this.rendezvous=new Semaphore (0);
        this.mutex=new Semaphore (1);
        this.platosP=new Semaphore (cantPlatos);
        this.platosG=new Semaphore (cantPlatos);
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
                System.out.println (Thread.currentThread().getName() +" no pudo ingresar, espera");
                cantPerrosEsperando++;
                mutex.release();
                //espera que el ultimo gato que se vaya le libere el permiso
                rendezvous.acquire();
                System.out.println (Thread.currentThread().getName() +" puede agarrar un plato");
            }
            platosP.acquire();
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
                rendezvous.acquire();
            }
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

                for (int i=0;i<cantidadPlatos;i++){
                    //libero a todos los gatos que estaban esperando el permiso 
                    rendezvous.release();
                }
                
              
            }else{
                if (cantGatosEsperando==0 && cantPerrosEsperando>=1){
                    rendezvous.release();
                }
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
            if (/*(cantGatosComiendo==0 && */cantPerrosEsperando>=1){
                cantPerrosEsperando--;
                comiendo='P';
                mutex.release();
               
                for (int i=0;i<cantidadPlatos;i++){
                    //libero a todos los perros que estaban esperando el permiso 
                    rendezvous.release();
                }

            }else{
                if (cantPerrosEsperando==0 && cantGatosEsperando>=1){
                    rendezvous.release();
                }
                mutex.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

