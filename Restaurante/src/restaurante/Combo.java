package restaurante;

import java.util.List;

public class Combo {
    private String nombre;
    private int reduccionPrecio;
    private boolean platoFuerte;
    private boolean acompanamiento;
    private boolean bebida;
    private List<Producto> productosDelCombo;
    private int tiempoDeProduccion;

    public Combo(String nombre, int reduccionPrecio, boolean platoFuerte, boolean acompanamiento, boolean bebida) {
        this.nombre = nombre;
        this.reduccionPrecio = reduccionPrecio;
        this.platoFuerte = platoFuerte;
        this.acompanamiento = acompanamiento;
        this.bebida = bebida;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getReduccionPrecio() {
        return reduccionPrecio;
    }

    public void setReduccionPrecio(int reduccionPrecio) {
        this.reduccionPrecio = reduccionPrecio;
    }

    @Override
    public String toString() {
        return "Combo{" +
                "nombre='" + nombre + '\'' +
                ", reduccionPrecio=" + reduccionPrecio +
                ", platoFuerte=" + platoFuerte +
                ", acompanamiento=" + acompanamiento +
                ", bebida=" + bebida +
                '}';
    }

    //public float getPrecioTotal(){
        //return (platoFuerte.getPrecio()+bebida.getPrecio()+acompanamiento.getPrecio())*(1-(reduccionPrecio/100));
    //}
}
