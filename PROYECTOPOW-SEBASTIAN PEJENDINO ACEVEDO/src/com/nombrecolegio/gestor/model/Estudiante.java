package com.nombrecolegio.gestor.model;

import java.util.List;
import com.nombrecolegio.gestor.model.Curso; // Asegúrate de que esta línea esté presente

public class Estudiante extends Usuario {
    private List<Curso> cursosInscritos;

    public Estudiante(String nombre, String email, String contraseña, String rol, List<Curso> cursosInscritos) {
        super(nombre, email, contraseña, rol);
        this.cursosInscritos = cursosInscritos;
    }

    public List<Curso> getCursosInscritos() {
        return cursosInscritos;
    }

    public void setCursosInscritos(List<Curso> cursosInscritos) {
        this.cursosInscritos = cursosInscritos;
    }
}
