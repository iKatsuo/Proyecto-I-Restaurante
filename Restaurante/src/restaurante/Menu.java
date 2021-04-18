package restaurante;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



public class Menu {
    private List<Producto[]> listProductos;
    private List<Combo[]> listCombos;
    private Gson gson;

    public Menu() {
        this.jsonReader();
    }

    public List<Producto[]> getListProductos() {
        return listProductos;
    }

    public List<Combo[]> getListCombos() {
        return listCombos;
    }

    public void jsonReader(){
        File file = new File("Restaurante/menu.json");
        listProductos = new ArrayList<Producto[]>();
        listCombos = new ArrayList<Combo[]>();
        gson = new Gson();

        try(InputStream is = new FileInputStream(file)){
            JSONTokener tokener = new JSONTokener(is);
            JSONObject object = new JSONObject(tokener);
            JSONObject menu = object.getJSONObject("Menu");

            JSONObject objectProductos = menu.getJSONObject("Productos");
            JSONArray arrayCombos = menu.getJSONArray("Combos");

            JSONArray arrayPlatoFuerte = objectProductos.getJSONArray("Plato Fuerte");
            JSONArray arrayAcompanamiento = objectProductos.getJSONArray("Acompanamiento");
            JSONArray arrayBebida = objectProductos.getJSONArray("Bebida");

            PlatoFuerte platos[] = gson.fromJson(arrayPlatoFuerte.toString(), PlatoFuerte[].class);
            Acompanamiento acompanamiento[] = gson.fromJson(arrayAcompanamiento.toString(), Acompanamiento[].class);
            Bebida bebida[] = gson.fromJson(arrayBebida.toString(), Bebida[].class);
            Combo combo[] = gson.fromJson(arrayCombos.toString(), Combo[].class);

            listProductos.add(platos);
            listProductos.add(acompanamiento);
            listProductos.add(bebida);
            listCombos.add(combo);

        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

    public Producto getProducto(int tipo, int id){
        return listProductos.get(tipo)[id];
    }

    public int cantidadProducto(int tipo){
        return listProductos.get(tipo).length;
    }
}
