// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.model;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    private static List<Medico> medicos;
    private static List<Usuario> secretarias;
    private static List<Paciente> pacientes;
    
    static {
        medicos = new ArrayList<>();
        secretarias = new ArrayList<>();
        pacientes = new ArrayList<>();
    }

    public static List<Medico> getMedicos() {
        return medicos;
    }
    
    public static List<Usuario> getSecretarias() {
        return secretarias;
    }

    public static List<Paciente> getPacientes() {
        return pacientes;
    }

    public static void setMedicos(List<Medico> medicos) {
        Controller.medicos = medicos;
    }

    public static void setSecretarias(List<Usuario> secretarias) {
        Controller.secretarias = secretarias;
    }

    public static void setPacientes(List<Paciente> pacientes) {
        Controller.pacientes = pacientes;
    }
}