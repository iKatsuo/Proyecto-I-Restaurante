package restaurante;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PedidosGui extends JFrame{
    private JList pedidosList;
    private JButton verInformaciónButton;
    private JButton cerrarButton;
    private JPanel home;
    private Restaurante restaurante;

    public PedidosGui(String titulo, Restaurante restaurante){
        super(titulo);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(home);
        this.setSize(400,400);
        this.restaurante = this.restaurante;
        cerrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        verInformaciónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(home,"Aqui va el toString de un pedido seleccionado");

            }
        });
    }

}
