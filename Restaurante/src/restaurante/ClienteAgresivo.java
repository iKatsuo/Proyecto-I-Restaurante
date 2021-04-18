package restaurante;

import javax.swing.*;
import java.util.List;

public class ClienteAgresivo extends Cliente {
    private int contadorPaciencia;

    public ClienteAgresivo(String nombre, int contador) {
        super(nombre, contador);
        this.contadorPaciencia = (int)(Math.random()*10+1);
    }

    @Override
    public void decrementarContador() {
        if(this.enEspera) this.contador--;
        else this.contador++;
    }

    public static boolean verificarPaciencia(ClienteAgresivo cliente){
        return(cliente.contador > cliente.contadorPaciencia && !cliente.enEspera);
    }

    public static DefaultListModel toList(List<ClienteAgresivo> lista){
        DefaultListModel modelo = new DefaultListModel();
        for(int i = 0; i < lista.size(); i++){
            modelo.addElement(lista.get(i).getNombre());
        }
        return modelo;
    }

    public int getContadorPaciencia() {
        return contadorPaciencia;
    }
}
