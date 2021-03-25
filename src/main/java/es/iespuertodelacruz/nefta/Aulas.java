package es.iespuertodelacruz.nefta;

public class Aulas {

    int piso;
    int numero;
    public Alumno alumnos;

    /**
     * Constructor vacio
     */
    public Aulas() {
    }

    /**
     * Constructor con parametros
     * 
     * @param piso   del aula
     * @param numero del aula
     */
    public Aulas(int piso, int numero, Alumno alumnos) {
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

    public Alumno getAlumnos() {
        return this.alumnos;
    }

    public void setAlumnos(Alumno alumnos) {
        this.alumnos = alumnos;
    }

    /**
     * Metodo equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Aulas)) {
            return false;
        }
        Aulas aulas = (Aulas) o;
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
