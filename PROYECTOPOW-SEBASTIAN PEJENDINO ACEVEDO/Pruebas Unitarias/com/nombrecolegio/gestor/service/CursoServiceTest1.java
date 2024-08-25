package com.nombrecolegio.gestor.service;

import com.nombrecolegio.gestor.model.Curso;
import com.nombrecolegio.gestor.model.Estudiante;
import com.nombrecolegio.gestor.model.Materia;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CursoServiceTest1 {
    private CursoService cursoService;
    private Curso curso;
    private Estudiante estudiante;
    private Materia materia;

    @Before
    public void setUp() {
        cursoService = new CursoService();
        estudiante = new Estudiante("Juan Pérez", "juan@example.com", "password123", "ESTUDIANTE", new ArrayList<>());
        materia = new Materia("Matemáticas");
        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(estudiante);
        curso = new Curso("Curso de Matemáticas", estudiantes, new ArrayList<>());
    }

    @Test
    public void testAgregarCurso() {
        cursoService.agregarCurso(curso);
        assertNotNull(cursoService.obtenerCursoPorNombre("Curso de Matemáticas"));
    }

    @Test
    public void testInscribirEstudiante() {
        cursoService.agregarCurso(curso);
        Estudiante nuevoEstudiante = new Estudiante("Ana García", "ana@example.com", "password456", "ESTUDIANTE", new ArrayList<>());
        cursoService.inscribirEstudiante(curso, nuevoEstudiante);
        assertEquals(2, cursoService.obtenerEstudiantesDeCurso(curso).size());
    }

    @Test
    public void testEliminarCurso() {
        cursoService.agregarCurso(curso);
        cursoService.eliminarCurso(curso);
        assertNull(cursoService.obtenerCursoPorNombre("Curso de Matemáticas"));
    }

    @Test
    public void testAsignarMateriasACurso() {
        cursoService.agregarCurso(curso);
        List<Materia> materias = new ArrayList<>();
        materias.add(materia);
        cursoService.asignarMateriasACurso(curso, materias);
        assertEquals(1, curso.getMaterias().size());
    }
}
