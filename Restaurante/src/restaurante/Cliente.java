package restaurante;

import java.util.List;

public abstract class Cliente {
    private String nombre;
    public int contador;
    private List<Orden> ordenCliente;
    public boolean enEspera;

    public Cliente(String nombre, int contador)
    {
        this.nombre = nombre;
        this.contador = contador;
        this.enEspera = true;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    //Funcion para que el cliente sepa que es lo que quiere pedir


    public boolean isEnEspera() {
        return enEspera;
    }

    public void setEnEspera(boolean enEspera) {
        this.enEspera = enEspera;
    }

    public abstract void decrementarContador();

    public List<Orden> pedir(){
        System.out.println("Aqui se crea la orden y ya la pidio en el sistema");
        return this.ordenCliente;
    }
}
