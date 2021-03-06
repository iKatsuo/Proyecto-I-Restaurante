package restaurante;

import com.github.javafaker.Faker;

import javax.swing.*;

public class App
{
    public static void main(String[] args)
    {
        Faker faker = new Faker();

        System.out.println("Bienvenido al Restaurante");

        //Creacion del restaurante, junto con su menu y la cocina
        Restaurante restaurante = new Restaurante();

        //Creacion de clientes
        for(int i = 0; i < Constants.NUM_CLIENTES.getValue(); i++){
            Cliente cliente;
            int num = (int)(Math.random()*Constants.PROBABILIDAD_AGRESIVO.getValue()+1);
            if(num==3) cliente = new ClienteAgresivo(
                    faker.name().fullName(), (int)(Math.random()*Constants.PACIENCIA_CLIENTES.getValue()+1));

            else cliente = new ClientePasivo(
                    faker.name().fullName(), (int)(Math.random()*Math.random()*Constants.PACIENCIA_CLIENTES.getValue()+1));
            restaurante.addCliente(cliente);
        }

        //Mostrar la ventana del GUI - A partir de aquí, el visualizador se encarga de lo demas
        JFrame pedidosGui = new ClientesGui("Clientes Agresivos en Espera", restaurante, restaurante.getClientesAgresivosModel());
        JFrame gui = new Visualizador("Simulación Restaurante", restaurante, pedidosGui, restaurante.getPedidosModel());

        gui.setVisible(true);

    }

}
