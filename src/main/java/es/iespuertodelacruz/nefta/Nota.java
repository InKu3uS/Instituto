package es.iespuertodelacruz.nefta;

import java.util.Objects;

public class Nota {

    String nombre;
    double calificacion;

    public Nota() {

    }

    /**
     * Constructor con parametros
     * 
     * @param nombre       de la asignatura
     * @param calificacion nota de la asignatura
     */
    public Nota(String nombre, double calificacion) {
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

    public double getCalificacion() {
        return this.calificacion;
    }

    /**
     * Metodo equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Nota)) {
            return false;
        }
        Nota notas = (Nota) o;
        return Objects.equals(nombre, notas.nombre) && Objects.equals(calificacion, notas.calificacion);
    }

    /**
     * Metodo toString
     */
    @Override
    public String toString() {
        return getNombre() + ":" + getCalificacion();
    }

}
