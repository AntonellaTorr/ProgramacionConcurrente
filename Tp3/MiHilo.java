package Tp3;
    class MiHilo implements Runnable {
        Thread hilo;
        static sumaMatriz sumaM= new sumaMatriz();
        int arr[];
        int resp;
        //Construye un nuevo hilo.
        MiHilo(String nombre, int nums[]){
            hilo= new Thread(this,nombre);
            arr=nums;
        }
        //Un método que crea e inicia un hilo
        public static MiHilo creaEInicia (String nombre,int nums[]){
            MiHilo miHilo=new MiHilo(nombre,nums);
            miHilo.hilo.start(); //Inicia el hilo
        return miHilo;
        }
        //Punto de entrada del hilo
        public void run(){
            int sum;
            System.out.println(hilo.getName()+ " iniciando.");
            synchronized (sumaM){
                resp=sumaM.sumMatriz(arr);
                System.out.println("Sali del metodo run");
                System.out.println("Suma para "+hilo.getName()+ " es "+resp);
                System.out.println(hilo.getName()+ " terminado.");
            }
            
        }
    }
