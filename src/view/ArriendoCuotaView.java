package view;

import javax.swing.*;
import java.awt.*;

public class ArriendoCuotaView extends JFrame {
    private JComboBox<String> cmbClientes;
    private JComboBox<String> cmbVehiculos;
    private JTextField txtPrecioPorDia;
    private JTextField txtFechaArriendo;
    private JTextField txtDias;
    private JTextField txtMontoTotal;
    private JTextField txtCantidadCuotas;
    private JButton btnGuardarArriendo;
    private JButton btnIngresarCliente;

    public ArriendoCuotaView() {
        setTitle("Arriendos con Cuotas");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel principal
        JPanel panel = new JPanel();
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Componentes
        JLabel lblCliente = new JLabel("Cliente:");
        cmbClientes = new JComboBox<>();
        cmbClientes.addItem("Seleccione Cliente"); // Opción inicial
        JLabel lblVehiculo = new JLabel("Vehículo:");
        cmbVehiculos = new JComboBox<>();
        cmbVehiculos.addItem("Seleccione Vehículo"); // Opción inicial
        JLabel lblPrecio = new JLabel("Precio por Día:");
        txtPrecioPorDia = new JTextField();
        txtPrecioPorDia.setEditable(false);
        JLabel lblFecha = new JLabel("Fecha de Arriendo (dd/MM/yyyy):");
        txtFechaArriendo = new JTextField();
        JLabel lblDias = new JLabel("Días:");
        txtDias = new JTextField();
        JLabel lblMonto = new JLabel("Monto Total:");
        txtMontoTotal = new JTextField();
        txtMontoTotal.setEditable(false);
        JLabel lblCuotas = new JLabel("Cantidad de Cuotas:");
        txtCantidadCuotas = new JTextField();
        btnIngresarCliente = new JButton("Ingresar Cliente");
        btnGuardarArriendo = new JButton("Guardar Arriendo y Mostrar Cuotas");

        // Layout horizontal
        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lblCliente)
                                .addComponent(lblVehiculo)
                                .addComponent(lblPrecio)
                                .addComponent(lblFecha)
                                .addComponent(lblDias)
                                .addComponent(lblMonto)
                                .addComponent(lblCuotas))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(cmbClientes)
                                .addComponent(cmbVehiculos)
                                .addComponent(txtPrecioPorDia)
                                .addComponent(txtFechaArriendo)
                                .addComponent(txtDias)
                                .addComponent(txtMontoTotal)
                                .addComponent(txtCantidadCuotas)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnIngresarCliente)
                                        .addComponent(btnGuardarArriendo)))
        );

        // Layout vertical
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCliente)
                                .addComponent(cmbClientes))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblVehiculo)
                                .addComponent(cmbVehiculos))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPrecio)
                                .addComponent(txtPrecioPorDia))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblFecha)
                                .addComponent(txtFechaArriendo))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblDias)
                                .addComponent(txtDias))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblMonto)
                                .addComponent(txtMontoTotal))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCuotas)
                                .addComponent(txtCantidadCuotas))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(btnIngresarCliente)
                                .addComponent(btnGuardarArriendo))
        );

        add(panel, BorderLayout.CENTER);
    }

    public JComboBox<String> getCmbClientes() {
        return cmbClientes;
    }

    public JComboBox<String> getCmbVehiculos() {
        return cmbVehiculos;
    }

    public JTextField getTxtPrecioPorDia() {
        return txtPrecioPorDia;
    }

    public JTextField getTxtFechaArriendo() {
        return txtFechaArriendo;
    }

    public JTextField getTxtDias() {
        return txtDias;
    }

    public JTextField getTxtMontoTotal() {
        return txtMontoTotal;
    }

    public JTextField getTxtCantidadCuotas() {
        return txtCantidadCuotas;
    }

    public JButton getBtnGuardarArriendo() {
        return btnGuardarArriendo;
    }

    public JButton getBtnIngresarCliente() {
        return btnIngresarCliente;
    }
}
