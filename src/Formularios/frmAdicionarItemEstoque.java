package Formularios;

import Classes.Conecta;
import Classes.ProdutoEstoque;
import Classes.ProdutoEstoqueDAO;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    Color azulPadrao = new Color(129, 167, 255);
    Color azulClaro = new Color(226, 235, 255);
    Color azulHover = new Color(192, 216, 235);
    Color vermelhoHover = new Color(242, 198, 196);
    Color azulClaroo = new Color(139, 215, 255);
    Color vermelhoPadraoExcluir = new Color(223, 107, 111);

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

    /*
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

     */
    public frmAdicionarItemEstoque() {
        initComponents();
        getContentPane().setBackground(azulClaro);
        carregaTabela();
        // carregaTabelaItens();
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
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProdutos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnNovoProduto = new javax.swing.JButton();
        btnSalvarProduto = new javax.swing.JButton();
        btnLimparCampos = new javax.swing.JButton();
        txtValidade = new javax.swing.JFormattedTextField();
        btnSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 2, 14)); // NOI18N
        jLabel1.setText("Selecione o Produto:");

        txtQuantidade.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtQuantidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtQuantidade.setDocument(new campoNumerico());
        txtQuantidade.setEnabled(false);

        txtPeso.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPeso.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtPeso.setDocument(new campoNumerico());
        txtPeso.setEnabled(false);

        jLabel4.setText("Fabricante");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Qtde:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Peso:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Validade:");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));

        tblProdutos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tblProdutos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tblProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
        tblProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProdutos);
        if (tblProdutos.getColumnModel().getColumnCount() > 0) {
            tblProdutos.getColumnModel().getColumn(0).setMinWidth(40);
            tblProdutos.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblProdutos.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        jLabel2.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(129, 167, 255));
        jLabel2.setText("CADASTRO DO ESTOQUE");

        btnNovoProduto.setBackground(new java.awt.Color(129, 167, 255));
        btnNovoProduto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNovoProduto.setForeground(new java.awt.Color(255, 255, 255));
        btnNovoProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/novo.png"))); // NOI18N
        btnNovoProduto.setText(" Novo Produto");
        btnNovoProduto.setBorder(null);
        btnNovoProduto.setEnabled(false);
        btnNovoProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNovoProdutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNovoProdutoMouseExited(evt);
            }
        });
        btnNovoProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoProdutoActionPerformed(evt);
            }
        });

        btnSalvarProduto.setBackground(new java.awt.Color(129, 167, 255));
        btnSalvarProduto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalvarProduto.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvarProduto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/salvar.png"))); // NOI18N
        btnSalvarProduto.setText("Salvar Produto");
        btnSalvarProduto.setBorder(null);
        btnSalvarProduto.setEnabled(false);
        btnSalvarProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalvarProdutoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalvarProdutoMouseExited(evt);
            }
        });
        btnSalvarProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarProdutoActionPerformed(evt);
            }
        });

        btnLimparCampos.setBackground(new java.awt.Color(129, 167, 255));
        btnLimparCampos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnLimparCampos.setForeground(new java.awt.Color(255, 255, 255));
        btnLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/limpar.png"))); // NOI18N
        btnLimparCampos.setText("Limpar Campos");
        btnLimparCampos.setBorder(null);
        btnLimparCampos.setEnabled(false);
        btnLimparCampos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnLimparCamposMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnLimparCamposMouseExited(evt);
            }
        });
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        txtValidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtValidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtValidade.setEnabled(false);
        txtValidade.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        btnSair.setBackground(new java.awt.Color(139, 215, 255));
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/voltar.png"))); // NOI18N
        btnSair.setText("voltar");
        btnSair.setBorder(null);
        btnSair.setMaximumSize(new java.awt.Dimension(61, 31));
        btnSair.setMinimumSize(new java.awt.Dimension(61, 31));
        btnSair.setPreferredSize(new java.awt.Dimension(61, 31));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNovoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addComponent(jLabel4))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValidade, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(65, 65, 65)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnNovoProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvarProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25))
        );

        setSize(new java.awt.Dimension(758, 498));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    String opc = null;

    private void btnNovoProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoProdutoActionPerformed
        limparCampos();
        habilitaCampos();
        opc = "novo";
        btnNovoProduto.setEnabled(false);
        btnSalvarProduto.setEnabled(true);
        btnLimparCampos.setEnabled(true);
    }//GEN-LAST:event_btnNovoProdutoActionPerformed

    private void btnSalvarProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarProdutoActionPerformed
        if (opc.equals("novo")) {
            if (verificaPreenchimento()) {
                int item = tblProdutos.getSelectionModel().getMinSelectionIndex();
                ProdutoEstoque pe = new ProdutoEstoque(Integer.parseInt(txtQuantidade.getText()),
                        Integer.parseInt(txtPeso.getText()), txtValidade.getText(),
                        Integer.parseInt(tblProdutos.getModel().getValueAt(item, 0).toString()));
                String resp = new ProdutoEstoqueDAO().gravarEstoque(pe);
                if (resp.equals("OK")) {
                    JOptionPane.showMessageDialog(rootPane, "Estoque incluído com sucesso!");
                    btnNovoProduto.setEnabled(false);
                } else {
                    JOptionPane.showMessageDialog(rootPane, resp);
                    btnNovoProduto.setEnabled(false);

                }
                limparCampos();
                desabilitaCampos();
//         carregaTabelaItens();
                btnNovoProduto.setEnabled(true);
                btnSalvarProduto.setEnabled(false);
                btnLimparCampos.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Campo Vazio!\nPreencha todos os campos obrigatórios.");
            }
        }

        if (opc.equals("editar")) {
            //lógica de edição(apenas editar quantidade)

        }
    }//GEN-LAST:event_btnSalvarProdutoActionPerformed

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnNovoProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoProdutoMouseEntered
        btnNovoProduto.setBackground(Color.white);
        btnNovoProduto.setForeground(azulPadrao);
    }//GEN-LAST:event_btnNovoProdutoMouseEntered

    private void btnNovoProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoProdutoMouseExited
        btnNovoProduto.setBackground(azulPadrao);
        btnNovoProduto.setForeground(Color.white);
    }//GEN-LAST:event_btnNovoProdutoMouseExited

    private void btnSalvarProdutoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarProdutoMouseEntered
        btnSalvarProduto.setBackground(Color.white);
        btnSalvarProduto.setForeground(azulPadrao);
    }//GEN-LAST:event_btnSalvarProdutoMouseEntered

    private void btnSalvarProdutoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarProdutoMouseExited
        btnSalvarProduto.setBackground(azulPadrao);
        btnSalvarProduto.setForeground(Color.white);
    }//GEN-LAST:event_btnSalvarProdutoMouseExited

    private void btnLimparCamposMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparCamposMouseEntered
        btnLimparCampos.setBackground(Color.white);
        btnLimparCampos.setForeground(azulPadrao);    }//GEN-LAST:event_btnLimparCamposMouseEntered

    private void btnLimparCamposMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparCamposMouseExited
        btnLimparCampos.setBackground(azulPadrao);
        btnLimparCampos.setForeground(Color.white);
    }//GEN-LAST:event_btnLimparCamposMouseExited

    private void tblProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutosMouseClicked
        btnNovoProduto.setEnabled(true);
    }//GEN-LAST:event_tblProdutosMouseClicked

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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblProdutos;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtQuantidade;
    private javax.swing.JFormattedTextField txtValidade;
    // End of variables declaration//GEN-END:variables
}
