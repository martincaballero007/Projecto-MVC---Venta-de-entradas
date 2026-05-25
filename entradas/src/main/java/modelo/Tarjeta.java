package modelo;

public class Tarjeta {

    private long numero;   // long para soportar los 16 dígitos de tarjetas reales
    private String nombre;
    private String fecha;
    private int cvv;

    public Tarjeta() {
    }

    public Tarjeta(long numero, String nombre, String fecha, int cvv) {
        this.numero = numero;
        this.nombre = nombre;
        this.fecha = fecha;
        this.cvv = cvv;
    }

    public boolean validar() {
        return numero > 0 && cvv > 0 && nombre != null && !nombre.isEmpty();
    }

    // Getters y Setters
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

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

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }
}
