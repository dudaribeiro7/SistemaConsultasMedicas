// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.view;

import com.dcc025.control.SalvarSecretaria;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaCadastroSecretaria extends JFrame{
    
    private JPanel principal;
    private JTextField tfNome;
    private JTextField tfDataNascimento;
    private JTextField tfCpf;
    private JTextField tfTelefone;
    private JTextField tfRua;
    private JTextField tfNum;
    private JTextField tfComplemento;
    private JTextField tfBairro;
    private JTextField tfCep;
    private JTextField tfCidade;
    private JComboBox<String> cbTipoSanguineo;
    private JTextField tfEmail;
    private JTextField tfLogin;
    private JTextField tfSenha;
    private JComboBox<String> cbEstado;

    public TelaCadastroSecretaria() {
    }
    
    public void montaTelaCadastroSecretaria(){
        configuraJanela();
        configuraCadastro();
        this.add(this.principal);
        this.setVisible(true);
    }
    
    private void configuraJanela(){
        this.setSize(500, 260);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.principal = new JPanel();
        this.principal.setLayout(new BorderLayout());
    }
    
    private void cancelar(){
        this.setVisible(false);
        Tela novaTela = new Tela();
        novaTela.montaTela();
    }
    
    private void configuraCadastro(){
        
        JPanel jpCadastro = new JPanel();
        jpCadastro.setBorder(BorderFactory.createTitledBorder("Cadastro"));
        jpCadastro.setLayout(new FlowLayout());
        
        jpCadastro.add(new JLabel("Nome:"));
        this.tfNome = new JTextField(20);
        jpCadastro.add(this.tfNome);
        
        jpCadastro.add(new JLabel("Data de nascimento:"));
        this.tfDataNascimento = new JTextField(6);
        this.tfDataNascimento.setToolTipText("Digite no formato dd/mm/aaaa.");
        jpCadastro.add(this.tfDataNascimento);
        
        jpCadastro.add(new JLabel("CPF:"));
        this.tfCpf = new JTextField(9);
        this.tfCpf.setToolTipText("Digite somente números.");
        jpCadastro.add(this.tfCpf);
        
        jpCadastro.add(new JLabel("Telefone:"));
        this.tfTelefone = new JTextField(9);
        this.tfTelefone.setToolTipText("Digite somente números, no formato (xx)xxxxx-xxxx.");
        jpCadastro.add(this.tfTelefone);
        
        jpCadastro.add(new JLabel("Tipo Sanguíneo:"));
        String tipos[] = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        this.cbTipoSanguineo = new JComboBox<>(tipos);
        jpCadastro.add(this.cbTipoSanguineo);
        
        jpCadastro.add(new JLabel("Rua:"));
        this.tfRua = new JTextField(15);
        jpCadastro.add(this.tfRua);
        
        jpCadastro.add(new JLabel("Nº:"));
        this.tfNum = new JTextField(4);
        jpCadastro.add(this.tfNum);
        
        jpCadastro.add(new JLabel("Complemento:"));
        this.tfComplemento = new JTextField(9);
        jpCadastro.add(this.tfComplemento);
        
        jpCadastro.add(new JLabel("Bairro:"));
        this.tfBairro = new JTextField(7);
        jpCadastro.add(this.tfBairro);
        
        jpCadastro.add(new JLabel("CEP:"));
        this.tfCep = new JTextField(9);
        this.tfCep.setToolTipText("Digite somente números.");
        jpCadastro.add(this.tfCep);
        
        jpCadastro.add(new JLabel("Cidade:"));
        this.tfCidade = new JTextField(12);
        jpCadastro.add(this.tfCidade);
        
        jpCadastro.add(new JLabel("Estado:"));
        String[] siglas = {"AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", 
                           "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", 
                           "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF"};
        this.cbEstado = new JComboBox<>(siglas);
        jpCadastro.add(this.cbEstado);
        jpCadastro.add(new JLabel("              "));
        
        jpCadastro.add(new JLabel("Email:"));
        this.tfEmail = new JTextField(15);
        jpCadastro.add(this.tfEmail);
        jpCadastro.add(new JLabel("              "));
        
        jpCadastro.add(new JLabel("Crie um login:"));
        this.tfLogin = new JTextField(12);
        jpCadastro.add(this.tfLogin);
        
        jpCadastro.add(new JLabel("Crie uma senha:"));
        this.tfSenha = new JTextField(12);
        jpCadastro.add(this.tfSenha);
        
        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(new SalvarSecretaria(this));
        jpCadastro.add(btnSalvar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });
        jpCadastro.add(btnCancelar);
        
        
        this.principal.add(jpCadastro, BorderLayout.CENTER);
        
    }

    public JTextField getTfNome() {
        return tfNome;
    }

    public JTextField getTfDataNascimento() {
        return tfDataNascimento;
    }

    public JTextField getTfCpf() {
        return tfCpf;
    }

    public JTextField getTfTelefone() {
        return tfTelefone;
    }

    public JTextField getTfRua() {
        return tfRua;
    }

    public JTextField getTfNum() {
        return tfNum;
    }

    public JTextField getTfComplemento() {
        return tfComplemento;
    }

    public JTextField getTfBairro() {
        return tfBairro;
    }

    public JTextField getTfCep() {
        return tfCep;
    }

    public JTextField getTfCidade() {
        return tfCidade;
    }

    public JComboBox<String> getCbTipoSanguineo() {
        return cbTipoSanguineo;
    }

    public JTextField getTfEmail() {
        return tfEmail;
    }

    public JTextField getTfLogin() {
        return tfLogin;
    }

    public JTextField getTfSenha() {
        return tfSenha;
    }

    public JComboBox<String> getCbEstado() {
        return cbEstado;
    }
}
