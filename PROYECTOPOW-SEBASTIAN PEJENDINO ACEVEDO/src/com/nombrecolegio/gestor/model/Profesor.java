package com.nombrecolegio.gestor.model;

import java.util.ArrayList;
import java.util.List;

public class Profesor extends Usuario {
    private List<Curso> cursosAsignados;
    private List<Materia> materiasAsignadas;

    public Profesor(String nombre, String email, String contraseña, String rol, List<Curso> cursosAsignados, List<Materia> materiasAsignadas) {
        super(nombre, email, contraseña, rol);
        this.cursosAsignados = cursosAsignados;
        this.materiasAsignadas = materiasAsignadas;
        this.materiasAsignadas = (materiasAsignadas != null) ? materiasAsignadas : new ArrayList<>();
    }

    public List<Curso> getCursosAsignados() {
        return cursosAsignados;
    }

    public void setCursosAsignados(List<Curso> cursosAsignados) {
        this.cursosAsignados = cursosAsignados;
    }

    public List<Materia> getMateriasAsignadas() {
        return materiasAsignadas;
    }

    public void setMateriasAsignadas(List<Materia> materiasAsignadas) {
        this.materiasAsignadas = materiasAsignadas;
    }
}
