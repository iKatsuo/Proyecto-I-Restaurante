package restaurante;

import java.util.List;

public abstract class Cliente {
    private String nombre;
    public int contador;
    private Orden ordenCliente;
    public boolean enEspera;

    public Cliente(String nombre, int contador)
    {
        this.nombre = nombre;
        this.contador = contador;
        this.enEspera = true;
        ordenCliente = new Orden();
    }

    public String getNombre() {
        return nombre;
    }

    public int getContador() {
        return contador;
    }

    public boolean isEnEspera() {
        return enEspera;
    }

    public void setEnEspera(boolean enEspera) {
        this.enEspera = enEspera;
    }

    public abstract void decrementarContador();

    public Orden pedir(Menu menu){
        int cantidadDeProductos = (int)(Math.random()*Constants.CANTIDAD_PRODUCTOS.getValue()+1);

        for(int i = 0; i < cantidadDeProductos; i++){
            int tipo = (int)(Math.random()*3);
            int id = (int)(Math.random()*(menu.cantidadProducto(tipo)));
            ordenCliente.agregarProducto(menu.getProducto(tipo, id));
        }

        return this.ordenCliente;
    }
}
