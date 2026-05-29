package controlador;

import modelo.Tarjeta;
import modelo.Venta;
import vista.VistaPrincipal;
import excepciones.VentaExcepcion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppControlador {
    private final VistaPrincipal vista;
    private final ConciertoControlador modeloControlador;

    // Vincula la interfaz con el procesador de lógica
    public AppControlador(VistaPrincipal vista, ConciertoControlador modeloControlador) {
        this.vista = vista;
        this.modeloControlador = modeloControlador;
        
        // Asignar listeners declarados en la interfaz Swing
        this.vista.addComprarListener(new ComprarAction());
        this.vista.addSalirListener(e -> System.exit(0));
    }

    private class ComprarAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String nombreZona = vista.getNombreZona();
                int cantidad = Integer.parseInt(vista.getCantidadInput());
                long numTarjeta = Long.parseLong(vista.getNumTarjetaInput());
                String titular = vista.getTitularInput();
                String vencimiento = vista.getVencimientoInput();
                int cvv = Integer.parseInt(vista.getCvvInput());

                Tarjeta tarjetaCliente = new Tarjeta(numTarjeta, titular, vencimiento, cvv);
                Venta ventaRealizada = modeloControlador.procesarCompra(nombreZona, cantidad, tarjetaCliente);

                String msg = "¡COMPRA EXITOSA!\n" +
                             "Monto total pagado: $" + ventaRealizada.getMonto() + "\n" +
                             "Fecha de compra: " + ventaRealizada.getFecha().toString();
                vista.mostrarMensajeExitoso(msg);
                vista.limpiarFormulario();

            } catch (NumberFormatException nfe) {
                vista.mostrarError("Error: Ingrese valores numéricos válidos en Cantidad, Tarjeta y CVV.");
            } catch (VentaExcepcion ve) {
                vista.mostrarError("Error en la compra: " + ve.getMessage());
            } catch (Exception ex) {
                vista.mostrarError("Ha ocurrido un error inesperado: " + ex.getMessage());
            }
        }
    }
}