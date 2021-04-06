package restaurante;

public enum TipoProducto {
    PLATOFUERTE(1), ACOMPANAMIENTO(2), BEBIDA(3);
    private int id;

    private TipoProducto(int id) {
        this.id = id;
    }

    public int getId(){
        return id;
    }
}
