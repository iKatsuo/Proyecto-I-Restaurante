package restaurante;

public class Bebida extends Producto
{

    private boolean fria;
    private TamanoBebida tamano;

    public Bebida(String nombre, float precio, int tiempoProd, boolean fria, TamanoBebida tamano) {
        super(nombre, precio, tiempoProd);
        this.fria = fria;
        this.tamano = tamano;
    }

    public boolean isFria() {
        return fria;
    }

    public void setFria(boolean fria) {
        this.fria = fria;
    }

    public TamanoBebida getTamano() {
        return tamano;
    }

    public void setTamano(TamanoBebida tamano) {
        this.tamano = tamano;
    }
}
