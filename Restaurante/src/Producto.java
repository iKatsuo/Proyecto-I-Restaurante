public class Producto
{
    String nombre;
    int precio;
    int tiempoProd;

    public Producto()
    {
        nombre = "";
        precio = 0;
        tiempoProd = 0;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public String getNombre()
    {
        return this.nombre;
    }

    public void setPrecio(int precio)
    {
        this.precio = precio;
    }
    public int getPrecio()
    {
        return this.precio;
    }

    public void setTiempoProd(int tiempoProd)
    {
        this.tiempoProd = tiempoProd;
    }
    public int getTiempoProd()
    {
        return this.tiempoProd;
    }
}
