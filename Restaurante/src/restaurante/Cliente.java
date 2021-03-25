package restaurante;

import java.util.List;

public abstract class Cliente {
    private String nombre;
    private int contador;
    private List<Producto> pedido;
    private Orden orden;

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
}
