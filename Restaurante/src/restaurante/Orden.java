package restaurante;

import java.util.ArrayList;
import java.util.List;

public class Orden
{
    private List<Producto> productosCliente;

    public Orden(){
        productosCliente = new ArrayList<>();
    }

    public void agregarProducto(Producto producto){
        productosCliente.add(producto);
    }

    public List<Producto> getProductosCliente() {
        return productosCliente;
    }
}
