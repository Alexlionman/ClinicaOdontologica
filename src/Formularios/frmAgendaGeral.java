package Formularios;

import Classes.Conecta;
import Classes.Consulta;
import Classes.ConsultaDAO;
import Classes.Utilidades;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class frmAgendaGeral extends javax.swing.JFrame {
    Color azulClaro = new Color(226, 235, 255);
    Color azulPadrao = new Color(129,167,255);
    Color azulFundo = new Color(226, 235, 255);
    Color vermelhoPadrao = new Color(255,153,153);
    Color azulClaroo = new Color (139, 215, 255);
    Color azulHover = new Color(192, 216, 235);
    Color vermelhoHover = new Color(242, 198, 196);
    Color vermelhoPadraoExcluir = new Color(223,107,111);
    
      //fonte para o zoom
    public Font fonteZoomTexto = new Font("Arial", Font.BOLD, 18);
    public Font fonteNormal = new Font("Arial", Font.BOLD, 14);
    
    public Font fonteZoomBotoes = new Font("Arial", Font.BOLD, 18);
    public Font fonteNormalBotoes = new Font("Arial", Font.BOLD, 14);
    
    
    private void habilitaCampos(){
    txtDataConsulta.setEnabled(true);
    txtHorarioConsulta.setEnabled(true);
    txtValorConsulta.setEnabled(true);
    }
    
    private void desabilitaCampos(){
     txtDataConsulta.setEnabled(false);
    txtHorarioConsulta.setEnabled(false);
    txtValorConsulta.setEnabled(false);
    
    }
    
    private void desabilitaBotoes(){
        btnEditarConsulta.setEnabled(false);
        btnExcluirConsulta.setEnabled(false);
        btnSalvarEdicaoConsulta.setEnabled(false);
    }
    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tblAgenda.getModel();
        modelo.setNumRows(0);
        try {
            Connection con = Conecta.getConexao();
            PreparedStatement pstm;
            ResultSet rs;
            pstm = con.prepareStatement("SELECT C.id, C.dataConsulta,C.hora,P.nome,D.nome,valor FROM consulta C, dentista D,paciente P "
                                       +"WHERE C.pacienteId = P.id AND C.dentistaId = D.id ORDER BY dataConsulta,hora");
            rs = pstm.executeQuery();
            while (rs.next()) {  //enquanto existirem registros no banco, ele continuar
                modelo.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("dataConsulta"),
                    rs.getString("hora"),
                    rs.getString("D.nome"),
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

    public frmAgendaGeral() {
        initComponents();
        carregaTabela();
        this.setExtendedState(MAXIMIZED_BOTH);
        getContentPane().setBackground(azulFundo);
        getContentPane().setBackground(azulClaro);
        //mudar a cor do cabeçalho da tabela
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(azulPadrao);
        headerRenderer.setForeground(Color.WHITE);
        for (int i = 0; i < tblAgenda.getModel().getColumnCount(); i++) {
            tblAgenda.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }
    
       private static void criarMensagemSucesso(){
        frmImagemSucesso form = new frmImagemSucesso();
        form.setVisible(true);
         form.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAgenda = new javax.swing.JTable();
        txtPesquisaDentista2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        btnNovaConsulta2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtDataConsulta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtHorarioConsulta = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtValorConsulta = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtNomeDentista = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtIdConsulta = new javax.swing.JLabel();
        btnEditarConsulta = new javax.swing.JButton();
        btnSalvarEdicaoConsulta = new javax.swing.JButton();
        txtNomePaciente = new javax.swing.JTextField();
        btnExcluirConsulta = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnZoom = new javax.swing.JButton();
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

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 153, 255));
        jLabel1.setText("AGENDA GERAL");

        tblAgenda.setBorder(new javax.swing.border.MatteBorder(null));
        tblAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data ", "Horário", "Dentista", "Paciente", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAgendaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAgenda);
        if (tblAgenda.getColumnModel().getColumnCount() > 0) {
            tblAgenda.getColumnModel().getColumn(0).setMinWidth(40);
            tblAgenda.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblAgenda.getColumnModel().getColumn(0).setMaxWidth(40);
            tblAgenda.getColumnModel().getColumn(1).setMinWidth(80);
            tblAgenda.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblAgenda.getColumnModel().getColumn(1).setMaxWidth(80);
            tblAgenda.getColumnModel().getColumn(2).setMinWidth(80);
            tblAgenda.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblAgenda.getColumnModel().getColumn(2).setMaxWidth(80);
            tblAgenda.getColumnModel().getColumn(3).setMinWidth(160);
            tblAgenda.getColumnModel().getColumn(3).setPreferredWidth(160);
            tblAgenda.getColumnModel().getColumn(3).setMaxWidth(160);
            tblAgenda.getColumnModel().getColumn(4).setMinWidth(160);
            tblAgenda.getColumnModel().getColumn(4).setPreferredWidth(160);
            tblAgenda.getColumnModel().getColumn(4).setMaxWidth(160);
            tblAgenda.getColumnModel().getColumn(5).setMinWidth(90);
            tblAgenda.getColumnModel().getColumn(5).setPreferredWidth(90);
            tblAgenda.getColumnModel().getColumn(5).setMaxWidth(90);
        }

        txtPesquisaDentista2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
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

        btnNovaConsulta2.setBackground(new java.awt.Color(129, 167, 255));
        btnNovaConsulta2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNovaConsulta2.setForeground(new java.awt.Color(255, 255, 255));
        btnNovaConsulta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/agendar.png"))); // NOI18N
        btnNovaConsulta2.setText("Agendar Consulta");
        btnNovaConsulta2.setBorder(null);
        btnNovaConsulta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNovaConsulta2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNovaConsulta2MouseExited(evt);
            }
        });
        btnNovaConsulta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaConsulta2ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta Selecionada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("ID:");

        txtDataConsulta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtDataConsulta.setEnabled(false);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Data agendada:");

        txtHorarioConsulta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtHorarioConsulta.setEnabled(false);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Horário:");

        txtValorConsulta.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtValorConsulta.setForeground(new java.awt.Color(0, 153, 255));
        txtValorConsulta.setEnabled(false);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel11.setText("VALOR:");

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Nome do dentista:");
        jLabel12.setEnabled(false);

        txtNomeDentista.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNomeDentista.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Nome do paciente:");
        jLabel13.setEnabled(false);

        txtIdConsulta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtIdConsulta.setForeground(new java.awt.Color(0, 153, 204));

        btnEditarConsulta.setBackground(new java.awt.Color(129, 167, 255));
        btnEditarConsulta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEditarConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/editar.png"))); // NOI18N
        btnEditarConsulta.setText("Editar consulta");
        btnEditarConsulta.setBorder(null);
        btnEditarConsulta.setEnabled(false);
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

        btnSalvarEdicaoConsulta.setBackground(new java.awt.Color(129, 167, 255));
        btnSalvarEdicaoConsulta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSalvarEdicaoConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvarEdicaoConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/salvar.png"))); // NOI18N
        btnSalvarEdicaoConsulta.setText("Salvar Edição");
        btnSalvarEdicaoConsulta.setBorder(null);
        btnSalvarEdicaoConsulta.setEnabled(false);
        btnSalvarEdicaoConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalvarEdicaoConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalvarEdicaoConsultaMouseExited(evt);
            }
        });
        btnSalvarEdicaoConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarEdicaoConsultaActionPerformed(evt);
            }
        });

        txtNomePaciente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNomePaciente.setEnabled(false);

        btnExcluirConsulta.setBackground(new java.awt.Color(223, 107, 111));
        btnExcluirConsulta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnExcluirConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluirConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/excluir.png"))); // NOI18N
        btnExcluirConsulta.setText("Excluir consulta");
        btnExcluirConsulta.setBorder(null);
        btnExcluirConsulta.setEnabled(false);
        btnExcluirConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExcluirConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExcluirConsultaMouseExited(evt);
            }
        });
        btnExcluirConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirConsultaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtIdConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                        .addComponent(txtDataConsulta))
                                    .addGap(40, 40, 40)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtHorarioConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)))
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNomeDentista)))
                        .addGap(313, 313, 313))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtValorConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnExcluirConsulta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSalvarEdicaoConsulta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEditarConsulta, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtDataConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(txtHorarioConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNomeDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtValorConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSalvarEdicaoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluirConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        btnVoltar.setBackground(new java.awt.Color(102, 204, 255));
        btnVoltar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnVoltar.setForeground(new java.awt.Color(255, 255, 255));
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/voltar.png"))); // NOI18N
        btnVoltar.setText("voltar");
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

        btnZoom.setBackground(new java.awt.Color(129, 167, 255));
        btnZoom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
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

        jMenuItem1.setBackground(new java.awt.Color(129, 167, 255));
        jMenuItem1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem1.setForeground(java.awt.Color.white);
        jMenuItem1.setText("Acessando consultas...");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem10.setBackground(new java.awt.Color(129, 167, 255));
        jMenuItem10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem10.setForeground(java.awt.Color.white);
        jMenuItem10.setText("Consultas por dentista");
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
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisaDentista2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(504, 504, 504)
                                .addComponent(btnZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnNovaConsulta2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(jLabel5)
                .addGap(3, 3, 3)
                .addComponent(txtPesquisaDentista2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(btnNovaConsulta2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        setSize(new java.awt.Dimension(1210, 730));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirConsultaActionPerformed
        int item = tblAgenda.getSelectionModel().getMinSelectionIndex();  //pega a linha selecionada
        item = (int) tblAgenda.getModel().getValueAt(item, 0); //essa coluna se refere ao ID na tabela
        String resp  = new ConsultaDAO().excluirConsulta(item);
                    if (resp.equals("OK")) {
                        Utilidades.criarMensagemSucesso();
                        carregaTabela();
                        desabilitaCampos();
                        desabilitaBotoes();
                        
                    } else {
                        Utilidades.criarMensagemErro();
                        carregaTabela();
                        desabilitaCampos();
                        desabilitaBotoes();
                    }
        
    }//GEN-LAST:event_btnExcluirConsultaActionPerformed

    private void tblAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAgendaMouseClicked
        btnEditarConsulta.setEnabled(true);
        btnExcluirConsulta.setEnabled(true);
        int item = tblAgenda.getSelectionModel().getMinSelectionIndex();  //pega a linha selecionada
        String itemString = (String) tblAgenda.getModel().getValueAt(item, 0).toString();
        

        DefaultTableModel modelo = (DefaultTableModel) tblAgenda.getModel();
        modelo.setNumRows(0);
        try {
            Connection con = Conecta.getConexao();
            Statement stmt=con.createStatement();
            
            String sql = "SELECT C.id, C.dataConsulta, C.hora,P.nome,D.nome,C.valor FROM consulta C, dentista D,paciente P  WHERE C.id = "+ itemString+" AND C.dentistaId=D.id AND C.pacienteId=P.id";
            stmt.execute(sql);
            ResultSet rs = stmt.getResultSet();
          
            while(rs.next()){
            txtIdConsulta.setText(rs.getString("id"));
            txtDataConsulta.setText(rs.getString("dataConsulta"));
            txtNomeDentista.setText(rs.getString("D.nome"));
            txtNomePaciente.setText(rs.getString("P.nome"));
            txtHorarioConsulta.setText(rs.getString("hora"));
            txtValorConsulta.setText(rs.getString("valor"));
            }
            
             rs.close();
            stmt.close();
            con.close();
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        }
        carregaTabela();
    
                                               
    }//GEN-LAST:event_tblAgendaMouseClicked

    private void txtPesquisaDentista2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaDentista2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaDentista2ActionPerformed

    private void txtPesquisaDentista2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaDentista2KeyPressed
        //para pesquisar conforme o usuario digita uma letra
        String nome = "%" +txtPesquisaDentista2.getText()+ "%";

        DefaultTableModel modelo = (DefaultTableModel) tblAgenda.getModel();
        modelo.setNumRows(0);
        try {
            Connection con = Conecta.getConexao();
            PreparedStatement pstm;
            ResultSet rs;
            pstm = con.prepareStatement("SELECT dataConsulta,hora,P.nome,D.nome,valor FROM consulta C, dentista D,paciente P "
                                       +"WHERE D.nome like ? ORDER BY dataConsulta,hora");
            pstm.setString(1, nome);
            rs = pstm.executeQuery();
            while (rs.next()) {  //enquanto existirem registros no banco, ele continuar
                modelo.addRow(new Object[]{
                    rs.getString("dataConsulta"),
                    rs.getString("hora"),
                    rs.getString("D.nome"),
                    rs.getString("P.nome"),
                    rs.getFloat("valor")});
            }
            pstm.close();
            con.close();
            rs.close();
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    
    }//GEN-LAST:event_txtPesquisaDentista2KeyPressed

    private void btnSalvarEdicaoConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarEdicaoConsultaActionPerformed
        Consulta consulta=new Consulta(Integer.parseInt(txtIdConsulta.getText()),txtDataConsulta.getText(), txtHorarioConsulta.getText(), Float.parseFloat(txtValorConsulta.getText()));
        String resp = new ConsultaDAO().editarConsulta(consulta);
                    if (resp.equals("OK")) {
                        Utilidades.criarMensagemSucesso();
                        carregaTabela();
                        desabilitaCampos();
                        
                    } else {
                        Utilidades.criarMensagemErro();
                        carregaTabela();
                        desabilitaCampos();
                    }
    }//GEN-LAST:event_btnSalvarEdicaoConsultaActionPerformed

    private void btnNovaConsulta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaConsulta2ActionPerformed
        frmAgendarConsulta frame = new frmAgendarConsulta();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNovaConsulta2ActionPerformed

    private void btnEditarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarConsultaActionPerformed
        btnSalvarEdicaoConsulta.setEnabled(true);
        habilitaCampos();
    }//GEN-LAST:event_btnEditarConsultaActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
        
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnZoomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZoomActionPerformed
            if(btnZoom.getText().equals("Zoom")){
             btnZoom.setText("Restaurar");
             aplicarZoomBotoes();
             aplicarZoomTexto();
        }else{
              btnZoom.setText("Zoom");
              aplicarFonteNormal();
              aplicarFonteBotoesNormal();
              
        }
    }//GEN-LAST:event_btnZoomActionPerformed

      private void aplicarFonteNormal() {
        txtDataConsulta.setFont(fonteNormal);
        txtHorarioConsulta.setFont(fonteNormal);
        txtNomeDentista.setFont(fonteNormal);
        txtNomePaciente.setFont(fonteNormal);
    }
    
    private void aplicarFonteBotoesNormal(){
         btnEditarConsulta.setFont(fonteNormalBotoes);
        btnSalvarEdicaoConsulta.setFont(fonteNormalBotoes);
        btnExcluirConsulta.setFont(fonteNormalBotoes);
        btnZoom.setFont(fonteNormalBotoes);
        btnVoltar.setFont(fonteNormalBotoes); 
        
    
    }
    
    
    
    private void aplicarZoomTexto() {
       txtDataConsulta.setFont(fonteZoomTexto);
        txtHorarioConsulta.setFont(fonteZoomTexto);
        txtNomeDentista.setFont(fonteZoomTexto);
        txtNomePaciente.setFont(fonteZoomTexto);

    }

    private void aplicarZoomBotoes() {
         btnEditarConsulta.setFont(fonteZoomBotoes);
        btnSalvarEdicaoConsulta.setFont(fonteZoomBotoes);
        btnExcluirConsulta.setFont(fonteZoomBotoes);
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
   
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        frmAgendaEspecifica frm = new frmAgendaEspecifica();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        this.dispose();
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

    private void btnEditarConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarConsultaMouseEntered
        btnEditarConsulta.setBackground(Color.white);
       btnEditarConsulta.setForeground(azulPadrao);
    }//GEN-LAST:event_btnEditarConsultaMouseEntered

    private void btnEditarConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarConsultaMouseExited
        btnEditarConsulta.setBackground(azulPadrao);
        btnEditarConsulta.setForeground(Color.white);
    }//GEN-LAST:event_btnEditarConsultaMouseExited

    private void btnSalvarEdicaoConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarEdicaoConsultaMouseEntered
        btnSalvarEdicaoConsulta.setBackground(Color.white);
       btnSalvarEdicaoConsulta.setForeground(azulPadrao);
    }//GEN-LAST:event_btnSalvarEdicaoConsultaMouseEntered

    private void btnSalvarEdicaoConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarEdicaoConsultaMouseExited
        btnSalvarEdicaoConsulta.setBackground(azulPadrao);
        btnSalvarEdicaoConsulta.setForeground(Color.white);
    }//GEN-LAST:event_btnSalvarEdicaoConsultaMouseExited

    private void btnNovaConsulta2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovaConsulta2MouseEntered
        btnNovaConsulta2.setBackground(Color.white);
       btnNovaConsulta2.setForeground(azulPadrao);
    }//GEN-LAST:event_btnNovaConsulta2MouseEntered

    private void btnNovaConsulta2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovaConsulta2MouseExited
        btnNovaConsulta2.setBackground(azulPadrao);
        btnNovaConsulta2.setForeground(Color.white);
    }//GEN-LAST:event_btnNovaConsulta2MouseExited

    private void btnExcluirConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirConsultaMouseEntered
        btnExcluirConsulta.setBackground(vermelhoHover);
       btnExcluirConsulta.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnExcluirConsultaMouseEntered

    private void btnExcluirConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirConsultaMouseExited
         btnExcluirConsulta.setBackground(vermelhoPadraoExcluir);
        btnExcluirConsulta.setForeground(Color.white);
    }//GEN-LAST:event_btnExcluirConsultaMouseExited

    private void btnZoomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnZoomMouseEntered
         btnZoom.setBackground(vermelhoHover);
       btnZoom.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnZoomMouseEntered

    private void btnZoomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnZoomMouseExited
        btnZoom.setBackground(vermelhoPadraoExcluir);
        btnZoom.setForeground(Color.white);
    }//GEN-LAST:event_btnZoomMouseExited

    private void btnVoltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseEntered
         btnVoltar.setBackground(Color.white);
       btnVoltar.setForeground(azulPadrao);
    }//GEN-LAST:event_btnVoltarMouseEntered

    private void btnVoltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseExited
         btnVoltar.setBackground(azulClaroo);
        btnVoltar.setForeground(Color.white);
    }//GEN-LAST:event_btnVoltarMouseExited

    
 
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
            java.util.logging.Logger.getLogger(frmAgendaGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAgendaGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAgendaGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAgendaGeral.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAgendaGeral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarConsulta;
    private javax.swing.JButton btnExcluirConsulta;
    private javax.swing.JButton btnNovaConsulta2;
    private javax.swing.JButton btnSalvarEdicaoConsulta;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnZoom;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    public javax.swing.JMenuItem jmiConsultas;
    public javax.swing.JMenuItem jmiDentistas;
    private javax.swing.JMenuItem jmiEstoque;
    public javax.swing.JMenuItem jmiPacientes;
    public javax.swing.JMenuItem jmiRecepcionistas;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JTable tblAgenda;
    private javax.swing.JTextField txtDataConsulta;
    private javax.swing.JTextField txtHorarioConsulta;
    private javax.swing.JLabel txtIdConsulta;
    private javax.swing.JTextField txtNomeDentista;
    private javax.swing.JTextField txtNomePaciente;
    private javax.swing.JTextField txtPesquisaDentista2;
    private javax.swing.JTextField txtValorConsulta;
    // End of variables declaration//GEN-END:variables
}
