package restaurante;

public class Orden
{
    private TipoProducto tipoProducto;
    private int id;
    private int idCombo;

    public Orden(TipoProducto tipoProducto, int id, int idCombo) {
        this.tipoProducto = tipoProducto;
        this.id = id;
        this.idCombo = idCombo;
    }
}
