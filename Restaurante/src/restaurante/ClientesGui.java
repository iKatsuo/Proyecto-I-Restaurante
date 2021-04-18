package restaurante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientesGui extends JFrame{
    private JList clientesList;
    private JButton verInformacionClientesButton;
    private JButton cerrarClientesButton;
    private JPanel home;
    private Restaurante restaurante;

    public ClientesGui(String titulo, Restaurante restaurante){
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(home);
        this.setSize(400,400);
        this.restaurante = this.restaurante;
        cerrarClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        verInformacionClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(home,"Aqui va el toString de un cliente seleccionado");

            }
        });
    }

}
