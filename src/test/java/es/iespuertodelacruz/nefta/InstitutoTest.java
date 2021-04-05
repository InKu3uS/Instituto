package es.iespuertodelacruz.nefta;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.iespuertodelacruz.nefta.exceptions.AlumnoException;
import es.iespuertodelacruz.nefta.exceptions.AulaException;
import es.iespuertodelacruz.nefta.exceptions.FicheroException;
import es.iespuertodelacruz.nefta.exceptions.NotasException;
import es.iespuertodelacruz.nefta.exceptions.ProfesorException;
import es.iespuertodelacruz.nefta.Instituto;
import es.iespuertodelacruz.nefta.Nota;
import org.junit.jupiter.api.AfterAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;

public class InstitutoTest {

    Alumno alumno;
    Alumno alumno2;
    Aula aula;
    File fichero;
    Profesor profesor;
    Instituto instituto;
    Nota nota;
    ArrayList<Nota> notas = new ArrayList<>();
    ArrayList<Aula> aulas = new ArrayList<>();

    @BeforeAll
    public static void setUpClass() throws Exception {
    }

    @AfterAll
    public static void tearDownClass() throws Exception {
    }

    @BeforeEach
    public void setup() throws NotasException {
        if (instituto == null) {
            instituto = new Instituto();
        }

        alumno = crearAlumno();
        try {
            instituto.insertarAlumno(alumno);
        } catch (AlumnoException e) {
            fail("Error al insertar el alumno");
        }
        profesor = crearProfesor();
        try {
            instituto.insertarProfesor(profesor);
        } catch (ProfesorException e) {
            fail("Error al insertar el profesor");
        }
        nota = crearNota();
        instituto.insertarNota(nota);

        aula = crearAula();
        try {
            instituto.insertarAula(aula);
        } catch (AulaException e) {
            fail("Error al insertar el aula");
        }

    }

    @AfterEach
    public void tearDown() throws Exception {
        instituto.borrarAlumno(alumno);
        instituto.borrarAula(aula);
        instituto.borrarProfesor(profesor);
    }

    @Test
    public void alumnoExisteTest() {
        assertTrue(instituto.alumnoExiste(alumno), "El alumno no existe");
    }

    @Test
    public void aulaExisteTest() {
        assertTrue(instituto.aulaExiste(aula), "El aula no existe");
    }

    @Test
    public void notaExisteTest() {
        assertTrue(instituto.notaExiste(nota), "La nota no existe");
    }

    @Test
    public void ProfesorExisteTest() {
        assertTrue(instituto.profesorExiste(profesor), "el profesor no existe");
        assertNotNull(profesor.getAulas());
    }

    @Test
    public void ProfesorEqualsTest() {
        assertEquals(profesor.toString(), crearProfesor().toString());
    }

    @Test
    public void AlumnoEqualsTest() {
        assertEquals(alumno.toString(), crearAlumno().toString());
    }

    @Test
    public void AlumnoNota() {
        assertTrue(alumno.getNotas().contains(nota), "La nota no existe");
    }

    @Test
    public void verAulas() {
        assertTrue(profesor.getAulas().contains(aula), "El aula no existe");
    }

    @Test
    public void errorDniTest() {
        try {
            alumno = new Alumno("Paco", "Gutierrez", "123456A", notas);
        } catch (Exception e) {
            boolean validar = e.getMessage().contains("no tiene un formato correcto");
            assertTrue(validar, "El programa no genera el error correcto");
        }
    }

    @Test
    public void ficheroNotaExisteTest() {
        try {
            instituto.almacenarNotasAlumno("12345678H");
        } catch (FicheroException e) {
            boolean validar = e.getMessage().contains("El fichero no se puede crear");
            assertTrue(validar, "El programa no genera el error correcto");
        } catch (Exception e) {
            fail("El test (ficheroNotaExisteTest) ha generado un error no controlado");
        }
    }

    @Test
    public void almacenarTodasNotasTest() {
        try {
            instituto.almacenarTodasNotas("Notas.txt");
        } catch (FicheroException e) {
            boolean validar = e.getMessage().contains("El fichero no se puede crear");
            assertTrue(validar, "El programa no genera el error correcto");
        } catch (Exception e) {
            fail("el test (almacenarTodasNotasTest) ha generado un error no controlado");
        }
    }

    @Test
    public void listarAlumnosTest() {
        assertTrue(instituto.buscaAlumno("12345678H").getNombre().equals("Paco"));
        assertTrue(instituto.buscaAlumno("12345678H").getDni().equals("12345678H"));
        assertTrue(instituto.buscaAlumno("12345678H").getApellidos().equals("Martin"));
    }

    @Test
    public void ficheroNoExisteTest() {
        String nombrefichero = "Notas.txt";

        try {
            instituto.leer(nombrefichero);
        } catch (FicheroException e) {
            boolean validar = e.getMessage().contains("El fichero a leer no existe");
            assertTrue(validar, "El programa no genera el error correcto");
        } catch (Exception e) {
            fail("El test (ficheroNoExisteTest) ha generado un error no controlado");
        }
    }

    /**
     * Funcion que crea un alumno
     * 
     * @return objeto de tipo alumno
     */
    private Alumno crearAlumno() {
        try {
            ArrayList<Nota> notas = new ArrayList<Nota>();
            notas.add(crearNota());
            return new Alumno("12345678H", "Paco", "Martin", notas);
        } catch (Exception e) {
            fail("El alumno no ha podido crearse");
        }
        return alumno;
    }

    /**
     * Funcion que crea una nota
     * 
     * @return objeto de tipo nota
     */
    private Nota crearNota() {
        try {
            return new Nota("Programacion", 4.5);
        } catch (Exception e) {
            fail("la nota no ha podido crearse");
        }
        return nota;
    }

    /**
     * Funcion que crea un aula
     * 
     * @return objeto tipo aula
     */
    private Aula crearAula() {
        try {
            ArrayList<Alumno> alumnos = new ArrayList<Alumno>();
            alumnos.add(crearAlumno());
            return new Aula(3, 1, alumnos);
        } catch (Exception e) {
            fail("El aula no ha podido crearse");
        }
        return aula;
    }

    /**
     * Funcion que crea un profesor
     * 
     * @return objeto tipo profesor
     */
    private Profesor crearProfesor() {
        try {
            ArrayList<Aula> aulas = new ArrayList<Aula>();
            aulas.add(crearAula());
            return new Profesor("87654321A", "Pepe", "Perez", aulas);
        } catch (Exception e) {
            fail("El profesor no ha podido crearse");
        }
        return profesor;
    }

}
