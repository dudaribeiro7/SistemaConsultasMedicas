// Trabalho para disciplina DCC025
// Alunos Gabriel Cabanez Machado(matrícula 202065506B) e Maria Eduarda Ribeiro Facio(matrícula 202065516B)

package com.dcc025.view;

import com.dcc025.control.Arquivo;
import com.dcc025.model.Controller;
import com.dcc025.model.JSON;
import com.dcc025.model.Medico;
import com.dcc025.model.Paciente;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class AgendaMedico extends JFrame{
    private JPanel principal;
    private Medico medico;
    
    private int anoFixo;
    private int mesFixo;
    private int diaFixo;
    
    private int anoAltera;
    private int mesAltera;
    private int diaAltera;
    
    private int valorSelecao;
    
    private JLabel labelAno;
    private JLabel labelDiaMes;
    private JLabel labelDiaSemana;
    private JLabel labelMes;
    
    private JComboBox<Integer> selecaoAno;
    private JComboBox<String> selecaoMes;
    
    private JLabel jlDom;
    private JLabel jlSeg;
    private JLabel jlTer;
    private JLabel jlQua;
    private JLabel jlQui;
    private JLabel jlSex;
    private JLabel jlSab;
    
    private JLabel t1;
    private JLabel t2;
    private JLabel t3;
    private JLabel t4;
    private JLabel t5;
    private JLabel t6;
    private JLabel t7;
    private JLabel t8;
    private JLabel t9;
    private JLabel t10;
    private JLabel t11;
    private JLabel t12;
    private JLabel t13;
    private JLabel t14;
    private JLabel t15;
    private JLabel t16;
    private JLabel t17;
    private JLabel t18;
    private JLabel t19;
    private JLabel t20;
    private JLabel t21;
    private JLabel t22;
    private JLabel t23;
    private JLabel t24;
    private JLabel t25;
    private JLabel t26;
    private JLabel t27;
    private JLabel t28;
    private JLabel t29;
    private JLabel t30;
    private JLabel t31;
    private JLabel t32;
    private JLabel t33;
    private JLabel t34;
    private JLabel t35;
    private JLabel t36;
    private JLabel t37;
    private JLabel t38;
    private JLabel t39;
    private JLabel t40;
    private JLabel t41;
    private JLabel t42;
    
    private JList<Paciente> listaEditar;
    private JList<Paciente> listaExcluir;
    private JList<Paciente> listaExibir;

    public AgendaMedico(Medico medico) {
        this.medico = medico;
        
        this.anoFixo = 0;
        this.mesFixo = 0;
        this.diaFixo = 0;
        
        this.anoAltera = 0;
        this.mesAltera = 0;
        this.diaAltera = 0;
        
        this.valorSelecao = 0;
        
        this.labelAno = new JLabel();
        this.labelDiaMes = new JLabel();
        this.labelDiaSemana = new JLabel();
        this.labelMes = new JLabel();
        
        this.selecaoAno = new JComboBox<>();
        this.selecaoMes = new JComboBox<>();
        
        this.jlDom = new JLabel();
        this.jlSeg = new JLabel();
        this.jlTer = new JLabel();
        this.jlQua = new JLabel();
        this.jlQui = new JLabel();
        this.jlSex = new JLabel();
        this.jlSab = new JLabel();
        
        this.t1 = new JLabel();
        this.t2 = new JLabel();
        this.t3 = new JLabel();
        this.t4 = new JLabel();
        this.t5 = new JLabel();
        this.t6 = new JLabel();
        this.t7 = new JLabel();
        this.t8 = new JLabel();
        this.t9 = new JLabel();
        this.t10 = new JLabel();
        this.t11 = new JLabel();
        this.t12 = new JLabel();
        this.t13 = new JLabel();
        this.t14 = new JLabel();
        this.t15 = new JLabel();
        this.t16 = new JLabel();
        this.t17 = new JLabel();
        this.t18 = new JLabel();
        this.t19 = new JLabel();
        this.t20 = new JLabel();
        this.t21 = new JLabel();
        this.t22 = new JLabel();
        this.t23 = new JLabel();
        this.t24 = new JLabel();
        this.t25 = new JLabel();
        this.t26 = new JLabel();
        this.t27 = new JLabel();
        this.t28 = new JLabel();
        this.t29 = new JLabel();
        this.t30 = new JLabel();
        this.t31 = new JLabel();
        this.t32 = new JLabel();
        this.t33 = new JLabel();
        this.t34 = new JLabel();
        this.t35 = new JLabel();
        this.t36 = new JLabel();
        this.t37 = new JLabel();
        this.t38 = new JLabel();
        this.t39 = new JLabel();
        this.t40 = new JLabel();
        this.t41 = new JLabel();
        this.t42 = new JLabel();
    }
    
    public void montaTela(){
        configuraJanela();
        configuraMenu();
        configuraCalendario();
        configuraData();
        this.add(this.principal);
        this.setVisible(true);
    }
    
    private void configuraJanela(){
        this.setSize(600, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.principal = new JPanel();
        this.principal.setLayout(new FlowLayout());
    }
    
    private void configuraMenu(){
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);
        
        JMenu arqMenu = new JMenu("Arquivo");
        menuBar.add(arqMenu);
        
        JMenuItem editarMenu = new JMenuItem("Editar meus dados");
        editarMenu.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                editarMeusDados();
           }});
        arqMenu.add(editarMenu);
        
        JMenuItem sairMenu = new JMenuItem("Sair");
        sairMenu.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                sair();
            }});
        arqMenu.add(sairMenu);
        
        JMenu pacientesMenu = new JMenu("Pacientes");
        menuBar.add(pacientesMenu);
        
        JMenuItem cadastroMenu = new JMenuItem("Novo cadastro");
        cadastroMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastroPaciente();
            }
        });
        pacientesMenu.add(cadastroMenu);
        
        JMenuItem editaPacienteMenu = new JMenu("Editar dados");
        pacientesMenu.add(editaPacienteMenu);
        this.listaEditar = ordemAlfabetica();
        this.listaEditar.setVisible(true);
        this.listaEditar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.listaEditar.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                editarPaciente();
            }
        });
        editaPacienteMenu.add(new JScrollPane(this.listaEditar));
        
        JMenuItem exibeFichaMenu = new JMenu("Exibir ficha");
        pacientesMenu.add(exibeFichaMenu);
        this.listaExibir = ordemAlfabetica();
        this.listaExibir.setVisible(true);
        this.listaExibir.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.listaExibir.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                exibirFichaPaciente();
            }
        });
        exibeFichaMenu.add(new JScrollPane(this.listaExibir));
        
        JMenuItem excluiPacienteMenu = new JMenu("Excluir ficha");
        pacientesMenu.add(excluiPacienteMenu);
        this.listaExcluir = ordemAlfabetica();
        this.listaExcluir.setVisible(true);
        this.listaExcluir.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.listaExcluir.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                excluirPaciente();
            }
        });
        excluiPacienteMenu.add(new JScrollPane(this.listaExcluir));
    }
    
    private JList<Paciente> ordemAlfabetica(){
        DefaultListModel<Paciente> model = new DefaultListModel<>();
        for(int i=0; i<Controller.getPacientes().size(); i++)
            model.addElement(Controller.getPacientes().get(i));
        JList<Paciente> listaAux = new JList<>(model);
        
        int cont;
        int[] ordem = new int[listaAux.getModel().getSize()];
        
        for(int i=0; i<listaAux.getModel().getSize(); i++){
            cont = 0;
            for(int j=0; j<listaAux.getModel().getSize(); j++)
                if(i != j && listaAux.getModel().getElementAt(i).getNome().compareToIgnoreCase
                                                            (listaAux.getModel().getElementAt(j).getNome()) > 0)
                    cont++;
            ordem[cont] = i;
        }
        
        DefaultListModel<Paciente> model2 = new DefaultListModel<>();
        for(int i=0; i<ordem.length; i++)
            model2.addElement(listaAux.getModel().getElementAt(ordem[i]));
        JList<Paciente> lista = new JList<>(model2);
        
        return lista;
    }
    
    private void editarPaciente(){
        this.setVisible(false);
        TelaEditaPaciente editaP = new TelaEditaPaciente(this.listaEditar.getModel().getElementAt
                                                                    (this.listaEditar.getSelectedIndex()), medico);
        editaP.montaTelaEditaPaciente();
    }
    
    private void editarMeusDados(){
        this.setVisible(false);
        TelaEditaMedico editaM = new TelaEditaMedico(medico);
        editaM.montaTelaEditaMedico();
    }
    
    private void excluirPaciente(){
        int ctz = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir a ficha de " + 
                        this.listaExcluir.getModel().getElementAt(this.listaExcluir.getSelectedIndex()).getNome() + "?", 
                "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if(ctz == 0){
            Controller.getPacientes().remove(this.listaExcluir.getModel().getElementAt(this.listaExcluir.getSelectedIndex()));
            gravaArquivoPaciente();
            this.setVisible(false);
            AgendaMedico agenda = new AgendaMedico(medico);
            agenda.montaTela();
        }
    }
    
    private void gravaArquivoPaciente() {
        List<Paciente> pacientes = Controller.getPacientes();
        String toJSONP = JSON.pToJSON(pacientes);
        
        System.out.println(toJSONP);
        
        Arquivo.escreverArquivo("listaPacientes", toJSONP);
        
        JOptionPane.showMessageDialog(null, "Paciente excluído com sucesso!", "Excluindo", JOptionPane.PLAIN_MESSAGE);  
    }
    
    private void exibirFichaPaciente(){
        this.setVisible(false);
        FichaPaciente fichaP = new FichaPaciente(medico);
        fichaP.montaTela();
    }
    
    private void cadastroPaciente(){
        this.setVisible(false);
        TelaCadastroPaciente cadastroP = new TelaCadastroPaciente(medico);
        cadastroP.montaTelaCadastroPaciente();
    }
    
    private void sair(){
        this.setVisible(false);
        Tela novaTela = new Tela();
        novaTela.montaTela();
    }
    
    private void selecaoMesActionPerformed(ActionEvent evt) {  
        calendario();
    }
    
    private void selecaoAnoActionPerformed(ActionEvent evt) {                                           
        this.labelAno.setText(this.selecaoAno.getSelectedItem().toString());
        calendario();
    }
    
    private void t1MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t1.getText());
        calendario();
    }
    
    private void t2MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t2.getText());
        calendario();
    }
    
    private void t3MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t3.getText());
        calendario();
    }
    
    private void t4MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t4.getText());
        calendario();
    }
    
    private void t5MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t5.getText());
        calendario();
    }
    
    private void t6MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t6.getText());
        calendario();
    }
    
    private void t7MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t7.getText());
        calendario();
    }
    
    private void t8MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t8.getText());
        calendario();
    }
    
    private void t9MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t9.getText());
        calendario();
    }
    
    private void t10MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t10.getText());
        calendario();
    }
    
    private void t11MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t11.getText());
        calendario();
    }
    
    private void t12MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t12.getText());
        calendario();
    }
    
    private void t13MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t13.getText());
        calendario();
    }
    
    private void t14MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t14.getText());
        calendario();
    }
    
    private void t15MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t15.getText());
        calendario();
    }
    
    private void t16MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t16.getText());
        calendario();
    }
    
    private void t17MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t17.getText());
        calendario();
    }
    
    private void t18MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t18.getText());
        calendario();
    }
    
    private void t19MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t19.getText());
        calendario();
    }
    
    private void t20MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t20.getText());
        calendario();
    }
    
    private void t21MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t21.getText());
        calendario();
    }
    
    private void t22MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t22.getText());
        calendario();
    }
    
    private void t23MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t23.getText());
        calendario();
    }
    
    private void t24MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t24.getText());
        calendario();
    }
    
    private void t25MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t25.getText());
        calendario();
    }
    
    private void t26MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t26.getText());
        calendario();
    }
    
    private void t27MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t27.getText());
        calendario();
    }
    
    private void t28MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t28.getText());
        calendario();
    }
    
    private void t29MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t29.getText());
        calendario();
    }
    
    private void t30MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t30.getText());
        calendario();
    }
    
    private void t31MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t31.getText());
        calendario();
    }
    
    private void t32MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t32.getText());
        calendario();
    }
    
    private void t33MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t33.getText());
        calendario();
    }
    
    private void t34MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t34.getText());
        calendario();
    }
    
    private void t35MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t35.getText());
        calendario();
    }
    
    private void t36MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t36.getText());
        calendario();
    }
    
    private void t37MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t37.getText());
        calendario();
    }
    
    private void t38MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t38.getText());
        calendario();
    }
    
    private void t39MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t39.getText());
        calendario();
    }
    
    private void t40MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t40.getText());
        calendario();
    }
    
    private void t41MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t41.getText());
        calendario();
    }
    
    private void t42MouseClicked(java.awt.event.MouseEvent evt) {                                
        this.diaAltera = Integer.parseInt(this.t42.getText());
        calendario();
    }
    
    private void configuraCalendario(){
        Calendar hoje = GregorianCalendar.getInstance();
        this.anoFixo = hoje.get(Calendar.YEAR);
        this.mesFixo = hoje.get(Calendar.MONTH);
        this.diaFixo = hoje.get(Calendar.DAY_OF_MONTH);
        
        this.diaAltera = this.diaFixo;
        
        JPanel jpCalendario = new JPanel();
        jpCalendario.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jpCalendario.setLayout(new FlowLayout());
        jpCalendario.setPreferredSize(new Dimension(270, 190));
        
//botões dos dias do mes:
        this.t1.setPreferredSize(new Dimension(29, 16));
        this.t2.setPreferredSize(new Dimension(29, 16));
        this.t3.setPreferredSize(new Dimension(29, 16));
        this.t4.setPreferredSize(new Dimension(29, 16));
        this.t5.setPreferredSize(new Dimension(29, 16));
        this.t6.setPreferredSize(new Dimension(29, 16));
        this.t7.setPreferredSize(new Dimension(29, 16));
        this.t8.setPreferredSize(new Dimension(29, 16));
        this.t9.setPreferredSize(new Dimension(29, 16));
        this.t10.setPreferredSize(new Dimension(29, 16));
        this.t11.setPreferredSize(new Dimension(29, 16));
        this.t12.setPreferredSize(new Dimension(29, 16));
        this.t13.setPreferredSize(new Dimension(29, 16));
        this.t14.setPreferredSize(new Dimension(29, 16));
        this.t15.setPreferredSize(new Dimension(29, 16));
        this.t16.setPreferredSize(new Dimension(29, 16));
        this.t17.setPreferredSize(new Dimension(29, 16));
        this.t18.setPreferredSize(new Dimension(29, 16));
        this.t19.setPreferredSize(new Dimension(29, 16));
        this.t20.setPreferredSize(new Dimension(29, 16));
        this.t21.setPreferredSize(new Dimension(29, 16));
        this.t22.setPreferredSize(new Dimension(29, 16));
        this.t23.setPreferredSize(new Dimension(29, 16));
        this.t24.setPreferredSize(new Dimension(29, 16));
        this.t25.setPreferredSize(new Dimension(29, 16));
        this.t26.setPreferredSize(new Dimension(29, 16));
        this.t27.setPreferredSize(new Dimension(29, 16));
        this.t28.setPreferredSize(new Dimension(29, 16));
        this.t29.setPreferredSize(new Dimension(29, 16));
        this.t30.setPreferredSize(new Dimension(29, 16));
        this.t31.setPreferredSize(new Dimension(29, 16));
        this.t32.setPreferredSize(new Dimension(29, 16));
        this.t33.setPreferredSize(new Dimension(29, 16));
        this.t34.setPreferredSize(new Dimension(29, 16));
        this.t35.setPreferredSize(new Dimension(29, 16));
        this.t36.setPreferredSize(new Dimension(29, 16));
        this.t37.setPreferredSize(new Dimension(29, 16));
        this.t38.setPreferredSize(new Dimension(29, 16));
        this.t39.setPreferredSize(new Dimension(29, 16));
        this.t40.setPreferredSize(new Dimension(29, 16));
        this.t41.setPreferredSize(new Dimension(29, 16));
        this.t42.setPreferredSize(new Dimension(29, 16));
       
        this.t1.setForeground(Color.RED);
        this.t8.setForeground(Color.RED);
        this.t15.setForeground(Color.RED);
        this.t22.setForeground(Color.RED);
        this.t29.setForeground(Color.RED);
        this.t36.setForeground(Color.RED);
        
        t1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t1MouseClicked(evt);
            }});
        
        t2.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t2MouseClicked(evt);
            }});
        
        t3.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t3MouseClicked(evt);
            }});
        
        t4.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t4MouseClicked(evt);
            }});
        
        t5.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t5MouseClicked(evt);
            }});
        
        t6.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t6MouseClicked(evt);
            }});
        
        t7.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t7MouseClicked(evt);
            }});
        
        t8.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t8MouseClicked(evt);
            }});
        
        t9.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t9MouseClicked(evt);
            }});
        
        t10.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t10MouseClicked(evt);
            }});
        
        t11.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t11MouseClicked(evt);
            }});
        
        t12.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t12MouseClicked(evt);
            }});
        
        t13.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t13MouseClicked(evt);
            }});
        
        t14.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t14MouseClicked(evt);
            }});
        
        t15.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t15MouseClicked(evt);
            }});
        
        t16.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t16MouseClicked(evt);
            }});
        
        t17.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t17MouseClicked(evt);
            }});
        
        t18.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t18MouseClicked(evt);
            }});
        
        t19.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t19MouseClicked(evt);
            }});
        
        t20.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t20MouseClicked(evt);
            }});
        
        t21.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t21MouseClicked(evt);
            }});
        
        t22.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t22MouseClicked(evt);
            }});
        
        t23.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t23MouseClicked(evt);
            }});
        
        t24.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t24MouseClicked(evt);
            }});
        
        t25.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t25MouseClicked(evt);
            }});
        
        t26.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t26MouseClicked(evt);
            }});
        
        t27.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t27MouseClicked(evt);
            }});
        
        t28.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t28MouseClicked(evt);
            }});
        
        t29.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t29MouseClicked(evt);
            }});
        
        t30.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t30MouseClicked(evt);
            }});
        
        t31.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t31MouseClicked(evt);
            }});
        
        t32.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t32MouseClicked(evt);
            }});
        
        t33.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t33MouseClicked(evt);
            }});
        
        t34.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t34MouseClicked(evt);
            }});
        
        t35.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t35MouseClicked(evt);
            }});
        
        t36.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t36MouseClicked(evt);
            }});
        
        t37.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t37MouseClicked(evt);
            }});
        
        t38.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t38MouseClicked(evt);
            }});
        
        t39.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t39MouseClicked(evt);
            }});
        
        t40.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t40MouseClicked(evt);
            }});
        
        t41.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t41MouseClicked(evt);
            }});
        
        t42.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                t42MouseClicked(evt);
            }});
        
//caixa de seleção ano:
        this.selecaoAno.setEditable(true);
        this.selecaoAno.setCursor(new java.awt.Cursor(Cursor.DEFAULT_CURSOR));
        this.selecaoAno.setPreferredSize(new Dimension(125, 20));
        int anoMaximo = this.anoFixo + 50;
        for(int i=2000; i<=anoMaximo; i++){
            this.selecaoAno.addItem(i);
        }
        this.selecaoAno.setSelectedItem(this.anoFixo);
        this.selecaoAno.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                selecaoAnoActionPerformed(evt);
            }
        });
        
//caixa de seleção mes: 
        this.selecaoMes.setModel(new DefaultComboBoxModel<>(new String[]{"Janeiro", 
                                                                        "Fevereiro", 
                                                                        "Março", 
                                                                        "Abril", 
                                                                        "Maio", 
                                                                        "Junho", 
                                                                        "Julho", 
                                                                        "Agosto", 
                                                                        "Setembro", 
                                                                        "Outubro", 
                                                                        "Novembro", 
                                                                        "Dezembro"}));
        this.selecaoMes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                selecaoMesActionPerformed(evt);
            }});
        switch(this.mesFixo){
            case 0: 
                this.selecaoMes.setSelectedIndex(0);
                break;
            case 1:
                this.selecaoMes.setSelectedIndex(1);
                break;
            case 2:
                this.selecaoMes.setSelectedIndex(2);
                break;
            case 3:
                this.selecaoMes.setSelectedIndex(3);
                break;
            case 4:
                this.selecaoMes.setSelectedIndex(4);
                break;
            case 5:
                this.selecaoMes.setSelectedIndex(5);
                break;
            case 6:
                this.selecaoMes.setSelectedIndex(6);
                break;
            case 7:
                this.selecaoMes.setSelectedIndex(7);
                break;
            case 8:
                this.selecaoMes.setSelectedIndex(8);
                break;
            case 9:
                this.selecaoMes.setSelectedIndex(9);
                break;
            case 10:
                this.selecaoMes.setSelectedIndex(10);
                break;
            case 11:
                this.selecaoMes.setSelectedIndex(11);
                break;
        }
        
//adiciona JComboBox's:
        jpCalendario.add(this.selecaoMes);
        jpCalendario.add(new JLabel("      "));
        jpCalendario.add(this.selecaoAno);
        
//dias da semana:
        jlDom.setForeground(Color.RED);
        jlDom.setHorizontalAlignment(SwingConstants.CENTER);
        jlDom.setText("Dom");
        jlDom.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlDom.setPreferredSize(new Dimension(29, 16));
        jpCalendario.add(this.jlDom);

        jlSeg.setHorizontalAlignment(SwingConstants.CENTER);
        jlSeg.setText("Seg");
        jlSeg.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlSeg.setPreferredSize(new Dimension(29, 16));
        jpCalendario.add(this.jlSeg);

        jlTer.setHorizontalAlignment(SwingConstants.CENTER);
        jlTer.setText("Ter");
        jlTer.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlTer.setPreferredSize(new Dimension(29, 16));
        jpCalendario.add(this.jlTer);

        jlQua.setHorizontalAlignment(SwingConstants.CENTER);
        jlQua.setText("Qua");
        jlQua.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlQua.setPreferredSize(new Dimension(29, 16));
        jpCalendario.add(this.jlQua);

        jlQui.setHorizontalAlignment(SwingConstants.CENTER);
        jlQui.setText("Qui");
        jlQui.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlQui.setPreferredSize(new Dimension(29, 16));
        jpCalendario.add(this.jlQui);

        jlSex.setHorizontalAlignment(SwingConstants.CENTER);
        jlSex.setText("Sex");
        jlSex.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlSex.setPreferredSize(new Dimension(29, 16));
        jpCalendario.add(this.jlSex);

        jlSab.setHorizontalAlignment(SwingConstants.CENTER);
        jlSab.setText("Sáb");
        jlSab.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        jlSab.setPreferredSize(new Dimension(29, 16));
        jpCalendario.add(this.jlSab);
        
        jpCalendario.add(this.t1);
        jpCalendario.add(this.t2);
        jpCalendario.add(this.t3);
        jpCalendario.add(this.t4);
        jpCalendario.add(this.t5);
        jpCalendario.add(this.t6);
        jpCalendario.add(this.t7);
        jpCalendario.add(this.t8);
        jpCalendario.add(this.t9);
        jpCalendario.add(this.t10);
        jpCalendario.add(this.t11);
        jpCalendario.add(this.t12);
        jpCalendario.add(this.t13);
        jpCalendario.add(this.t14);
        jpCalendario.add(this.t15);
        jpCalendario.add(this.t16);
        jpCalendario.add(this.t17);
        jpCalendario.add(this.t18);
        jpCalendario.add(this.t19);
        jpCalendario.add(this.t20);
        jpCalendario.add(this.t21);
        jpCalendario.add(this.t22);
        jpCalendario.add(this.t23);
        jpCalendario.add(this.t24);
        jpCalendario.add(this.t25);
        jpCalendario.add(this.t26);
        jpCalendario.add(this.t27);
        jpCalendario.add(this.t28);
        jpCalendario.add(this.t29);
        jpCalendario.add(this.t30);
        jpCalendario.add(this.t31);
        jpCalendario.add(this.t32);
        jpCalendario.add(this.t33);
        jpCalendario.add(this.t34);
        jpCalendario.add(this.t35);
        jpCalendario.add(this.t36);
        jpCalendario.add(this.t37);
        jpCalendario.add(this.t38);
        jpCalendario.add(this.t39);
        jpCalendario.add(this.t40);
        jpCalendario.add(this.t41);
        jpCalendario.add(this.t42);
        
        
        this.principal.add(jpCalendario);
    }
    
    private void configuraData(){
        Calendar hoje = GregorianCalendar.getInstance();
        this.anoFixo = hoje.get(Calendar.YEAR);
        this.mesFixo = hoje.get(Calendar.MONTH);
        this.diaFixo = hoje.get(Calendar.DAY_OF_MONTH);
        
        JPanel jpAno = new JPanel();
        jpAno.setPreferredSize(new Dimension(100, 90));
        jpAno.setLayout(new BorderLayout());
        
        this.labelAno.setFont(new Font("Tahoma", 1, 30));
        this.labelAno.setText("" + this.anoFixo);
        jpAno.add(this.labelAno, BorderLayout.EAST);
        
        
        JPanel jpData = new JPanel();
        jpData.setLayout(new BorderLayout());
        jpData.setPreferredSize(new Dimension(125, 90));
        
        this.labelDiaMes.setFont(new Font("Tahoma", 1, 29));
        this.labelDiaMes.setForeground(new Color(204, 0, 0));
        this.labelDiaMes.setHorizontalAlignment(SwingConstants.CENTER);
        this.labelDiaMes.setText("" + this.diaFixo);
        jpData.add(this.labelDiaMes, BorderLayout.CENTER);
        
        this.labelDiaSemana.setFont(new Font("Tahoma", 1, 15));
        this.labelDiaSemana.setHorizontalAlignment(SwingConstants.CENTER);
        int semana = hoje.get(Calendar.DAY_OF_WEEK);
        switch(semana){
            case 1:
                this.labelDiaSemana.setText("Domingo");
                break;
            case 2:
                this.labelDiaSemana.setText("Segunda-feira");
                break;
            case 3:
                this.labelDiaSemana.setText("Terça-feira");
                break;
            case 4:
                this.labelDiaSemana.setText("Quarta-feira");
                break;
            case 5:
                this.labelDiaSemana.setText("Quinta-feira");
                break;
            case 6:
                this.labelDiaSemana.setText("Sexta-feira");
                break;
            case 7:
                this.labelDiaSemana.setText("Sábado");
                break;
        }
        jpData.add(this.labelDiaSemana, BorderLayout.NORTH);
        
        this.labelMes.setFont(new Font("Tahoma", 1, 17));
        this.labelMes.setHorizontalAlignment(SwingConstants.CENTER);
        switch(this.mesFixo){
            case 0: 
                this.labelMes.setText("Janeiro");
                break;
            case 1:
                this.labelMes.setText("Fevereiro");
                break;
            case 2:
                this.labelMes.setText("Março");
                break;
            case 3:
                this.labelMes.setText("Abril");
                break;
            case 4:
                this.labelMes.setText("Maio");
                break;
            case 5:
                this.labelMes.setText("Junho");
                break;
            case 6:
                this.labelMes.setText("Julho");
                break;
            case 7:
                this.labelMes.setText("Agosto");
                break;
            case 8:
                this.labelMes.setText("Setembro");
                break;
            case 9:
                this.labelMes.setText("Outubro");
                break;
            case 10:
                this.labelMes.setText("Novembro");
                break;
            case 11: 
                this.labelMes.setText("Dezembro");
                break;
        }
        jpData.add(this.labelMes, BorderLayout.SOUTH);
        
        
        this.principal.add(jpAno);
        this.principal.add(jpData);
        
    }
    
    private void calendario(){
        this.t1.setText("");
        this.t2.setText("");
        this.t3.setText("");
        this.t4.setText("");
        this.t5.setText("");
        this.t6.setText("");
        this.t7.setText("");
        this.t8.setText("");
        this.t9.setText("");
        this.t10.setText("");
        this.t11.setText("");
        this.t12.setText("");
        this.t13.setText("");
        this.t14.setText("");
        this.t15.setText("");
        this.t16.setText("");
        this.t17.setText("");
        this.t18.setText("");
        this.t19.setText("");
        this.t20.setText("");
        this.t21.setText("");
        this.t22.setText("");
        this.t23.setText("");
        this.t24.setText("");
        this.t25.setText("");
        this.t26.setText("");
        this.t27.setText("");
        this.t28.setText("");
        this.t29.setText("");
        this.t30.setText("");
        this.t31.setText("");
        this.t32.setText("");
        this.t33.setText("");
        this.t34.setText("");
        this.t35.setText("");
        this.t36.setText("");
        this.t37.setText("");
        this.t38.setText("");
        this.t39.setText("");
        this.t40.setText("");
        this.t41.setText("");
        this.t42.setText("");
        
        this.mesAltera = this.selecaoMes.getSelectedIndex();
        this.anoAltera = Integer.parseInt(this.selecaoAno.getSelectedItem().toString());
        
        this.labelDiaMes.setText("" + this.diaAltera);
        
        Calendar dia = Calendar.getInstance();
        dia.set(this.anoAltera, this.mesAltera, this.diaAltera);
        int sem = dia.get(Calendar.DAY_OF_WEEK);
        switch(sem){
            case 1:
                this.labelDiaSemana.setText("Domingo");
                break;
            case 2:
                this.labelDiaSemana.setText("Segunda-feira");
                break;
            case 3:
                this.labelDiaSemana.setText("Terça-feira");
                break;
            case 4:
                this.labelDiaSemana.setText("Quarta-feira");
                break;
            case 5:
                this.labelDiaSemana.setText("Quinta-feira");
                break;
            case 6:
                this.labelDiaSemana.setText("Sexta-feira");
                break;
            case 7:
                this.labelDiaSemana.setText("Sábado");
                break;
        }
        
        int totalDiaMes = 0;
        
        switch(this.mesAltera){
            case 0: 
                this.labelMes.setText("Janeiro");
                totalDiaMes = 31;
                break;
            case 1:
                this.labelMes.setText("Fevereiro");
                int resultado = this.anoAltera % 4;
                if(resultado == 0)
                    totalDiaMes = 29; //ano bissexto
                else 
                    totalDiaMes = 28; //ano nao bissexto
                break;
            case 2:
                this.labelMes.setText("Março");
                totalDiaMes = 31;
                break;
            case 3:
                this.labelMes.setText("Abril");
                totalDiaMes = 30;
                break;
            case 4:
                this.labelMes.setText("Maio");
                totalDiaMes = 31;
                break;
            case 5:
                this.labelMes.setText("Junho");
                totalDiaMes = 30;
                break;
            case 6:
                this.labelMes.setText("Julho");
                totalDiaMes = 31;
                break;
            case 7:
                this.labelMes.setText("Agosto");
                totalDiaMes = 31;
                break;
            case 8:
                this.labelMes.setText("Setembro");
                totalDiaMes = 30;
                break;
            case 9:
                this.labelMes.setText("Outubro");
                totalDiaMes = 31;
                break;
            case 10:
                this.labelMes.setText("Novembro");
                totalDiaMes = 30;
                break;
            case 11:
                this.labelMes.setText("Dezembro");
                totalDiaMes = 31;
                break;
        }
        
        Calendar calendar = Calendar.getInstance();
        calendar.set(this.anoAltera, this.mesAltera, 1);
        int setaDia = 0;
        
        int semana = calendar.get(Calendar.DAY_OF_WEEK);
        switch(semana){
            case Calendar.SUNDAY:
                setaDia = 1;
                break;
            case Calendar.MONDAY:
                setaDia = 2;
                break;
            case Calendar.TUESDAY:
                setaDia = 3;
                break;
            case Calendar.WEDNESDAY:
                setaDia = 4;
                break;
            case Calendar.THURSDAY:
                setaDia = 5;
                break;
            case Calendar.FRIDAY:
                setaDia = 6;
                break;
            case Calendar.SATURDAY:
                setaDia = 7;
                break;
        }
        
        for(int i=1; i<=totalDiaMes; i++){
            switch(setaDia){
                case 1:
                    t1.setText("" + i);
                    break;
                case 2:
                    t2.setText("" + i);
                    break;
                case 3:
                    t3.setText("" + i);
                    break;
                case 4:
                    t4.setText("" + i);
                    break;
                case 5:
                    t5.setText("" + i);
                    break;
                case 6:
                    t6.setText("" + i);
                    break;
                case 7:
                    t7.setText("" + i);
                    break;
                case 8:
                    t8.setText("" + i);
                    break;
                case 9:
                    t9.setText("" + i);
                    break;
                case 10:
                    t10.setText("" + i);
                    break;
                case 11:
                    t11.setText("" + i);
                    break;
                case 12:
                    t12.setText("" + i);
                    break;
                case 13:
                    t13.setText("" + i);
                    break;
                case 14:
                    t14.setText("" + i);
                    break;
                case 15:
                    t15.setText("" + i);
                    break;
                case 16:
                    t16.setText("" + i);
                    break;
                case 17:
                    t17.setText("" + i);
                    break;
                case 18:
                    t18.setText("" + i);
                    break;
                case 19:
                    t19.setText("" + i);
                    break;
                case 20:
                    t20.setText("" + i);
                    break;
                case 21:
                    t21.setText("" + i);
                    break;
                case 22:
                    t22.setText("" + i);
                    break;
                case 23:
                    t23.setText("" + i);
                    break;
                case 24:
                    t24.setText("" + i);
                    break;
                case 25:
                    t25.setText("" + i);
                    break;
                case 26:
                    t26.setText("" + i);
                    break;
                case 27:
                    t27.setText("" + i);
                    break;
                case 28:
                    t28.setText("" + i);
                    break;
                case 29:
                    t29.setText("" + i);
                    break;
                case 30:
                    t30.setText("" + i);
                    break;
                case 31:
                    t31.setText("" + i);
                    break;
                case 32:
                    t32.setText("" + i);
                    break;
                case 33:
                    t33.setText("" + i);
                    break;
                case 34:
                    t34.setText("" + i);
                    break;
                case 35:
                    t35.setText("" + i);
                    break;
                case 36:
                    t36.setText("" + i);
                    break;
                case 37:
                    t37.setText("" + i);
                    break;
                case 38:
                    t38.setText("" + i);
                    break;
                case 39:
                    t39.setText("" + i);
                    break;
                case 40:
                    t40.setText("" + i);
                    break;
                case 41:
                    t41.setText("" + i);
                    break;
                case 42:
                    t42.setText("" + i);
                    break;
            }
            setaDia++;
        }
    }
}