package restaurante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ClientesGui extends JFrame{
    private JList clientesList;
    private JButton verInformacionClientesButton;
    private JButton cerrarClientesButton;
    private JPanel home;
    private Restaurante restaurante;


    public ClientesGui(String titulo, Restaurante restaurante, DefaultListModel model){
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(home);
        this.setSize(400,400);
        this.restaurante = this.restaurante;
        clientesList.setModel(model);

        cerrarClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        verInformacionClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    List<ClienteAgresivo> agresivos = restaurante.getClientesEnEsperaAgresivos();
                    String clienteNombre = (String) clientesList.getSelectedValue();
                    ClienteAgresivo selectedCliente = null;
                    for (ClienteAgresivo cliente : agresivos) {
                        if (cliente.getNombre() == clienteNombre) selectedCliente = cliente;
                    }
                    JOptionPane.showMessageDialog(home, "Nombre del Cliente: " + selectedCliente.getNombre() +
                            "\nLimite de Paciencia: " + String.valueOf(selectedCliente.getContadorPaciencia()) +
                            "\nEl Cliente lleva esperando: " + String.valueOf(selectedCliente.getContador()));
                }
                catch (Exception err){
                    JOptionPane.showMessageDialog(home, "Debe seleccionar un cliente para poder visualizar su información");
                }

            }
        });
    }

}
