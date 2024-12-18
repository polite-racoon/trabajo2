package controller;

import model.Arriendo;
import model.CuotaArriendo;
import model.Data;
import view.ArriendoCuotaView;
import view.PagarCuotasView;
import view.Components.ComboBoxItem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.stream.Collectors;

public class PagarCuotasController {
    private PagarCuotasView view;
    private ArriendoCuotaView arriendoCuotaView;
    private DefaultListModel<Arriendo> listModelArriendos;

    public PagarCuotasController(PagarCuotasView view, ArriendoCuotaView arriendoCuotaView) {
        this.view = view;
        this.arriendoCuotaView = arriendoCuotaView;
        initController();
    }

    private void initController() {
        // Configurar modelo para el JList
        listModelArriendos = new DefaultListModel<>();
        view.getLstArriendos().setModel(listModelArriendos);
        view.getLstArriendos().setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // seleccion simple
        
        // Listener para seleccion de cliente en el combobox
        view.getCmbClientes().addActionListener(e -> mostrarArriendos());
        
        // Listener para boton volver
        view.getBtnVolver().addActionListener(e -> volver());

        // Listener para boton mostrar pagos
        view.getBtnMostrarPagos().addActionListener(e -> mostrarPagos());

        // Listener para boton pagar cuota
        view.getBtnRealizarPago().addActionListener(e -> pagarCuota());
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
    
    public void volver() {
        view.setVisible(false);
        arriendoCuotaView.setVisible(true);
        listModelArriendos.clear();
        // Limpiar tabla de cuotas
        view.getTblCuotas().setModel(new DefaultTableModel(new String[]{"Número", "Valor", "Pagada"}, 0));
    }
    
    private void mostrarPagos() {
        Arriendo arriendoSeleccionado = view.getLstArriendos().getSelectedValue(); // Selecciona el arriendo
        DefaultTableModel model = new DefaultTableModel(new String[]{"Número", "Valor", "Pagada"}, 0);
        
        if (arriendoSeleccionado != null) {
            List<CuotaArriendo> cuotas = arriendoSeleccionado.getCuotas();

            for (CuotaArriendo cuota : cuotas) {
                model.addRow(new Object[]{cuota.getNumCuota(), cuota.getValorCuota(), cuota.isPagada()});
            }

        } else {
            // Mostrar mensaje de error si no se selecciona un arriendo
            JOptionPane.showMessageDialog(view, "Seleccione un arriendo para mostrar sus cuotas.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        view.getTblCuotas().setModel(model);
    }

    private void pagarCuota() {

        Arriendo arriendoSeleccionado = view.getLstArriendos().getSelectedValue();
        if (arriendoSeleccionado == null) {
            JOptionPane.showMessageDialog(view, "Seleccione un arriendo para pagar sus cuotas.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int selectedRow = view.getTblCuotas().getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(view, "Seleccione una cuota para pagar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        CuotaArriendo cuotaSeleccionada = arriendoSeleccionado.getCuotas().get(selectedRow);
        if (cuotaSeleccionada == null) {
            JOptionPane.showMessageDialog(view, "La cuota no corresponde al arriendo seleccionado.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (cuotaSeleccionada.isPagada()) {
            JOptionPane.showMessageDialog(view, "La cuota seleccionada ya ha sido pagada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        cuotaSeleccionada.setPagada(true);
        JOptionPane.showMessageDialog(view, "Cuota pagada con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                
        mostrarPagos();
    }
}
