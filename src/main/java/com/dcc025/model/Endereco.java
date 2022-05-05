// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.model;

import javax.swing.JOptionPane;

public class Endereco {
    private String rua;
    private int numero;
    private String bairro;
    private String cep;
    private String cidade;
    private String complemento;
    private String estado;

    public Endereco() {
    }

    public Endereco(String rua, int numero, String bairro, String cep, String cidade, String complemento, String estado) {
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        validaArrumaCEP();
        this.cidade = cidade;
        this.complemento = complemento;
        this.estado = estado;
    }

    public void validaArrumaCEP() {
        String cep1;
        if (this.cep.length() != 8) {
            cep1 = JOptionPane.showInputDialog("CEP inválido. Digite um novo CEP, sem traços ou pontos.");
            this.cep = cep1;
            validaArrumaCEP();
        } else {
            this.cep = this.cep.substring(0, 5) + "-" + this.cep.substring(5, 8);
        }
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
        validaArrumaCEP();
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
}
