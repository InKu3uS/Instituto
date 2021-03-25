package es.iespuertodelacruz.nefta;

import java.util.Objects;

public class Profesores extends Persona {

    private static final long serialVersionUID = -7098513995355326641L;

    public Aulas aulas;

    /**
     * Constructor vacio
     */
    public Profesores() {
    }

    /**
     * Constructor con parametros
     * 
     * @param dni       del profesor
     * @param nombre    del profesor
     * @param apellidos del profesor
     * @param aulas     en las que imparte clase el profesor
     * @throws Exception
     */
    public Profesores(String dni, String nombre, String apellidos, Aulas aulas) throws Exception {
        super(dni, nombre, apellidos);
        this.aulas = aulas;
    }

    /**
     * Get de aulas
     * 
     * @return
     */
    public Aulas getAulas() {
        return this.aulas;
    }

    /**
     * Metodo equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Profesores)) {
            return false;
        }
        Profesores profesores = (Profesores) o;
        return Objects.equals(aulas, profesores.aulas);
    }

    /**
     * Metodo toString
     */
    @Override
    public String toString() {
        return getNombre() + "-" + getApellidos() + "-" + getDni() + "-" + getAulas() + "\n";
    }

}
