package Tp3;

public class SumaArreglo {
    private int sum;
    public SumaArreglo (){
        sum=0;
    }
    int sumArreglo(int nums[],int inicio,int fin){
        sum=0;
        for (int i=inicio; i<fin;i++){
            sum=sum+nums[i];
            /*try {
                Thread.sleep(10);//permitir el cambio de tarea
            }catch (InterruptedException exc){
                System.out.println("Hilo interrumpido");
            }*/

        }
    return sum;
    }
}
