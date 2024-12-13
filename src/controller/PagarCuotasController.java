package controller;

import model.Arriendo;
import model.CuotaArriendo;
import model.Data;
import view.PagarCuotasView;
import view.Components.ComboBoxItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
        view.getLstArriendos().setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // seleccion simple

        // Listener para seleccion de cliente en el combobox
        view.getCmbClientes().addActionListener(e -> mostrarArriendos());
    
        // Listener para boton mostrar pagos
        view.getBtnMostrarPagos().addActionListener(e -> mostrarPagos());
    }

    public void mostrarArriendos() {
        ComboBoxItem itemSeleccionado = (ComboBoxItem) view.getCmbClientes().getSelectedItem();
        String cedulaCliente = itemSeleccionado.getValue();
                
        List<Arriendo> arriendos = Data.arriendos.stream().filter(a->a.getCliente().getCedula() == cedulaCliente).collect(Collectors.toList());
        
        listModelArriendos.clear(); // Limpia el modelo antes de agregar nuevos datos
        
        for (Arriendo arriendo : arriendos) {
            listModelArriendos.addElement(arriendo);
        }
    }

    private void mostrarPagos() {
        Arriendo arriendoSeleccionado = view.getLstArriendos().getSelectedValue(); // Selecciona el arriendo
        System.out.println("Arriendo seleccionado: " + arriendoSeleccionado);
        if (arriendoSeleccionado != null) {
            List<CuotaArriendo> cuotas = arriendoSeleccionado.getCuotas();
            DefaultTableModel model = new DefaultTableModel(new String[]{"Número", "Valor", "Pagada"}, 0);

            for (CuotaArriendo cuota : cuotas) {
                model.addRow(new Object[]{cuota.getNumCuota(), cuota.getValorCuota(), cuota.isPagada()});
            }

            view.getTblCuotas().setModel(model);
        } else {
            // Mostrar mensaje de error si no se selecciona un arriendo
            JOptionPane.showMessageDialog(view, "Seleccione un arriendo para mostrar sus cuotas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
