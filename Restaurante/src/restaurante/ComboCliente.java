package restaurante;

import java.util.ArrayList;
import java.util.List;

public class ComboCliente extends Combo {
    private List<Producto> productosDelCombo = new ArrayList<Producto>();
    private int tiempoDeProduccion;
    private double precio;

    public ComboCliente(Acompanamiento acompanamiento, Bebida bebida, Menu menu) {
        super();
        this.productosDelCombo.add(acompanamiento);
        this.productosDelCombo.add(bebida);
        Combo comboMenu = getComboMenu(menu, null, acompanamiento, bebida);
        this.tiempoDeProduccion = acompanamiento.getTiempoProd() + bebida.getTiempoProd();
        this.precio = (acompanamiento.getPrecio() + bebida.getPrecio())*(1-(comboMenu.getReduccionPrecio()/100));
        this.setNombre(comboMenu.getNombre());
        this.setReduccionPrecio(comboMenu.getReduccionPrecio());
    }

    public ComboCliente(PlatoFuerte platoFuerte, Bebida bebida, Menu menu) {
        super();
        productosDelCombo.add(platoFuerte);
        productosDelCombo.add(bebida);
        Combo comboMenu = getComboMenu(menu, platoFuerte, null, bebida);
        this.tiempoDeProduccion = platoFuerte.getTiempoProd() + bebida.getTiempoProd();
        this.precio = (platoFuerte.getPrecio() + bebida.getPrecio())*(1-(comboMenu.getReduccionPrecio()/100));
        this.setNombre(comboMenu.getNombre());
        this.setReduccionPrecio(comboMenu.getReduccionPrecio());
    }

    public ComboCliente(PlatoFuerte platoFuerte, Acompanamiento acompanamiento, Bebida bebida, Menu menu) {
        super();
        productosDelCombo.add(platoFuerte);
        productosDelCombo.add(acompanamiento);
        productosDelCombo.add(bebida);
        Combo comboMenu = getComboMenu(menu, platoFuerte, acompanamiento, bebida);
        this.tiempoDeProduccion = platoFuerte.getTiempoProd() + acompanamiento.getTiempoProd() + bebida.getTiempoProd();
        this.precio = (platoFuerte.getPrecio() + acompanamiento.getPrecio() + bebida.getPrecio())*(1-(comboMenu.getReduccionPrecio()/100));
        this.setNombre(comboMenu.getNombre());
        this.setReduccionPrecio(comboMenu.getReduccionPrecio());
    }

    private Combo getComboMenu(Menu menu, PlatoFuerte platoFuerte, Acompanamiento acompanamiento, Bebida bebida){
        boolean indicadorPlatoFuerte = ((platoFuerte == null) ? false : true);
        boolean indicadorAcompanamiento = ((acompanamiento == null) ? false : true);
        boolean indicadorBebida = ((bebida == null) ? false : true);
        Combo[] combo = menu.getListCombos().get(0);
        for(Combo cb: combo){
            if(cb.isPlatoFuerte() == indicadorPlatoFuerte && cb.isAcompanamiento() == indicadorAcompanamiento &&
            cb.isBebida() == indicadorBebida) return cb;
        }
        return null;
    }

    public int getTiempoDeProduccion() {
        return tiempoDeProduccion;
    }

    public double getPrecio() {
        return precio;
    }
}
