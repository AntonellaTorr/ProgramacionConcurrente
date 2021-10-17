package SalaEspera;

import java.util.concurrent.Semaphore;

public class RecCompartido {
    private int cantAsientos;
    private int cantLibres;
    private Semaphore esperarSillaA;
    private Semaphore esperarSillaB;
    //mutex para proteger la seccion critica, donde pregunto por la variable compartida y actuo 
    private Semaphore mutex;
    private int cantEsperandoA;
    private int cantEsperandoB;
    private char ocupando;
    //controla acceso a secciones criticas donde se modifique la cantidad de cada tipo esperando
    private Semaphore mutexCantA;
    private Semaphore mutexCantB;


    public RecCompartido(){
        ocupando='B';
        cantAsientos=2;
        cantLibres=2;
        cantEsperandoA=0;
        cantEsperandoB=0;
        mutex= new Semaphore (1);
        esperarSillaA= new Semaphore(0);
        esperarSillaB= new Semaphore(0);
        mutexCantB= new Semaphore(1);
        mutexCantA= new Semaphore(1);

    }

    public void intentarIngresarA(){
        try {
            //System.out.println (Thread.currentThread().getName()+" de tipo A,intenta tomar mutex");
            mutex.acquire();
            //System.out.println (Thread.currentThread().getName()+" de tipo A,tomo el mutex finalmente");

            if (ocupando=='A'){
                if (cantLibres==0){
                    System.out.println (Thread.currentThread().getName() +"de tipoA, intenta ingresar pero no hay sillas" );
                    mutex.release();

                    mutexCantA.acquire();
                    cantEsperandoA++;
                    mutexCantA.release();
                   
                    System.out.println (Thread.currentThread().getName() +" esta esperando una silla..." );
                    esperarSillaA.acquire();
                    //luego de que se logro hacer el acquiere, quiere decir que alguien libero una silla, entonces entra una persona y ocupa un asiento
                    
                    mutexCantA.acquire();
                    cantEsperandoA--;
                    mutexCantA.release();

                    mutex.acquire();
                    System.out.println ("Se desocupo una silla "+Thread.currentThread().getName() +" logra ingresar" );
                    cantLibres--;
                    mutex.release();
                }
                else{
                    System.out.println (Thread.currentThread().getName() +" logra ingresar, de tipo A, cantidad de asientos libres antes de que el lo tome "+cantLibres);
                    cantLibres--;
                    mutex.release();
                }
            }
            else{
                //System.out.println (Thread.currentThread().getName() +"linea  69");
                mutex.release();
                //espera la silla
                mutexCantA.acquire();
                cantEsperandoA++;
                mutexCantA.release();
                esperarSillaA.acquire();
               // System.out.println (Thread.currentThread().getName() +"abajo sem silla ");
              
                //modifica variable compartida entre hilos de tipo A
                mutexCantA.acquire();
                //System.out.println (Thread.currentThread().getName() +"mutex cant a ");
                cantEsperandoA--;
                mutexCantA.release();
                //modifica variable compartida entre todos los hilos
                mutex.acquire();
               // System.out.println (Thread.currentThread().getName() +"mutex acquiere  ");
                cantLibres--;
                System.out.println ("Se desocupo una silla "+Thread.currentThread().getName() +", de tipo A, logra ingresar" );
                mutex.release();


            }
        } catch (Exception e) {
            //TODO: handle exception
        }

    }
    public void intentarIngresarB(){
        try {
            mutex.acquire();
            if (ocupando=='B'){
                if (cantLibres==0){
                    System.out.println (Thread.currentThread().getName() +", de tipoB, intenta ingresar pero no hay sillas" );
                    mutex.release();

                    mutexCantB.acquire();
                    cantEsperandoB++;
                    mutexCantB.release();
                   
                    System.out.println (Thread.currentThread().getName() +" esta esperando una silla..." );
                    esperarSillaB.acquire();
                    //luego de que se logro hacer el acquiere, quiere decir que alguien libero una silla, entonces entra una persona y ocupa un asiento
                    //Verificar el lugar del mensaje
                    System.out.println ("Se desocupo una silla "+Thread.currentThread().getName() +", de tipoB logra ingresar" );
                    mutexCantB.acquire();
                    cantEsperandoB--;
                    mutexCantB.release();

                    mutex.acquire();
                    System.out.println ("Se desocupo una silla "+Thread.currentThread().getName() +", de logra ingresar" );
                    cantLibres--;
                    mutex.release();
                }
                else{
                    System.out.println (Thread.currentThread().getName() +", de tipoB, logra ingresar, cantidad de asientos libres antes de que el lo tome "+cantLibres);
                    cantLibres--;
                    mutex.release();
                }
            }
            else{
                mutex.release();

                mutexCantB.acquire();
                cantEsperandoB++;
                mutexCantB.release();
                //espera la silla
                esperarSillaB.acquire();
              
                //modifica variable compartida entre hilos de tipo A
                mutexCantB.acquire();
                cantEsperandoB--;
                mutexCantB.release();
                //modifica variable compartida entre todos los hilos
                mutex.acquire();
                cantLibres--;
                System.out.println ("Se desocupo una silla "+Thread.currentThread().getName() +",de tipoB, logra ingresar" );
                mutex.release();


            }
        } catch (Exception e) {
        }

    }
    public void irseA(){
        try{
            mutex.acquire();
            System.out.println (Thread.currentThread().getName() +", de tipoA se va");
            //desocupa una silla
            cantLibres++;
            mutex.release();
            //acquiere de mutex para proteger acceso a cantEsperandoB
            mutexCantB.acquire();
            System.out.println ("Cuando " +Thread.currentThread().getName() +", de tipoA, se va hay "+cantEsperandoB+ " personas esperando de tipoB");
            //si ademas habia alguien esperando habilita el permiso
            if (cantEsperandoB>=1){
                mutexCantB.release();
                esperarSillaB.release();
            }
            else{
                mutexCantB.release();
                //si cuando se va habia de tipos A esperando entonces les da el paso
                mutexCantA.acquire();
                System.out.println ("Cuando " +Thread.currentThread().getName() +", de tipoA, se va hay "+cantEsperandoA+ " personas esperando de tipoA");
                if (cantEsperandoA>=1){
                    mutexCantA.release();

                    esperarSillaA.release();

                }else{
                    mutexCantA.release();
                }
                
            }
           

        }catch(InterruptedException e){
            e.printStackTrace();

        } 

    }
    public void irseB(){
        try{
            mutex.acquire();
            System.out.println (Thread.currentThread().getName() +", de tipoB, se va");
            //desocupa una silla
            cantLibres++;
            mutex.release();
            //acquiere de mutex para proteger acceso a cantEsperandoA
            mutexCantA.acquire();
            System.out.println ("Cuando " +Thread.currentThread().getName() +", de tipoB se va, de tipob,  hay "+cantEsperandoA+ " personas esperando de tipoA");
            //si ademas habia alguien esperando habilita el permiso
            if (cantEsperandoA>=1){
                mutexCantA.release();
                esperarSillaA.release();
            }
            else{
                mutexCantA.release();
                //si cuando se va habia de tipos A esperando entonces les da el paso
                mutexCantB.acquire();
                System.out.println ("Cuando " +Thread.currentThread().getName() +", de tipoB, se va hay "+cantEsperandoB+ " personas esperando de tipoB");
                if (cantEsperandoB>=1){
                    mutexCantB.release();

                    esperarSillaB.release();

                }else{
                    mutexCantB.release();
                }
            }
           

        }catch(InterruptedException e){
            e.printStackTrace();

        } 

    }





    /*

    public void intentarIngresar(){
        try {
            mutex.acquire();
            if (cantLibres==0){
                System.out.println (Thread.currentThread().getName() +" intenta ingresar pero no hay sillas" );
                cantEsperando++;
                mutex.release();
                System.out.println (Thread.currentThread().getName() +" esta esperando una silla..." );
                esperarSilla.acquire();
                //luego de que se logro hacer el acquiere, quiere decir que alguien libero una silla, entonces entra una persona y ocupa un asiento
                mutex.acquire();
                System.out.println ("Se desocupo una silla "+Thread.currentThread().getName() +" logra ingresar" );
                cantEsperando--;
                cantLibres--;
                mutex.release();
            }
            else{
                System.out.println (Thread.currentThread().getName() +" logra ingresar, cantidad de asientos libres antes de que el lo tome "+cantLibres);
                cantLibres--;
                mutex.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
      
       
    }

    public void irse(){
        try{
            mutex.acquire();
            System.out.println (Thread.currentThread().getName() +" se va");
            //desocupa una silla
            cantLibres++;
            System.out.println ("Cuando " +Thread.currentThread().getName() +" se va hay "+cantEsperando+ " personas esperando");
            //si ademas habia alguien esperando habilita el permiso
            if (cantEsperando>=1){
                esperarSilla.release();
            }
            mutex.release();

        }catch(InterruptedException e){
            e.printStackTrace();

        }
        
  

      

    }*/
    
}
