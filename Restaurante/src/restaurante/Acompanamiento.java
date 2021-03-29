package restaurante;

public class Acompanamiento extends Producto
{
    boolean salado;
    int costoProduccion;

    public Acompanamiento(String nombre, float precio, int tiempoProd, boolean salado, int costoProduccion)
    {
        super(nombre, precio, tiempoProd);
        this.salado = salado;
        costoProduccion = 2;
    }

    public void setSabor(boolean salado)
    {
        this.salado = salado;
    }
    public boolean getSabor()
    {
        return this.salado;
    }
}
