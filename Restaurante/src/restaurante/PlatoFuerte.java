package restaurante;

public class PlatoFuerte extends Producto
{
    boolean mediano;

    public PlatoFuerte(String nombre, float precio, int tiempoProd, boolean mediano) {
        super(nombre, precio, tiempoProd);
        this.mediano = mediano;
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
