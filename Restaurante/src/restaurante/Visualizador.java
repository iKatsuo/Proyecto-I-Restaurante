package restaurante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Visualizador extends JFrame{
    private Restaurante restaurante;
    private JButton avanzarElContadorButton;
    private JButton informaciónDelRestauranteButton;
    private JList productosList;
    private JPanel home;
    private JLabel clienteLabel;
    private JLabel tipoLabel;
    private JLabel contadorLabel;
    private JLabel pacienciaLabel;
    private JLabel tiempoLabel;
    private JButton listaDePedidosActualesButton;

    public Visualizador(String titulo, Restaurante restaurante){
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(home);
        this.pack();
        this.restaurante = this.restaurante;

        avanzarElContadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(restaurante.getClientesEnFila().isEmpty() && restaurante.getClienteActual() == null){
                    //Termina el programa
                    JOptionPane.showMessageDialog(home,"Se han acabado los clientes por atender. Gracias por Visitarnos.");
                    System.out.println("Cerrando la simulación del restaurante");
                    setVisible(false);
                    dispose();

                }
                else {
                    //Empieza la simulación del restaurante, decrementando contadores del Cliente
                    int status = restaurante.simulacion();

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
    }
}
