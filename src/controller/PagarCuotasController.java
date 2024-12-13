package controller;

import model.Arriendo;
import model.CuotaArriendo;
import view.PagarCuotasView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

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

        // Listener para el botón "Mostrar Pagos"
        view.getBtnMostrarPagos().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPagos();
            }
        });
    }

    public void cargarArriendos(List<Arriendo> arriendos) {
        listModelArriendos.clear(); // Limpia el modelo antes de agregar nuevos datos
        for (Arriendo arriendo : arriendos) {
            listModelArriendos.addElement(arriendo);
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
