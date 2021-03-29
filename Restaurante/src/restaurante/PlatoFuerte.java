package restaurante;

public class PlatoFuerte extends Producto
{
    boolean mediano;
    int costoProduccion;

    public PlatoFuerte(String nombre, float precio, int tiempoProd, boolean mediano, int costoProduccion) {
        super(nombre, precio, tiempoProd);
        this.mediano = mediano;
        costoProduccion = 3;
    }

    public void setTamaño(boolean mediano)
    {
        this.mediano = mediano;
    }
    public boolean getTamaño()
    {
        return this.mediano;
    }
}
