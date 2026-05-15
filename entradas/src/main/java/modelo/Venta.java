/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author odiol
 */
public class Venta {

    private Date fecha;
    private int monto;

    // Asociacion: una Venta referencia a una Zona
    private Zona zona;

    // Agregacion y restriccion, una venta contiene entre 1 y 4 entradas
    private List<Entrada> entradas;

    
    private Tarjeta tarjeta;

    public Venta() {
        this.entradas = new ArrayList<>();
        this.fecha = new Date();
    }

    public Venta(Date fecha, int monto, Zona zona, Tarjeta tarjeta) {
        this.fecha = fecha;
        this.monto = monto;
        this.zona = zona;
        this.tarjeta = tarjeta;
        this.entradas = new ArrayList<>();
    }

    /*Anular venta y libera las entradas asociadas */
    public boolean anular() {
        if (entradas == null || entradas.isEmpty()) {
            return false;
        }
        for (int i = 0; i < entradas.size(); i++) {
            Entrada e = entradas.get(i); // Aquí creas manualmente el "e" usando la posición i
            e.liberar();
        }
        
        this.monto = 0;
        return true;
    }

    /*Validar venta 1 y 4 entradas    */
   public boolean esValida() {
    
    if (entradas == null) {
        return false;
    }

    int cantidad = entradas.size();

    
    boolean tieneMinimo = cantidad >= 1;
    boolean tieneMaximo = cantidad <= 4;

    return tieneMinimo && tieneMaximo;
}

    // Getters y Setters
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Zona getZona() {
        return zona;
    }

    public void setZona(Zona zona) {
        this.zona = zona;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }

    public void agregarEntrada(Entrada entrada) {
        if (this.entradas.size() < 4) {
            this.entradas.add(entrada);
        }
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }
}
