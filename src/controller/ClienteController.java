package controller;

import model.Cliente;
import model.Data;
import view.ClienteView;
import view.PagarCuotasView;
import view.Components.ComboBoxItem;
import view.ArriendoCuotaView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ClienteController {
    private ClienteView view;
    private ArriendoCuotaView arriendoCuotaView;
    private PagarCuotasView pagarCuotasView;

    public ClienteController(ClienteView view, ArriendoCuotaView arriendoCuotaView, PagarCuotasView pagarCuotasView) {
        this.view = view;
        this.arriendoCuotaView = arriendoCuotaView;
        this.pagarCuotasView = pagarCuotasView;
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

        if (cedula.isEmpty() || nombre.isEmpty()) {
            JOptionPane.showMessageDialog(view, "Por   favorcomplete todos los campos");
            return;
        }

        // if (!isCedulaValid(cedula)) {
        //     JOptionPane.showMessageDialog(view, "La cédula ingresada no es válida");
        //     return;
        // }

        // Crear cliente y añadirlo a la lista de clientes
        Cliente cliente = new Cliente(cedula, nombre, vigente);
        Data.clientes.add(cliente);

        // Mostrar mensaje de éxito
        JOptionPane.showMessageDialog(view, "Cliente agregado exitosamente");
        limpiarCampos();

        // Añadir cliente al JComboBox en ArriendoCuotaView y en PagarCuotasView
        String vigencia = cliente.isVigente() ? "" : " (No Vigente)";
        String displayValue = cliente.getNombre() + vigencia;
        arriendoCuotaView.getCmbClientes().addItem(new ComboBoxItem(displayValue, cedula));
        pagarCuotasView.getCmbClientes().addItem(new ComboBoxItem(displayValue, cedula));


        // Cerrar ClienteView y abrir ArriendoCuotaView
        view.setVisible(false);
        arriendoCuotaView.setVisible(true);
    }

    private void limpiarCampos() {
        view.getTxtCedula().setText("");
        view.getTxtNombre().setText("");
        view.getChkVigente().setSelected(false);
    }

    private boolean isCedulaValid(String cedula) {
        //quitar espacios en blanco,puntos y guiones
        cedula = cedula.trim().replace(".", "").replace("-", "");
        //separar número y digito verificador
        String numero = cedula.substring(0, cedula.length() - 1);
        char dvIngresado = cedula.charAt(cedula.length() - 1);
    
        char[] digitos = numero.toCharArray();
        int[] secuencia = {2,3,4,5,6,7};
    
        int suma = 0;
        int j = 0;
        for (int i = digitos.length - 1; i >= 0; i--) {
            suma += Character.getNumericValue(digitos[i]) * secuencia[j];
            j = (j + 1) % secuencia.length;
        }
    
        int resto = suma % 11;
        int dvCalculado = 11 - resto;
    
        char dvEsperado;
        if (dvCalculado == 10) {
            dvEsperado = 'K';
        } else if (dvCalculado == 11) {
            dvEsperado = '0';
        } else {
            dvEsperado = (char) (dvCalculado + '0');
        }
    
        return dvIngresado == dvEsperado;
        }
}
