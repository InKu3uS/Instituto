package es.iespuertodelacruz.nefta;

import java.util.Objects;

import es.iespuertodelacruz.nefta.validaciones.ValidarDni;

public class Persona extends ValidarDni {

    private static final long serialVersionUID = 2582102258992445060L;

    String dni;
    String nombre;
    String apellidos;

    /**
     * Constructor vacio
     */
    public Persona() {
    }

    /**
     * Constructor con parametros
     * 
     * @param dni       de la persona
     * @param nombre    de la persona
     * @param apellidos de la persona
     * @throws Exception
     */
    public Persona(String dni, String nombre, String apellidos) throws Exception {
        validarDni(dni);
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    /**
     * Getters de la clase
     * 
     * @return
     */
    public String getDni() {
        return this.dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    /**
     * Metodo equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Persona)) {
            return false;
        }
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni) && Objects.equals(nombre, persona.nombre)
                && Objects.equals(apellidos, persona.apellidos);
    }

    /**
     * Metodo toString
     */
    @Override
    public String toString() {
        return getNombre() + "-" + getApellidos() + "-" + getDni() + "\n";
    }
}
