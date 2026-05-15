/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author odiol
 */
public class Entrada {

    private int numero;
    private String estado;

    public Entrada() {
    }

    public Entrada(int numero, String estado) {
        this.numero = numero;
        this.estado = estado;
    }

    public boolean vender() {
        if ("DISPONIBLE".equalsIgnoreCase(this.estado)) {
            this.estado = "VENDIDA";
            return true;
        }
        return false;
    }

    public boolean liberar() {
        if ("VENDIDA".equalsIgnoreCase(this.estado)) {
            this.estado = "DISPONIBLE";
            return true;
        }
        return false;
    }

    // Getters y Setters
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
