package restaurante;

public class Bebida extends Producto
{
    private boolean fria;
    private TamanoBebida tamano;

    public Bebida(String nombre, float precio, int tiempoProd, boolean fria, TamanoBebida tamano)
    {
        super(nombre, precio, tiempoProd);
        this.fria = fria;
        this.tamano = tamano;
    }

    public Bebida(String nombre, float precio, int tiempoProd) {
        super(nombre, precio, tiempoProd);
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "fria=" + fria +
                ", tamano=" + tamano +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", tiempoProd=" + tiempoProd +
                '}';
    }
}
