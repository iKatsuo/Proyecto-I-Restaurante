public class Acompañamiento extends Producto
{
    boolean salado;
    
    public Acompañamiento()
    {
        salado = true;
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
