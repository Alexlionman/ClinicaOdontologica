package Formularios;

import Classes.Conecta;
import Classes.Consulta;
import Classes.ConsultaDAO;
import Classes.Dentista;
import Classes.DentistaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmAgendaGeral extends javax.swing.JFrame {
    
    
    
    
    private void habilitaCampos(){
    txtDataConsulta.setEnabled(true);
    txtHorarioConsulta.setEnabled(true);
    txtValorConsulta.setEnabled(true);
    }

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tblAgenda.getModel();
        modelo.setNumRows(0);
        try {
            Connection con = Conecta.getConexao();
            PreparedStatement pstm;
            ResultSet rs;
            pstm = con.prepareStatement("SELECT id,dataConsulta,hora,P.nome,D.nome,valor FROM consulta C, dentista D,paciente P "
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
        txtNomePaciente = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txtNomeDentista = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtIdConsulta = new javax.swing.JLabel();
        btnSalvarEdicaoConsulta = new javax.swing.JButton();
        btnExcluirConsulta1 = new javax.swing.JButton();
        btnExcluirConsulta = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 153, 255));
        jLabel1.setText("AGENDA GERAL");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 37, 240, 40);

        tblAgenda.setBorder(new javax.swing.border.MatteBorder(null));
        tblAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Data ", "Horário", "Dentista", "Paciente", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
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
            tblAgenda.getColumnModel().getColumn(0).setMinWidth(75);
            tblAgenda.getColumnModel().getColumn(0).setPreferredWidth(75);
            tblAgenda.getColumnModel().getColumn(0).setMaxWidth(75);
            tblAgenda.getColumnModel().getColumn(1).setMinWidth(55);
            tblAgenda.getColumnModel().getColumn(1).setPreferredWidth(55);
            tblAgenda.getColumnModel().getColumn(1).setMaxWidth(55);
            tblAgenda.getColumnModel().getColumn(2).setMinWidth(170);
            tblAgenda.getColumnModel().getColumn(2).setPreferredWidth(170);
            tblAgenda.getColumnModel().getColumn(2).setMaxWidth(170);
            tblAgenda.getColumnModel().getColumn(4).setMinWidth(50);
            tblAgenda.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblAgenda.getColumnModel().getColumn(4).setMaxWidth(50);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(50, 160, 790, 380);

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
        getContentPane().add(txtPesquisaDentista2);
        txtPesquisaDentista2.setBounds(80, 110, 480, 20);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Pesquisar Dentista:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(80, 90, 150, 17);

        btnNovaConsulta2.setBackground(new java.awt.Color(88, 138, 255));
        btnNovaConsulta2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNovaConsulta2.setForeground(new java.awt.Color(255, 255, 255));
        btnNovaConsulta2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/agendar.png"))); // NOI18N
        btnNovaConsulta2.setText("Agendar Consulta");
        btnNovaConsulta2.setBorder(null);
        btnNovaConsulta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaConsulta2ActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovaConsulta2);
        btnNovaConsulta2.setBounds(910, 260, 170, 60);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Consulta Selecionada", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Id Consulta:");

        txtDataConsulta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Data agendada:");

        txtHorarioConsulta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Horário:");

        txtValorConsulta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Valor:");

        txtNomePaciente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNomePaciente.setEnabled(false);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Nome do paciente:");
        jLabel12.setEnabled(false);

        txtNomeDentista.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNomeDentista.setEnabled(false);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Nome do dentista:");
        jLabel13.setEnabled(false);

        txtIdConsulta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtIdConsulta.setForeground(new java.awt.Color(0, 153, 204));

        btnSalvarEdicaoConsulta.setBackground(new java.awt.Color(88, 138, 255));
        btnSalvarEdicaoConsulta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSalvarEdicaoConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvarEdicaoConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/salvar.png"))); // NOI18N
        btnSalvarEdicaoConsulta.setText("Salvar Edição");
        btnSalvarEdicaoConsulta.setBorder(null);
        btnSalvarEdicaoConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarEdicaoConsultaActionPerformed(evt);
            }
        });

        btnExcluirConsulta1.setBackground(new java.awt.Color(88, 138, 255));
        btnExcluirConsulta1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnExcluirConsulta1.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluirConsulta1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/editar.png"))); // NOI18N
        btnExcluirConsulta1.setText("Editar");
        btnExcluirConsulta1.setBorder(null);
        btnExcluirConsulta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirConsulta1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(txtIdConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDataConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(txtNomeDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtHorarioConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnSalvarEdicaoConsulta, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnExcluirConsulta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtHorarioConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtValorConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                        .addComponent(txtIdConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(txtDataConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNomeDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNomePaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnExcluirConsulta1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvarEdicaoConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addGap(19, 19, 19))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(50, 550, 800, 150);

        btnExcluirConsulta.setBackground(new java.awt.Color(255, 102, 102));
        btnExcluirConsulta.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnExcluirConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluirConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/excluir.png"))); // NOI18N
        btnExcluirConsulta.setText("Excluir consulta");
        btnExcluirConsulta.setBorder(null);
        btnExcluirConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirConsultaActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluirConsulta);
        btnExcluirConsulta.setBounds(910, 340, 170, 50);

        setSize(new java.awt.Dimension(1226, 754));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirConsultaActionPerformed
        int item = tblAgenda.getSelectionModel().getMinSelectionIndex();  //pega a linha selecionada
        item = (int) tblAgenda.getModel().getValueAt(item, 0);
        String c  = new ConsultaDAO().excluirConsulta(item);
        
    }//GEN-LAST:event_btnExcluirConsultaActionPerformed

    private void tblAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAgendaMouseClicked
         int item = tblAgenda.getSelectionModel().getMinSelectionIndex();  //pega a linha selecionada
        String itemString = (String) tblAgenda.getModel().getValueAt(item, 0).toString();
        

        DefaultTableModel modelo = (DefaultTableModel) tblAgenda.getModel();
        modelo.setNumRows(0);
        try {
            Connection con = Conecta.getConexao();
            PreparedStatement pstm;
            ResultSet rs;
            pstm = con.prepareStatement("SELECT id, dataConsulta,hora,P.nome,D.nome,valor FROM consulta C, dentista D,paciente P "
                                       +"WHERE C.id = ? ");
            pstm.setString(1, itemString);
            rs = pstm.executeQuery();
            
            txtIdConsulta.setText(rs.getString("id"));
            txtDataConsulta.setText(rs.getString("dataConsulta"));
            txtNomeDentista.setText(rs.getString("D.nome"));
            txtNomePaciente.setText(rs.getString("P.nome"));
            txtHorarioConsulta.setText(rs.getString("hora"));
            txtValorConsulta.setText(rs.getString("valor"));
            
            pstm.close();
            con.close();
            rs.close();
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    
                                               
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
                        JOptionPane.showMessageDialog(null, "Consulta Alterada com sucesso.");
                    } else {
                        JOptionPane.showMessageDialog(null, resp);
                    }
    }//GEN-LAST:event_btnSalvarEdicaoConsultaActionPerformed

    private void btnNovaConsulta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaConsulta2ActionPerformed
        frmAdicionarConsulta frame = new frmAdicionarConsulta();
        frame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnNovaConsulta2ActionPerformed

    private void btnExcluirConsulta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirConsulta1ActionPerformed
        habilitaCampos();
    }//GEN-LAST:event_btnExcluirConsulta1ActionPerformed

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
    private javax.swing.JButton btnExcluirConsulta;
    private javax.swing.JButton btnExcluirConsulta1;
    private javax.swing.JButton btnNovaConsulta2;
    private javax.swing.JButton btnSalvarEdicaoConsulta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
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
