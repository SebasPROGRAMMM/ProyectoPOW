package com.nombrecolegio.gestor.service;

import com.nombrecolegio.gestor.model.Profesor;
import com.nombrecolegio.gestor.model.Materia;

import java.util.ArrayList;
import java.util.List;

public class ProfesorService {
    private List<Profesor> profesores;

    // Constructor
    public ProfesorService() {
        this.profesores = new ArrayList<>();
    }

    // Método para agregar un profesor
    public void agregarProfesor(Profesor profesor) {
        profesores.add(profesor);
    }

    // Método para eliminar un profesor
    public void eliminarProfesor(Profesor profesor) {
        profesores.remove(profesor);
    }

    // Método para obtener la lista de todos los profesores
    public List<Profesor> obtenerProfesores() {
        return profesores;
    }

    // Método para buscar un profesor por su nombre
    public Profesor buscarProfesorPorNombre(String nombre) {
        for (Profesor profesor : profesores) {
            if (profesor.getNombre().equalsIgnoreCase(nombre)) {
                return profesor;
            }
        }
        return null;
    }

    // Método para asignar materias a un profesor
    public void asignarMateriaAProfesor(Profesor profesor, Materia materia) {
        profesor.getMateriasAsignadas().add(materia);  // Cambiado a getMateriasAsignadas()
    }

    // Otros métodos relacionados con profesores...
}
