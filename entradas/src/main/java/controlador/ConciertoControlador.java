package controlador;

import modelo.Concierto;
import modelo.Zona;
import modelo.Entrada;
import modelo.Cliente;
import modelo.Tarjeta;
import modelo.Venta;
import excepciones.VentaExcepcion;
import java.util.Date;

public class ConciertoControlador {
    private Concierto conciertoActual;
    private Cliente clienteSesion;

    public ConciertoControlador(Concierto concierto) {
        this.conciertoActual = concierto;
    }

    public void iniciarSesionCliente(Cliente cliente) {
        this.clienteSesion = cliente;
    }

    public Venta procesarCompra(String nombreZona, int cantidad, Tarjeta tarjeta) throws VentaExcepcion {
        try {
            if (clienteSesion == null) {
                throw new VentaExcepcion("Debe iniciar sesión para comprar.");
            }
            if (tarjeta == null || !tarjeta.validar()) {
                throw new VentaExcepcion("Tarjeta inválida o no proporcionada.");
            }

            Zona zona = conciertoActual.buscarZona(nombreZona);

            Entrada[] entradasCompradas = zona.venderEntrada(cantidad);
            
            int montoTotal = zona.getPrecio() * cantidad;
            Venta nuevaVenta = new Venta(new Date(), montoTotal, zona, tarjeta);
            
            for (Entrada e : entradasCompradas) {
                nuevaVenta.agregarEntrada(e);
            }

            if (!nuevaVenta.esValida()) {
                nuevaVenta.anular();
                throw new VentaExcepcion("La venta no cumple los requisitos.");
            }

            clienteSesion.agregarVenta(nuevaVenta);
            return nuevaVenta;

        } catch (VentaExcepcion ve) {
            throw ve;
        } catch (Exception e) {
            throw new VentaExcepcion("Error crítico al procesar la transacción: " + e.getMessage());
        }
    }
}