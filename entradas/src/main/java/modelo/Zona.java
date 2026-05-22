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
import excepciones.VentaExcepcion;

public class Zona {

    private String nombre;
    private int capacidad;
    private int precio;

    // Composición: una Zona contiene múltiples Entradas
    private List<Entrada> entradas;

    public Zona() {
        this.entradas = new ArrayList<>();
    }

    public Zona(String nombre, int capacidad, int precio) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precio = precio;
        this.entradas = new ArrayList<>();
    }

    /*Generar entradas  */
    
    public boolean generarEntradas() {
        if (capacidad <= 0) {
            return false;
        }
        entradas.clear();
        for (int i = 1; i <= capacidad; i++) {
            entradas.add(new Entrada(i, "DISPONIBLE"));
        }
        return true;
    }

/* Retornar entradas disponibles */
public Entrada[] venderEntrada(int cantidadASolicitar) throws VentaExcepcion {
        if (cantidadASolicitar < 1 || cantidadASolicitar > 4) {
            throw new VentaExcepcion("Error: Solo se permite comprar entre 1 y 4 entradas.");
        }

        List<Entrada> listaTemporalDeDisponibles = new ArrayList<>();
        for (Entrada entradaIndividual : entradas) {
            if ("DISPONIBLE".equalsIgnoreCase(entradaIndividual.getEstado())) {
                listaTemporalDeDisponibles.add(entradaIndividual);
                if (listaTemporalDeDisponibles.size() == cantidadASolicitar) {
                    break;
                }
            }
        }

        if (listaTemporalDeDisponibles.size() < cantidadASolicitar) {
            throw new VentaExcepcion("Error: Stock insuficiente en la zona " + this.nombre + ". Quedan " + getCapacidadDisponible() + " entradas.");
        }

        for (Entrada entradaSeleccionada : listaTemporalDeDisponibles) {
            entradaSeleccionada.vender();
        }

        return listaTemporalDeDisponibles.toArray(new Entrada[0]);
    }

    public int getCapacidadDisponible() {
        return (int) entradas.stream()
                .filter(unaEntrada -> "DISPONIBLE".equalsIgnoreCase(unaEntrada.getEstado()))
                .count();
    }
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public List<Entrada> getEntradas() {
        return entradas;
    }

    public void setEntradas(List<Entrada> entradas) {
        this.entradas = entradas;
    }
}

