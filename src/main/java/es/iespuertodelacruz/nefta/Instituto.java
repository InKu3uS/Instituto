package es.iespuertodelacruz.nefta;

import java.util.ArrayList;

import es.iespuertodelacruz.nefta.exceptions.AlumnoException;
import es.iespuertodelacruz.nefta.exceptions.AulaException;
import es.iespuertodelacruz.nefta.exceptions.ProfesorException;

public class Instituto {

    ArrayList<Alumnos> listaalumnos = null;
    ArrayList<Notas> listanotas = null;
    ArrayList<Aulas> listaaulas = null;
    ArrayList<Profesores> listaprofesores = null;

    public Instituto() {
        listaalumnos = new ArrayList<>();
        listanotas = new ArrayList<>();
        listaaulas = new ArrayList<>();
        listaprofesores = new ArrayList<>();

    }

    /**
     * Funcion que verifica si existe el alumno
     * 
     * @param alumno a buscar
     * @return true/false
     */
    public boolean alumnoExiste(Alumnos alumno) {
        return listaalumnos.contains(alumno);
    }

    /**
     * Funcion que verifica si existe el profesor
     * 
     * @param profesor a buscar
     * @return true/false
     */
    public boolean profesorExiste(Profesores profesor) {
        return listaprofesores.contains(profesor);
    }

    /**
     * Funcion que verifica si existe el aula
     * 
     * @param aula a buscar
     * @return true/false
     */
    public boolean aulaExiste(Aulas aula) {
        return listaaulas.contains(aula);
    }

    /**
     * Funcion que verifica si existe la nota
     * 
     * @param nota a buscar
     * @return true/false
     */
    public boolean notaExiste(Notas nota) {
        return listanotas.contains(nota);
    }

    /**
     * Metodo para insertar un alumno en la lista
     * 
     * @param alumno a insertar
     * @throws AlumnoException error controlado
     */
    public void insertarAlumno(Alumnos alumno) throws AlumnoException {
        if (!alumnoExiste(alumno)) {
            listaalumnos.add(alumno);
        } else {
            throw new AlumnoException("El alumno ya esta en la lista" + alumno);
        }
    }

    /**
     * Metodo para eliminar un alumno de la lista
     * 
     * @param alumno a eliminar
     * @throws AlumnoException error controlado
     */
    public void borrarAlumno(Alumnos alumno) throws AlumnoException {
        if (alumnoExiste(alumno)) {
            listaalumnos.remove(alumno);
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
    public void insertarProfesor(Profesores profesor) throws ProfesorException {
        if (!profesorExiste(profesor)) {
            listaprofesores.add(profesor);
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
    public void borrarProfesor(Profesores profesor) throws ProfesorException {
        if (profesorExiste(profesor)) {
            listaprofesores.remove(profesor);
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
    public void insertarAula(Aulas aula) throws AulaException {
        if (!aulaExiste(aula)) {
            listaaulas.add(aula);
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
    public void borrarAula(Aulas aula) throws AulaException {
        if (aulaExiste(aula)) {
            listaaulas.remove(aula);
        } else {
            throw new AulaException("El aula no existe en la lista" + aula);
        }
    }

    /**
     * Metodo para insertar nota de una asignatura
     * 
     * @param nota a insertar
     */
    public void insertarNota(Notas nota) {
        listanotas.add(nota);
    }

}
