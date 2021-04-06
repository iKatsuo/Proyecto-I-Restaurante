package restaurante;

public class ClientePasivo extends Cliente {

    public ClientePasivo(String nombre, int contador) {
        super(nombre, contador);
    }

    @Override
    public void decrementarContador() {
        this.contador--;
    }
}
