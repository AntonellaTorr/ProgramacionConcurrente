package Tp2;

public class Cliente {
    private String nombre;
    private int carroCompra[]= new int [20];

    public Cliente (String nombre, int [] carro){
        this.nombre=nombre;
        carroCompra= carro;
    }
    
    public String getNombre(){
        return nombre;
    }
    public int [] getCarroCompra(){
        return carroCompra;
    }
    public void setName (String nombre){
        this.nombre=nombre;
    }
    public void setCarroCompra(int [] carro){
        carroCompra=carro;
    }

}
