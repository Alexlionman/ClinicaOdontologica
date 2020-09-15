package Formularios;

import Classes.Conecta;
import Classes.Consulta;
import Classes.ConsultaDAO;
import Classes.Dentista;
import Classes.DentistaDAO;
import Classes.Paciente;
import Classes.PacienteDAO;
import Classes.Recepcionista;
import Classes.RecepcionistaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
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
            JOptionPane.showMessageDialog(null, "Erro ao carregar tabela de dados" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDentista = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPaciente = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtData = new javax.swing.JFormattedTextField();
        jcbHora = new javax.swing.JComboBox<>();
        txtValor = new javax.swing.JFormattedTextField();
        btnLimparCampos = new javax.swing.JToggleButton();
        txtPesquisaDentista1 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtPesquisaPaciente1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Data:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Hora:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Valor da consulta:");

        btnAgendar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/iconSalvar.png"))); // NOI18N
        btnAgendar.setText("Agendar Consulta");
        btnAgendar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarActionPerformed(evt);
            }
        });

        tblDentista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        tblPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText("Agendamentos de Consultas");

        jLabel8.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel8.setText("Selecionar Paciente");

        jLabel9.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel9.setText("Selecionar Dentista");

        txtData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jcbHora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "09:00", "09:45", "10:30", "11:15", "13:00", "13:45", "14:30", "15:15", "16:00", "16:45", "17:30" }));
        jcbHora.setBorder(null);

        txtValor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtValor.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        btnLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/iconLimpar.png"))); // NOI18N
        btnLimparCampos.setText("Limpar Campos    ");
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        txtPesquisaDentista1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        txtPesquisaDentista1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaDentista1ActionPerformed(evt);
            }
        });
        txtPesquisaDentista1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaDentista1KeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Pesquisa Dentista:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Pesquisar Paciente:");

        txtPesquisaPaciente1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(88, 138, 255)));
        txtPesquisaPaciente1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaPaciente1KeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel10)
                        .addGap(254, 254, 254)
                        .addComponent(jLabel11))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(txtPesquisaDentista1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(txtPesquisaPaciente1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel9)
                        .addGap(247, 247, 247)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(80, 80, 80)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190)
                        .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(920, 920, 920)
                        .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPesquisaDentista1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisaPaciente1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(btnAgendar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbHora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtValor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        setSize(new java.awt.Dimension(1226, 754));
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

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void txtPesquisaDentista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaDentista1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaDentista1ActionPerformed

    private void txtPesquisaDentista1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaDentista1KeyPressed
        //para pesquisar conforme o usuario digita uma letra
        String nome = "%" +txtPesquisaDentista1.getText()+ "%";

        DentistaDAO dao = new DentistaDAO();
        List<Dentista> lista = dao.buscaDentistaPorNome(nome);
        DefaultTableModel dados = (DefaultTableModel) tblDentista.getModel();
        dados.setNumRows(0); //limpar

        for(Dentista c: lista){
            dados.addRow(new Object[]{
                c.getId(),
                c.getNome()
         
            });
        }
    }//GEN-LAST:event_txtPesquisaDentista1KeyPressed

    private void txtPesquisaPaciente1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaPaciente1KeyPressed
        //para pesquisar conforme o usuario digita uma letra
        String nome = "%" +txtPesquisaPaciente1.getText()+ "%";

        PacienteDAO dao = new PacienteDAO();
        List<Paciente> lista = dao.buscaPacientePorNome(nome);
        DefaultTableModel dados = (DefaultTableModel) tblPaciente.getModel();
        dados.setNumRows(0); //limpar

        for(Paciente c: lista){
            dados.addRow(new Object[]{
                c.getId(),
                c.getNome()
                
            });
        }
    }//GEN-LAST:event_txtPesquisaPaciente1KeyPressed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JTextField txtPesquisaDentista1;
    private javax.swing.JTextField txtPesquisaPaciente1;
    private javax.swing.JFormattedTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
