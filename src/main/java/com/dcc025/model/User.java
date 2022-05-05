// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.model;

public class User {
    
    private String login;
    private String senha;

    public User(String login, String senha) {
        this.login = login;
        this.senha = senha;
    }

    public User() {
        this.login = null;
        this.senha = null;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public boolean validaLogin(String username, String password) {
        if(this.getLogin().equals(username) && this.getSenha().equals(password))
            return true;
        else 
            return false;
    }
}
