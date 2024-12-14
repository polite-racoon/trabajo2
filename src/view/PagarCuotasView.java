package view;

import model.Arriendo;
import view.Components.ComboBoxItem;

import javax.swing.*;
import java.awt.*;

public class PagarCuotasView extends JFrame {
    private JComboBox<ComboBoxItem> cmbClientes;
    private JList<Arriendo> lstArriendos; // Asegúrate de que el JList es de tipo Arriendo
    private JTable tblCuotas;
    private JButton btnVolver;
    private JButton btnMostrarPagos;
    private JButton btnRealizarPago;

    public PagarCuotasView() {
        setTitle("Pagar Cuotas de Arriendos");
        setSize(600, 600);
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
        cmbClientes.addItem(new ComboBoxItem("Seleccione un cliente", null));

        JLabel lblArriendos = new JLabel("Arriendos:");
        lstArriendos = new JList<>(new DefaultListModel<>());
        lstArriendos.setVisibleRowCount(5);

        JLabel lblCuotas = new JLabel("Pagos:");
        tblCuotas = new JTable();
        
        btnVolver = new JButton("Volver");
        btnMostrarPagos = new JButton("Mostrar Pagos");
        btnRealizarPago = new JButton("Realizar Pago");

        JScrollPane scrollArriendos = new JScrollPane(lstArriendos);
        scrollArriendos.setPreferredSize(new Dimension(400, 200));

        JScrollPane scrollCuotas = new JScrollPane(tblCuotas);
        scrollCuotas.setPreferredSize(new Dimension(400, 200));

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
                                        .addComponent(btnVolver)
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
                                .addComponent(btnVolver)
                                .addComponent(btnMostrarPagos)
                                .addComponent(btnRealizarPago))
        );

        add(panel, BorderLayout.CENTER);
    }

    public JComboBox<ComboBoxItem> getCmbClientes() {
        return cmbClientes;
    }

    public JList<Arriendo> getLstArriendos() {
        return lstArriendos;
    }

    public JTable getTblCuotas() {
        return tblCuotas;
    }

    public JButton getBtnVolver() {
        return btnVolver;
    }
    
    public JButton getBtnMostrarPagos() {
        return btnMostrarPagos;
    }

    public JButton getBtnRealizarPago() {
        return btnRealizarPago;
    }
}
