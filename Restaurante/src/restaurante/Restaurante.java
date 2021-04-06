package restaurante;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Restaurante {
    private Menu menu;
    private Cocina cocina;
    private Queue<Cliente> clientesEnFila;
    private List<ClienteAgresivo> clientesEnEsperaAgresivos;
    private Cliente clienteActual;
    private int gananciaTotal;
    private int clientesInsatisfechos;
    private int ordenesCompletadas;

    public Restaurante() {
        menu = new Menu();
        cocina = new Cocina();
        clientesInsatisfechos = 0;
        gananciaTotal = 0;
        ordenesCompletadas = 0;
        clientesEnFila = new LinkedList<Cliente>();
        clientesEnEsperaAgresivos = new LinkedList<ClienteAgresivo>();
    }

    public Queue<Cliente> getClientesEnFila() {
        return clientesEnFila;
    }

    public void setClientesEnFila(Queue<Cliente> clientesEnFila) {
        this.clientesEnFila = clientesEnFila;
    }

    public int getGananciaTotal() {
        return gananciaTotal;
    }

    public void setGananciaTotal(int gananciaTotal) {
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

    public List<Pedido> obtenerPedidos(){
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
        if(!clientesEnFila.isEmpty() || clienteActual != null){
            if(clienteActual == null){
                System.out.println("Obteniendo un cliente nuevo");
                clienteActual = clientesEnFila.remove();
                return 1;
            }
            //Esto es para los casos cuando el cliente aun no ha pedido
            if(clienteActual.isEnEspera()){
                clienteActual.decrementarContador();
                if(clienteActual.getContador() == 0){
                    clienteActual.setEnEspera(false);
                    clienteActual.pedir();
                }
            }
            else{
                //Ya los clientes ordenaron a este punto y estan esperando recibir la orden
                //Esto es para el cliente agresivo
                if(clienteActual.getClass() == ClienteAgresivo.class){
                    clienteActual.decrementarContador();

                    //Aqui el cliente se va si ya se le acabó la paciencia y no recibió el pedido
                    if(ClienteAgresivo.verificarPaciencia((ClienteAgresivo) clienteActual)) {
                        clienteActual = null;
                        this.addClientesInsatisfechos();
                        return 3;
                    }
                }
                else{
                    //Aqui el pasivo va a estar esperando por la orden
                    clienteActual = null;
                }
            }
            return 2;
        }
        return 0;
    }
}
