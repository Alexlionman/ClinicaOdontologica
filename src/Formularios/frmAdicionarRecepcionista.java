/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Classes.Paciente;
import Classes.PacienteDAO;
import Classes.Recepcionista;
import Classes.RecepcionistaDAO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author perei
 */
public class frmAdicionarRecepcionista extends javax.swing.JFrame {

    class campoNumerico extends PlainDocument{
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            super.insertString(offs, str.replaceAll("[^0-9]", ""), a);
        }
    }
    
    public boolean verificaPreenchimento() {
        if (txtNome.getText().equals("") || txtLogin.getText().equals("") || txtCpf.getText().equals("   .   .   -  ")
                || txtSenha.getText().equals("") || txtConfirmaSenha.getText().equals("")) {
            return false;
        }
        return true;
    }

    public void habilitaCampos() {
        txtId.setEnabled(false);
        txtNome.setEnabled(true);
        txtCpf.setEnabled(true);
        txtLogin.setEnabled(true);
        txtSenha.setEnabled(true);
        txtConfirmaSenha.setEnabled(true);
    }

    public void desabilitaCampos() {
        txtId.setEnabled(true);
        txtNome.setEnabled(false);
        txtCpf.setEnabled(false);
        txtLogin.setEnabled(false);
        txtSenha.setEnabled(false);
        txtConfirmaSenha.setEnabled(false);
    }

    public void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtCpf.setText("");
        txtLogin.setText("");
        txtSenha.setText("");
        txtConfirmaSenha.setText("");
    }

    public frmAdicionarRecepcionista() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnSalvarRecepcionista = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtConfirmaSenha = new javax.swing.JPasswordField();
        txtSenha = new javax.swing.JPasswordField();
        btnNovoRecepcionista = new javax.swing.JButton();
        btnPesquisarRecepcionista = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Cadastrar Recepcionista");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 20, 147, 15);

        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNome.setEnabled(false);
        getContentPane().add(txtNome);
        txtNome.setBounds(60, 90, 330, 16);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Id:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 50, 30, 15);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Login:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(20, 170, 40, 15);

        btnSalvarRecepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/iconSalvar.png"))); // NOI18N
        btnSalvarRecepcionista.setText("Salvar Recepcionista");
        btnSalvarRecepcionista.setEnabled(false);
        btnSalvarRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarRecepcionistaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvarRecepcionista);
        btnSalvarRecepcionista.setBounds(410, 140, 190, 40);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/btnSairPequeno.png"))); // NOI18N
        jButton2.setText("Sair");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(410, 10, 190, 40);

        txtCpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setEnabled(false);
        getContentPane().add(txtCpf);
        txtCpf.setBounds(50, 130, 130, 16);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Confirmar Senha:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(190, 210, 100, 15);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("CPF:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(20, 130, 24, 15);

        txtLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtLogin.setEnabled(false);
        getContentPane().add(txtLogin);
        txtLogin.setBounds(60, 170, 120, 16);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Nome:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 90, 36, 15);

        txtId.setDocument(new campoNumerico());
        txtId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(txtId);
        txtId.setBounds(40, 50, 30, 16);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Senha:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(20, 210, 50, 15);

        txtConfirmaSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtConfirmaSenha.setEnabled(false);
        txtConfirmaSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmaSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(txtConfirmaSenha);
        txtConfirmaSenha.setBounds(290, 210, 100, 16);

        txtSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtSenha.setEnabled(false);
        getContentPane().add(txtSenha);
        txtSenha.setBounds(70, 210, 110, 16);

        btnNovoRecepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/iconAdd.png"))); // NOI18N
        btnNovoRecepcionista.setText("Novo Recepcionista");
        btnNovoRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoRecepcionistaActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovoRecepcionista);
        btnNovoRecepcionista.setBounds(410, 90, 190, 40);

        btnPesquisarRecepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/iconPesquisar.png"))); // NOI18N
        btnPesquisarRecepcionista.setText("Pesquisar Recepcionista");
        btnPesquisarRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarRecepcionistaActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisarRecepcionista);
        btnPesquisarRecepcionista.setBounds(410, 190, 190, 40);

        setSize(new java.awt.Dimension(622, 281));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarRecepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarRecepcionistaActionPerformed
        if (verificaPreenchimento()) {

            if (txtSenha.getText().equals(txtConfirmaSenha.getText())) {
                Recepcionista recepcionista = new Recepcionista(txtNome.getText(), txtCpf.getText(), txtLogin.getText(),
                        txtSenha.getText());
                if (new RecepcionistaDAO().verificaCpfExistente(recepcionista).equals(txtCpf.getText())) {
                    JOptionPane.showMessageDialog(null, "CPF ja cadastrado!\nEsse CPF ja esta cadastrado, digite outro.");
                } else {
                    if (new RecepcionistaDAO().verificaLoginExistente(recepcionista).equals(txtLogin.getText())) {
                        JOptionPane.showMessageDialog(null, "Login ja cadastrado!\nEsse Login ja esta cadastrado, digite outro.");
                    } else {
                        String resp = new RecepcionistaDAO().gravarRecepcionista(recepcionista);
                        if (resp.equals("OK")) {
                            JOptionPane.showMessageDialog(rootPane, "Recepcionista gravada(o) com sucesso");
                            limparCampos();
                            desabilitaCampos();
                            btnNovoRecepcionista.setEnabled(true);
                            btnSalvarRecepcionista.setEnabled(false);
                            btnPesquisarRecepcionista.setEnabled(true);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, resp);
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Senhas digitadas divergem.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Campo Vazio!\nPreencha todos os campos obrigatórios.");
        }
    }//GEN-LAST:event_btnSalvarRecepcionistaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtConfirmaSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmaSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmaSenhaActionPerformed

    private void btnNovoRecepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoRecepcionistaActionPerformed
        limparCampos();
        habilitaCampos();
        btnNovoRecepcionista.setEnabled(false);
        btnSalvarRecepcionista.setEnabled(true);
        btnPesquisarRecepcionista.setEnabled(false);
    }//GEN-LAST:event_btnNovoRecepcionistaActionPerformed

    private void btnPesquisarRecepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarRecepcionistaActionPerformed
        if (txtId.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Campo vazio!\nDigite o campo ID para realizar a consulta.");
            limparCampos();
        } else {
            Recepcionista r = new RecepcionistaDAO().pesquisarRecepcionista(Integer.parseInt(txtId.getText()) + 1);
            if (r.getCpf() == null) {
                JOptionPane.showMessageDialog(null, "Recepcionista não cadastrada(o).");
                limparCampos();
            } else {
                txtId.setText((r.getId() - 1) + "");
                txtNome.setText(r.getNome());
                txtCpf.setText(r.getCpf());
                txtLogin.setText(r.getLogin());
                txtSenha.setText(r.getSenha());
                txtConfirmaSenha.setText(r.getSenha());
            }
            r = null;
        }
    }//GEN-LAST:event_btnPesquisarRecepcionistaActionPerformed

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
            java.util.logging.Logger.getLogger(frmAdicionarRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAdicionarRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAdicionarRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAdicionarRecepcionista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAdicionarRecepcionista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovoRecepcionista;
    private javax.swing.JButton btnPesquisarRecepcionista;
    private javax.swing.JButton btnSalvarRecepcionista;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField txtConfirmaSenha;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtSenha;
    // End of variables declaration//GEN-END:variables
}
