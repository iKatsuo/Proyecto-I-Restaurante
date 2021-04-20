package restaurante;

public class PlatoFuerte extends Producto
{
    boolean mediano;

    public PlatoFuerte(String nombre, float precio, int tiempoProd, boolean mediano) {
        super(nombre, precio, tiempoProd);
        this.mediano = mediano;
    }

    @Override
    public String toString() {
        return "PlatoFuerte{" +
                "mediano=" + mediano +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", tiempoProd=" + tiempoProd +
                '}';
    }
}
