package restaurante;

import java.util.List;

public class Pedido {
    private List<Orden> ordenCliente;
    private int platosFuerte;
    private int acompanamientos;
    private int bebidas;
    private List<Integer> cantidadCombos;
    private List<Producto> productosIndividuales;
    private List<Combo> combosSolicitados;
    private int duracion;

    public Pedido(List<Orden> ordenCliente){
        this.ordenCliente = ordenCliente;
        //Aqui tengo que llenar los ints
    }

    public void generarCombos(){
        //Aqui genero los combos desde la lista cantidadCombos y elimino los productos de productosIndividuales
        //si se le puede hacer algun combo
    }
}
