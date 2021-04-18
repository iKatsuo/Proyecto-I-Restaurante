package restaurante;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cocina {
    private HashMap<Cliente, Pedido> listaDePedidos;
    private HashMap<Cliente, Pedido> pedidosListos;
    private int tiempo;

    public Cocina(){
        this.listaDePedidos = new HashMap<Cliente, Pedido>();
        this.pedidosListos = new HashMap<Cliente, Pedido>();
        this.tiempo = 0;
    }
    public void cocinar(){
        tiempo = 0;
        for (Map.Entry pedido : this.listaDePedidos.entrySet()) {
            Pedido pedidoActual = (Pedido) pedido.getValue();
            tiempo += pedidoActual.getDuracion();
            if ((pedidoActual.getDuracion() == 0)) {
                pedidosListos.put((Cliente) pedido.getKey(), pedidoActual);
            } else {
                listaDePedidos.put((Cliente) pedido.getKey(), pedidoActual);
            }
            pedidoActual.cocinando();
        }
    }

    public void removePedidoDeLista(Cliente cliente){
        listaDePedidos.remove(cliente);
    }

    public HashMap<Cliente, Pedido> getListaDePedidos() {
        return listaDePedidos;
    }

    public void addPedido(Pedido pedido){
        this.listaDePedidos.put(pedido.getCliente(), pedido);
    }

    public HashMap<Cliente, Pedido> getPedidosListos(){
        return this.pedidosListos;
    }

    public void setPedidosListos() {
        this.pedidosListos.clear();
    }

    public int getTiempo() {
        return tiempo;
    }
}
