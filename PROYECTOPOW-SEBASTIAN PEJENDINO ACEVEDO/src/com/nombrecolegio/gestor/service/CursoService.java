package com.nombrecolegio.gestor.service;

import com.nombrecolegio.gestor.model.Curso;
import com.nombrecolegio.gestor.model.Estudiante;
import com.nombrecolegio.gestor.model.Materia;

import java.util.ArrayList;
import java.util.List;

public class CursoService {
    private List<Curso> cursos;

    public CursoService() {
        this.cursos = new ArrayList<>();
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public List<Curso> obtenerCursos() {
        return cursos;
    }

    public void inscribirEstudiante(Curso curso, Estudiante estudiante) {
        curso.getEstudiantes().add(estudiante);
    }

    public void eliminarCurso(Curso curso) {
        cursos.remove(curso);
    }

    public Curso obtenerCursoPorNombre(String nombre) {
        for (Curso curso : cursos) {
            if (curso.getNombre().equals(nombre)) {
                return curso;
            }
        }
        return null; // Retorna null si no se encuentra el curso
    }

    public List<Estudiante> obtenerEstudiantesDeCurso(Curso curso) {
        return curso.getEstudiantes();
    }

    public void asignarMateriasACurso(Curso curso, List<Materia> materias) {
        curso.setMaterias(materias);
    }
}
