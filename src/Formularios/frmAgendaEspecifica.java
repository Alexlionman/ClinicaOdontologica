/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Classes.Conecta;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class frmAgendaEspecifica extends javax.swing.JFrame {

    Color azulPadrao = new Color(129,167,255);
    Color azulFundo = new Color(226, 235, 255);
    Color azulClaro = new Color(226, 235, 255);
    Color azulClaroo = new Color(139, 215, 255);
    Color azulHover = new Color(192, 216, 235);
    Color vermelhoHover = new Color(242, 198, 196);
    Color vermelhoPadraoExcluir = new Color(223,107,111);
      //fonte para o zoom
    public Font fonteZoomTexto = new Font("Arial", Font.BOLD, 18);
    public Font fonteNormal = new Font("Arial", Font.BOLD, 14);
    
    public Font fonteZoomBotoes = new Font("Arial", Font.BOLD, 18);
    public Font fonteNormalBotoes = new Font("Arial", Font.BOLD, 14);
    
    
    
    
    private void carregaTabela() {
        
        tblDentista.getColumnModel().getColumn(0).setPreferredWidth(100); 
        tblDentista.getColumnModel().getColumn(1).setPreferredWidth(200);
        DefaultTableModel modelo = (DefaultTableModel) tblDentista.getModel();
        modelo.setNumRows(0);
        try {
            Connection con = Conecta.getConexao();
            PreparedStatement pstm;
            ResultSet rs;
            pstm = con.prepareStatement("select * from dentista order by nome");
            rs = pstm.executeQuery();
            while (rs.next()) {  //enquanto existirem registros no banco, ele continuar
                modelo.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome")});
            }
            pstm.close();
            con.close();
            rs.close();
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void carregaTabelaEspecifica(int id) {
        DefaultTableModel modelo = (DefaultTableModel) tblAgenda.getModel();
        modelo.setNumRows(0);
        try {
            Connection con = Conecta.getConexao();
            PreparedStatement pstm;
            ResultSet rs;
            pstm = con.prepareStatement("SELECT dataConsulta,hora,P.nome,valor FROM consulta C,paciente P "
                    + "WHERE C.pacienteId = P.id AND C.dentistaId=" + id + " ORDER BY dataConsulta,hora");
            rs = pstm.executeQuery();
            while (rs.next()) {  //enquanto existirem registros no banco, ele continuar
                modelo.addRow(new Object[]{
                    rs.getString("dataConsulta"),
                    rs.getString("hora"),
                    rs.getString("P.nome"),
                    rs.getFloat("valor")});
            }
            pstm.close();
            con.close();
            rs.close();
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public frmAgendaEspecifica() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        carregaTabela();
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        jScrollPane3.getViewport().setBackground(Color.WHITE);
        getContentPane().setBackground(azulClaro);
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(azulPadrao);
        headerRenderer.setForeground(Color.WHITE);
        for (int i = 0; i < tblDentista.getModel().getColumnCount(); i++) {
            tblDentista.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        for (int i = 0; i < tblAgenda.getModel().getColumnCount(); i++) {
            tblAgenda.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
                                                        
    }

    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblDentista = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAgenda = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtPesquisaDentista2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnAgendaGeral = new javax.swing.JButton();
        btnAgendarConsulta = new javax.swing.JButton();
        btnEditarConsulta = new javax.swing.JButton();
        btnZoom = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        jmiPacientes = new javax.swing.JMenuItem();
        jmiDentistas = new javax.swing.JMenuItem();
        jmiRecepcionistas = new javax.swing.JMenuItem();
        jmiConsultas = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiEstoque = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jmiSair = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        tblDentista.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        tblDentista.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblDentista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDentista.setGridColor(new java.awt.Color(255, 255, 255));
        tblDentista.setSelectionBackground(new java.awt.Color(129, 167, 255));
        tblDentista.getTableHeader().setResizingAllowed(false);
        tblDentista.getTableHeader().setReorderingAllowed(false);
        tblDentista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDentistaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblDentista);
        if (tblDentista.getColumnModel().getColumnCount() > 0) {
            tblDentista.getColumnModel().getColumn(0).setMinWidth(40);
            tblDentista.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblDentista.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jLabel1.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel1.setText("Procedimentos agendados para esse(a) dentista");

        jScrollPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        tblAgenda.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        tblAgenda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data ", "Horário", "Paciente", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAgenda.setGridColor(new java.awt.Color(255, 255, 255));
        tblAgenda.setSelectionBackground(new java.awt.Color(129, 167, 255));
        tblAgenda.getTableHeader().setResizingAllowed(false);
        tblAgenda.getTableHeader().setReorderingAllowed(false);
        tblAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAgendaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblAgenda);
        if (tblAgenda.getColumnModel().getColumnCount() > 0) {
            tblAgenda.getColumnModel().getColumn(0).setMinWidth(90);
            tblAgenda.getColumnModel().getColumn(0).setPreferredWidth(90);
            tblAgenda.getColumnModel().getColumn(0).setMaxWidth(90);
            tblAgenda.getColumnModel().getColumn(1).setMinWidth(90);
            tblAgenda.getColumnModel().getColumn(1).setPreferredWidth(90);
            tblAgenda.getColumnModel().getColumn(1).setMaxWidth(90);
            tblAgenda.getColumnModel().getColumn(2).setMinWidth(200);
            tblAgenda.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblAgenda.getColumnModel().getColumn(2).setMaxWidth(200);
            tblAgenda.getColumnModel().getColumn(3).setMinWidth(90);
            tblAgenda.getColumnModel().getColumn(3).setPreferredWidth(90);
            tblAgenda.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        jLabel2.setFont(new java.awt.Font("Arial", 2, 12)); // NOI18N
        jLabel2.setText("Selecione Um Dentista");

        txtPesquisaDentista2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPesquisaDentista2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPesquisaDentista2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaDentista2ActionPerformed(evt);
            }
        });
        txtPesquisaDentista2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaDentista2KeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Pesquisar Dentista:");

        btnVoltar.setBackground(new java.awt.Color(102, 204, 255));
        btnVoltar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/voltar.png"))); // NOI18N
        btnVoltar.setText(" Voltar");
        btnVoltar.setActionCommand("Voltar");
        btnVoltar.setBorder(null);
        btnVoltar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnVoltarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVoltarMouseExited(evt);
            }
        });
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        btnAgendaGeral.setBackground(new java.awt.Color(129, 167, 255));
        btnAgendaGeral.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAgendaGeral.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendaGeral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/agendar.png"))); // NOI18N
        btnAgendaGeral.setText("Agenda Geral");
        btnAgendaGeral.setBorder(null);
        btnAgendaGeral.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgendaGeralMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgendaGeralMouseExited(evt);
            }
        });
        btnAgendaGeral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendaGeralActionPerformed(evt);
            }
        });

        btnAgendarConsulta.setBackground(new java.awt.Color(129, 167, 255));
        btnAgendarConsulta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAgendarConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/incluir.png"))); // NOI18N
        btnAgendarConsulta.setText("Agendar Consulta");
        btnAgendarConsulta.setBorder(null);
        btnAgendarConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgendarConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgendarConsultaMouseExited(evt);
            }
        });
        btnAgendarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarConsultaActionPerformed(evt);
            }
        });

        btnEditarConsulta.setBackground(new java.awt.Color(129, 167, 255));
        btnEditarConsulta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEditarConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/editar.png"))); // NOI18N
        btnEditarConsulta.setText("Editar Consulta");
        btnEditarConsulta.setBorder(null);
        btnEditarConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarConsultaMouseExited(evt);
            }
        });
        btnEditarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarConsultaActionPerformed(evt);
            }
        });

        btnZoom.setBackground(new java.awt.Color(129, 167, 255));
        btnZoom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnZoom.setForeground(new java.awt.Color(255, 255, 255));
        btnZoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/zoom.png"))); // NOI18N
        btnZoom.setText("Zoom");
        btnZoom.setBorder(null);
        btnZoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnZoomMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnZoomMouseExited(evt);
            }
        });
        btnZoom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZoomActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(129, 167, 255));
        jLabel6.setText("AGENDA ESPECÍFICA");

        jMenuBar1.setBackground(new java.awt.Color(129, 167, 255));
        jMenuBar1.setForeground(new java.awt.Color(129, 167, 255));
        jMenuBar1.setBorderPainted(false);
        jMenuBar1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jMenuBar1.setPreferredSize(new java.awt.Dimension(346, 60));

        jMenu5.setText("         ");
        jMenu5.setEnabled(false);
        jMenuBar1.add(jMenu5);

        jMenu1.setBorder(null);
        jMenu1.setForeground(new java.awt.Color(255, 255, 255));
        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/registrar.png"))); // NOI18N
        jMenu1.setText(" Registrar");
        jMenu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jmiPacientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiPacientes.setBackground(new java.awt.Color(129, 167, 255));
        jmiPacientes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiPacientes.setForeground(java.awt.Color.white);
        jmiPacientes.setText("Registrar Paciente");
        jmiPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPacientesActionPerformed(evt);
            }
        });
        jMenu1.add(jmiPacientes);

        jmiDentistas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiDentistas.setBackground(new java.awt.Color(129, 167, 255));
        jmiDentistas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiDentistas.setForeground(java.awt.Color.white);
        jmiDentistas.setText("Registrar Dentista");
        jmiDentistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiDentistasActionPerformed(evt);
            }
        });
        jMenu1.add(jmiDentistas);

        jmiRecepcionistas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiRecepcionistas.setBackground(new java.awt.Color(129, 167, 255));
        jmiRecepcionistas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiRecepcionistas.setForeground(java.awt.Color.white);
        jmiRecepcionistas.setText("Registrar Recepcionista");
        jmiRecepcionistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiRecepcionistasActionPerformed(evt);
            }
        });
        jMenu1.add(jmiRecepcionistas);

        jmiConsultas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiConsultas.setBackground(new java.awt.Color(129, 167, 255));
        jmiConsultas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiConsultas.setForeground(java.awt.Color.white);
        jmiConsultas.setText("Agendar Consulta");
        jmiConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiConsultasActionPerformed(evt);
            }
        });
        jMenu1.add(jmiConsultas);

        jSeparator1.setForeground(java.awt.Color.white);
        jMenu1.add(jSeparator1);

        jmiEstoque.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiEstoque.setBackground(new java.awt.Color(129, 167, 255));
        jmiEstoque.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiEstoque.setForeground(java.awt.Color.white);
        jmiEstoque.setText("Estoque");
        jmiEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiEstoqueActionPerformed(evt);
            }
        });
        jMenu1.add(jmiEstoque);

        jSeparator4.setForeground(java.awt.Color.white);
        jMenu1.add(jSeparator4);

        jmiSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_BACK_SPACE, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiSair.setBackground(new java.awt.Color(223, 107, 111));
        jmiSair.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiSair.setForeground(java.awt.Color.white);
        jmiSair.setText("Sair");
        jmiSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSairActionPerformed(evt);
            }
        });
        jMenu1.add(jmiSair);

        jMenuBar1.add(jMenu1);

        jMenu4.setText("         ");
        jMenu4.setEnabled(false);
        jMenuBar1.add(jMenu4);

        jMenu2.setForeground(new java.awt.Color(255, 255, 255));
        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/agendar.png"))); // NOI18N
        jMenu2.setText(" Agendas");
        jMenu2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setBackground(new java.awt.Color(129, 167, 255));
        jMenuItem1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem1.setForeground(java.awt.Color.white);
        jMenuItem1.setText("Consultas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem10.setBackground(new java.awt.Color(129, 167, 255));
        jMenuItem10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem10.setForeground(java.awt.Color.white);
        jMenuItem10.setText("Acessando consultas...");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        jMenu6.setText("         ");
        jMenu6.setEnabled(false);
        jMenuBar1.add(jMenu6);

        jMenu7.setForeground(new java.awt.Color(255, 255, 255));
        jMenu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/prontuario.png"))); // NOI18N
        jMenu7.setText(" Prontuários");
        jMenu7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jMenu7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu7MouseClicked(evt);
            }
        });
        jMenuBar1.add(jMenu7);

        jMenu8.setText("         ");
        jMenu8.setEnabled(false);
        jMenuBar1.add(jMenu8);

        jMenu3.setForeground(new java.awt.Color(255, 255, 255));
        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/ajuda.png"))); // NOI18N
        jMenu3.setText(" Ajuda");
        jMenu3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jMenu3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        jMenuItem8.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem8.setBackground(new java.awt.Color(129, 167, 255));
        jMenuItem8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem8.setForeground(java.awt.Color.white);
        jMenuItem8.setText("Ajuda");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_9, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem9.setBackground(new java.awt.Color(129, 167, 255));
        jMenuItem9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem9.setForeground(java.awt.Color.white);
        jMenuItem9.setText("Sobre");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem9);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnAgendarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnAgendaGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPesquisaDentista2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(1, 1, 1)
                        .addComponent(txtPesquisaDentista2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgendaGeral, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnAgendarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(btnEditarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 461, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(1262, 711));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblDentistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDentistaMouseClicked
        int item = tblDentista.getSelectionModel().getMinSelectionIndex();  //pega o menor valor selecionado na tabela
        item= (int) tblDentista.getModel().getValueAt(item, 0);
        carregaTabelaEspecifica(item);
    }//GEN-LAST:event_tblDentistaMouseClicked

    private void tblAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAgendaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblAgendaMouseClicked

    private void txtPesquisaDentista2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaDentista2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaDentista2ActionPerformed

    private void txtPesquisaDentista2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaDentista2KeyPressed
        //para pesquisar conforme o usuario digita uma letra
        String nome = txtPesquisaDentista2.getText()+ "%";

        DefaultTableModel modelo = (DefaultTableModel) tblDentista.getModel();
        modelo.setNumRows(0);
        try {
            Connection con = Conecta.getConexao();
            PreparedStatement pstm;
            ResultSet rs;
            pstm = con.prepareStatement("SELECT id, nome FROM dentista WHERE nome like ? ");
            pstm.setString(1, nome);
            rs = pstm.executeQuery();
            while (rs.next()) {  //enquanto existirem registros no banco, ele continuar
                modelo.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("nome")});
        }
        pstm.close();
        con.close();
        rs.close();
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_txtPesquisaDentista2KeyPressed

    private void btnAgendaGeralMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendaGeralMouseEntered
        btnAgendaGeral.setBackground(Color.white);
        btnAgendaGeral.setForeground(azulPadrao);
    }//GEN-LAST:event_btnAgendaGeralMouseEntered

    private void btnAgendaGeralMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendaGeralMouseExited
        btnAgendaGeral.setBackground(azulPadrao);
        btnAgendaGeral.setForeground(Color.white);
    }//GEN-LAST:event_btnAgendaGeralMouseExited

    private void btnAgendaGeralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendaGeralActionPerformed
        frmAgendaGeral frm = new frmAgendaGeral();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgendaGeralActionPerformed

    private void btnAgendarConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendarConsultaMouseEntered
        btnAgendarConsulta.setBackground(Color.white);
        btnAgendarConsulta.setForeground(azulPadrao);
    }//GEN-LAST:event_btnAgendarConsultaMouseEntered

    private void btnAgendarConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendarConsultaMouseExited
        btnAgendarConsulta.setBackground(azulPadrao);
        btnAgendarConsulta.setForeground(Color.white);
    }//GEN-LAST:event_btnAgendarConsultaMouseExited

    private void btnAgendarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarConsultaActionPerformed
        frmAgendarConsulta frm = new frmAgendarConsulta();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgendarConsultaActionPerformed

    private void btnEditarConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarConsultaMouseEntered
        btnEditarConsulta.setBackground(Color.white);
        btnEditarConsulta.setForeground(azulPadrao);
    }//GEN-LAST:event_btnEditarConsultaMouseEntered

    private void btnEditarConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarConsultaMouseExited
        btnEditarConsulta.setBackground(azulPadrao);
        btnEditarConsulta.setForeground(Color.white);
    }//GEN-LAST:event_btnEditarConsultaMouseExited

    private void btnEditarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarConsultaActionPerformed
       frmAgendarConsulta frm = new frmAgendarConsulta();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnEditarConsultaActionPerformed

    private void btnZoomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnZoomMouseEntered
        btnZoom.setBackground(Color.white);
        btnZoom.setForeground(azulPadrao);
    }//GEN-LAST:event_btnZoomMouseEntered

    private void btnZoomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnZoomMouseExited
        btnZoom.setBackground(azulPadrao);
        btnZoom.setForeground(Color.white);
    }//GEN-LAST:event_btnZoomMouseExited

    private void btnZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomActionPerformed
        if(btnZoom.getText().equals("Zoom")){
             btnZoom.setText("Restaurar");
             aplicarZoomBotoes();
        }else{
              btnZoom.setText("Zoom");
              aplicarFonteBotoesNormal();
              
        }
    }//GEN-LAST:event_btnZoomActionPerformed

    
    
     
    
    private void aplicarFonteBotoesNormal(){
         btnEditarConsulta.setFont(fonteNormalBotoes);
         btnEditarConsulta.setText("Editar Consulta");
         
        btnAgendarConsulta.setFont(fonteNormalBotoes);
        btnAgendarConsulta.setText("Agendar Consulta");
                
        btnAgendaGeral.setFont(fonteNormalBotoes);
        btnAgendaGeral.setText("Agenda Geral");
        
        btnZoom.setFont(fonteNormalBotoes);
        btnVoltar.setFont(fonteNormalBotoes); 
        
    
    }
    
    
    
 

    private void aplicarZoomBotoes() {
       btnEditarConsulta.setFont(fonteZoomBotoes);
       btnEditarConsulta.setText("Editar");
        btnAgendarConsulta.setFont(fonteZoomBotoes);
        btnAgendarConsulta.setText("Agendar");
        btnAgendaGeral.setFont(fonteZoomBotoes);
        btnAgendaGeral.setText("Geral");
        btnZoom.setFont(fonteZoomBotoes);
        
        btnVoltar.setFont(fonteZoomBotoes);  
    }
    
    
    private void jmiPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPacientesActionPerformed

        frmPaciente frm = new frmPaciente();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        this.dispose();

    }//GEN-LAST:event_jmiPacientesActionPerformed

    private void jmiDentistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDentistasActionPerformed
        frmDentista frm = new frmDentista();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jmiDentistasActionPerformed

    private void jmiRecepcionistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRecepcionistasActionPerformed

        frmRecepcionista frm = new frmRecepcionista();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jmiRecepcionistasActionPerformed

    private void jmiConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsultasActionPerformed

        frmAgendarConsulta frm = new frmAgendarConsulta();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jmiConsultasActionPerformed

    private void jmiEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEstoqueActionPerformed

        frmEstoqueGeral frm = new frmEstoqueGeral();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jmiEstoqueActionPerformed

    private void jmiSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiSairActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        frmAgendaGeral frm = new frmAgendaGeral();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
      
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jMenu7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu7MouseClicked
        frmProntuario frm = new frmProntuario();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jMenu7MouseClicked

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        frmAjuda frm = new frmAjuda();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        frmSobre frm = new frmSobre();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();

    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnVoltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseExited
        btnVoltar.setBackground(azulClaroo);
        btnVoltar.setForeground(Color.white);
    }//GEN-LAST:event_btnVoltarMouseExited

    private void btnVoltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseEntered
        btnVoltar.setBackground(Color.white);
        btnVoltar.setForeground(azulPadrao);
    }//GEN-LAST:event_btnVoltarMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmAgendaEspecifica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgendaEspecifica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgendaEspecifica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgendaEspecifica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAgendaEspecifica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgendaGeral;
    private javax.swing.JButton btnAgendarConsulta;
    private javax.swing.JButton btnEditarConsulta;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnZoom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    public javax.swing.JMenuItem jmiConsultas;
    public javax.swing.JMenuItem jmiDentistas;
    private javax.swing.JMenuItem jmiEstoque;
    public javax.swing.JMenuItem jmiPacientes;
    public javax.swing.JMenuItem jmiRecepcionistas;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JTable tblAgenda;
    private javax.swing.JTable tblDentista;
    private javax.swing.JTextField txtPesquisaDentista2;
    // End of variables declaration//GEN-END:variables
}
