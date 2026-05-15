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

public class Concierto {

    private String nombre;
    private String fecha;

    // Relación 1 a *: Un Concierto contiene múltiples Zonas
    private List<Zona> listaDeZonas;

    public Concierto() {
        this.listaDeZonas = new ArrayList<>();
    }

    public Concierto(String nombre, String fecha) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.listaDeZonas = new ArrayList<>();
    }

    /* Agrega una zona nueva al concierto creando el objeto internamente.*/
    public boolean agregarZona(String nombreDeLaNuevaZona) {
        for (Zona zonaExistente : listaDeZonas) {
            if (zonaExistente.getNombre().equalsIgnoreCase(nombreDeLaNuevaZona)) {
                return false; // Evita nombres duplicados
            }
        }
        listaDeZonas.add(new Zona(nombreDeLaNuevaZona, 0, 0));
        return true;
    }

    /* Agrega un objeto Zona ya configurado a la lista del concierto.*/
    public boolean agregarZona(Zona zonaParaAgregar) {
        for (Zona zonaEnLista : listaDeZonas) {
            if (zonaEnLista.getNombre().equalsIgnoreCase(zonaParaAgregar.getNombre())) {
                return false;
            }
        }
        listaDeZonas.add(zonaParaAgregar);
        return true;
    }

    /*Elimina una zona de la lista basándose en su nombre.*/
    public boolean eliminarZona(String nombreDeZonaAEliminar) {
        return listaDeZonas.removeIf(zonaActual -> 
            zonaActual.getNombre().equalsIgnoreCase(nombreDeZonaAEliminar)
        );
    }

    /* Busca y retorna una zona específica por su nombre.  */
    public Zona buscarZona(String nombreDeZonaABuscar) {
        return listaDeZonas.stream()
                .filter(zonaCualquiera -> zonaCualquiera.getNombre().equalsIgnoreCase(nombreDeZonaABuscar))
                .findFirst()
                .orElse(null);
    }

    // --- Getters y Setters ---

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public List<Zona> getZonas() {
        return listaDeZonas;
    }

    public void setZonas(List<Zona> listaDeZonas) {
        this.listaDeZonas = listaDeZonas;
    }
}