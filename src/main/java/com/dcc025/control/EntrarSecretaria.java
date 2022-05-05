// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.control;

import com.dcc025.model.Controller;
import com.dcc025.view.AgendaSecretaria;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class EntrarSecretaria implements ActionListener{
    
    private LoginSecretaria login;

    public EntrarSecretaria(LoginSecretaria login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        boolean achou = false;
        
        for(int i=0; i<Controller.getSecretarias().size(); i++){
            if(Controller.getSecretarias().get(i).getUser().validaLogin(login.getTfLogin().getText(), login.getTfSenha().getText())){
                login.getJanela().setVisible(false);
                AgendaSecretaria agenda = new AgendaSecretaria(Controller.getSecretarias().get(i));
                agenda.montaTela();
                achou = true;
                break;
            }
        }
        
        if(!achou){
            JOptionPane.showMessageDialog(null, "Login ou senha incorretos. Por favor, tente novamente.", 
                    "Erro ao realizar login", JOptionPane.ERROR_MESSAGE);
        }
    }
}
