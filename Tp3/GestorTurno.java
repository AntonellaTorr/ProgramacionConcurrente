package Tp3;

public class GestorTurno {
    private int num;
    private int limite;

    public GestorTurno(int limite){
       num=1;
       this.limite=limite;
    }
    public synchronized int getTurno(){
        return this.num;
    }
    public synchronized int siguienteTurno(){
        if (num==limite){
            num=1;
        }
        else{
            num++;
        }
        return num;
    }


}
