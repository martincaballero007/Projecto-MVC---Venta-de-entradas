/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author odiol
 */
public class Usuario extends Persona {

    private boolean estado;

    public Usuario() {
    }

    public Usuario(String nombres, String apellidos, String dni, String contrasena, boolean estado) {
        super(nombres, apellidos, dni, contrasena);
        this.estado = estado;
    }

    public void registrarZonas() {
        
    }

    // Getters y Setters
    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}