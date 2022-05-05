// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.view;

import com.dcc025.model.Medico;
import com.dcc025.model.Usuario;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FichaPaciente extends JFrame{
    
    private JPanel principal;
    private Usuario secretaria;
    private Medico medico;

    public FichaPaciente() {
    }

    public FichaPaciente(Usuario secretaria) {
        this.secretaria = secretaria;
        this.medico = null;
    }

    public FichaPaciente(Medico medico) {
        this.medico = medico;
        this.secretaria = null;
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
    
    
    public static void main(String[] args) {
        FichaPaciente ficha1 = new FichaPaciente();
        ficha1.montaTela();
       
        FichaMedico ficha2 = new FichaMedico();
        ficha2.montaTela();
       
        FichaSecretaria ficha3 = new FichaSecretaria();
        ficha3.montaTela();
    }
}
