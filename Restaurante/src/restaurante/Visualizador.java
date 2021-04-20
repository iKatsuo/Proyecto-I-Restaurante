package restaurante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Visualizador extends JFrame{
    private Restaurante restaurante;
    private JButton avanzarElContadorButton;
    private JButton informaciónDelRestauranteButton;
    private JList pedidosList;
    private JPanel home;
    private JLabel clienteLabel;
    private JLabel tipoLabel;
    private JLabel contadorLabel;
    private JLabel pacienciaLabel;
    private JButton listaDeClientesEsperaButton;
    private JLabel tiempoLabel;
    private JButton infoPedidosButton;
    private JFrame pedidosGui;


    public Visualizador(String titulo, Restaurante restaurante, JFrame pedidosGui, DefaultListModel model){
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(home);
        this.setSize(800,600);
        this.restaurante = this.restaurante;
        this.pedidosGui = pedidosGui;

        pedidosList.setModel(model);



        avanzarElContadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(restaurante.getClientesEnFila().isEmpty() && restaurante.getClienteActual() == null && restaurante.getPedidosPendientes().isEmpty()){
                    //Termina el programa
                    JOptionPane.showMessageDialog(home,"Se han acabado los clientes por atender. Gracias por Visitarnos.");
                    System.out.println("Cerrando la simulación del restaurante");
                    JOptionPane.showMessageDialog(home,"Estadisticas generales del Restaurante Finales:\n" +
                            "Clientes Insatisfechos: " + restaurante.getClientesInsatisfechos() +
                            "\nGanancia total del Restaurante: " + restaurante.getGananciaTotal() +
                            "\nOrdenes completadas: " + restaurante.getOrdenesCompletadas() +
                            "\nClientes restantes en la fila: " + restaurante.getClientesEnFila().size());


                    setVisible(false);
                    dispose();

                }
                else {
                    //Empieza la simulación del restaurante, decrementando contadores del Cliente
                    int status = restaurante.simulacion();
                    tiempoLabel.setText(String.valueOf(restaurante.getTiempo()));

                    switch (status){
                        case 1:
                            JOptionPane.showMessageDialog(home,"Bienvenido al Restaurante: " +
                                    restaurante.getClienteActual().getNombre() + ". ¿En que le podemos servir?");
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(home,"¡Un cliente se ha enojado y ha abandonado la fila sin pagar!");
                            break;
                    }

                    //Esto es solo para los casos cuando el cliente no es nulo.
                    if (restaurante.getClienteActual() != null) {
                        clienteLabel.setText(restaurante.getClienteActual().getNombre());
                        tipoLabel.setText(String.valueOf(restaurante.getClienteActual().getClass()));
                        contadorLabel.setText(String.valueOf(restaurante.getClienteActual().getContador()));
                        if(restaurante.getClienteActual().getClass() == ClienteAgresivo.class){
                            ClienteAgresivo agresivo = (ClienteAgresivo) restaurante.getClienteActual();
                            pacienciaLabel.setText(String.valueOf(agresivo.getContadorPaciencia()));
                        }
                        else pacienciaLabel.setText("N/A");

                    }
                }
            }
        });
        informaciónDelRestauranteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(home,"Estadisticas generales del Restaurante:\n" +
                        "Clientes Insatisfechos: " + restaurante.getClientesInsatisfechos() +
                        "\nGanancia total del Restaurante: " + restaurante.getGananciaTotal() +
                        "\nOrdenes completadas: " + restaurante.getOrdenesCompletadas() +
                        "\nClientes restantes en la fila: " + restaurante.getClientesEnFila().size());
            }
        });
        listaDeClientesEsperaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pedidosGui.setVisible(true);
            }
        });
        infoPedidosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Pedido pedido = restaurante.getPedidoByNombre((String) pedidosList.getSelectedValue());
                    JOptionPane.showMessageDialog(home, pedido.toString());
                }
                catch(Exception err){
                    JOptionPane.showMessageDialog(home, "Seleccione un pedido para poder visualizar la información.");
                }
            }
        });
    }
}
