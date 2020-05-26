package Formularios;

import Classes.Conecta;
import Classes.ProdutoEstoque;
import Classes.ProdutoEstoqueDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class frmAdicionarItemEstoque extends javax.swing.JFrame {

    class campoNumerico extends PlainDocument {

        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            super.insertString(offs, str.replaceAll("[^0-9]", ""), a);
        }
    }

    private void habilitaCampos() {
        txtPeso.setEnabled(true);
        txtQuantidade.setEnabled(true);
        txtValidade.setEnabled(true);
    }

    private void desabilitaCampos() {
        txtPeso.setEnabled(false);
        txtQuantidade.setEnabled(false);
        txtValidade.setEnabled(false);
    }

    private boolean verificaPreenchimento() {
        if (txtValidade.getText().equals("  /  /    ") || txtPeso.getText().equals("")
                || txtQuantidade.getText().equals("") || tblProdutos.getSelectedRow() == -1) {
            return false;
        }
        return true;
    }

    private void limparCampos() {
        txtPeso.setText("");
        txtQuantidade.setText("");
        txtValidade.setText("");
        tblProdutos.clearSelection();
    }

    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tblProdutos.getModel();
        modelo.setNumRows(0);
        try {
            java.sql.Connection con = Conecta.getConexao();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("SELECT id, nome, fabricante FROM produto");
            rs = pstm.executeQuery();

            while (rs.next()) {  //enquanto existirem registros no banco, ele continuar
                modelo.addRow(new Object[]{
                    rs.getString("id"),
                    rs.getString("nome"),
                    rs.getString("fabricante")});
            }
            pstm.close();
            con.close();
            rs.close();
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void carregaTabelaItens() {
        DefaultTableModel modelo = (DefaultTableModel) tblItens.getModel();
        modelo.setNumRows(0);
        try {
            java.sql.Connection con = Conecta.getConexao();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("SELECT e.id, p.nome, p.fabricante, e.quantidade, e.peso, e.validade "
                    + "FROM produto p, produtoEstoque e WHERE p.id=e.produtoId");
            rs = pstm.executeQuery();

            while (rs.next()) {  //enquanto existirem registros no banco, ele continuar
                modelo.addRow(new Object[]{
                    rs.getInt("e.id"),
                    rs.getString("p.nome"),
                    rs.getString("p.fabricante"),
                    rs.getInt("e.quantidade"),
                    rs.getFloat("e.peso"),
                    rs.getString("e.validade")});
            }
            pstm.close();
            con.close();
            rs.close();
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public frmAdicionarItemEstoque() {
        initComponents();
        carregaTabela();
        carregaTabelaItens();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtQuantidade = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblItens = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnNovoProduto = new javax.swing.JButton();
        btnSalvarProduto = new javax.swing.JButton();
        btnLimparCampos = new javax.swing.JButton();
        txtValidade = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Selecione o Produto:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 50, 135, 19);

        txtQuantidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtQuantidade.setDocument(new campoNumerico());
        txtQuantidade.setEnabled(false);
        getContentPane().add(txtQuantidade);
        txtQuantidade.setBounds(340, 110, 110, 16);

        txtPeso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPeso.setDocument(new campoNumerico());
        txtPeso.setEnabled(false);
        getContentPane().add(txtPeso);
        txtPeso.setBounds(340, 140, 110, 16);

        jLabel4.setText("Fabricante");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(117, 126, 51, 0);

        jLabel5.setText("Qtde:");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(300, 110, 40, 14);

        jLabel6.setText("Peso:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(300, 140, 40, 14);

        jLabel7.setText("Validade:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(300, 80, 60, 14);

        tblItens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Produto", "Fabricante", "Qtde", "Peso", "Validade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblItens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblItensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblItens);
        if (tblItens.getColumnModel().getColumnCount() > 0) {
            tblItens.getColumnModel().getColumn(0).setMinWidth(40);
            tblItens.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblItens.getColumnModel().getColumn(0).setMaxWidth(40);
            tblItens.getColumnModel().getColumn(3).setMinWidth(50);
            tblItens.getColumnModel().getColumn(3).setPreferredWidth(50);
            tblItens.getColumnModel().getColumn(3).setMaxWidth(50);
            tblItens.getColumnModel().getColumn(4).setMinWidth(50);
            tblItens.getColumnModel().getColumn(4).setPreferredWidth(50);
            tblItens.getColumnModel().getColumn(4).setMaxWidth(50);
            tblItens.getColumnModel().getColumn(5).setMinWidth(75);
            tblItens.getColumnModel().getColumn(5).setPreferredWidth(75);
            tblItens.getColumnModel().getColumn(5).setMaxWidth(75);
        }

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 220, 470, 90);

        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/btnSairPequeno.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair);
        btnSair.setBounds(500, 10, 150, 40);

        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Produto", "Fabricante"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblProdutos);
        if (tblProdutos.getColumnModel().getColumnCount() > 0) {
            tblProdutos.getColumnModel().getColumn(0).setMinWidth(40);
            tblProdutos.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblProdutos.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 70, 260, 90);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Estoque");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(220, 0, 90, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Central do estoque");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(200, 200, 135, 19);

        btnNovoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/iconAdd.png"))); // NOI18N
        btnNovoProduto.setText(" Novo Produto");
        btnNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btnNovoProduto);
        btnNovoProduto.setBounds(500, 170, 150, 40);

        btnSalvarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/iconSalvar.png"))); // NOI18N
        btnSalvarProduto.setText("Salvar Produto");
        btnSalvarProduto.setEnabled(false);
        btnSalvarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvarProduto);
        btnSalvarProduto.setBounds(500, 220, 150, 40);

        btnLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/iconLimpar.png"))); // NOI18N
        btnLimparCampos.setText("Limpar Campos");
        btnLimparCampos.setEnabled(false);
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });
        getContentPane().add(btnLimparCampos);
        btnLimparCampos.setBounds(500, 270, 150, 40);

        txtValidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtValidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtValidade.setEnabled(false);
        getContentPane().add(txtValidade);
        txtValidade.setBounds(350, 80, 100, 20);

        setSize(new java.awt.Dimension(677, 359));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        frmEstoqueGeral frmestoque = new frmEstoqueGeral();
        frmestoque.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void tblItensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblItensMouseClicked


    }//GEN-LAST:event_tblItensMouseClicked

    private void btnNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProdutoActionPerformed
        limparCampos();
        habilitaCampos();
        btnNovoProduto.setEnabled(false);
        btnSalvarProduto.setEnabled(true);
        btnLimparCampos.setEnabled(true);
    }//GEN-LAST:event_btnNovoProdutoActionPerformed

    private void btnSalvarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarProdutoActionPerformed
        if (verificaPreenchimento()) {
            int item = tblProdutos.getSelectionModel().getMinSelectionIndex();
            ProdutoEstoque pe = new ProdutoEstoque(Integer.parseInt(txtQuantidade.getText()),
                    Integer.parseInt(txtPeso.getText()), txtValidade.getText(),
                    Integer.parseInt(tblProdutos.getModel().getValueAt(item, 0).toString()));
            String resp = new ProdutoEstoqueDAO().gravarEstoque(pe);
            if (resp.equals("OK")) {
                JOptionPane.showMessageDialog(rootPane, "Estoque incluído com sucesso!");
            } else {
                JOptionPane.showMessageDialog(rootPane, resp);
            }
            limparCampos();
            desabilitaCampos();
            carregaTabelaItens();
            btnNovoProduto.setEnabled(true);
            btnSalvarProduto.setEnabled(false);
            btnLimparCampos.setEnabled(false);
        } else {
            JOptionPane.showMessageDialog(null, "Campo Vazio!\nPreencha todos os campos obrigatórios.");
        }
    }//GEN-LAST:event_btnSalvarProdutoActionPerformed

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
            java.util.logging.Logger.getLogger(frmAdicionarItemEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmAdicionarItemEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmAdicionarItemEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmAdicionarItemEstoque.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmAdicionarItemEstoque().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JButton btnNovoProduto;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvarProduto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblItens;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JFormattedTextField txtValidade;
    // End of variables declaration//GEN-END:variables
}
