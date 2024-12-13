package controller;

import model.Arriendo;
import model.Cliente;
import model.CuotaArriendo;
import model.Data;
import model.Vehiculo;
import view.PagarCuotasView;
import view.Components.ComboBoxItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PagarCuotasController {
    private PagarCuotasView view;
    private DefaultListModel<Arriendo> listModelArriendos;

    public PagarCuotasController(PagarCuotasView view) {
        this.view = view;
        initController();
    }

    private void initController() {
        // Configurar modelo para el JList
        listModelArriendos = new DefaultListModel<>();
        view.getLstArriendos().setModel(listModelArriendos);

        // agregar arriendo de muestra
        // Cliente cliente = new Cliente("12345678-9", "Juanito", true);
        // Cliente cliente1 = new Cliente("987654", "Pepito", true);
        // Vehiculo vehiculo = new Vehiculo("ABCD123", "Toyota", "Yaris", 10000);
        // Vehiculo vehiculo1 = new Vehiculo("EFGH456", "Chevrolet", "Spark", 8000);
        // Arriendo arriendo = new Arriendo(cliente, vehiculo, new Date(), 5, 50000, 5);
        // Arriendo arriendo1 = new Arriendo(cliente1, vehiculo1, new Date(), 5, 50000, 5);
        // listModelArriendos.addElement(arriendo);
        // listModelArriendos.addElement(arriendo1);

        // Configurar selección simple en el JList
        view.getLstArriendos().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // agregar arriendos a la lista
        view.getLstArriendos().setModel(listModelArriendos);


        // Listener para el botón "Mostrar Pagos"
        view.getBtnMostrarPagos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPagos();
            }
        });

        // Listener para seleccion de cliente en el combobox
        view.getCmbClientes().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Seleccionando cliente...");
                ComboBoxItem itemSeleccionado = (ComboBoxItem) view.getCmbClientes().getSelectedItem();
                String cedulaCliente = itemSeleccionado.getValue();
                
                System.out.println("Data.arriendos: " + Data.arriendos.size());

                List<Arriendo> arriendos = Data.arriendos.stream().filter(a->a.getCliente().getCedula() == cedulaCliente).collect(Collectors.toList());
                cargarArriendos(arriendos);
            }
        });
    }

    

    public void cargarArriendos(List<Arriendo> arriendos) {
        System.out.println("Cargando arriendos..." + arriendos.size());
        listModelArriendos.clear(); // Limpia el modelo antes de agregar nuevos datos
        
        for (Arriendo arriendo : arriendos) {
            listModelArriendos.addElement(arriendo);
            System.out.println("Arriendo en tercera ventana: " + arriendo);
        }
    }

    private void mostrarPagos() {
        Arriendo arriendoSeleccionado = view.getLstArriendos().getSelectedValue(); // Selecciona el arriendo

        if (arriendoSeleccionado != null) {
            List<CuotaArriendo> cuotas = arriendoSeleccionado.getCuotas();
            DefaultTableModel model = new DefaultTableModel(new String[]{"Número", "Valor", "Pagada"}, 0);

            for (CuotaArriendo cuota : cuotas) {
                model.addRow(new Object[]{cuota.getNumCuota(), cuota.getValorCuota(), cuota.isPagada()});
            }

            view.getTblCuotas().setModel(model);
        } else {
            System.out.println("Seleccione un arriendo para mostrar sus cuotas.");
        }
    }
}
