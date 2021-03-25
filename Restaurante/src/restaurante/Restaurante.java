package restaurante;

import java.util.LinkedList;
import java.util.Queue;

public class Restaurante {
    private Queue<Cliente> clientesEnEspera = new LinkedList<>();
    private int gananciaTotal;
    private int clientesInsatisfechos;
    private int ordenesCompletadas;

    public Queue<Cliente> getClientesEnEspera() {
        return clientesEnEspera;
    }

    public void setClientesEnEspera(Queue<Cliente> clientesEnEspera) {
        this.clientesEnEspera = clientesEnEspera;
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

    public void setClientesInsatisfechos(int clientesInsatisfechos) {
        this.clientesInsatisfechos = clientesInsatisfechos;
    }

    public int getOrdenesCompletadas() {
        return ordenesCompletadas;
    }

    public void setOrdenesCompletadas(int ordenesCompletadas) {
        this.ordenesCompletadas = ordenesCompletadas;
    }
}
