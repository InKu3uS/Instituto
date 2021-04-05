package es.iespuertodelacruz.nefta;

import java.util.ArrayList;
import java.util.Objects;

public class Profesor extends Persona {

    private static final long serialVersionUID = -7098513995355326641L;

    ArrayList<Aula> aulas;

    /**
     * Constructor vacio
     */
    public Profesor() {

        aulas = new ArrayList<>();
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
    public Profesor(String dni, String nombre, String apellidos, ArrayList<Aula> aulas) throws Exception {
        super(dni, nombre, apellidos);
        this.aulas = aulas;
    }

    /**
     * Getters y Setters
     * 
     * @return
     */
    public ArrayList<Aula> getAulas() {
        return this.aulas;
    }

    
    /**
     * Metodo equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Profesor)) {
            return false;
        }
        Profesor profesores = (Profesor) o;
        return Objects.equals(aulas, profesores.aulas);
    }

    /**
     * Metodo toString
     */
    @Override
    public String toString() {
        return getNombre() + "-" + getApellidos() + "-" + getDni() + "-" + aulas.toString() + "\n";
    }

}
