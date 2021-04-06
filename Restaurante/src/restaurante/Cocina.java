package restaurante;

import java.util.List;

public class Cocina {
    private List<Pedido> listaDePedidos;
    private Pedido pedidoActual;

    public void cocinar(){
        pedidoActual.generarCombos();
    }

    public Pedido getPedidoActual() {
        return pedidoActual;
    }

    public void setPedidoActual(Pedido pedidoActual) {
        this.pedidoActual = pedidoActual;
    }
}
