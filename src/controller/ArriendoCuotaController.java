package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import java.util.Objects;

import view.ArriendoCuotaView;
import view.ClienteView;
import view.PagarCuotasView;
import view.Components.ComboBoxItem;

import model.Data;
import model.Vehiculo;


public class ArriendoCuotaController {
    private ArriendoCuotaView view;
    private PagarCuotasView pagarCuotasView;
    private ClienteView clienteView;

    public ArriendoCuotaController(ArriendoCuotaView view, PagarCuotasView pagarCuotasView, ClienteView clienteView) {
        this.view = view;
        this.pagarCuotasView = pagarCuotasView;
        this.clienteView = clienteView;
        cargarVehiculos();
        initController();
    }

    private void initController() {
        // Listener para calcular automáticamente el monto total cuando se ingresen los días
        view.getTxtDias().addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                calcularMontoTotal();
            }
        });

        // Listener para actualizar el precio por día al seleccionar un vehículo
        view.getCmbVehiculos().addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                actualizarPrecioPorDia();
            }
        });

        // Listener del botón "Guardar Arriendo y Mostrar Cuotas"
        view.getBtnGuardarArriendo().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarArriendo();
            }
        });

        //Listener botón "Ingresar Cliente"
        view.getBtnIngresarCliente().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setVisible(false);
                // view.dispose();
                clienteView.setVisible(true);
            }
        });

    }

    private void cargarVehiculos() {
        for (Vehiculo vehiculo : Data.vehiculos) {
            String displayValue = vehiculo.toString();
            view.getCmbVehiculos().addItem(new ComboBoxItem(displayValue, vehiculo.getPatente()));   
        }
    }

    private void actualizarPrecioPorDia() {
        ComboBoxItem itemSeleccionado = (ComboBoxItem) view.getCmbVehiculos().getSelectedItem();
        
        String patenteVehiculo = itemSeleccionado.getValue();
        if (Objects.equals(patenteVehiculo, null)) {
            view.getTxtPrecioPorDia().setText("");
            return;
        }

        for (Vehiculo vehiculo : Data.vehiculos) {
            if ((vehiculo.getPatente()).equals(patenteVehiculo)) {
                    view.getTxtPrecioPorDia().setText(String.valueOf(vehiculo.getPrecioPorDia()));
                    break;
                }
            }
    }

    private void calcularMontoTotal() {
        try {
            int dias = Integer.parseInt(view.getTxtDias().getText());
            int precioPorDia = Integer.parseInt(view.getTxtPrecioPorDia().getText());
            int montoTotal = dias * precioPorDia;
            view.getTxtMontoTotal().setText(String.valueOf(montoTotal));
        } catch (NumberFormatException e) {
            view.getTxtMontoTotal().setText(""); // Limpia el campo si el input es inválido
        }
    }

    private void guardarArriendo() {
        ComboBoxItem itemCliente = (ComboBoxItem) view.getCmbClientes().getSelectedItem();
        ComboBoxItem itemVehiculo = (ComboBoxItem) view.getCmbVehiculos().getSelectedItem();

        String cedulaCliente = itemCliente.getValue();
        String patenteVehiculo = itemVehiculo.getValue();

        String diasTexto = view.getTxtDias().getText();
        String cuotasTexto = view.getTxtCantidadCuotas().getText();
        String montoTexto = view.getTxtMontoTotal().getText();

        // Validar que todos los campos estén completos
        if (Objects.equals(cedulaCliente, null) 
            || Objects.equals(patenteVehiculo, null) 
            || diasTexto.isEmpty() 
            || cuotasTexto.isEmpty() 
            || montoTexto.isEmpty()) {
            // Mostrar mensaje de error
            JOptionPane.showMessageDialog(view, "Complete todos los campos.");
            return;
        }

        System.out.println("Cliente: " + cedulaCliente);
        System.out.println("Vehículo: " + patenteVehiculo);
        System.out.println("Monto Total: " + montoTexto);
        System.out.println("Cantidad de Cuotas: " + cuotasTexto);

        // Avanzar a la interfaz PagarCuotasView
        view.setVisible(false);
        pagarCuotasView.setVisible(true);
    }
}
