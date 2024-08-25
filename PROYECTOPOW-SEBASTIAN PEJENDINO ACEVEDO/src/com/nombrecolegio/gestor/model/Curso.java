package com.nombrecolegio.gestor.model;

import java.util.List;
import com.nombrecolegio.gestor.model.Estudiante; // Asegúrate de que esta línea esté presente

public class Curso {
	private String nombre;
    private List<Estudiante> estudiantes;
    private List<Materia> materias;  // Nuevo atributo

    public Curso(String nombre, List<Estudiante> estudiantes, List<Materia> materias) {
        this.nombre = nombre;
        this.estudiantes = estudiantes;
        this.materias = materias; 
    }

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(List<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

}
