package controller;

import model.Cliente;
import view.ClienteView;
import view.ArriendoCuotaView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteController {
    private ClienteView view;
    private ArriendoCuotaView arriendoCuotaView;

    public ClienteController(ClienteView view, ArriendoCuotaView arriendoCuotaView) {
        this.view = view;
        this.arriendoCuotaView = arriendoCuotaView;
        initController();
    }

    private void initController() {
        view.getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCliente();
            }
        });
    }

    private void agregarCliente() {
        String cedula = view.getTxtCedula().getText();
        String nombre = view.getTxtNombre().getText();
        boolean vigente = view.getChkVigente().isSelected();

        if (!cedula.isEmpty() && !nombre.isEmpty()) {
            Cliente cliente = new Cliente(cedula, nombre, vigente);
            System.out.println("Cliente agregado: " + cliente);
            limpiarCampos();

            // Añadir cliente al JComboBox en ArriendoCuotaView
            arriendoCuotaView.getCmbClientes().addItem(cliente.toString());

            // Cerrar ClienteView y abrir ArriendoCuotaView
            view.setVisible(false);
            arriendoCuotaView.setVisible(true);
        } else {
            System.out.println("Por favor, complete todos los campos.");
        }
    }

    private void limpiarCampos() {
        view.getTxtCedula().setText("");
        view.getTxtNombre().setText("");
        view.getChkVigente().setSelected(false);
    }
}
