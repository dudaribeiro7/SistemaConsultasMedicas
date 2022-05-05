// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.model;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

public class Paciente {
    private Questionario quest;
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private Endereco endereco;
    private String telefone;
    private String email;
    private String tipoSanguineo;

    public Paciente(){
    }

    public Paciente(Questionario quest, String nome, Date dataNascimento, String cpf, 
            Endereco endereco, String telefone, String email, String tipoSanguineo) {
        this.quest = quest;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.cpf = cpf;
        validaArrumaCpf();
        this.endereco = endereco;
        this.telefone = telefone;
        validaArrumaTelefone();
        this.email = email;
        this.tipoSanguineo = tipoSanguineo;
    }
    
    public void validaArrumaCpf() {
        String cpf;
        if (this.cpf.length() != 11) {
            cpf = JOptionPane.showInputDialog("CPF inválido. Digite um novo CPF, sem traços ou pontos.");
            this.cpf = cpf;
            validaArrumaCpf();
        } else {
            this.cpf = this.cpf.substring(0, 3) + "." + this.cpf.substring(3, 6) + "."
                    + this.cpf.substring(6, 9) + "-" + this.cpf.substring(9, 11);
        }
    }

    public void validaArrumaTelefone() {
        String tel;
        if (this.telefone.length() != 11) {
            tel = JOptionPane.showInputDialog("Telefone inválido. Digite um novo telefone, "
                    + "com DDD e sem parênteses ou traços.");
            setTelefone(tel);
        } else {
            this.telefone = "(" + this.telefone.substring(0, 2) + ")"
                    + this.telefone.substring(2, 7) + "-" + this.telefone.substring(7, 11);
        }
    }

    public void setQuest() {
        this.quest = new Questionario();
    }
    
    public Questionario getQuest() {
        return this.quest;
    }
    
    public String getNome() {
        return nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
        validaArrumaCpf();
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
        validaArrumaTelefone();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }
    
    public int getIdade(){
        Calendar hoje = GregorianCalendar.getInstance();
        
        if(hoje.get(Calendar.MONTH) < dataNascimento.getMonth())
            return hoje.get(Calendar.YEAR) - dataNascimento.getYear() - 1;
        else
            return hoje.get(Calendar.YEAR) - dataNascimento.getYear();
        
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
