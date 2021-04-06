package restaurante;

public class Cocina {
    private Pedido pedido;

    public void cocinar(){
        pedido.generarCombos();
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
