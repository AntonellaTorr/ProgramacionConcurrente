package TORRESFAI2991.Ej1;

public class Actividad {
    private int cupo;
    private int cantAdentro;

    public Actividad (int cupo){
        this.cupo=cupo;
    }
    public int getCantAdentro(){
        return cantAdentro;
    }
    public void setCantAdentro(int cant){
        this.cantAdentro=cant;
    }
    public int getCupo(){
        return cupo;
    }
}
