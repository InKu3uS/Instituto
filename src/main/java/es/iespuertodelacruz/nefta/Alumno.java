package es.iespuertodelacruz.nefta;

import java.util.ArrayList;
import java.util.Objects;

public class Alumno extends Persona {

    private static final long serialVersionUID = -8998687794343508825L;

    ArrayList<Nota> notas;

    /**
     * Constructor vacio
     */
    public Alumno() {

        notas = new ArrayList<>();

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
    public Alumno(String dni, String nombre, String apellidos, ArrayList<Nota> notas) throws Exception {
        super(dni, nombre, apellidos);
        this.notas = notas;
    }

    /**
     * Getter de la arraylist notas
     * 
     * @return notas
     */
    public ArrayList<Nota> getNotas() {
        return this.notas;
    }

    /**
     * Metodo equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Alumno)) {
            return false;
        }
        Alumno alumnos = (Alumno) o;
        return Objects.equals(notas, alumnos.notas);
    }

    /**
     * Metodo toString
     */
    @Override
    public String toString() {
        return getNombre() + "-" + getApellidos() + "-" + getDni() + "-" + notas.toString();
    }

}
