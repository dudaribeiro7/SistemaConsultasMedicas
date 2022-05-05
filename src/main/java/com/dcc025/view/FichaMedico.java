// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.view;

import com.dcc025.model.Usuario;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FichaMedico extends JFrame{
    
    private JPanel principal;
    private Usuario secretaria;

    public FichaMedico() {
    }

    public FichaMedico(Usuario secretaria) {
        this.secretaria = secretaria;
    }
    
    public void montaTela(){
        configuraJanela();
        configuraFicha();
        this.add(this.principal);
        this.setVisible(true);
    }
    
    private void configuraJanela(){
        this.setSize(320, 140);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.principal = new JPanel();
        this.principal.setLayout(new BorderLayout());
    }
    
    private void configuraFicha(){
        
    }
}
