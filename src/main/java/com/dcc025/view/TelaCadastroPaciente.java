// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.view;

import com.dcc025.control.SalvarPaciente;
import com.dcc025.model.Medico;
import com.dcc025.model.Usuario;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class TelaCadastroPaciente extends JFrame{
    
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
    private JComboBox<String> cbEstado;
    private JRadioButton cbHospitalSim;
    private String motivoHospital;
    private JRadioButton cbOperadoSim;
    private String motivoOperado;
    private JRadioButton cbEpilepsiaSim;
    private JRadioButton cbAlcoolSim;
    private JRadioButton cbTabagismoSim;
    private JRadioButton cbSinusiteSim;
    private JRadioButton cbRiniteSim;
    private JRadioButton cbAsmaSim;
    private JRadioButton cbOsteoporoseSim;
    private JRadioButton cbArtroseSim;
    private JRadioButton cbDiabetesSim;
    private int tipoDiabetes;
    private JRadioButton cbHipertensaoSim;
    private JRadioButton cbAlergiaSim;
    private String qualAlergia;
    private JTextField tfObs;
    private Medico medico;
    private Usuario secretaria;
    

    public TelaCadastroPaciente(Medico medico) {
        this.motivoHospital = "";
        this.motivoOperado = "";
        this.tipoDiabetes = 0;
        this.qualAlergia = "";
        this.medico = medico;
        this.secretaria = null;
    }
    
    public TelaCadastroPaciente(Usuario secretaria) {
        this.motivoHospital = "";
        this.motivoOperado = "";
        this.tipoDiabetes = 0;
        this.qualAlergia = "";
        this.secretaria = secretaria;
        this.medico = null;
    }
    
    public void montaTelaCadastroPaciente(){
        configuraJanela();
        configuraCadastro();
        configuraQuestionario();
        configuraBotoes();
        this.add(this.principal);
        this.setVisible(true);
    }
    
    private void configuraJanela(){
        this.setSize(500, 690);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.principal = new JPanel();
        this.principal.setLayout(new BorderLayout());
    }
    
    private void configuraCadastro(){
        
        JPanel jpCadastro = new JPanel();
        jpCadastro.setBorder(BorderFactory.createTitledBorder("Cadastro"));
        jpCadastro.setLayout(new FlowLayout());
        jpCadastro.setPreferredSize(new Dimension(500, 170));
        
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
        
        jpCadastro.add(new JLabel("Email:"));
        this.tfEmail = new JTextField(15);
        jpCadastro.add(this.tfEmail);
        
        jpCadastro.add(new JLabel("Rua:"));
        this.tfRua = new JTextField(12);
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
        
        this.principal.add(jpCadastro, BorderLayout.NORTH); 
    }
    
    private void configuraQuestionario(){
        
        JPanel jpQuestionario = new JPanel();
        jpQuestionario.setBorder(BorderFactory.createTitledBorder("Questionário"));
        jpQuestionario.setLayout(new FlowLayout());
        jpQuestionario.setPreferredSize(new Dimension(500, 400));
        
        JLabel lHospital = new JLabel("Foi hospitalizado nos ultimos 6 meses?", JLabel.LEFT);
        lHospital.setPreferredSize(new Dimension(360, 15));
        jpQuestionario.add(lHospital);
        this.cbHospitalSim = new JRadioButton("Sim");
        JRadioButton cbHospitalNao = new JRadioButton("Não");
        ButtonGroup gHospital = new ButtonGroup();
        gHospital.add(this.cbHospitalSim);
        gHospital.add(cbHospitalNao);
        jpQuestionario.add(this.cbHospitalSim);
        jpQuestionario.add(cbHospitalNao);
        this.cbHospitalSim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hospitalSim();
            }
        });
        
        JLabel lOperado = new JLabel("Já foi operado?", JLabel.LEFT);
        lOperado.setPreferredSize(new Dimension(360, 15));
        jpQuestionario.add(lOperado);
        this.cbOperadoSim = new JRadioButton("Sim");
        JRadioButton cbOperadoNao = new JRadioButton("Não");
        ButtonGroup gOperado = new ButtonGroup();
        gOperado.add(this.cbOperadoSim);
        gOperado.add(cbOperadoNao);
        jpQuestionario.add(this.cbOperadoSim);
        jpQuestionario.add(cbOperadoNao);
        this.cbOperadoSim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operadoSim();
            }
        });
        
        JLabel lEpilepsia = new JLabel("Tem epilepsia?", JLabel.LEFT);
        lEpilepsia.setPreferredSize(new Dimension(360, 15));
        jpQuestionario.add(lEpilepsia);
        this.cbEpilepsiaSim = new JRadioButton("Sim");
        JRadioButton cbEpilepsiaNao = new JRadioButton("Não");
        ButtonGroup gEpilepsia = new ButtonGroup();
        gEpilepsia.add(this.cbEpilepsiaSim);
        gEpilepsia.add(cbEpilepsiaNao);
        jpQuestionario.add(this.cbEpilepsiaSim);
        jpQuestionario.add(cbEpilepsiaNao);
        
        JLabel lAlcool = new JLabel("Faz uso de álcool?", JLabel.LEFT);
        lAlcool.setPreferredSize(new Dimension(360, 15));
        jpQuestionario.add(lAlcool);
        this.cbAlcoolSim = new JRadioButton("Sim");
        JRadioButton cbAlcoolNao = new JRadioButton("Não");
        ButtonGroup  gAlcool = new ButtonGroup();
        gAlcool.add(this.cbAlcoolSim);
        gAlcool.add(cbAlcoolNao);
        jpQuestionario.add(this.cbAlcoolSim);
        jpQuestionario.add(cbAlcoolNao);
        
        JLabel lTabagismo = new JLabel("Faz uso de tabaco?", JLabel.LEFT);
        lTabagismo.setPreferredSize(new Dimension(360, 15));
        jpQuestionario.add(lTabagismo);
        this.cbTabagismoSim = new JRadioButton("Sim");
        JRadioButton cbTabagismoNao = new JRadioButton("Não");
        ButtonGroup  gTabagismo = new ButtonGroup();
        gTabagismo.add(this.cbTabagismoSim);
        gTabagismo.add(cbTabagismoNao);
        jpQuestionario.add(this.cbTabagismoSim);
        jpQuestionario.add(cbTabagismoNao);
        
        JLabel lSinusite = new JLabel("Tem sinusite?", JLabel.LEFT);
        lSinusite.setPreferredSize(new Dimension(360, 15));
        jpQuestionario.add(lSinusite);
        this.cbSinusiteSim = new JRadioButton("Sim");
        JRadioButton cbSinusiteNao = new JRadioButton("Não");
        ButtonGroup  gSinusite = new ButtonGroup();
        gSinusite.add(this.cbSinusiteSim);
        gSinusite.add(cbSinusiteNao);
        jpQuestionario.add(this.cbSinusiteSim);
        jpQuestionario.add(cbSinusiteNao);
        
        JLabel lRinite = new JLabel("Tem rinite?", JLabel.LEFT);
        lRinite.setPreferredSize(new Dimension(360, 15));
        jpQuestionario.add(lRinite);
        this.cbRiniteSim = new JRadioButton("Sim");
        JRadioButton cbRiniteNao = new JRadioButton("Não");
        ButtonGroup  gRinite = new ButtonGroup();
        gRinite.add(this.cbRiniteSim);
        gRinite.add(cbRiniteNao);
        jpQuestionario.add(this.cbRiniteSim);
        jpQuestionario.add(cbRiniteNao);
        
        JLabel lAsma = new JLabel("Tem asma?", JLabel.LEFT);
        lAsma.setPreferredSize(new Dimension(360, 15));
        jpQuestionario.add(lAsma);
        this.cbAsmaSim = new JRadioButton("Sim");
        JRadioButton cbAsmaNao = new JRadioButton("Não");
        ButtonGroup  gAsma = new ButtonGroup();
        gAsma.add(this.cbAsmaSim);
        gAsma.add(cbAsmaNao);
        jpQuestionario.add(this.cbAsmaSim);
        jpQuestionario.add(cbAsmaNao);
        
        JLabel lOsteoporose = new JLabel("Tem osteoporose?", JLabel.LEFT);
        lOsteoporose.setPreferredSize(new Dimension(360, 15));
        jpQuestionario.add(lOsteoporose);
        this.cbOsteoporoseSim = new JRadioButton("Sim");
        JRadioButton cbOsteoporoseNao = new JRadioButton("Não");
        ButtonGroup  gOsteoporose = new ButtonGroup();
        gOsteoporose.add(this.cbOsteoporoseSim);
        gOsteoporose.add(cbOsteoporoseNao);
        jpQuestionario.add(this.cbOsteoporoseSim);
        jpQuestionario.add(cbOsteoporoseNao);
        
        JLabel lArtrose = new JLabel("Tem artrose?", JLabel.LEFT);
        lArtrose.setPreferredSize(new Dimension(360, 15));
        jpQuestionario.add(lArtrose);
        this.cbArtroseSim = new JRadioButton("Sim");
        JRadioButton cbArtroseNao = new JRadioButton("Não");
        ButtonGroup  gArtrose = new ButtonGroup();
        gArtrose.add(this.cbArtroseSim);
        gArtrose.add(cbArtroseNao);
        jpQuestionario.add(this.cbArtroseSim);
        jpQuestionario.add(cbArtroseNao);
        
        JLabel lDiabetes = new JLabel("Tem diabetes?", JLabel.LEFT);
        lDiabetes.setPreferredSize(new Dimension(360, 15));
        jpQuestionario.add(lDiabetes);
        this.cbDiabetesSim = new JRadioButton("Sim");
        JRadioButton cbDiabetesNao = new JRadioButton("Não");
        ButtonGroup  gDiabetes = new ButtonGroup();
        gDiabetes.add(this.cbDiabetesSim);
        gDiabetes.add(cbDiabetesNao);
        jpQuestionario.add(this.cbDiabetesSim);
        jpQuestionario.add(cbDiabetesNao);
        this.cbDiabetesSim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                diabetesSim();
            }
        });
        
        JLabel lHipertensao = new JLabel("Tem hipertensão?", JLabel.LEFT);
        lHipertensao.setPreferredSize(new Dimension(360, 15));
        jpQuestionario.add(lHipertensao);
        this.cbHipertensaoSim = new JRadioButton("Sim");
        JRadioButton cbHipertensaoNao = new JRadioButton("Não");
        ButtonGroup  gHipertensao = new ButtonGroup();
        gHipertensao.add(this.cbHipertensaoSim);
        gHipertensao.add(cbHipertensaoNao);
        jpQuestionario.add(this.cbHipertensaoSim);
        jpQuestionario.add(cbHipertensaoNao);
        
        JLabel lAlergia = new JLabel("Tem alguma alergia?", JLabel.LEFT);
        lAlergia.setPreferredSize(new Dimension(360, 15));
        jpQuestionario.add(lAlergia);
        this.cbAlergiaSim = new JRadioButton("Sim");
        JRadioButton cbAlergiaNao = new JRadioButton("Não");
        ButtonGroup  gAlergia = new ButtonGroup();
        gAlergia.add(this.cbAlergiaSim);
        gAlergia.add(cbAlergiaNao);
        jpQuestionario.add(this.cbAlergiaSim);
        jpQuestionario.add(cbAlergiaNao);
        this.cbAlergiaSim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alergiaSim();
            }
        });
        
        jpQuestionario.add(new JLabel("Observações:"));
        this.tfObs = new JTextField(32);
        jpQuestionario.add(this.tfObs);
        
        this.principal.add(jpQuestionario, BorderLayout.CENTER); 
    }
    
    private void hospitalSim(){
        this.motivoHospital = JOptionPane.showInputDialog("Por qual motivo foi hospitalizado?");
    }
    
    private void operadoSim(){
        this.motivoOperado = JOptionPane.showInputDialog("Qual foi a operação?");
    }
    
    private void diabetesSim(){
        String[] tipos = {"Tipo 1", "Tipo 2"};
        this.tipoDiabetes = 1 + JOptionPane.showOptionDialog(null, "Diabetes de qual tipo?", 
                "Tipo de diabetes", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, tipos, 0);
    }
    
    private void alergiaSim(){
        this.qualAlergia = JOptionPane.showInputDialog("Alergia a que?");
    }
    
    private void configuraBotoes(){
        
        JPanel jpBotoes = new JPanel();
        jpBotoes.setLayout(new FlowLayout());
        jpBotoes.setPreferredSize(new Dimension(500, 40));
        
        JButton btnSalvar = new JButton("Salvar");
        if(this.medico == null)
            btnSalvar.addActionListener(new SalvarPaciente(this, secretaria));
        else if(this.secretaria == null)
            btnSalvar.addActionListener(new SalvarPaciente(this, medico));
        jpBotoes.add(btnSalvar);
        
        JButton btnCancelar = new JButton("Cancelar");
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cancelar();
            }
        });
        jpBotoes.add(btnCancelar);
        
        this.principal.add(jpBotoes, BorderLayout.SOUTH); 
    }
    
    private void cancelar(){
        this.setVisible(false);
        if(this.medico == null){
            AgendaSecretaria agendaS = new AgendaSecretaria(secretaria);
            agendaS.montaTela();
        }
        else if(this.secretaria == null){
            AgendaMedico agendaM = new AgendaMedico(medico);
            agendaM.montaTela();
        }
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

    public JComboBox<String> getCbEstado() {
        return cbEstado;
    }

    public JRadioButton getCbAlcoolSim() {
        return cbAlcoolSim;
    }

    public JRadioButton getCbEpilepsiaSim() {
        return cbEpilepsiaSim;
    }

    public JRadioButton getCbAsmaSim() {
        return cbAsmaSim;
    }

    public JRadioButton getCbArtroseSim() {
        return cbArtroseSim;
    }

    public JRadioButton getCbDiabetesSim() {
        return cbDiabetesSim;
    }

    public JRadioButton getCbAlergiaSim() {
        return cbAlergiaSim;
    }

    public JRadioButton getCbHospitalSim() {
        return cbHospitalSim;
    }

    public JRadioButton getCbOperadoSim() {
        return cbOperadoSim;
    }

    public JRadioButton getCbOsteoporoseSim() {
        return cbOsteoporoseSim;
    }

    public JRadioButton getCbHipertensaoSim() {
        return cbHipertensaoSim;
    }

    public JRadioButton getCbRiniteSim() {
        return cbRiniteSim;
    }

    public JRadioButton getCbSinusiteSim() {
        return cbSinusiteSim;
    }

    public JRadioButton getCbTabagismoSim() {
        return cbTabagismoSim;
    }

    public String getMotivoHospital() {
        return motivoHospital;
    }

    public String getMotivoOperado() {
        return motivoOperado;
    }

    public int getTipoDiabetes() {
        return tipoDiabetes;
    }

    public String getQualAlergia() {
        return qualAlergia;
    }

    public JTextField getTfObs() {
        return tfObs;
    }
}
