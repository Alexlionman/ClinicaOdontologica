package Formularios;

import Classes.Conecta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmAgendaGeral extends javax.swing.JFrame {

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tblAgenda.getModel();
        modelo.setNumRows(0);
        try {
            Connection con = Conecta.getConexao();
            PreparedStatement pstm;
            ResultSet rs;
            pstm = con.prepareStatement("SELECT dataConsulta,hora,P.nome,D.nome,valor FROM consulta C, dentista D,paciente P "
                                       +"WHERE C.pacienteId = P.id AND C.dentistaId = D.id ORDER BY dataConsulta,hora");
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
        btnNovaConsulta = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Agenda Geral");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(200, 30, 92, 17);

        tblAgenda.setBorder(new javax.swing.border.MatteBorder(null));
        tblAgenda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Data ", "Horário", "Dentista", "Paciente", "Valor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        jScrollPane1.setBounds(20, 70, 530, 210);

        btnNovaConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/btnNovaConsulta.png"))); // NOI18N
        btnNovaConsulta.setText(" Nova Consulta");
        btnNovaConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovaConsultaActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovaConsulta);
        btnNovaConsulta.setBounds(560, 220, 160, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/iconeAgendaGeral.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(300, 10, 50, 50);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/btnSairPequeno.png"))); // NOI18N
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(560, 10, 160, 40);

        setSize(new java.awt.Dimension(750, 328));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovaConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovaConsultaActionPerformed
        frmAdicionarConsulta frm = new frmAdicionarConsulta();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnNovaConsultaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
    private javax.swing.JButton btnNovaConsulta;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblAgenda;
    // End of variables declaration//GEN-END:variables
}
