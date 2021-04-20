package restaurante;

import javax.swing.*;
import java.util.*;

public class Restaurante {
    private Menu menu;
    private Cocina cocina;
    private Queue<Cliente> clientesEnFila;
    private List<ClienteAgresivo> clientesEnEsperaAgresivos;
    private Cliente clienteActual;
    private double gananciaTotal;
    private int clientesInsatisfechos;
    private int ordenesCompletadas;
    private DefaultListModel pedidosModel;
    private DefaultListModel clientesAgresivosModel;

    public Restaurante() {
        menu = new Menu();
        cocina = new Cocina();
        clientesInsatisfechos = 0;
        gananciaTotal = 0;
        ordenesCompletadas = 0;
        clientesEnFila = new LinkedList<Cliente>();
        clientesEnEsperaAgresivos = new LinkedList<ClienteAgresivo>();
        pedidosModel = Pedido.toList(this.getPedidosPendientes());
        clientesAgresivosModel = ClienteAgresivo.toList(this.getClientesEnEsperaAgresivos());
    }

    public Queue<Cliente> getClientesEnFila() {
        return clientesEnFila;
    }

    public void setClientesEnFila(Queue<Cliente> clientesEnFila) {
        this.clientesEnFila = clientesEnFila;
    }

    public double getGananciaTotal() {
        return gananciaTotal;
    }

    public void setGananciaTotal(double gananciaTotal) {
        this.gananciaTotal = gananciaTotal;
    }

    public int getClientesInsatisfechos() {
        return clientesInsatisfechos;
    }

    public void addClientesInsatisfechos() {
        this.clientesInsatisfechos++;
    }

    public Cliente getClienteActual() {
        return clienteActual;
    }

    public HashMap<Cliente, Pedido> obtenerPedidos(){
        return cocina.getListaDePedidos();
    }

    public int getOrdenesCompletadas() {
        return ordenesCompletadas;
    }

    public void setOrdenesCompletadas(int ordenesCompletadas) {
        this.ordenesCompletadas = ordenesCompletadas;
    }

    public void addCliente(Cliente cliente){
        clientesEnFila.add(cliente);
    }

    //Aqui tiene que estar el metodo de la simulacion del restaurante, verificar contadores principalmente
    //Valores de retorno:
    // 0 = Ya no hay clientes en cola ni en espera
    // 1 = Se ha agregado un nuevo cliente al sistema
    // 2 = Un cliente esta esperando por su orden
    // 3 = Un cliente agresivo se ha enojado y se ha ido sin recibir la orden
    public int simulacion(){
        //Se revisa si la lista no esta vacia o el cliente no es nulo
        if(cocina.getListaDePedidos() != null){
            if(clienteActual == null && !clientesEnFila.isEmpty()){
                clienteActual = clientesEnFila.remove();
                return 1;
            }
            //Esto es para los casos cuando el cliente aun no ha pedido
            if(clienteActual != null) {
                if (clienteActual.isEnEspera()) {
                    clienteActual.decrementarContador();
                    if (clienteActual.getContador() == -1) {
                        clienteActual.setEnEspera(false);
                        Orden orden = clienteActual.pedir(menu);
                        //Aqui hay que convertir la orden en un pedido y enviarlo a la cocina
                        Pedido pedido = new Pedido(orden, clienteActual, menu);
                        pedidosModel.addElement(pedido.getCliente().getNombre());
                        cocina.addPedido(pedido);

                        if (clienteActual.getClass() == ClienteAgresivo.class) {
                            clientesEnEsperaAgresivos.add((ClienteAgresivo) clienteActual);
                            clientesAgresivosModel.addElement(clienteActual.getNombre());
                            clienteActual = null;
                        }
                        clienteActual = null;
                    }
                }
            }
            //Aqui ahora hay que decrementar todos los contadores

            //La cocina se encarga de la lista de pedidos actuales que tiene
            cocina.cocinar();

            //Recolectar los pedidos que ya estan listos
            if(cocina.getPedidosListos() != null) {
                recolectarPedidos(cocina.getPedidosListos());
                cocina.setPedidosListos();
            }


            //esta parte se encarga de ver si algún cliente esta muy impaciente, se encarga de sacar al cliente de la lista
            //y tambien se tiene que encargar de remover el pedido de la cocina
            if(this.contadoresClientesAgresivos()){
                clientesInsatisfechos++;
                return 3;
            }
            return 2;
        }
        return 0;
    }

    //Revisa si hay clientes enojados que quieren irse y saca la orden de la cocina
    private boolean contadoresClientesAgresivos() {
        boolean flag = false;
        for(ClienteAgresivo cliente : clientesEnEsperaAgresivos){
            cliente.decrementarContador();
            if(cliente.getContador() == cliente.getContadorPaciencia()) {
                clientesEnEsperaAgresivos.remove(cliente);
                cocina.removePedidoDeLista((Cliente) cliente);
                clientesAgresivosModel.removeElement(cliente.getNombre());
                pedidosModel.removeElement(cliente.getNombre());
                flag = true;
            }
        }
        return ((flag == false) ? false : true);
    }

    private void recolectarPedidos(HashMap<Cliente, Pedido> pedidos){
        for (Map.Entry pedido : pedidos.entrySet()) {
            Cliente clienteActual = (Cliente) pedido.getKey();
            Pedido pedidoActual = (Pedido) pedido.getValue();
            if(clienteActual.getClass() == ClienteAgresivo.class) {
                clientesEnEsperaAgresivos.remove(clienteActual);
                clientesAgresivosModel.removeElement(clienteActual.getNombre());
            }
            ordenesCompletadas++;
            gananciaTotal += pedidoActual.getValorDelPedido();
            cocina.removePedidoDeLista((Cliente)pedido.getKey());
            pedidosModel.removeElement(clienteActual.getNombre());

        }
    }

    public HashMap<Cliente, Pedido> getPedidosPendientes(){
        return cocina.getListaDePedidos();
    }

    public int getTiempo(){
        return cocina.getTiempo();
    }

    public List<ClienteAgresivo> getClientesEnEsperaAgresivos(){
        return clientesEnEsperaAgresivos;
    }

    public DefaultListModel getPedidosModel() {
        return pedidosModel;
    }

    public DefaultListModel getClientesAgresivosModel() {
        return clientesAgresivosModel;
    }

    public Pedido getPedidoByNombre(String nombre){
        HashMap<Cliente, Pedido> listaPedidos = this.getPedidosPendientes();
        for (Map.Entry pedido : listaPedidos.entrySet()) {
            Cliente cliente = (Cliente) pedido.getKey();
            if(cliente.getNombre() == nombre) return (Pedido) pedido.getValue();
        }
        return null;
    }
}
