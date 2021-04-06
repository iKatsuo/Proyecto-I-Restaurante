package restaurante;

import java.util.List;

public class Pedido {
    private List<Orden> ordenCliente;
    private List<Integer> cantidadCombos;
    private List<Producto> productosIndividuales;
    private List<Combo> combosSolicitados;
    private int duracion;

    //ints para el algoritmo de deteccion de combos;
    private int platosFuerte;
    private int acompanamientos;
    private int bebidas;

    public Pedido(List<Orden> ordenCliente){
        this.ordenCliente = ordenCliente;
        //Aqui tengo que llenar los ints
    }

    public void generarCombos(){
        //Aqui genero los combos desde la lista cantidadCombos y elimino los productos de productosIndividuales
        //si se le puede hacer algun combo
    }
}
