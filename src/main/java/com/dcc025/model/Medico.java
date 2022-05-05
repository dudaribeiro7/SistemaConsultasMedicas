// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.model;

import java.util.Date;

public class Medico extends Usuario{
    private String areaAtuacao;

    public Medico(String areaAtuacao, String nome, Date dataNascimento, String cpf, 
            Endereco endereco, String telefone, String email, User login, String tipoSanguineo) {
        super(nome, dataNascimento, cpf, endereco, telefone, email, login, tipoSanguineo);
        this.areaAtuacao = areaAtuacao;
    }

    public Medico() {
        super();
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }
    
    public void setAreaAtuacao(String areaAtuacao){
        this.areaAtuacao = areaAtuacao;
    }
}