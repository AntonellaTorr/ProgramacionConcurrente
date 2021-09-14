package Tp3;

public class HiloSumador implements Runnable {

        static SumaArreglo sumaA= new SumaArreglo();
        int arr[];
        int sumaParcial;
        int posFinal;
        int posIni;
        //Construye un nuevo hilo.
        HiloSumador(int nums[], int posIni,int posFinal){
            arr=nums;
            this.sumaParcial=0;
            this.posIni=posIni;
            this.posFinal=posFinal;
        }
        //Punto de entrada del hilo
        public void run(){
            synchronized (sumaA){
                sumaParcial=sumaA.sumArreglo(arr,posIni,posFinal);
            }
            
            
        }

        public int getSumaParcial(){
            return sumaParcial;
        }

    }

