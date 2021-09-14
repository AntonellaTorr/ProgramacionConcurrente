package Tp3;


public class Auto extends Vehiculo implements Runnable {
    private String patente;
    private String modelo; 
    private String marca;
    private int kmFaltantesParaElService;
    private int kmService;
    private int kmActual;
    private double litrosNafta;
    private double distanciaARecorrer;
    private SurtidorCombustible s;

    public Auto (String patente, String modelo, String marca, int kmService, int kmActual, double litrosNafta ,SurtidorCombustible s){
        this.patente=patente;
        this.modelo=modelo;
        this.marca=marca;
        this.kmService=kmService;
        this.kmActual=kmActual;
        this.kmFaltantesParaElService= kmService-kmActual;
        this.litrosNafta=litrosNafta;
        this.s=s;
    }
    public void run (){
        andar(10);
        SurtidorCombustible.cargarCombustible(this,20);
    }
    public void andar(int cantKm){
        System.out.println ("En el metodo andar de "+Thread.currentThread().getName()+ "/ kmActual antes de andar " +kmActual);
        this.kmActual=kmActual+cantKm;
        System.out.println (Thread.currentThread().getName()+ "/ kmActual despues de andar " +kmActual);
        actualizarKmFaltantes(cantKm);
        //por cada kilometro se consumen 0.125 litros 
        actualizarCantNafta(cantKm*0.125);
    }
    private void actualizarCantNafta(double cant){
        this.litrosNafta=this.litrosNafta-cant;
    }

    private void actualizarKmFaltantes(int cantKm){
        this.kmFaltantesParaElService= this.kmFaltantesParaElService-cantKm;
        //si ya se alcanzo el km para el service se reestablece su valor
        if (this.kmFaltantesParaElService<0){
            this.kmFaltantesParaElService=(kmService+cantKm)-Math.abs( this.kmFaltantesParaElService);
        }
    }
    public void cargarNafta(double cantLitros){
        this.litrosNafta+=cantLitros;
    }
}
