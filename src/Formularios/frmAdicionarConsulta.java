package Formularios;

import Classes.Conecta;
import Classes.Consulta;
import Classes.ConsultaDAO;
import Classes.DentistaDAO;
import Classes.Recepcionista;
import Classes.RecepcionistaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmAdicionarConsulta extends javax.swing.JFrame {

    private void limparCampos() {
        txtData.setText("");
        txtValor.setText("");
        jcbHora.setSelectedIndex(0);
        tblDentista.clearSelection();
        tblPaciente.clearSelection();
    }

    private boolean verificaPreenchimento() {
        if (txtData.getText().equals("  /  /    ") || txtValor.getText().equals("   .  ") || jcbHora.getSelectedIndex() == 0
                || tblDentista.getSelectedRow() == -1 || tblPaciente.getSelectedRow() == -1) {
            return false;
        }
        return true;
    }

    private void carregaTabelaPaciente() {
        DefaultTableModel modelo = (DefaultTableModel) tblPaciente.getModel();
        modelo.setNumRows(0);
        try {
            java.sql.Connection con = Conecta.getConexao();
            PreparedStatement pstm;
            ResultSet rs;
            pstm = con.prepareStatement("SELECT id,nome FROM paciente ORDER BY id");
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

    private void carregaTabelaDentista() {
        DefaultTableModel modelo = (DefaultTableModel) tblDentista.getModel();
        modelo.setNumRows(0);
        try {
            java.sql.Connection con = Conecta.getConexao();
            PreparedStatement pstm;
            ResultSet rs;
            pstm = con.prepareStatement("SELECT id,nome FROM dentista ORDER BY id");
            rs = pstm.executeQuery();
            while (rs.next()) {
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

    public frmAdicionarConsulta() {
        initComponents();
        carregaTabelaPaciente();
        carregaTabelaDentista();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnAgendar = new javax.swing.JToggleButton();
        btnSair = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDentista = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPaciente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnListaConsultas = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        jcbHora = new javax.swing.JComboBox<>();
        txtValor = new javax.swing.JFormattedTextField();
        btnLimparCampos = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel5.setText("Data:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 240, 40, 14);

        jLabel6.setText("Hora:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(170, 240, 40, 14);

        jLabel7.setText("Valor da consulta:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(310, 240, 86, 14);

        btnAgendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/iconSalvar.png"))); // NOI18N
        btnAgendar.setText("Agendar Consulta");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgendar);
        btnAgendar.setBounds(530, 120, 170, 40);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/btnSairPequeno.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair);
        btnSair.setBounds(540, 10, 150, 40);

        tblDentista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Dentista"
            }
        ));
        jScrollPane1.setViewportView(tblDentista);
        if (tblDentista.getColumnModel().getColumnCount() > 0) {
            tblDentista.getColumnModel().getColumn(0).setMinWidth(40);
            tblDentista.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblDentista.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 90, 240, 120);

        tblPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id", "Paciente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblPaciente);
        if (tblPaciente.getColumnModel().getColumnCount() > 0) {
            tblPaciente.getColumnModel().getColumn(0).setMinWidth(40);
            tblPaciente.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblPaciente.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(280, 90, 240, 120);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Agendamentos de Consultas");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 10, 250, 20);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Selecionar Paciente");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(280, 60, 132, 17);

        btnListaConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/iconAgenda.png"))); // NOI18N
        btnListaConsultas.setText("Lista de Consultas");
        btnListaConsultas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaConsultasActionPerformed(evt);
            }
        });
        getContentPane().add(btnListaConsultas);
        btnListaConsultas.setBounds(530, 220, 170, 40);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Selecionar Dentista");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 60, 131, 17);

        txtData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtData);
        txtData.setBounds(50, 240, 90, 20);

        jcbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "09:00", "09:45", "10:30", "11:15", "13:00", "13:45", "14:30", "15:15", "16:00", "16:45", "17:30" }));
        jcbHora.setBorder(null);
        getContentPane().add(jcbHora);
        jcbHora.setBounds(210, 240, 70, 20);

        txtValor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtValor);
        txtValor.setBounds(400, 240, 70, 20);

        btnLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/iconLimpar.png"))); // NOI18N
        btnLimparCampos.setText("Limpar Campos    ");
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimparCampos);
        btnLimparCampos.setBounds(530, 170, 170, 40);

        setSize(new java.awt.Dimension(723, 315));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgendarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarActionPerformed
        if (verificaPreenchimento()) {
            int itemD = tblDentista.getSelectionModel().getMinSelectionIndex();  //pega a linha selecionada
            int itemP = tblPaciente.getSelectionModel().getMinSelectionIndex();  //pega a linha selecionada
            Consulta consulta = new Consulta(txtData.getText(), jcbHora.getSelectedItem().toString(),
                    Integer.parseInt(tblPaciente.getModel().getValueAt(itemP, 0).toString()),
                    Integer.parseInt(tblDentista.getModel().getValueAt(itemD, 0).toString()),
                    Float.parseFloat(txtValor.getText()));
            String resp = new ConsultaDAO().gravarConsulta(consulta);
            if (resp.equals("OK")) {
                JOptionPane.showMessageDialog(rootPane, "Consulta agendada com sucesso");
            } else {
                JOptionPane.showMessageDialog(rootPane, resp);
            }
            limparCampos();
        }
    }//GEN-LAST:event_btnAgendarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnListaConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaConsultasActionPerformed
        frmAgendaGeral frm = new frmAgendaGeral();
        frm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnListaConsultasActionPerformed

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmAdicionarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAdicionarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAdicionarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAdicionarConsulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAdicionarConsulta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnAgendar;
    private javax.swing.JToggleButton btnLimparCampos;
    private javax.swing.JButton btnListaConsultas;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbHora;
    private javax.swing.JTable tblDentista;
    private javax.swing.JTable tblPaciente;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JFormattedTextField txtData1;
    private javax.swing.JFormattedTextField txtData2;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
