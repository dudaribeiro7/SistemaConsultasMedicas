// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.view;

import com.dcc025.control.Arquivo;
import com.dcc025.control.LoginMedico;
import com.dcc025.control.LoginSecretaria;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Tela extends JFrame{
    
    private JPanel principal;

    public Tela() {
    }
    
    private void mostraTela(){
        this.add(this.principal);
        this.setVisible(true);
    }
    
    public void montaTela(){
        configuraJanela();
        configuraLogin();
        configuraCadastro();
        mostraTela();
    }
    
    private void configuraJanela(){
        this.setSize(320, 140);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(new Arquivo(this));
        
        this.principal = new JPanel();
        this.principal.setLayout(new BorderLayout());
    }
    
    private void configuraLogin(){
        
        JPanel jpBotoes = new JPanel();
        jpBotoes.setBorder(BorderFactory.createTitledBorder("Fazer Login"));
        jpBotoes.setLayout(new FlowLayout());
        jpBotoes.setPreferredSize(new Dimension(150, 180));
        
        JButton btnSecretaria = new JButton("Sou secretaria");
        btnSecretaria.addActionListener(new LoginSecretaria(this));
        jpBotoes.add(btnSecretaria);
        
        JButton btnMedico = new JButton("Sou médico(a)");
        btnMedico.addActionListener(new LoginMedico(this));
        jpBotoes.add(btnMedico);
        
        this.principal.add(jpBotoes, BorderLayout.WEST);
    }
    
    private void configuraCadastro(){
        
        JPanel jpBotoes = new JPanel();
        jpBotoes.setBorder(BorderFactory.createTitledBorder("Fazer Cadastro"));
        jpBotoes.setLayout(new FlowLayout());
        jpBotoes.setPreferredSize(new Dimension(150, 180));
        
        JButton btnSecretaria = new JButton("Sou secretaria");
        btnSecretaria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastroSecretaria();
            }
        });
        jpBotoes.add(btnSecretaria);
        
        JButton btnMedico = new JButton("Sou médico(a)");
        btnMedico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastroMedico();
            }
        });
        jpBotoes.add(btnMedico);
        
        this.principal.add(jpBotoes, BorderLayout.EAST);
        
    }
    
    private void cadastroSecretaria(){
        TelaCadastroSecretaria cadastroS = new TelaCadastroSecretaria();
        cadastroS.montaTelaCadastroSecretaria();
        this.setVisible(false);
    }
    
    private void cadastroMedico(){
        TelaCadastroMedico cadastroM = new TelaCadastroMedico();
        cadastroM.montaTelaCadastroMedico();
        this.setVisible(false);
    }
    
    public static void main(String[] args) {
        Tela tela = new Tela();
        tela.montaTela();
    }
}
