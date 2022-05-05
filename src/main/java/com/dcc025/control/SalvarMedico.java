// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.control;

import com.dcc025.model.Controller;
import com.dcc025.model.JSON;
import com.dcc025.model.Endereco;
import com.dcc025.model.Medico;
import com.dcc025.model.User;
import com.dcc025.view.Tela;
import com.dcc025.view.TelaCadastroMedico;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.List;

public class SalvarMedico implements ActionListener {

    private TelaCadastroMedico tela;
    private Medico medico;
    private String username;
    private Date data;
    private SimpleDateFormat formato;
    private int num;

    public SalvarMedico(TelaCadastroMedico tela) {
        this.tela = tela;
        this.formato = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        setUsername(tela.getTfLogin().getText());

        Endereco endereco;
        try {
            this.num = Integer.parseInt(tela.getTfNum().getText());
        } catch (NumberFormatException ex) {
            validaNum();
        } finally {
            endereco = new Endereco(tela.getTfRua().getText(), this.num, tela.getTfBairro().getText(),
                    tela.getTfCep().getText(), tela.getTfCidade().getText(), tela.getTfComplemento().getText(),
                    (String) tela.getCbEstado().getSelectedItem());
        }

        User user = new User(this.username, tela.getTfSenha().getText());

        try {
            this.data = formato.parse(tela.getTfDataNascimento().getText());
        } catch (ParseException ex) {
            validaData();
        } finally {
            this.medico = new Medico(tela.getTfArea().getText(), tela.getTfNome().getText(), this.data,
                    tela.getTfCpf().getText(), endereco, tela.getTfTelefone().getText(), tela.getTfEmail().getText(),
                    user, (String) tela.getCbTipoSanguineo().getSelectedItem());
        }

        Controller.getMedicos().add(medico);

        gravaArquivoMedico();

        tela.setVisible(false);
        Tela novaTela = new Tela();
        novaTela.montaTela();
    }

    private void gravaArquivoMedico() {
        List<Medico> medicos = Controller.getMedicos();
        String toJSONM = JSON.mToJSON(medicos);
        
        System.out.println(toJSONM);
        
        Arquivo.escreverArquivo("listaMedicos", toJSONM);
        
        JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!", "Salvando", JOptionPane.PLAIN_MESSAGE); 
    }

    private void validaUsername() {
        String name;
        for (int i = 0; i < Controller.getMedicos().size(); i++) {
            if (Controller.getMedicos().get(i).getUser().getLogin().equals(this.username)) {
                name = JOptionPane.showInputDialog(null, "Este login já existe. Por favor, crie outro:",
                        "Erro ao cadastrar login", JOptionPane.ERROR_MESSAGE);
                setUsername(name);
                break;
            }
        }
    }

    private void setUsername(String username) {
        this.username = username;
        validaUsername();
    }

    private void validaData() {
        try {
            this.data = formato.parse(JOptionPane.showInputDialog(
                    "Data de nascimento inválida. " + "Por favor, digite novamente, no formato dd/mm/aaaa"));
        } catch (ParseException ex) {
            validaData();
        }
    }

    private void validaNum() {
        try {
            this.num = Integer.parseInt(JOptionPane.showInputDialog(
                    "Número de residência inválido. " + "Por favor, tente novamente, digitando um número inteiro."));
        } catch (NumberFormatException ex) {
            validaNum();
        }
    }
}