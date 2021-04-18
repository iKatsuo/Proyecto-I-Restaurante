package restaurante;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pedido {
    private Orden ordenCliente;
    private Cliente cliente;
    private List<Producto> productosIndividuales;
    private List<ComboCliente> combosSolicitados;
    private int duracion;
    private double valorDelPedido;
    private Menu menu;

    //ints para el algoritmo de deteccion de combos;
    private int platosFuerteContador;
    private int acompanamientosContador;
    private int bebidasContador;

    public Pedido(Orden ordenCliente, Cliente cliente, Menu menu){
        this.ordenCliente = ordenCliente;
        this.productosIndividuales = ordenCliente.getProductosCliente();
        this.cliente = cliente;
        this.platosFuerteContador = 0;
        this.acompanamientosContador = 0;
        this.bebidasContador = 0;
        this.menu = menu;
        this.duracion = 0;
        this.valorDelPedido = 0;
        this.combosSolicitados = new ArrayList<ComboCliente>();

        this.generarCombos(menu);
    }

    public void generarCombos(Menu menu){
        //Aqui genera los combos desde la lista cantidadCombos y se elimina los productos de productosIndividuales
        //si se le puede hacer algun combo
        List<Producto> productosDelCliente = ordenCliente.getProductosCliente();
        System.out.println("Productos del Cliente: ");
        for(Producto pd : productosDelCliente){
            System.out.println("Producto: " + pd.getNombre() + " Clase: " + pd.getClass());
            if(pd.getClass() == PlatoFuerte.class) this.platosFuerteContador++;
            if(pd.getClass() == Bebida.class) this.bebidasContador++;
            if(pd.getClass() == Acompanamiento.class) this.acompanamientosContador++;
        }
        System.out.println("Antes de generar los combos");
        System.out.println(productosIndividuales.toString());
        System.out.println(combosSolicitados.toString());

        while((platosFuerteContador != 0 && bebidasContador != 0)||(bebidasContador != 0 && acompanamientosContador != 0)){
            if(platosFuerteContador != 0){
                if(bebidasContador != 0){
                    if(acompanamientosContador !=0){

                        //Combo completo con las 3 cosas
                        combosSolicitados.add(new ComboCliente(getAndRemovePlatoFuerte(),
                                getAndRemoveAcompanamiento(), getAndRemoveBebida(), menu));
                        System.out.println("Op 1 F");

                    }else{
                        //Combo de platoFuerte con bebida
                        combosSolicitados.add(new ComboCliente(getAndRemovePlatoFuerte(), getAndRemoveBebida(), menu));
                        System.out.println("Op 2 F");
                    }
                }
            }else if (bebidasContador != 0){
                if(acompanamientosContador != 0){
                    //Combo de bebida y acompanamiento
                    combosSolicitados.add(new ComboCliente(getAndRemoveAcompanamiento(), getAndRemoveBebida(), menu));
                    System.out.println("Op 3 F");
                }
            }
        }
        System.out.println("Despues de generar los combos");
        System.out.println(productosIndividuales.toString());
        System.out.println(combosSolicitados.toString());
        this.actualizarValorYTiempoDelPedido();
    }

    private void actualizarValorYTiempoDelPedido(){
        for(Producto pd : productosIndividuales){

            this.duracion += pd.getTiempoProd();
            this.valorDelPedido += pd.getPrecio();
        }
        if(combosSolicitados != null) {

            for (ComboCliente cb : combosSolicitados) {
                this.duracion += cb.getTiempoDeProduccion();
                this.valorDelPedido += cb.getPrecio();
            }
        }
    }

    public Orden getOrdenCliente() {
        return ordenCliente;
    }

    public void cocinando(){
        duracion--;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public PlatoFuerte getAndRemovePlatoFuerte(){
        for(Producto pg: productosIndividuales){
            if(pg.getClass() == PlatoFuerte.class) {
                productosIndividuales.remove(pg);
                platosFuerteContador--;
                return (PlatoFuerte) pg;
            }
        }
        return null;
    }

    public Bebida getAndRemoveBebida(){
        for(Producto pg: productosIndividuales){
            if(pg.getClass() == Bebida.class) {
                productosIndividuales.remove(pg);
                bebidasContador--;
                return (Bebida) pg;
            }
        }
        return null;
    }

    public Acompanamiento getAndRemoveAcompanamiento(){
        for(Producto pg: productosIndividuales){
            if(pg.getClass() == Acompanamiento.class) {
                productosIndividuales.remove(pg);
                acompanamientosContador--;
                return (Acompanamiento) pg;
            }
        }
        return null;
    }

    public int getDuracion() {
        return duracion;
    }

    public double getValorDelPedido() {
        return valorDelPedido;
    }

    public static DefaultListModel toList(HashMap<Cliente, Pedido> lista){
        DefaultListModel modelo = new DefaultListModel();
        for (Map.Entry pedido : lista.entrySet()) {
            Cliente cliente = (Cliente) pedido.getKey();
            modelo.addElement(cliente.getNombre());
        }
        return modelo;
    }

    public String toString(){
        return "Cliente: " + cliente.getNombre() +
                "\nProductos Individuales:\n " + productosToString(this.productosIndividuales) +
                "\nCombos pedidos:\n " + combosToString(this.combosSolicitados) +
                "\nTiempo para preparar pedido: " + String.valueOf(duracion) +
                "\nCosto del pedido: " + String.valueOf(valorDelPedido);
    }

    public String productosToString(List<Producto> productos){
        String val = "";
        for(Producto producto : productos){
            val += "Producto: " + producto.getNombre() + " Tipo: " + String.valueOf(producto.getClass());
            val += "\n";
        }
        return val;
    }

    public String combosToString(List<ComboCliente> combos){
        String val = "";
        for(ComboCliente combo : combos){
            val += "Combo: " + combo.getNombre();
            val += "\n";
        }
        return val;
    }
}
