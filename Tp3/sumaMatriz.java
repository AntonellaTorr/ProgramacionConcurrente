package Tp3;

public class sumaMatriz {
    private int sum;
    int sumMatriz(int[]  nums) {
        sum=0;
        for (int i=0; i<nums.length;i++){
                sum+=nums[i];  
                System.out.println("Total acumulado de "+Thread.currentThread().getName()+"es "+sum);
                try {
                    Thread.sleep(10);//permitir el cambio de tarea
                }catch (InterruptedException exc){
                    System.out.println("Hilo interrumpido");
                }
                catch(NullPointerException e){
                    System.out.println ("ERROR");
                }
        }
        return sum;
    }
}
