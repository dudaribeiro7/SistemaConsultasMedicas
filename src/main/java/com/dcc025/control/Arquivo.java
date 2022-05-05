// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.control;

import com.dcc025.model.Controller;
import com.dcc025.model.JSON;
import com.dcc025.view.Tela;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;


public class Arquivo implements WindowListener{
    
    private Tela tela;

    public Arquivo(Tela tela) {
        this.tela = tela;
    }

    public static String lerArquivo(String caminho) throws FileNotFoundException {

        StringBuilder conteudo = new StringBuilder();

        File arquivo = new File(caminho);

        Scanner leitor = new Scanner(arquivo);

        // varrendo o conteúdo do arquivo linha por linha
        while (leitor.hasNextLine()) {
            conteudo.append(leitor.nextLine()).append("\n");
        }

        return conteudo.toString();
    }

    public static void escreverArquivo(String caminho, String conteudo) {
        FileWriter fwArquivo;
        BufferedWriter bwArquivo;
        try {
            File arquivo = new File(caminho);

            //Se o arquivo já existir, então abrir para concatenação, caso contrário criar novo arquivo
            fwArquivo = new FileWriter(arquivo, false);
            bwArquivo = new BufferedWriter(fwArquivo);

            // escrevendo String no arquivo e adicionando caracter para criar nova linha
            bwArquivo.write(conteudo + '\n');

            // fechando o arquivo
            bwArquivo.close();
            fwArquivo.close();

        } catch (IOException e) {
            System.err.println("Erro ao tentar escrever no arquivo: " + e.toString());
        }
    }

    @Override
    public void windowOpened(WindowEvent evt) {
         try {
            String lerArquivoM = Arquivo.lerArquivo("listaMedicos");
            String lerArquivoS = Arquivo.lerArquivo("listaSecretarias");
            String lerArquivoP = Arquivo.lerArquivo("listaPacientes");

            Controller.setMedicos(JSON.toMedicos(lerArquivoM)); 
            Controller.setSecretarias(JSON.toSecretarias(lerArquivoS));
            Controller.setPacientes(JSON.toPacientes(lerArquivoP));

            this.tela.repaint();

        } catch(FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Arquivo nao encontrado");
        }
    }

    @Override
    public void windowClosing(WindowEvent e) {}

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}
}
