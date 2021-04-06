package restaurante;

public class Bebida extends Producto
{

    private boolean fria;
    private TamanoBebida tamano;
    int costoProduccion;

    public Bebida(String nombre, float precio, int tiempoProd, boolean fria, TamanoBebida tamano, int costoProduccion)
    {
        super(nombre, precio, tiempoProd);
        this.fria = fria;
        this.tamano = tamano;
        costoProduccion = 1;
    }

    public Bebida(String nombre, float precio, int tiempoProd) {
        super(nombre, precio, tiempoProd);
    }

    public boolean isFria() {
        return fria;
    }

    public void setFria(boolean fria) {
        this.fria = fria;
    }

    public TamanoBebida getTamano() {
        return tamano;
    }

    public void setTamano(TamanoBebida tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return "Bebida{" +
                "fria=" + fria +
                ", tamano=" + tamano +
                ", costoProduccion=" + costoProduccion +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", tiempoProd=" + tiempoProd +
                '}';
    }
}
