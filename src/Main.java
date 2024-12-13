import view.ClienteView;
import view.ArriendoCuotaView;
import view.PagarCuotasView;
import controller.ClienteController;
import controller.ArriendoCuotaController;
import controller.PagarCuotasController;
import model.Vehiculo;
import model.Data;

public class Main {
    public static void main(String[] args) {
        crearVehiculos();

        // Crear vistas
        ClienteView clienteView = new ClienteView();
        ArriendoCuotaView arriendoCuotaView = new ArriendoCuotaView();
        PagarCuotasView pagarCuotasView = new PagarCuotasView();
        
        // Crear controladores
        new ClienteController(clienteView, arriendoCuotaView);
        new ArriendoCuotaController(arriendoCuotaView, pagarCuotasView, clienteView);
        new PagarCuotasController(pagarCuotasView);

        clienteView.setVisible(true);
    }

    static void crearVehiculos() {
        Data.vehiculos.add(new Vehiculo("AB1234", "Toyota", "Yaris", 10000));
        Data.vehiculos.add(new Vehiculo("CD5678", "Suzuki", "Swift", 12000));
        Data.vehiculos.add(new Vehiculo("EF9101", "Kia", "Rio", 15000));
        Data.vehiculos.add(new Vehiculo("GH1121", "Hyundai", "Accent", 20000));
        Data.vehiculos.add(new Vehiculo("IJ3141", "Chevrolet", "Sail", 18000));
    }
}
