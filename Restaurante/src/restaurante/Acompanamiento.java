package restaurante;

public class Acompanamiento extends Producto
{
    private boolean salado;

    public Acompanamiento(String nombre, double precio, int tiempoProd, boolean salado)
    {
        super(nombre, precio, tiempoProd);
        this.salado = salado;
    }

    @Override
    public String toString() {
        return "Acompanamiento{" +
                "salado=" + salado +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", tiempoProd=" + tiempoProd +
                '}';
    }
}
