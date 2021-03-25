package restaurante;

public class App
{
    public static void main(String[] args)
    {
        System.out.println("Bienvenido al Restaurante");
        Menu menu = new Menu();
        menu.jsonReader();
    }

}
