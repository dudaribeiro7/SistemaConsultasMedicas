// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.control;

import com.dcc025.model.Controller;
import com.dcc025.model.JSON;
import com.dcc025.model.Endereco;
import com.dcc025.model.User;
import com.dcc025.model.Usuario;
import com.dcc025.view.AgendaSecretaria;
import com.dcc025.view.TelaEditaSecretaria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class EditarSecretaria implements ActionListener{
    
    private TelaEditaSecretaria tela;
    private Usuario novaSecretaria;
    private Usuario antigaSecretaria;
    private String username;
    private Date data;
    private SimpleDateFormat formato;
    private int num;

    public EditarSecretaria(TelaEditaSecretaria tela, Usuario antigaSecretaria) {
        this.tela = tela;
        this.antigaSecretaria = antigaSecretaria;
        this.formato = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        Controller.getSecretarias().remove(antigaSecretaria);
        
        setUsername(tela.getTfLogin().getText());
        
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
        
        
        User user = new User(this.username, tela.getTfSenha().getText());
        
        try {
            this.data = formato.parse(tela.getTfDataNascimento().getText());
        } 
        catch (ParseException ex) {
            validaData();
        }
        finally {
            this.novaSecretaria = new Usuario(tela.getTfNome().getText(),
                    this.data,
                    tela.getTfCpf().getText(),
                    endereco,
                    tela.getTfTelefone().getText(),
                    tela.getTfEmail().getText(),
                    user,
                    (String) tela.getCbTipoSanguineo().getSelectedItem());
        }
        
        Controller.getSecretarias().add(novaSecretaria);

        gravaArquivoSecretaria();
        
        tela.setVisible(false);
        AgendaSecretaria agenda = new AgendaSecretaria(novaSecretaria);
        agenda.montaTela();
    }

    private void gravaArquivoSecretaria() {
        List<Usuario> secretarias = Controller.getSecretarias();

        String toJSONS = JSON.uToJSON(secretarias);

        System.out.println(toJSONS);

        Arquivo.escreverArquivo("listaSecretarias", toJSONS);

        JOptionPane.showMessageDialog(tela, "Dados alterados com sucesso!", "Salvando", JOptionPane.PLAIN_MESSAGE); 
    }
    
    private void validaUsername(){
        String name;
        for (int i=0; i<Controller.getSecretarias().size(); i++){
            if(Controller.getSecretarias().get(i).getUser().getLogin().equals(this.username)){
                name = JOptionPane.showInputDialog(null, "Este login já existe. Por favor, crie outro:", 
                        "Erro ao cadastrar login", JOptionPane.ERROR_MESSAGE);
                setUsername(name);
                break;
            }
        }
    }

    public void setUsername(String username) {
        this.username = username;
        validaUsername();
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
