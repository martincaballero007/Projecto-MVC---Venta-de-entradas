import modelo.Concierto;
import modelo.Zona;
import modelo.Cliente;
import controlador.ConciertoControlador;
import vista.VistaPrincipal;

public class Main {
    public static void main(String[] args) {
        
        Concierto concierto = new Concierto("Rock en Lima", "20/06/2026");
        
        Zona zonaVip = new Zona("VIP", 100, 250);
        zonaVip.generarEntradas();
        
        Zona zonaGeneral = new Zona("General", 500, 100);
        zonaGeneral.generarEntradas();

        concierto.agregarZona(zonaVip);
        concierto.agregarZona(zonaGeneral);

        Cliente clientePrueba = new Cliente("Juan", "Perez", "12345678", "clave123", 0);

        
        ConciertoControlador controlador = new ConciertoControlador(concierto);
        controlador.iniciarSesionCliente(clientePrueba);

        
        VistaPrincipal vista = new VistaPrincipal(controlador);
        vista.iniciar();
    }
}