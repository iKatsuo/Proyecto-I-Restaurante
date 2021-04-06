package restaurante;

public abstract class Producto
{
    int id;
    String nombre;
    float precio;
    int tiempoProd;

    public Producto(String nombre, float precio, int tiempoProd) {
        this.nombre = nombre;
        this.precio = precio;
        this.tiempoProd = tiempoProd;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    public String getNombre()
    {
        return this.nombre;
    }

    public void setPrecio(float precio)
    {
        this.precio = precio;
    }
    public float getPrecio()
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
