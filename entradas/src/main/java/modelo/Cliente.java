/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author odiol
 */

import java.util.ArrayList;
import java.util.List;
import excepciones.UsuarioExcepcion;

public class Cliente extends Persona {

    private int puntos;

    // Composición: un Cliente tiene una Tarjeta
    private Tarjeta tarjeta;

    // Asociación: un Cliente puede tener varias Ventas
    private List<Venta> ventas;

    public Cliente() {
        this.ventas = new ArrayList<>();
    }

    public Cliente(String nombres, String apellidos, String dni, String contrasena, int puntos) {
        super(nombres, apellidos, dni, contrasena);
        this.puntos = puntos;
        this.ventas = new ArrayList<>();
    }

    public boolean ingresar(String usuario, String clave) throws UsuarioExcepcion {
        if (this.getDni() == null || this.getContrasena() == null) {
            throw new UsuarioExcepcion("Credenciales no configuradas.");
        }
        if (this.getDni().equals(usuario) && this.getContrasena().equals(clave)) {
            return true;
        } else {
            throw new UsuarioExcepcion("DNI o contraseña incorrectos.");
        }
    }

    @Override
    public boolean registrarTarjeta() {
        return tarjeta != null;
    }

    @Override
    public boolean eliminarTarjeta() {
        if (tarjeta != null) {
            tarjeta = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean anularVenta() {
        return false;
    }

    @Override
    public boolean comprar() {
        return tarjeta != null;
    }

    // Getters y Setters
    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }

    public void agregarVenta(Venta venta) {
        this.ventas.add(venta);
    }
}
