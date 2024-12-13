package view;

import javax.swing.*;
import java.awt.*;

public class ClienteView extends JFrame {
    private JTextField txtCedula;
    private JTextField txtNombre;
    private JCheckBox chkVigente;
    private JButton btnAgregar;

    public ClienteView() {
        setTitle("Gestión de Clientes");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel principal
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Componentes
        JLabel lblCedula = new JLabel("Cédula:");
        txtCedula = new JTextField();
        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField();
        JLabel lblVigente = new JLabel("¿Vigente?");
        chkVigente = new JCheckBox();
        btnAgregar = new JButton("Agregar");

        // Layout horizontal
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lblCedula)
                                .addComponent(lblNombre)
                                .addComponent(lblVigente))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(txtCedula)
                                .addComponent(txtNombre)
                                .addComponent(chkVigente)
                                .addComponent(btnAgregar))
        );

        // Layout vertical
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCedula)
                                .addComponent(txtCedula))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblNombre)
                                .addComponent(txtNombre))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblVigente)
                                .addComponent(chkVigente))
                        .addComponent(btnAgregar)
        );

        add(panel, BorderLayout.CENTER);
    }

    public JTextField getTxtCedula() {
        return txtCedula;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JCheckBox getChkVigente() {
        return chkVigente;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }
}
