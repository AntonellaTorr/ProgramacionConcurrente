package Tp5.Ej1b;

import java.util.concurrent.Semaphore;

public class Comedor {
    private int cantPlatos,platosOcupados, contador; 
    private char ocupaPlato;
    private Semaphore mutex, platos, espera;

    public void entrar(char raza){
        try {
            mutex.acquire();
            if (platosOcupados==0 && contador<cantPlatos){
                    if (raza== 'P'){
                        ocupaPlato='P';
                    
                    }else{
                        ocupaPlato='G';
                    }
                platosOcupados++;
                contador++;
                mutex.release();
                platos.acquire();
            }else{
                mutex.release();
                if (raza!= ocupaPlato){
                    espera.acquire();   
                }
                mutex.acquire();
                platosOcupados++;
                contador++;
                mutex.release();
                platos.acquire();
                
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
    public void salir (){
        try {
            mutex.acquire();
            if (contador==cantPlatos){
               /* if (x==1){

                }*/
            }
       
        } catch (Exception e) {
            //TODO: handle exception
        }
      

    }
}
