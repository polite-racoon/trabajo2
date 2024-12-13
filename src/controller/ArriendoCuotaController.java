package controller;

import view.ArriendoCuotaView;
import view.PagarCuotasView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import model.Data;
import model.Vehiculo;

public class ArriendoCuotaController {
    private ArriendoCuotaView view;
    private PagarCuotasView pagarCuotasView;

    public ArriendoCuotaController(ArriendoCuotaView view, PagarCuotasView pagarCuotasView) {
        this.view = view;
        this.pagarCuotasView = pagarCuotasView;
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
    }

    private void cargarVehiculos() {
        view.getCmbVehiculos().addItem("Seleccione Vehículo");
        for (Vehiculo vehiculo : Data.vehiculos) {
            view.getCmbVehiculos().addItem(vehiculo.getMarca() + " " + vehiculo.getModelo());   
        }
    }

    private void actualizarPrecioPorDia() {
        String vehiculoSeleccionado = (String) view.getCmbVehiculos().getSelectedItem();

            if (vehiculoSeleccionado.equals("Seleccione Vehículo")) {
                view.getTxtPrecioPorDia().setText("");
                return;
            }

            for (Vehiculo vehiculo : Data.vehiculos) {
                if ((vehiculo.getMarca() + " " + vehiculo.getModelo()).equals(vehiculoSeleccionado)) {
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
        String clienteSeleccionado = (String) view.getCmbClientes().getSelectedItem();
        String vehiculoSeleccionado = (String) view.getCmbVehiculos().getSelectedItem();
        String diasTexto = view.getTxtDias().getText();
        String cuotasTexto = view.getTxtCantidadCuotas().getText();
        String montoTexto = view.getTxtMontoTotal().getText();

        // Validar que todos los campos estén completos
        if (clienteSeleccionado.equals("Seleccione Cliente") || vehiculoSeleccionado.equals("Seleccione Vehículo")
                || diasTexto.isEmpty() || cuotasTexto.isEmpty() || montoTexto.isEmpty()) {
            System.out.println("Complete todos los campos.");
            return;
        }

        System.out.println("Cliente: " + clienteSeleccionado);
        System.out.println("Vehículo: " + vehiculoSeleccionado);
        System.out.println("Monto Total: " + montoTexto);
        System.out.println("Cantidad de Cuotas: " + cuotasTexto);

        // Avanzar a la interfaz PagarCuotasView
        view.setVisible(false);
        pagarCuotasView.setVisible(true);
    }
}
