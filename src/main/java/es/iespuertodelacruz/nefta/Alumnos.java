package es.iespuertodelacruz.nefta;

import java.util.Objects;

public class Alumnos extends Persona {

    private static final long serialVersionUID = -8998687794343508825L;

    public Notas notas;

    /**
     * Constructor vacio
     */
    public Alumnos() {

    }

    /**
     * Constructor con parametros
     * 
     * @param dni       del alumno
     * @param nombre    del alumno
     * @param apellidos del alumno
     * @param notas     del alumno
     * @throws Exception
     */
    public Alumnos(String dni, String nombre, String apellidos, Notas notas) throws Exception {
        super(dni, nombre, apellidos);
        this.notas = notas;
    }

    /**
     * Getter de notas
     * 
     * @return notas
     */
    public Notas getNotas() {
        return this.notas;
    }

    /**
     * Metodo equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Alumnos)) {
            return false;
        }
        Alumnos alumnos = (Alumnos) o;
        return Objects.equals(notas, alumnos.notas);
    }

    /**
     * Metodo toString
     */
    @Override
    public String toString() {
        return getNombre() + "-" + getApellidos() + "-" + getDni() + "-" + getNotas() + "\n";
    }

}
