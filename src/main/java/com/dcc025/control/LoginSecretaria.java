// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.control;

import com.dcc025.view.Tela;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginSecretaria implements ActionListener{
    
    private Tela tela;
    private JFrame janela;
    private JPanel principal;
    private JTextField tfLogin;
    private JPasswordField tfSenha;

    public LoginSecretaria(Tela tela) {
        this.tela = tela;
        this.janela = new JFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        montaTelaLogin();
        tela.setVisible(false);
    }

    public JTextField getTfLogin() {
        return tfLogin;
    }

    public JPasswordField getTfSenha() {
        return tfSenha;
    }
    
    public JFrame getJanela() {
        return janela;
    }
    
    private void montaTelaLogin(){
        configuraJanela();
        configuraLogin();
        janela.add(this.principal);
        janela.setVisible(true);
    }
    
    private void configuraJanela(){
        janela.setSize(250, 140);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.principal = new JPanel();
        this.principal.setLayout(new BorderLayout());
    }
    
    private void cancelar(){
        janela.setVisible(false);
        Tela novaTela = new Tela();
        novaTela.montaTela();
    }
    
    private void configuraLogin(){
        int size = 15;
        
        JPanel jpLogin = new JPanel();
        JPanel jpBotoes = new JPanel();
        
        jpLogin.add(new JLabel("Login:"));
        this.tfLogin = new JTextField(size);
        jpLogin.add(this.tfLogin);
        
        jpLogin.add(new JLabel("Senha:"));
        this.tfSenha = new JPasswordField(size);
        jpLogin.add(this.tfSenha);
        
        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.addActionListener(new EntrarSecretaria(this));
        jpBotoes.add(btnEntrar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });
        jpBotoes.add(btnCancelar);
        
        this.principal.add(jpLogin, BorderLayout.CENTER);
        this.principal.add(jpBotoes, BorderLayout.SOUTH);
        
    }
}
