public class Plato extends Producto
{
    boolean mediano;

    public Plato()
    {
        mediano = true;
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
