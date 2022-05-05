// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.view;

import com.dcc025.control.EditarMedico;
import com.dcc025.model.Medico;
import com.dcc025.model.Usuario;
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

public class TelaEditaMedico extends JFrame{
    
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
    private JTextField tfArea;
    private JComboBox<String> cbEstado;
    private Medico medico;
    private Usuario secretaria;

    public TelaEditaMedico(Medico medico) {
        this.medico = medico;
        this.secretaria = null;
    }
    
    public TelaEditaMedico(Medico medico, Usuario secretaria) {
        this.medico = medico;
        this.secretaria = secretaria;
    }
    
    public void montaTelaEditaMedico(){
        configuraJanela();
        configuraEdicao();
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
        if(this.secretaria == null){
            AgendaMedico agenda = new AgendaMedico(medico);
            agenda.montaTela();
        }
        else{
            AgendaSecretaria agenda = new AgendaSecretaria(secretaria);
            agenda.montaTela();
        }
    }
    
    private void configuraEdicao(){
        
        JPanel jpCadastro = new JPanel();
        jpCadastro.setBorder(BorderFactory.createTitledBorder("Edição"));
        jpCadastro.setLayout(new FlowLayout());
        
        jpCadastro.add(new JLabel("Nome:"));
        this.tfNome = new JTextField(20);
        this.tfNome.setText(this.medico.getNome());
        jpCadastro.add(this.tfNome);
        
        jpCadastro.add(new JLabel("Data de nascimento:"));
        this.tfDataNascimento = new JTextField(6);
        this.tfDataNascimento.setText(this.medico.getDataNascimento().getDate() + "/" + 
                                      (this.medico.getDataNascimento().getMonth() + 1) + "/" + 
                                      (this.medico.getDataNascimento().getYear() + 1900));
        this.tfDataNascimento.setToolTipText("Digite no formato dd/mm/aaaa.");
        jpCadastro.add(this.tfDataNascimento);
        
        jpCadastro.add(new JLabel("CPF:"));
        this.tfCpf = new JTextField(9);
        this.tfCpf.setText(this.medico.getCpf().substring(0, 3) + 
                           this.medico.getCpf().substring(4, 7) + 
                           this.medico.getCpf().substring(8, 11) + 
                           this.medico.getCpf().substring(12, 14));
        this.tfCpf.setToolTipText("Digite somente números.");
        jpCadastro.add(this.tfCpf);
        
        jpCadastro.add(new JLabel("Telefone:"));
        this.tfTelefone = new JTextField(9);
        this.tfTelefone.setText(this.medico.getTelefone().substring(1, 3) + 
                                this.medico.getTelefone().substring(4, 9) + 
                                this.medico.getTelefone().substring(10, 14));
        this.tfTelefone.setToolTipText("Digite somente números, no formato (xx)xxxxx-xxxx.");
        jpCadastro.add(this.tfTelefone);
        
        jpCadastro.add(new JLabel("Tipo Sanguíneo:"));
        String tipos[] = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        this.cbTipoSanguineo = new JComboBox<>(tipos);
        this.cbTipoSanguineo.setSelectedItem(this.medico.getTipoSanguineo());
        jpCadastro.add(this.cbTipoSanguineo);
        
        jpCadastro.add(new JLabel("Rua:"));
        this.tfRua = new JTextField(15);
        this.tfRua.setText(this.medico.getEndereco().getRua());
        jpCadastro.add(this.tfRua);
        
        jpCadastro.add(new JLabel("Nº:"));
        this.tfNum = new JTextField(4);
        this.tfNum.setText("" + this.medico.getEndereco().getNumero());
        jpCadastro.add(this.tfNum);
        
        jpCadastro.add(new JLabel("Complemento:"));
        this.tfComplemento = new JTextField(9);
        this.tfComplemento.setText(this.medico.getEndereco().getComplemento());
        jpCadastro.add(this.tfComplemento);
        
        jpCadastro.add(new JLabel("Bairro:"));
        this.tfBairro = new JTextField(7);
        this.tfBairro.setText(this.medico.getEndereco().getBairro());
        jpCadastro.add(this.tfBairro);
        
        jpCadastro.add(new JLabel("CEP:"));
        this.tfCep = new JTextField(7);
        this.tfCep.setText(this.medico.getEndereco().getCep().substring(0, 5) + 
                           this.medico.getEndereco().getCep().substring(6, 9));
        this.tfCep.setToolTipText("Digite somente números.");
        jpCadastro.add(this.tfCep);
        
        jpCadastro.add(new JLabel("Cidade:"));
        this.tfCidade = new JTextField(10);
        this.tfCidade.setText(this.medico.getEndereco().getCidade());
        jpCadastro.add(this.tfCidade);
        
        String[] siglas = {"AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", 
                           "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", 
                           "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO", "DF"};
        this.cbEstado = new JComboBox<>(siglas);
        this.cbEstado.setSelectedItem(this.medico.getEndereco().getEstado());
        jpCadastro.add(this.cbEstado);
        
        jpCadastro.add(new JLabel("Email:"));
        this.tfEmail = new JTextField(15);
        this.tfEmail.setText(this.medico.getEmail());
        jpCadastro.add(this.tfEmail);
        
        jpCadastro.add(new JLabel("Área de atuação:"));
        this.tfArea = new JTextField(13);
        this.tfArea.setText(this.medico.getAreaAtuacao());
        jpCadastro.add(this.tfArea);
        
        if(this.secretaria == null){
            jpCadastro.add(new JLabel("Crie um login:"));
            this.tfLogin = new JTextField(12);
            this.tfLogin.setText(this.medico.getUser().getLogin());
            jpCadastro.add(this.tfLogin);

            jpCadastro.add(new JLabel("Crie uma senha:"));
            this.tfSenha = new JTextField(12);
            this.tfSenha.setText(this.medico.getUser().getSenha());
            jpCadastro.add(this.tfSenha);
        }
        
        JButton btnSalvar = new JButton("Salvar");
        if(this.secretaria == null)
            btnSalvar.addActionListener(new EditarMedico(this, medico));
        else
            btnSalvar.addActionListener(new EditarMedico(this, medico, secretaria));
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

    public JComboBox getCbTipoSanguineo() {
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

    public JTextField getTfArea() {
        return tfArea;
    }

    public JComboBox<String> getCbEstado() {
        return cbEstado;
    }
}
