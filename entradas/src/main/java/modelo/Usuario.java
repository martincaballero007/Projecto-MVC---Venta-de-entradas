package modelo;

public class Usuario extends Persona {

    private boolean estado;

    public Usuario() {
    }

    public Usuario(String nombres, String apellidos, String dni, String contrasena, boolean estado) {
        super(nombres, apellidos, dni, contrasena);
        this.estado = estado;
    }

    // Administrador: puede registrar zonas en el sistema
    public void registrarZonas() {
        // TODO: lógica para registrar zonas
    }

    // Implementación de los métodos abstractos de Persona
    // Un Usuario administrador no realiza compras personales
    @Override
    public boolean registrarTarjeta() {
        return false; // los administradores no tienen tarjeta asociada
    }

    @Override
    public boolean eliminarTarjeta() {
        return false;
    }

    @Override
    public boolean anularVenta() {
        // Un administrador sí puede anular ventas
        return estado; // solo si está activo
    }

    @Override
    public boolean comprar() {
        return false; // los administradores no compran entradas
    }

    // Getters y Setters
    public boolean isEstado() { return estado; }
    public void setEstado(boolean estado) { this.estado = estado; }
}
