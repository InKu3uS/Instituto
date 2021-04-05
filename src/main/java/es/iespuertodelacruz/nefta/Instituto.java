package es.iespuertodelacruz.nefta;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

import es.iespuertodelacruz.nefta.exceptions.AlumnoException;
import es.iespuertodelacruz.nefta.exceptions.AulaException;
import es.iespuertodelacruz.nefta.exceptions.FicheroException;
import es.iespuertodelacruz.nefta.exceptions.ProfesorException;

public class Instituto {

    ArrayList<Alumno> alumnos = null;
    ArrayList<Aula> aulas = null;
    ArrayList<Profesor> profesores = null;
    ArrayList<Nota> notas = null;

    public Instituto() {
        alumnos = new ArrayList<>();
        aulas = new ArrayList<>();
        profesores = new ArrayList<>();
        notas = new ArrayList<>();
    }

    /**
     * Funcion que verifica si existe el alumno
     *
     * @param alumno a buscar
     * @return true/false
     */
    public boolean alumnoExiste(Alumno alumno) {
        return alumnos.contains(alumno);
    }

    /**
     * Funcion que verifica si existe la nota
     *
     * @param nota a buscar
     * @return true/false
     */
    public boolean notaExiste(Nota nota) {
        return notas.contains(nota);
    }

    /**
     * Funcion que verifica si existe el profesor
     *
     * @param profesor a buscar
     * @return true/false
     */
    public boolean profesorExiste(Profesor profesor) {
        return profesores.contains(profesor);
    }

    /**
     * Funcion que verifica si existe el aula
     *
     * @param aula a buscar
     * @return true/false
     */
    public boolean aulaExiste(Aula aula) {
        return aulas.contains(aula);
    }

    /**
     * Metodo para insertar un alumno en la lista
     *
     * @param alumno a insertar
     * @throws AlumnoException error controlado
     */
    public void insertarAlumno(Alumno alumno) throws AlumnoException {
        if (!alumnoExiste(alumno)) {
            alumnos.add(alumno);
        } else {
            throw new AlumnoException("El alumno ya esta en la lista" + alumno);
        }
    }

    /**
     * Metodo para insertar una nota
     *
     * @param nota a insertar
     */
    public void insertarNota(Nota nota) {
        notas.add(nota);
    }

    /**
     * Metodo para eliminar un alumno de la lista
     *
     * @param alumno a eliminar
     * @throws AlumnoException error controlado
     */
    public void borrarAlumno(Alumno alumno) throws AlumnoException {
        if (alumnoExiste(alumno)) {
            alumnos.remove(alumno);
        } else {
            throw new AlumnoException("El alumno no existe en la lista" + alumno);
        }
    }

    /**
     * Metodo para insertar un profesor en la lista
     *
     * @param profesor a insertar
     * @throws ProfesorException error controlado
     */
    public void insertarProfesor(Profesor profesor) throws ProfesorException {
        if (!profesorExiste(profesor)) {
            profesores.add(profesor);
        } else {
            throw new ProfesorException("El profesor ya esta en la lista" + profesor);
        }
    }

    /**
     * Metodo para eliminar un profesor de la lista
     *
     * @param profesor a eliminar
     * @throws ProfesorException error controlado
     */
    public void borrarProfesor(Profesor profesor) throws ProfesorException {
        if (profesorExiste(profesor)) {
            profesores.remove(profesor);
        } else {
            throw new ProfesorException("El profesor no existe en la lista" + profesor);
        }
    }

    /**
     * Metodo para insertar un aula en la lista
     *
     * @param aula a insertar
     * @throws AulaException error controlado
     */
    public void insertarAula(Aula aula) throws AulaException {
        if (!aulaExiste(aula)) {
            aulas.add(aula);
        } else {
            throw new AulaException("El aula ya esta en la lista" + aula);
        }
    }

    /**
     * Metodo para borrar un aula de la lista
     *
     * @param aula a eliminar
     * @throws AulaException error controlado
     */
    public void borrarAula(Aula aula) throws AulaException {
        if (aulaExiste(aula)) {
            aulas.remove(aula);
        } else {
            throw new AulaException("El aula no existe en la lista" + aula);
        }
    }

    /**
     * Metodo que muestra las notas de todas las asignaturas de un alumno
     *
     * @param dni del alumno
     * @return lista de notas del alumno
     */
    public ArrayList<Double> verNotas(String dni) {
        ArrayList<Double> notaAlumnos = new ArrayList<>();

        for (int i = 0; i < notas.size(); i++) {
            Alumno alumno = alumnos.get(i);
            if (alumno.getDni().equals(dni)) {
                notaAlumnos.add(notas.get(i).getCalificacion());
            }
        }
        return notaAlumnos;
    }

    /**
     * Busca al alumno por el DNI
     * 
     * @param dni del alumno
     * @return Objeto alumno
     */
    public Alumno buscaAlumno(String dni) {
        Alumno alumno = null;
        for (int i = 0; i < alumnos.size(); i++) {
            if (alumnos.get(i).getDni().equals(dni)) {
                alumno = alumnos.get(i);
            }
        }
        return alumno;
    }

    /**
     * Lista de alumnos
     * 
     * @return alumnos
     */
    public ArrayList<Nota> notasAlumno() {
        ArrayList<Nota> notasalumno = new ArrayList<>();
        for (int i = 0; i < notas.size(); i++) {
            notasalumno.add(notas.get(i));
        }
        return notasalumno;
    }

    /**
     * Metodo que almacena las notas todos los alumnos
     *
     * @throws FicheroException error controlado
     */
    public void almacenarTodasNotas(String nombre) throws FicheroException {
        FileWriter escribir = null;
        try {
            escribir = new FileWriter(nombre);
            escribir.write(String.valueOf(notasAlumno()));
        } catch (Exception e) {
            throw new FicheroException("El fichero no se puede crear");
        } finally {
            if (escribir != null) {
                try {
                    escribir.close();
                } catch (IOException e) {
                    throw new FicheroException("El fichero no se pudo cerrar", e);
                }
            }
        }
    }

    /**
     * Metodo que almacena las notas de un alumno en un fichero
     *
     * @throws FicheroException error controlado
     */
    public void almacenarNotasAlumno(String dni) throws FicheroException {
        Alumno alumno = null;
        FileWriter escribir = null;
        try {
            if (buscaAlumno(dni) != null) {
                alumno = buscaAlumno(dni);
                escribir = new FileWriter(alumno.getNombre() + "_" + alumno.getApellidos() + ".txt");
                escribir.write(buscaAlumno(dni) + String.valueOf(verNotas(dni)));
            }
        } catch (Exception e) {
            throw new FicheroException("El fichero no se puede crear");
        } finally {
            if (escribir != null) {
                try {
                    escribir.close();
                } catch (IOException e) {
                    throw new FicheroException("El fichero no se pudo cerrar", e);
                }
            }
        }
    }

    /**
     * Metodo que comprueba que un fichero existe
     * 
     * @param fichero a buscar
     * @return true o false
     */
    public boolean validarFichero(File fichero) {
        return fichero.exists();
    }

    public String leer(String nombre) throws FicheroException {

        StringBuilder informacion = null;
        File fichero = null;
        Scanner scanner = null;

        try {

            fichero = new File(nombre);

            if (!validarFichero(fichero)) {

                throw new FicheroException("El fichero a leer no existe");
            }
            informacion = new StringBuilder();
            scanner = new Scanner(fichero);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                informacion.append(linea + "\n");
            }
        } catch (FicheroException e) {
            throw e;
        } catch (Exception e) {
            throw new FicheroException("Se ha producido un error en la lectura del fichero", e);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return informacion.toString();
    }
}
