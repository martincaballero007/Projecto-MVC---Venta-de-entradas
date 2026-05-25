package vista;

import controlador.ConciertoControlador;
import modelo.Tarjeta;
import modelo.Venta;
import excepciones.VentaExcepcion;
import java.util.Scanner;

public class VistaPrincipal {
    private ConciertoControlador controlador;
    private Scanner scanner;

    public VistaPrincipal(ConciertoControlador controlador) {
        this.controlador = controlador;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- SISTEMA DE VENTA DE ENTRADAS ---");
            System.out.println("1. Comprar Entradas");
            System.out.println("2. Salir");
            System.out.print("Seleccione una opción: ");

            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    mostrarMenuCompra();
                    break;
                case "2":
                    salir = true;
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    private void mostrarMenuCompra() {
        try {
            System.out.println("\n--- COMPRA DE ENTRADAS ---");
            System.out.print("Ingrese el nombre de la Zona (ej. VIP, General): ");
            String nombreZona = scanner.nextLine();

            System.out.print("Ingrese la cantidad de entradas (Máximo 4): ");
            int cantidad = Integer.parseInt(scanner.nextLine());

            // Datos completos de la tarjeta
            System.out.print("Ingrese el número de su tarjeta (16 dígitos): ");
            long numTarjeta = Long.parseLong(scanner.nextLine());

            System.out.print("Ingrese el nombre del titular: ");
            String titular = scanner.nextLine();

            System.out.print("Ingrese la fecha de vencimiento (MM/AA): ");
            String vencimiento = scanner.nextLine();

            System.out.print("Ingrese el CVV (3 dígitos): ");
            int cvv = Integer.parseInt(scanner.nextLine());

            Tarjeta tarjetaCliente = new Tarjeta(numTarjeta, titular, vencimiento, cvv);

            Venta ventaRealizada = controlador.procesarCompra(nombreZona, cantidad, tarjetaCliente);

            System.out.println("\n¡COMPRA EXITOSA!");
            System.out.println("Monto total pagado: $" + ventaRealizada.getMonto());
            System.out.println("Fecha de compra: " + ventaRealizada.getFecha().toString());

        } catch (NumberFormatException nfe) {
            System.err.println("Error: Debe ingresar un valor numérico válido.");
        } catch (VentaExcepcion ve) {
            System.err.println("Error en la compra: " + ve.getMessage());
        } catch (Exception e) {
            System.err.println("Ha ocurrido un error inesperado: " + e.getMessage());
        }
    }
}
