import modelo.Concierto;
import modelo.Zona;
import modelo.Cliente;
import controlador.ConciertoControlador;
import controlador.AppControlador; 
import vista.VistaPrincipal;

public class Main {
    public static void main(String[] args) {
        
        Concierto concierto = new Concierto("Concierto de Prueba", "2026-12-25");
        
        Zona vip = new Zona("VIP", 20, 150);
        vip.generarEntradas();
        concierto.agregarZona(vip);
        
        Zona general = new Zona("General", 50, 60);
        general.generarEntradas();
        concierto.agregarZona(general);

        // Instancia el controlador lógico de negocio
        ConciertoControlador conciertoCtrl = new ConciertoControlador(concierto);
        
        
        Cliente clientePrueba = new Cliente("Jose", "Anonimo", "25200198", "pass@123", 100);
        conciertoCtrl.iniciarSesionCliente(clientePrueba);

        
        javax.swing.SwingUtilities.invokeLater(() -> {
            VistaPrincipal vista = new VistaPrincipal();
            
            new AppControlador(vista, conciertoCtrl);
            vista.setVisible(true);
        });
    }
}