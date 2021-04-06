package restaurante;

import java.util.List;

public abstract class Cliente {
    private String nombre;
    private int contador;
    private List<Producto> pedido;
    private Orden orden;
    private int contadorPaciencia;

    public Cliente(String nombre, int contador, List<Producto> pedido, Orden orden, int contadorPaciencia)
    {
        int num = (int)(Math.random()*2+1);

        if (num == 2)
        {
            this.contadorPaciencia = contadorPaciencia;
        }
        this.nombre = nombre;
        this.contador = contador;
        this.pedido = pedido;
        this.orden = orden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public List<Producto> getPedido() {
        return pedido;
    }

    public void setPedido(List<Producto> pedido) {
        this.pedido = pedido;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public void setPaciencia(int contadorPaciencia)
    {
        this.contadorPaciencia = contadorPaciencia;
    }

    public int getPaciencia()
    {
        return this.contadorPaciencia;
    }

    //Funcion para que el cliente sepa que es lo que quiere pedir
}
