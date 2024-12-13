package view;

import model.Arriendo;

import javax.swing.*;
import java.awt.*;

public class PagarCuotasView extends JFrame {
    private JComboBox<String> cmbClientes;
    private JList<Arriendo> lstArriendos; // Asegúrate de que el JList es de tipo Arriendo
    private JTable tblCuotas;
    private JButton btnMostrarPagos;
    private JButton btnRealizarPago;

    public PagarCuotasView() {
        setTitle("Pagar Cuotas de Arriendos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel principal
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Componentes
        JLabel lblClientes = new JLabel("Cliente:");
        cmbClientes = new JComboBox<>();
        JLabel lblArriendos = new JLabel("Arriendos:");
        lstArriendos = new JList<>(new DefaultListModel<>()); // JList con DefaultListModel
        JLabel lblCuotas = new JLabel("Pagos:");
        tblCuotas = new JTable();
        btnMostrarPagos = new JButton("Mostrar Pagos");
        btnRealizarPago = new JButton("Realizar Pago");

        JScrollPane scrollArriendos = new JScrollPane(lstArriendos);
        JScrollPane scrollCuotas = new JScrollPane(tblCuotas);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lblClientes)
                                .addComponent(lblArriendos)
                                .addComponent(lblCuotas))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(cmbClientes)
                                .addComponent(scrollArriendos)
                                .addComponent(scrollCuotas)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnMostrarPagos)
                                        .addComponent(btnRealizarPago)))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblClientes)
                                .addComponent(cmbClientes))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblArriendos)
                                .addComponent(scrollArriendos))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCuotas)
                                .addComponent(scrollCuotas))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnMostrarPagos)
                                .addComponent(btnRealizarPago))
        );

        add(panel, BorderLayout.CENTER);
    }

    public JComboBox<String> getCmbClientes() {
        return cmbClientes;
    }

    public JList<Arriendo> getLstArriendos() {
        return lstArriendos;
    }

    public JTable getTblCuotas() {
        return tblCuotas;
    }

    public JButton getBtnMostrarPagos() {
        return btnMostrarPagos;
    }

    public JButton getBtnRealizarPago() {
        return btnRealizarPago;
    }
}