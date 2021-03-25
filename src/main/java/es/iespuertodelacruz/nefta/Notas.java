package es.iespuertodelacruz.nefta;

import java.util.Objects;

public class Notas {

    String nombre;
    double calificacion;

    public Notas() {

    }

    /**
     * Constructor con parametros
     * 
     * @param nombre       de la asignatura
     * @param calificacion nota de la asignatura
     */
    public Notas(String nombre, double calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

    /**
     * Getters y Setters
     * 
     * @return
     */
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCalificacion() {
        return this.calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    /**
     * Metodo equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Notas)) {
            return false;
        }
        Notas notas = (Notas) o;
        return Objects.equals(nombre, notas.nombre) && Objects.equals(calificacion, notas.calificacion);
    }

    /**
     * Metodo toString
     */
    @Override
    public String toString() {
        return getNombre() + ":" + getCalificacion() + "\n";
    }

}
