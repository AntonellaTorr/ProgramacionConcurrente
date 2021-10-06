package PracticaParcial.EjComedero;

import java.util.concurrent.Semaphore;

public class Comedor {
    private int cantComederos;
    private char comiendo;
    private int cantComederosLibres=cantComederos;
    private int cantGatosEsperando=0;
    private int cantPerrosEsperando=0;
    private static Semaphore esperaGatos= new Semaphore(1);
    private static Semaphore esperaPerros= new Semaphore(1);
    private static Semaphore mutex= new Semaphore(1);
    private static Semaphore mutexCantPerrosEsperando= new Semaphore (1);
    private static Semaphore mutexCantGatosEsperando= new Semaphore (1);
    //para proteger comiendo
    private static Semaphore mutexAnimalComiendo= new Semaphore(1);

    public Comedor (int cant){
        int  cantComederos=cant;
        char comiendo='P';//this.elegirQuienEmpieza();
        System.out.println ("Empiezan los "+comiendo);


    }
    public void gatoEntrarAComer(){
        try{
            //acquire de mutexAnimal para proteger acceso a la variable comiendo
            mutexAnimalComiendo.acquire();
            if (comiendo=='G'){                
                mutexAnimalComiendo.release();
                //acquire de mutex para proteger acceso a cantComederosLibres

                mutex.acquire();

                if (cantComederosLibres==0){
                    System.out.println ("Estan comiendo los gatos pero no hay platos libres " +Thread.currentThread().getName() +" espera");
                    
                    //si no hay comederos se queda esperando
                    mutex.release();
                    mutexCantGatosEsperando.acquire();
                    cantGatosEsperando++;
                    mutexCantGatosEsperando.release();

                    //adquiere sem
                    esperaGatos.acquire();
                    System.out.println (Thread.currentThread().getName() +" liberaron su permiso");
                    //una vez que el gato pudo entrar se restan la cantidad de gatos esperando y se restan la can de comederos libres 

                    mutexCantGatosEsperando.acquire();
                    cantGatosEsperando--;
                    mutexCantGatosEsperando.release();

                    mutex.acquire();
                    cantComederosLibres--;
                    mutex.release();
                }
                else{
                    System.out.println (Thread.currentThread().getName() +" entro a comer");
                    cantComederosLibres--;
                    mutex.release();
                }            
            }
            else{
                System.out.println ("Estan comiendo los perros "+Thread.currentThread().getName() + " intento ingresar y no pudo ");
                mutexAnimalComiendo.release();

                esperaGatos.acquire();
                System.out.println (Thread.currentThread().getName() +" liberaron su permiso");

                mutexCantGatosEsperando.acquire();
                cantGatosEsperando--;
                mutexCantGatosEsperando.release();

                mutex.acquire();
                cantComederosLibres--;
                mutex.release();


            }
        }catch (InterruptedException e){}
    }
   
    public void perroEntrarAComer(){
        try{
            //acquire de mutexAnimal para proteger acceso a la variable comiendo
            mutexAnimalComiendo.acquire();
            if (comiendo=='P'){
                
                mutexAnimalComiendo.release();
                //acquire de mutex para proteger acceso a cantComederosLibres

                mutex.acquire();

                if (cantComederosLibres==0){
                    System.out.println ("Estan comiendo los perros pero no hay platos libres " +Thread.currentThread().getName() +" espera");
                    //si no hay comederos se queda esperando
                    mutex.release();
                    mutexCantPerrosEsperando.acquire();
                    cantPerrosEsperando++;
                    mutexCantPerrosEsperando.release();

                    //adquiere sem
                    esperaPerros.acquire();
                    System.out.println (Thread.currentThread().getName() +" liberaron su permiso");
                    //una vez que el gato pudo entrar se restan la cantidad de gatos esperando y se restan la can de comederos libres 

                    mutexCantPerrosEsperando.acquire();
                    cantPerrosEsperando--;
                    mutexCantPerrosEsperando.release();

                    mutex.acquire();
                    cantComederosLibres--;
                    mutex.release();
                }  
                else{
                    System.out.println (Thread.currentThread().getName() +" entro a comer");
                    cantComederosLibres--;
                    mutex.release();
                }              
            }
            else{
                System.out.println ("Estan comiendo los gatos "+Thread.currentThread().getName() + " intento ingresar y no pudo ");
                mutexAnimalComiendo.release();

                esperaPerros.acquire();
                System.out.println (Thread.currentThread().getName() +" liberaron su permiso");

                mutexCantPerrosEsperando.acquire();
                cantPerrosEsperando--;
                mutexCantPerrosEsperando.release();

                mutex.acquire();
                cantComederosLibres--;
                mutex.release();

            }
        }catch (InterruptedException e){}
    }

    public void saleDeComerGato (){
       try {

           //adquiere mutex para proteger variable compartida
           mutex.acquire();
           cantComederosLibres++;
           System.out.println (Thread.currentThread().getName() +" se va");
           mutex.release();

            // DE NUEVO adquiere mutex para proteger acceso a cantComederosLibres
           mutex.acquire();
            //cuando se va el ultimo gato
           if (cantComederosLibres==cantComederos){
             
               mutex.release();
               
              //mutexAnimal para proteger variable comiendo 
               mutexAnimalComiendo.acquire();
               mutexCantPerrosEsperando.acquire();

               if (cantPerrosEsperando>=1){
                 System.out.println (Thread.currentThread().getName() +" era el ultimo gato comiendo pero habian perros esperando, lo deja pasar");
                    mutexCantPerrosEsperando.release();

                    //se les da el paso a los perros
                    comiendo='P';
                    mutexAnimalComiendo.release();

                    esperaPerros.release();//hacer un release del sem donde estan trabados los perros
               }
               else{
                   //si no hay perros esperando pero si gatos
                   mutexCantGatosEsperando.acquire();
                   if (cantGatosEsperando>=1){
                    System.out.println (Thread.currentThread().getName() +" era el ultimo gato comiendo como no habian perros esperando, deja pasar mas gatos");
                       comiendo='G';
                       mutexAnimalComiendo.release();
                       mutexCantGatosEsperando.release();
                       
                       esperaGatos.release();//release del sem donde estan trabados los gatos 
                   }

               }
           }
       } catch (Exception e) {
       }

    }
    public void saleDeComerPerro (){
         try {

           //adquiere mutex para proteger variable compartida
           mutex.acquire();
           cantComederosLibres++;
           System.out.println (Thread.currentThread().getName() +" se va");
           mutex.release();

            // DE NUEVO adquiere mutex para proteger acceso a cantComederosLibres
           mutex.acquire();
            //cuando se va el ultimo gato
           if (cantComederosLibres==cantComederos){
               mutex.release();
               
              //mutexAnimal para proteger variable comiendo 
               mutexAnimalComiendo.acquire();
               
               mutexCantGatosEsperando.acquire();

               if (cantGatosEsperando>=1){
                  System.out.println (Thread.currentThread().getName() +" era el ultimo perro comiendo pero habian gatos esperando, los deja pasar");
                   mutexCantGatosEsperando.release();

                    //se les da el paso a los gatos
                    comiendo='G';
                    mutexAnimalComiendo.release();
                    
                    esperaGatos.release();//hacer un release del sem donde estan trabados los perros
               }
               else{
                   //si no hay perros esperando pero si gatos
                   mutexCantPerrosEsperando.acquire();
                   if (cantPerrosEsperando>=1){
                    System.out.println (Thread.currentThread().getName() +" era el ultimo perro comiendo como no habian gatos esperando, deja pasar mas perros");
                       comiendo='P';
                       mutexAnimalComiendo.release();
                       mutexCantGatosEsperando.release();
                       
                       esperaPerros.release();//release del sem donde estan trabados los gatos 
                   }

               }
           }
       } catch (Exception e) {
       }
 
     }
  
    public char elegirQuienEmpieza(){
        char letra;
        if (Math.floor(Math.random())%2==0){
            letra='G';
        }
        else{
            letra='P';
        }
        return letra;
    
    }

}
