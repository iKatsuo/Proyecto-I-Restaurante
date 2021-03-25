package restaurante;

public class Acompanamiento extends Producto
{
    boolean salado;

    public Acompanamiento(String nombre, float precio, int tiempoProd, boolean salado) {
        super(nombre, precio, tiempoProd);
        this.salado = salado;
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
