package es.iespuertodelacruz.nefta;

import java.util.ArrayList;

public class Aula {

    int piso;
    int numero;
    ArrayList<Alumno> alumnos;

    /**
     * Constructor vacio
     */
    public Aula() {

        alumnos = new ArrayList<>();
    }

    /**
     * Constructor con parametros
     * 
     * @param piso   del aula
     * @param numero del aula
     */
    public Aula(int piso, int numero, ArrayList<Alumno> alumnos) {
        this.piso = piso;
        this.numero = numero;
        this.alumnos = alumnos;
    }

    /**
     * Getters y Setters de la clase
     * 
     * @return
     */
    public int getPiso() {
        return this.piso;
    }

    public int getNumero() {
        return this.numero;
    }

    public ArrayList<Alumno> getAlumnos() {
        return this.alumnos;
    }

    /**
     * Metodo equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Aula)) {
            return false;
        }
        Aula aulas = (Aula) o;
        return piso == aulas.piso && numero == aulas.numero;
    }

    /**
     * Metodo toString
     */
    @Override
    public String toString() {
        return getPiso() + "-" + getNumero() + "-" + getAlumnos() + "\n";
    }

}
