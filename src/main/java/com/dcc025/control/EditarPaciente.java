// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.control;

import com.dcc025.model.Controller;
import com.dcc025.model.Endereco;
import com.dcc025.model.JSON;
import com.dcc025.model.Medico;
import com.dcc025.model.Paciente;
import com.dcc025.model.Questionario;
import com.dcc025.model.Usuario;
import com.dcc025.view.AgendaMedico;
import com.dcc025.view.AgendaSecretaria;
import com.dcc025.view.TelaEditaPaciente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class EditarPaciente implements ActionListener{
    
    private TelaEditaPaciente tela;
    private Paciente novoPaciente;
    private Paciente antigoPaciente;
    private Date data;
    private SimpleDateFormat formato;
    private int num;
    private Medico medico;
    private Usuario secretaria;
    

    public EditarPaciente(TelaEditaPaciente tela, Paciente antigoPaciente, Medico medico) {
        this.tela = tela;
        this.formato = new SimpleDateFormat("dd/MM/yyyy");
        this.antigoPaciente = antigoPaciente;
        this.medico = medico;
        this.secretaria = null;
    }
    
    public EditarPaciente(TelaEditaPaciente tela, Paciente antigoPaciente, Usuario secretaria) {
        this.tela = tela;
        this.formato = new SimpleDateFormat("dd/MM/yyyy");
        this.antigoPaciente = antigoPaciente;
        this.secretaria = secretaria;
        this.medico = null;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Controller.getPacientes().remove(antigoPaciente);
        
        Questionario quest = new Questionario(tela.getCbHospitalSim().isSelected(), 
                tela.getMotivoHospital(), 
                tela.getCbOperadoSim().isSelected(), 
                tela.getMotivoOperado(), 
                tela.getCbEpilepsiaSim().isSelected(), 
                tela.getCbAlcoolSim().isSelected(), 
                tela.getCbTabagismoSim().isSelected(), 
                tela.getCbSinusiteSim().isSelected(), 
                tela.getCbRiniteSim().isSelected(), 
                tela.getCbAsmaSim().isSelected(), 
                tela.getCbOsteoporoseSim().isSelected(), 
                tela.getCbArtroseSim().isSelected(), 
                tela.getCbDiabetesSim().isSelected(), 
                tela.getTipoDiabetes(), 
                tela.getCbHipertensaoSim().isSelected(), 
                tela.getCbAlergiaSim().isSelected(), 
                tela.getQualAlergia(), 
                tela.getTfObs().getText());
        
        Endereco endereco;
        try{
            this.num = Integer.parseInt(tela.getTfNum().getText());
        }
        catch (NumberFormatException ex) {
            validaNum();
        }
        finally{
            endereco = new Endereco(tela.getTfRua().getText(), 
                                        this.num, 
                                        tela.getTfBairro().getText(), 
                                        tela.getTfCep().getText(), 
                                        tela.getTfCidade().getText(), 
                                        tela.getTfComplemento().getText(), 
                                        (String) tela.getCbEstado().getSelectedItem());
        }
        
        try {
            this.data = formato.parse(tela.getTfDataNascimento().getText());
        } 
        catch (ParseException ex) {
            validaData();
        } 
        finally {
            this.novoPaciente = new Paciente(quest,
                    tela.getTfNome().getText(),
                    this.data,
                    tela.getTfCpf().getText(),
                    endereco,
                    tela.getTfTelefone().getText(),
                    tela.getTfEmail().getText(),
                    (String) tela.getCbTipoSanguineo().getSelectedItem());
        }
        
        Controller.getPacientes().add(novoPaciente);
        
        gravaArquivoPaciente();
        
        tela.setVisible(false);
        
        if(this.secretaria == null){
            AgendaMedico agendaM = new AgendaMedico(medico);
            agendaM.montaTela();
        }
        else if(this.medico == null){
            AgendaSecretaria agendaS = new AgendaSecretaria(secretaria);
            agendaS.montaTela();
        }
    }
    
    private void gravaArquivoPaciente() {
        List<Paciente> pacientes = Controller.getPacientes();
        String toJSONP = JSON.pToJSON(pacientes);
        
        System.out.println(toJSONP);
        
        Arquivo.escreverArquivo("listaPacientes", toJSONP);
        
        JOptionPane.showMessageDialog(null, "Dados do paciente salvos com sucesso!", "Salvando", JOptionPane.PLAIN_MESSAGE);  
    }
    
    private void validaData(){
        try {
            this.data = formato.parse(JOptionPane.showInputDialog("Data de nascimento inválida. "
                    + "Por favor, digite novamente, no formato dd/mm/aaaa"));
        } catch (ParseException ex) {
            validaData();
        }
    }
    
    private void validaNum(){
        try {
            this.num = Integer.parseInt(JOptionPane.showInputDialog("Número de residência inválido. "
                    + "Por favor, tente novamente, digitando um número inteiro."));
        }
        catch (NumberFormatException ex){
            validaNum();
        }
    }
}

