// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.model;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JSON {

    public static String toJSON(Medico medico) {
        Gson gson = new Gson();
        String json = gson.toJson(medico);
        return json;
    }

    public static String toJSON(Usuario secretaria) {
        Gson gson = new Gson();
        String json = gson.toJson(secretaria);
        return json;
    }

    public static String toJSON(Paciente paciente) {
        Gson gson = new Gson();
        String json = gson.toJson(paciente);
        return json;
    }

    public static String mToJSON(List<Medico> medicos) {
        Gson gson = new Gson();
        String json = gson.toJson(medicos);
        return json;
    }

    public static String uToJSON(List<Usuario> secretarias) {
        Gson gson = new Gson();
        String json = gson.toJson(secretarias);
        return json;
    }

    public static String pToJSON(List<Paciente> pacientes) {
        Gson gson = new Gson();
        String json = gson.toJson(pacientes);
        return json;
    }

    public static Medico toMedico(String conteudo) {
        Gson gson = new Gson();
        Medico medico = gson.fromJson(conteudo, Medico.class);

        return medico;
    }

    public static Usuario toSecretaria(String conteudo) {
        Gson gson = new Gson();
        Usuario secretaria = gson.fromJson(conteudo, Usuario.class);

        return secretaria;
    }

    public static Paciente toPaciente(String conteudo) {
        Gson gson = new Gson();
        Paciente paciente = gson.fromJson(conteudo, Paciente.class);

        return paciente;
    }

    public static List<Medico> toMedicos(String conteudo) {
        Gson gson = new Gson();
        Type pessoasTipo = new TypeToken<ArrayList<Medico>>() {
        }.getType();
        List<Medico> medicos = gson.fromJson(conteudo, pessoasTipo);

        return medicos;
    }

    public static List<Usuario> toSecretarias(String conteudo) {
        Gson gson = new Gson();
        Type pessoasTipo = new TypeToken<ArrayList<Usuario>>() { 
        }.getType();
        List<Usuario> secretarias = gson.fromJson(conteudo, pessoasTipo);

        return secretarias;
    }

    public static List<Paciente> toPacientes(String conteudo) {
        Gson gson = new Gson();
        Type pessoasTipo = new TypeToken<ArrayList<Paciente>>() { 
        }.getType();
        List<Paciente> pacientes = gson.fromJson(conteudo, pessoasTipo);

        return pacientes;
    }

}
