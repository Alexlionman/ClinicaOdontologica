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
                || txtSenha.getText().equals("") || txtConfirmarSenha.getText().equals("")) {
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
        txtConfirmarSenha.setEnabled(true);
    }

    public void desabilitaCampos() {
        txtId.setEnabled(true);
        txtNome.setEnabled(false);
        txtCpf.setEnabled(false);
        txtLogin.setEnabled(false);
        txtSenha.setEnabled(false);
        txtConfirmarSenha.setEnabled(false);
    }

    public void limparCampos() {
        txtId.setText("");
        txtNome.setText("");
        txtCpf.setText("");
        txtLogin.setText("");
        txtSenha.setText("");
        txtConfirmarSenha.setText("");
    }

    public frmAdicionarRecepcionista() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnSalvarRecepcionista = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnNovoRecepcionista = new javax.swing.JButton();
        btnPesquisarRecepcionista = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtId = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtDataNascimento = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtRg = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        txtCep = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        endwe = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        nconsu2 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        nconsu3 = new javax.swing.JLabel();
        txtConfirmarSenha = new javax.swing.JTextField();
        nconsu4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnSair1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Cadastrar Recepcionista");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 20, 146, 15);

        btnSalvarRecepcionista.setBackground(new java.awt.Color(88, 138, 255));
        btnSalvarRecepcionista.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalvarRecepcionista.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvarRecepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/salvar.png"))); // NOI18N
        btnSalvarRecepcionista.setText("Salvar Recepcionista");
        btnSalvarRecepcionista.setBorder(null);
        btnSalvarRecepcionista.setEnabled(false);
        btnSalvarRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarRecepcionistaActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvarRecepcionista);
        btnSalvarRecepcionista.setBounds(820, 420, 190, 50);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("E-mail:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 330, 80, 20);

        btnNovoRecepcionista.setBackground(new java.awt.Color(88, 138, 255));
        btnNovoRecepcionista.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNovoRecepcionista.setForeground(new java.awt.Color(255, 255, 255));
        btnNovoRecepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/iconAdd.png"))); // NOI18N
        btnNovoRecepcionista.setText("Novo Recepcionista");
        btnNovoRecepcionista.setBorder(null);
        btnNovoRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoRecepcionistaActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovoRecepcionista);
        btnNovoRecepcionista.setBounds(820, 360, 190, 50);

        btnPesquisarRecepcionista.setBackground(new java.awt.Color(88, 138, 255));
        btnPesquisarRecepcionista.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnPesquisarRecepcionista.setForeground(new java.awt.Color(255, 255, 255));
        btnPesquisarRecepcionista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/pesquisar.png"))); // NOI18N
        btnPesquisarRecepcionista.setText("Pesquisar");
        btnPesquisarRecepcionista.setBorder(null);
        btnPesquisarRecepcionista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarRecepcionistaActionPerformed(evt);
            }
        });
        getContentPane().add(btnPesquisarRecepcionista);
        btnPesquisarRecepcionista.setBounds(820, 480, 190, 50);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("ID:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 70, 24, 17);
        getContentPane().add(txtId);
        txtId.setBounds(50, 70, 50, 20);

        txtCpf.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        getContentPane().add(txtCpf);
        txtCpf.setBounds(160, 170, 140, 30);

        txtEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        getContentPane().add(txtEmail);
        txtEmail.setBounds(20, 350, 280, 30);

        txtDataNascimento.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDataNascimento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        getContentPane().add(txtDataNascimento);
        txtDataNascimento.setBounds(20, 230, 280, 30);

        txtNome.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        getContentPane().add(txtNome);
        txtNome.setBounds(20, 110, 280, 30);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Nome:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(20, 90, 60, 20);

        txtTelefone.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTelefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        getContentPane().add(txtTelefone);
        txtTelefone.setBounds(20, 290, 130, 30);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("RG:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(20, 150, 30, 20);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("CPF:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(160, 150, 40, 20);

        txtRg.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtRg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        getContentPane().add(txtRg);
        txtRg.setBounds(20, 170, 130, 30);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Data de nasc.:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(20, 210, 120, 20);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Celular:");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(160, 270, 90, 20);

        txtCelular.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        getContentPane().add(txtCelular);
        txtCelular.setBounds(160, 290, 140, 30);

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Telefone:");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(20, 270, 80, 20);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N
        jPanel1.setLayout(null);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Rua:");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(10, 10, 40, 20);

        txtRua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        txtRua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRuaActionPerformed(evt);
            }
        });
        jPanel1.add(txtRua);
        txtRua.setBounds(10, 30, 260, 20);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Numero:");
        jPanel1.add(jLabel17);
        jLabel17.setBounds(10, 60, 80, 20);

        txtNumero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        jPanel1.add(txtNumero);
        txtNumero.setBounds(10, 80, 120, 20);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Complemento:");
        jPanel1.add(jLabel18);
        jLabel18.setBounds(140, 60, 120, 20);

        txtComplemento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        jPanel1.add(txtComplemento);
        txtComplemento.setBounds(140, 80, 120, 20);

        txtCep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        jPanel1.add(txtCep);
        txtCep.setBounds(10, 130, 220, 20);

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("CEP:");
        jPanel1.add(jLabel19);
        jLabel19.setBounds(10, 110, 120, 20);

        txtBairro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        jPanel1.add(txtBairro);
        txtBairro.setBounds(10, 170, 220, 20);

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Bairro:");
        jPanel1.add(jLabel20);
        jLabel20.setBounds(10, 150, 120, 20);

        txtEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        jPanel1.add(txtEstado);
        txtEstado.setBounds(10, 210, 220, 20);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Estado:");
        jPanel1.add(jLabel24);
        jLabel24.setBounds(10, 190, 120, 20);

        txtCidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        jPanel1.add(txtCidade);
        txtCidade.setBounds(10, 250, 220, 20);

        endwe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        endwe.setText("Cidade:");
        jPanel1.add(endwe);
        endwe.setBounds(10, 230, 120, 20);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 390, 280, 280);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Informações de Login"));

        nconsu2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nconsu2.setText("Login");

        txtLogin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));

        txtSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));

        nconsu3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nconsu3.setText("Senha:");

        txtConfirmarSenha.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtConfirmarSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));

        nconsu4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nconsu4.setText("Confirmar senha:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nconsu2)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nconsu3)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nconsu4)
                    .addComponent(txtConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(nconsu2)
                .addGap(1, 1, 1)
                .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nconsu3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nconsu4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 49, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2);
        jPanel2.setBounds(430, 360, 260, 208);

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/limpar.png"))); // NOI18N
        jButton1.setText("Limpar Campos");
        jButton1.setBorder(null);
        getContentPane().add(jButton1);
        jButton1.setBounds(820, 540, 190, 50);

        btnSair.setBackground(new java.awt.Color(51, 255, 255));
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/voltar.png"))); // NOI18N
        btnSair.setText("voltar");
        btnSair.setBorder(null);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair);
        btnSair.setBounds(850, 50, 120, 40);

        btnSair1.setBackground(new java.awt.Color(88, 138, 255));
        btnSair1.setForeground(new java.awt.Color(255, 255, 255));
        btnSair1.setText("Zoom");
        btnSair1.setBorder(null);
        btnSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair1);
        btnSair1.setBounds(730, 50, 100, 40);

        setSize(new java.awt.Dimension(1226, 754));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarRecepcionistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarRecepcionistaActionPerformed
        if (verificaPreenchimento()) {

            if (txtSenha.getText().equals(txtConfirmarSenha.getText())) {
                Recepcionista recepcionista = new Recepcionista(txtNome.getText(), txtRg.getText(), txtCpf.getText(),
                        txtDataNascimento.getText(), txtTelefone.getText(),txtCelular.getText(),txtEmail.getText(),txtRua.getText(),txtNumero.getText(),
                        txtComplemento.getText(),txtCep.getText(),txtBairro.getText(),txtEstado.getText(), txtCidade.getText(),txtLogin.getText(), txtSenha.getText());
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
                txtConfirmarSenha.setText(r.getSenha());
            }
            r = null;
        }
    }//GEN-LAST:event_btnPesquisarRecepcionistaActionPerformed

    private void txtRuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRuaActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSair1ActionPerformed

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
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSair1;
    private javax.swing.JButton btnSalvarRecepcionista;
    private javax.swing.JLabel endwe;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel nconsu2;
    private javax.swing.JLabel nconsu3;
    private javax.swing.JLabel nconsu4;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtConfirmarSenha;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtDataNascimento;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtRg;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
