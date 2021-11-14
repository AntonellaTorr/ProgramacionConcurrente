package Tp5.Ej6Babuinos;

import java.util.concurrent.Semaphore;

public class Puente {
    private Semaphore exclusion, mutex, rendevous, babuinosI, babuinosD;
    private char cruzando;
    private int cantCruzando;


 
    

    public void cruzar (char lado){
        if (lado=='I'){

        }
        else{

        }
        try {
            if (cantCruzando==0){
                exclusion.acquire();
                cruzando=lado;
                cantCruzando++;
            }
            else{
                if (cruzando==lado){
                    if (cantCruzando<5){
                        cantCruzando++;
                    }
                    

                }
            }
           
        }catch(InterruptedException e){

        }
          
    }
    public void llegar(char lado){
        try {
            if (cantCruzando==0){
                exclusion.acquire();
                cruzando=lado;
                cantCruzando++;
            }   
        } catch (Exception e) {
            
        }
    }
    private void  cruzarIzquierda(){
        try {
            //si estan cruzando los de la izquierda
            if (cruzando=='I'){
                //y cruzan menos de 5 paso
                if (cantCruzando<5){
                    cantCruzando++;
                }else{
                    //espera que le den permiso
                    babuinosI.acquire();
                    cantCruzando++;
                }              

            }        
        } catch (Exception e) {
            e.printStackTrace();    
        }      
    
            
    }
    private void  cruzarDerecha(){
        try {
            //si estan cruzando los de la derecha
            if (cruzando=='D'){
                //y cruzan menos de 5 paso
                if (cantCruzando<5){
                    cantCruzando++;
                }else{
                    //espera que le den permiso
                    babuinosD.acquire();
                    cantCruzando++;
                }              

            }        
        } catch (Exception e) {
            e.printStackTrace();    
        }      
    
    }
    public void irseDerecha(){
        if (cantCruzando==1){
            cantCruzando--;
            exclusion.release();
            babuinosD.release();
        }
    }
}