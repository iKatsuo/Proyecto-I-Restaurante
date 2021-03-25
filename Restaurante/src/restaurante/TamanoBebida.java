package restaurante;

public enum TamanoBebida {
    PEQUENO(200), MEDIANO(250), GRANDE(330);
    private int tamano;

    private TamanoBebida(int tamano) {
        this.tamano = tamano;
    }

    public int getTamano(){
        return tamano;
    }
}
