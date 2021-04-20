package restaurante;

public enum Constants {
    NUM_CLIENTES(50), PACIENCIA_CLIENTES(10), PACIENCIA_CLIENTES_AGRESIVOS(60), PROBABILIDAD_AGRESIVO(3),
    CANTIDAD_PRODUCTOS(10);
    private int value;

    private Constants(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
