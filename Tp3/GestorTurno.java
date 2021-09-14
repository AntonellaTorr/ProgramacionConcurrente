package Tp3;

public class GestorTurno {
    private int num;

    public GestorTurno(){
       num=0;
    }
    public int getNum(){
        return this.num;
    }
    public int siguienteTurno(){
        num=(num+1)%3;
        return num;
    }


}
