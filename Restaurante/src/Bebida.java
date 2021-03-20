public class Bebida extends Producto
{
    boolean fria;
    int[] cantidades;
    int tamaño;

    public Bebida()
    {
        fria = true;
        int[] cantidades = {200, 250, 330};
        tamaño = 200;
    }

    public void setTemperatura(boolean fria)
    {
        this.fria = fria;
    }
    public boolean getTemperatura()
    {
        return this.fria;
    }

    public void setTamaño(int num)
    {
        if (num >= 0 || num <= 2)
        {
            this.tamaño = cantidades[num];
        }
        else
        {
            System.out.println("Clase Bebida\nError en línea: 25\nEl tamaño de la bebida ingresado no está dentro de los parámetros. Valor: " + num);
        }
    }
    public int getTamaño()
    {
        return this.tamaño;
    }
}
