/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Classes.Conecta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmAgendaEspecifica extends javax.swing.JFrame {

    private void carregaTabela() {
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
        carregaTabela();
    }

    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblDentista = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblAgenda = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

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
                "ID", "Nome"
            }
        ));
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

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 100, 460, 120);

        jLabel1.setText("Selecione o(a) dentista para exibir seus agendamentos:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 80, 290, 14);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Agenda especifica por dentista");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(120, 20, 210, 17);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/btnSairPequeno.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair);
        btnSair.setBounds(350, 10, 130, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Procedimentos agendados para esse(a) dentista");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 250, 295, 15);

        tblAgenda.setBorder(new javax.swing.border.MatteBorder(null));
        tblAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
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
        tblAgenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAgendaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblAgenda);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 270, 470, 140);

        setSize(new java.awt.Dimension(517, 457));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblDentistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDentistaMouseClicked
        int item = tblDentista.getSelectionModel().getMinSelectionIndex();  //pega o menor valor selecionado na tabela
        item= (int) tblDentista.getModel().getValueAt(item, 0);
        carregaTabelaEspecifica(item);
    }//GEN-LAST:event_tblDentistaMouseClicked

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void tblAgendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAgendaMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblAgendaMouseClicked

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
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblAgenda;
    private javax.swing.JTable tblDentista;
    // End of variables declaration//GEN-END:variables
}
