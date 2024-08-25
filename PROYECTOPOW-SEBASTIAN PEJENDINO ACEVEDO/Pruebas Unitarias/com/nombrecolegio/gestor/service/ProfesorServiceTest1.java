package com.nombrecolegio.gestor.service;

import static org.junit.jupiter.api.Assertions.*;
import com.nombrecolegio.gestor.model.Materia;
import com.nombrecolegio.gestor.model.Profesor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

class ProfesorServiceTest1 {

    private ProfesorService profesorService;
    private Profesor profesor;
    private Materia materia;

    @BeforeEach
    void setUp() {
        // Inicializamos los objetos antes de cada prueba
        profesorService = new ProfesorService();
        profesor = new Profesor("Juan Pérez", "juan@example.com", "password123", "PROFESOR", new ArrayList<>(), null);
        materia = new Materia("Matemáticas");
    }

    @Test
    void testAgregarProfesor() {
        profesorService.agregarProfesor(profesor);
        assertEquals(1, profesorService.obtenerProfesores().size(), "El profesor no fue agregado correctamente");
    }

    @Test
    void testEliminarProfesor() {
        profesorService.agregarProfesor(profesor);
        profesorService.eliminarProfesor(profesor);
        assertEquals(0, profesorService.obtenerProfesores().size(), "El profesor no fue eliminado correctamente");
    }

    @Test
    void testBuscarProfesorPorNombre() {
        profesorService.agregarProfesor(profesor);
        Profesor encontrado = profesorService.buscarProfesorPorNombre("Juan Pérez");
        assertNotNull(encontrado, "El profesor no fue encontrado");
    }

    @Test
    void testAsignarMateriaAProfesor() {
        profesorService.agregarProfesor(profesor);
        profesorService.asignarMateriaAProfesor(profesor, materia);
        assertEquals(1, profesor.getMateriasAsignadas().size(), "La materia no fue asignada correctamente al profesor");
    }
}
