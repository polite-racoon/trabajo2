import view.ClienteView;
import view.ArriendoCuotaView;
import view.PagarCuotasView;
import controller.ClienteController;
import controller.ArriendoCuotaController;
import controller.PagarCuotasController;

public class Main {
    public static void main(String[] args) {
        // Crear vistas
        ClienteView clienteView = new ClienteView();
        ArriendoCuotaView arriendoCuotaView = new ArriendoCuotaView();
        PagarCuotasView pagarCuotasView = new PagarCuotasView();

        // Crear controladores
        new ClienteController(clienteView, arriendoCuotaView);
        new ArriendoCuotaController(arriendoCuotaView, pagarCuotasView);
        new PagarCuotasController(pagarCuotasView);

        // Mostrar ClienteView
        clienteView.setVisible(true);
    }
}
