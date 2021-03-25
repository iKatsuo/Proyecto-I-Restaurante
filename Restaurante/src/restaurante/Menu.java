package restaurante;

import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;



public class Menu {
    private List<Producto> productos;
    private List<Combo> combos;

    public void jsonReader(){
        File file = new File("Restaurante/menu.json");

        try(InputStream is = new FileInputStream(file)){
            JSONTokener tokener = new JSONTokener(is);
            JSONObject object = new JSONObject(tokener);
            System.out.println("Menu: ");
            JSONObject menu = object.getJSONObject("Menu");


            JSONObject productos = menu.getJSONObject("Productos");
            JSONObject combos = menu.getJSONObject("Combos");

            JSONObject platosFuerte = productos.getJSONObject("Platos Fuerte");
            JSONObject acompanamientos = productos.getJSONObject("Acompanamientos");
            JSONObject bebidas = productos.getJSONObject("Bebidas");

            JSONObject plato = platosFuerte.getJSONObject("Tacos al Pastor");

            System.out.println(plato.getFloat("Precio"));

        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }
}
