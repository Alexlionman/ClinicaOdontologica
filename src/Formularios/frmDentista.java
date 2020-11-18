package Formularios;

import Classes.Conecta;
import Classes.Dentista;
import Classes.DentistaDAO;
import Classes.Utilidades;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import Formularios.frmPaciente;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class frmDentista extends javax.swing.JFrame {
    Color azulPadrao = new Color(129, 167, 255);
    Color azulClaro = new Color(226, 235, 255);
    Color azulClaroo = new Color(139, 215, 255);
    Color vermelhoHover = new Color(242, 198, 196);
    Color vermelhoPadraoExcluir = new Color(223,107,111); 
    //fonte para o zoom
    public Font fonteZoomTexto = new Font("Arial", Font.BOLD, 18);
    public Font fonteNormal = new Font("Arial", Font.BOLD, 14);
    public Font fonteZoomBotoes = new Font("Arial", Font.BOLD, 18);
    public Font fonteNormalBotoes = new Font("Arial", Font.BOLD, 14);

    public String situacao = "";
    String logradouro;
    String bairro;
    String cidade;
    String uf;

    class campoNumerico extends PlainDocument{
        @Override
        public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
            super.insertString(offs, str.replaceAll("[^0-9]", ""), a);
        }
    }
    public boolean verificaPreenchimento() {
        if (txtEmail.getText().equals("") || txtEmail.getText().equals("") || txtNascimento.getText().equals("  /  /    ")
                 || txtValorConsulta.getText().equals("   .  ")) {
            return false;
        }
        return true;
    }
    public void limparCampos() {
        txtId.setText("");
        txtTelefone.setText("");
        txtNome1.setText("");
        txtCpf.setText("");
        txtRg.setText("");
        txtNascimento.setText("");
        txtLogin.setText("");
        txtSenha.setText("");
        txtConfirmarSenha.setText("");
        txtCro.setText("");
        txtEstado.setText("");
        txtRua.setText("");
        txtNumeroConsultorio.setText("");
        txtValorConsulta.setText("");
        txtBairro.setText("");
        txtComplemento.setText("");
        txtNumero.setText("");
        txtTelefone.setText("");
        txtCelular.setText("");
        txtCep.setText("");
        txtEmail.setText("");
        txtCidade.setText("");
    }
    public void habilitaCampos() {
        txtTelefone.setEnabled(true);
        txtNome1.setEnabled(true);
        txtCpf.setEnabled(true);
        txtRg.setEnabled(true);
        txtNascimento.setEnabled(true);
        txtLogin.setEnabled(true);
        txtSenha.setEnabled(true);
        txtConfirmarSenha.setEnabled(true);
        txtCro.setEnabled(true);
        txtEstado.setEnabled(true);
        txtRua.setEnabled(true);
        txtNumeroConsultorio.setEnabled(true);
        txtValorConsulta.setEnabled(true);
        txtBairro.setEnabled(true);
        txtComplemento.setEnabled(true);
        txtNumero.setEnabled(true);
        txtTelefone.setEnabled(true);
        txtCelular.setEnabled(true);
        txtCep.setEnabled(true);
        txtEmail.setEnabled(true);
        txtCelular1.setEnabled(true);
        txtCidade.setEnabled(true);
    }
    public void desabilitaCampos() {
        txtTelefone.setEnabled(false);
        txtNome1.setEnabled(false);
        txtCpf.setEnabled(false);
        txtRg.setEnabled(false);
        txtNascimento.setEnabled(false);
        txtLogin.setEnabled(false);
        txtSenha.setEnabled(false);
        txtConfirmarSenha.setEnabled(false);
        txtCelular.setEnabled(false);
        txtCelular1.setEnabled(false);
        txtCro.setEnabled(false);
        txtEstado.setEnabled(false);
        txtRua.setEnabled(false);
        txtNumeroConsultorio.setEnabled(false);
        txtValorConsulta.setEnabled(false);
        txtBairro.setEnabled(false);
        txtComplemento.setEnabled(false);
        txtNumero.setEnabled(false);
        txtTelefone.setEnabled(false);
        txtCelular.setEnabled(false);
        txtCep.setEnabled(false);
        txtEmail.setEnabled(false);
        txtCidade.setEnabled(false);
    }
    public void buscarCep(String cep){
        String json;        

        try {
            URL url = new URL("http://viacep.com.br/ws/"+ cep +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));
            json = jsonSb.toString();
            
            // JOptionPane.showMessageDialog(null, json);
            
            json = json.replaceAll("[{},:]", "");
            json = json.replaceAll("\"", "\n");                       
            String array[] = new String[30];
            array = json.split("\n");
            
            // JOptionPane.showMessageDialog(null, array);
                             
            logradouro = array[7];            
            bairro = array[15];
            cidade = array[19]; 
            uf = array[23];
            
            txtRua.setText(logradouro);
            txtBairro.setText(bairro);
            txtCidade.setText(cidade);
            txtEstado.setText(uf);
            //JOptionPane.showMessageDialog(null, logradouro + " " + bairro + " " + cidade + " " + uf);
            
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tblDentista.getModel();
        modelo.setNumRows(0);
        try {
            java.sql.Connection con = Conecta.getConexao();
            PreparedStatement pstm;
            ResultSet rs;
            pstm = con.prepareStatement("select * from dentista order by nome");
            rs = pstm.executeQuery();
            while (rs.next()) {  //enquanto existirem registros no banco, ele continuar
                modelo.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cro"),
                    rs.getInt("consultorio"),
                    rs.getFloat("valorConsulta"),});
            }
            pstm.close();
            con.close();
            rs.close();
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void pegarResolucao() {
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension dimensao = t.getScreenSize();
        this.setSize((dimensao.width + 5), (dimensao.height - 38));

 }

    public frmDentista() {
        initComponents();
        pegarResolucao();
        desabilitaCampos();
        this.setExtendedState(MAXIMIZED_BOTH);
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        carregaTabela();
        getContentPane().setBackground(azulClaro);
        //mudar a cor do cabeçalho da tabela
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(azulPadrao);
        headerRenderer.setForeground(Color.WHITE);
        for (int i = 0; i < tblDentista.getModel().getColumnCount(); i++) {
            tblDentista.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCelular = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDentista = new javax.swing.JTable();
        btnExcluirDentista = new javax.swing.JButton();
        btnEditarDentista = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnNovoDentista = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        btnSalvarDentista = new javax.swing.JButton();
        btnLimparCampos = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        nconsu = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        txtNascimento = new javax.swing.JFormattedTextField();
        txtRg = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCpf = new javax.swing.JFormattedTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtCro = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        endwe = new javax.swing.JLabel();
        txtCep = new javax.swing.JFormattedTextField();
        txtValorConsulta = new javax.swing.JTextField();
        nconsu1 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtNumeroConsultorio = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        nconsu2 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        txtSenha = new javax.swing.JTextField();
        nconsu3 = new javax.swing.JLabel();
        txtConfirmarSenha = new javax.swing.JTextField();
        nconsu4 = new javax.swing.JLabel();
        txtNome1 = new javax.swing.JTextField();
        txtPesquisaDentista1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtCelular1 = new javax.swing.JFormattedTextField();
        btnZoom = new javax.swing.JButton();
        txtId = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
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

        txtCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)##### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelular.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Celular:");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Data de Nasc:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Nome:");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jScrollPane2.setOpaque(false);

        tblDentista.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblDentista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CRO", "Consultório", "Valor Consulta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDentista.setGridColor(new java.awt.Color(255, 255, 255));
        tblDentista.setOpaque(false);
        tblDentista.setSelectionBackground(new java.awt.Color(129, 167, 255));
        tblDentista.getTableHeader().setResizingAllowed(false);
        tblDentista.getTableHeader().setReorderingAllowed(false);
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
            tblDentista.getColumnModel().getColumn(1).setMinWidth(250);
            tblDentista.getColumnModel().getColumn(1).setPreferredWidth(250);
            tblDentista.getColumnModel().getColumn(1).setMaxWidth(250);
            tblDentista.getColumnModel().getColumn(3).setMinWidth(80);
            tblDentista.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblDentista.getColumnModel().getColumn(3).setMaxWidth(80);
            tblDentista.getColumnModel().getColumn(4).setMinWidth(95);
            tblDentista.getColumnModel().getColumn(4).setPreferredWidth(95);
            tblDentista.getColumnModel().getColumn(4).setMaxWidth(95);
        }

        btnExcluirDentista.setBackground(new java.awt.Color(223, 107, 111));
        btnExcluirDentista.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnExcluirDentista.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluirDentista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/excluir.png"))); // NOI18N
        btnExcluirDentista.setText("Excluir Dentista");
        btnExcluirDentista.setBorder(null);
        btnExcluirDentista.setEnabled(false);
        btnExcluirDentista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExcluirDentistaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExcluirDentistaMouseExited(evt);
            }
        });
        btnExcluirDentista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirDentistaActionPerformed(evt);
            }
        });

        btnEditarDentista.setBackground(new java.awt.Color(129, 167, 255));
        btnEditarDentista.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEditarDentista.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarDentista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/editar.png"))); // NOI18N
        btnEditarDentista.setText("Editar Dentista");
        btnEditarDentista.setBorder(null);
        btnEditarDentista.setEnabled(false);
        btnEditarDentista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarDentistaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarDentistaMouseExited(evt);
            }
        });
        btnEditarDentista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarDentistaActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(129, 167, 255));
        jLabel4.setText("INFORMAÇÕES DO DENTISTA");

        btnNovoDentista.setBackground(new java.awt.Color(129, 167, 255));
        btnNovoDentista.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNovoDentista.setForeground(new java.awt.Color(255, 255, 255));
        btnNovoDentista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/novo.png"))); // NOI18N
        btnNovoDentista.setText(" Novo Dentista");
        btnNovoDentista.setBorder(null);
        btnNovoDentista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNovoDentistaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNovoDentistaMouseExited(evt);
            }
        });
        btnNovoDentista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoDentistaActionPerformed(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        btnSalvarDentista.setBackground(new java.awt.Color(129, 167, 255));
        btnSalvarDentista.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalvarDentista.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvarDentista.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/salvar.png"))); // NOI18N
        btnSalvarDentista.setText("Salvar Dentista");
        btnSalvarDentista.setBorder(null);
        btnSalvarDentista.setEnabled(false);
        btnSalvarDentista.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalvarDentistaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalvarDentistaMouseExited(evt);
            }
        });
        btnSalvarDentista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarDentistaActionPerformed(evt);
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

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("ID:");

        nconsu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nconsu.setText("Email");

        btnVoltar.setBackground(new java.awt.Color(102, 204, 255));
        btnVoltar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
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

        txtNascimento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtNascimento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        txtRg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtRg.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRgActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("RG:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("CPF:");

        txtCpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Telefone:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("Celular:");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("CRO:");

        txtCro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtCro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCroActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(226, 235, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Endereço", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Logradouro:");

        txtRua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtRua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Numero:");

        txtNumero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNumero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setText("Complemento:");

        txtComplemento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtComplemento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("CEP:");

        txtBairro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtBairro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Bairro:");

        txtEstado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel24.setText("Estado:");

        txtCidade.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        endwe.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        endwe.setText("Cidade:");

        txtCep.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCep.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCep.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCepKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCepKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24)))
                    .addComponent(endwe)
                    .addComponent(jLabel20)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel24))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addComponent(jLabel20)
                .addGap(0, 0, 0)
                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(endwe, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        txtRua.getAccessibleContext().setAccessibleName("");
        txtNumero.getAccessibleContext().setAccessibleName("");
        txtComplemento.getAccessibleContext().setAccessibleName("");
        txtBairro.getAccessibleContext().setAccessibleName("");
        txtEstado.getAccessibleContext().setAccessibleName("");
        txtCidade.getAccessibleContext().setAccessibleName("");
        txtCep.getAccessibleContext().setAccessibleName("");

        txtValorConsulta.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtValorConsulta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        nconsu1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        nconsu1.setText("Valor da Consulta:");

        jLabel21.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel21.setText("Nº Consultório");

        txtNumeroConsultorio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNumeroConsultorio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        txtNumeroConsultorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroConsultorioActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(226, 235, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Informações de Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        nconsu2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nconsu2.setText("Login");

        txtLogin.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtSenha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        nconsu3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        nconsu3.setText("Senha:");

        txtConfirmarSenha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtConfirmarSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nconsu3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nconsu4))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nconsu3)
                    .addComponent(nconsu4)
                    .addComponent(nconsu2))
                .addGap(0, 0, 0)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        txtNome1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNome1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtPesquisaDentista1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPesquisaDentista1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
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

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Pesquisa Dentista:");

        txtTelefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        txtCelular1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtCelular1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)##### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelular1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        btnZoom.setBackground(new java.awt.Color(129, 167, 255));
        btnZoom.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
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

        txtId.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtId.setForeground(new java.awt.Color(129, 167, 255));

        jSeparator2.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

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

        jmiDentistas.setBackground(new java.awt.Color(129, 167, 255));
        jmiDentistas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiDentistas.setForeground(java.awt.Color.white);
        jmiDentistas.setText("Acessando tela de dentistas...");
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

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMenuItem1.setBackground(new java.awt.Color(129, 167, 255));
        jMenuItem1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jMenuItem1.setForeground(java.awt.Color.white);
        jMenuItem1.setText("Consultas");
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
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nconsu, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addGap(106, 106, 106))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(txtRg, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                                            .addGap(27, 27, 27)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)))
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNome1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNumeroConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(nconsu1)
                                            .addGap(34, 34, 34))
                                        .addComponent(txtValorConsulta)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 343, Short.MAX_VALUE)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtNascimento)
                                                .addGap(27, 27, 27))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel18)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(76, 76, 76)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel14)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel13)
                                            .addComponent(txtCro, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                                            .addComponent(txtCelular1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNovoDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnEditarDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnSalvarDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnExcluirDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(50, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtPesquisaDentista1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel7)
                        .addGap(0, 0, 0)
                        .addComponent(txtNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel14))
                                .addGap(0, 0, 0)
                                .addComponent(txtNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(txtCro, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18)
                            .addComponent(jLabel13))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCelular1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(nconsu)
                        .addGap(0, 0, 0)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nconsu1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumeroConsultorio, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtValorConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, 0)
                                .addComponent(txtPesquisaDentista1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnNovoDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(btnEditarDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(46, 46, 46)
                                        .addComponent(btnSalvarDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(45, 45, 45)
                                        .addComponent(btnExcluirDentista, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(58, 58, 58))
        );

        setSize(new java.awt.Dimension(1212, 776));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblDentistaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDentistaMouseClicked
        int item = tblDentista.getSelectionModel().getMinSelectionIndex();  //pega a linha selecionada
        item = (int) tblDentista.getModel().getValueAt(item, 0);
        Dentista d = new DentistaDAO().pesquisarDentista(item);
        desabilitaCampos();
        
        txtId.setText(d.getId()+"");
        txtNome1.setText(d.getNome());
        txtNascimento.setText(d.getNascimento());
        txtNumeroConsultorio.setText(d.getConsultorio());
        txtRg.setText(d.getRg());
        txtCpf.setText(d.getCpf());
        txtTelefone.setText(d.getTelefone());
        txtCelular1.setText(d.getCelular());
        txtEmail.setText(d.getEmail());
        txtComplemento.setText(d.getComplemento());
        txtBairro.setText(d.getBairro());
        txtCep.setText(d.getCep());
        txtCidade.setText(d.getCidade());
        txtLogin.setText(d.getLogin());
        txtSenha.setText(d.getSenha());
        txtConfirmarSenha.setText(d.getSenha());
        txtValorConsulta.setText(d.getValorConsulta() + "");
        txtCro.setText(d.getCro());
        txtRua.setText(d.getEndereco());
        txtEstado.setText(d.getEstado());
        txtNumero.setText(d.getNumero());

        btnEditarDentista.setEnabled(true);
        btnExcluirDentista.setEnabled(true);
        btnSalvarDentista.setEnabled(false);
        btnNovoDentista.setEnabled(true);
        btnLimparCampos.setEnabled(false);
    }//GEN-LAST:event_tblDentistaMouseClicked

    private void btnExcluirDentistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirDentistaActionPerformed
        switch (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse dentista?")) {
            case 0:
                Dentista dentista = new Dentista(Integer.parseInt(txtId.getText()));
                String resp = new DentistaDAO().excluirDentista(dentista);

                if (resp.equals("OK")) {
                    Utilidades.criarMensagemSucesso();
                    limparCampos();
                    desabilitaCampos();
                    carregaTabela();
                } else {
                Utilidades.criarMensagemErro();
                    limparCampos();
                    desabilitaCampos();
                    carregaTabela();                }
          
                btnNovoDentista.setEnabled(true);
                btnEditarDentista.setEnabled(false);
                btnExcluirDentista.setEnabled(false);
                btnLimparCampos.setEnabled(false);
                btnSalvarDentista.setEnabled(false);
                break;

        }

    }//GEN-LAST:event_btnExcluirDentistaActionPerformed

    private void btnEditarDentistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarDentistaActionPerformed
        habilitaCampos();
        situacao = "edicao";

        btnNovoDentista.setEnabled(false);
        btnExcluirDentista.setEnabled(false);
        btnSalvarDentista.setEnabled(true);
        btnEditarDentista.setEnabled(false);


    }//GEN-LAST:event_btnEditarDentistaActionPerformed

    private void btnNovoDentistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoDentistaActionPerformed

        limparCampos();
        habilitaCampos();
        btnLimparCampos.setEnabled(true);
        btnSalvarDentista.setEnabled(true);
        btnNovoDentista.setEnabled(true);
        btnEditarDentista.setEnabled(false);
        btnExcluirDentista.setEnabled(false);
        situacao = "cadastro";


    }//GEN-LAST:event_btnNovoDentistaActionPerformed

    private void btnSalvarDentistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarDentistaActionPerformed
        if (verificaPreenchimento()) {
            if (situacao == "cadastro") {
                Dentista dentista = new Dentista(txtNome1.getText(), txtRg.getText(), txtCpf.getText(), txtRua.getText(), txtRua.getText(), txtNumero.getText(), txtComplemento.getText(),
                         txtCep.getText(), txtBairro.getText(), txtEstado.getText(),  txtCidade.getText(),
                        txtCro.getText(), txtEmail.getText(), txtCelular1.getText(), txtTelefone.getText(),txtNascimento.getText(), txtNumeroConsultorio.getText(), txtValorConsulta.getText(),
                txtLogin.getText(), txtSenha.getText());
                if (new DentistaDAO().verificaNomeExistente(dentista).equals(txtEmail.getText())) {
                    JOptionPane.showMessageDialog(null, "Dentista ja cadastrado!\nEsse Dentista ja esta cadastrado, digite outro.");
                } else {
                    String resp = new DentistaDAO().gravarDentista(dentista);
                    if (resp.equals("OK")) {
                        Utilidades.criarMensagemSucesso();
                        limparCampos();
                        desabilitaCampos();
                        carregaTabela();
                    } else {
                        Utilidades.criarMensagemErro();
                        limparCampos();
                        desabilitaCampos();
                        carregaTabela();
                    }
                    situacao = "";
                    btnEditarDentista.setEnabled(false);
                    btnExcluirDentista.setEnabled(false);
                    btnLimparCampos.setEnabled(false);
                    btnSalvarDentista.setEnabled(false);
                    btnNovoDentista.setEnabled(true);
                }
            } else if (situacao == "edicao") {
                 Dentista dentista = new Dentista(txtNome1.getText(), txtRg.getText(), txtCpf.getText(), txtRua.getText(), txtRua.getText(), txtNumero.getText(), txtComplemento.getText(),
                         txtCep.getText(), txtBairro.getText(), txtEstado.getText(),  txtCidade.getText(),
                        txtCro.getText(), txtEmail.getText(), txtCelular1.getText(), txtTelefone.getText(),txtNascimento.getText(), txtNumeroConsultorio.getText(), txtValorConsulta.getText(),
                txtLogin.getText(), txtSenha.getText());
                
                    String resp = new DentistaDAO().editarDentista(dentista);
                    if (resp.equals("OK")) {
                        Utilidades.criarMensagemSucesso();
                        limparCampos();
                        desabilitaCampos();
                        carregaTabela();
                    } else {
                        Utilidades.criarMensagemErro();
                        limparCampos();
                        desabilitaCampos();
                        carregaTabela();
                    }
                    carregaTabela();
                    limparCampos();
                    situacao = "";
                    btnEditarDentista.setEnabled(false);
                    btnExcluirDentista.setEnabled(false);
                    btnLimparCampos.setEnabled(false);
                    btnSalvarDentista.setEnabled(false);
                    btnNovoDentista.setEnabled(true);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Campo Vazio!\nPreencha todos os campos obrigatórios.");
            
        }
    }//GEN-LAST:event_btnSalvarDentistaActionPerformed

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();

        
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnNovoDentistaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoDentistaMouseEntered
       btnNovoDentista.setBackground(Color.white);
       btnNovoDentista.setForeground(azulPadrao);
    }//GEN-LAST:event_btnNovoDentistaMouseEntered

    private void btnNovoDentistaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoDentistaMouseExited
        btnNovoDentista.setBackground(azulPadrao);
       btnNovoDentista.setForeground(Color.white);
    }//GEN-LAST:event_btnNovoDentistaMouseExited

    private void btnEditarDentistaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarDentistaMouseEntered
         btnEditarDentista.setBackground(Color.white);
         btnEditarDentista.setForeground(azulPadrao);
    }//GEN-LAST:event_btnEditarDentistaMouseEntered

    private void btnEditarDentistaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarDentistaMouseExited
       btnEditarDentista.setBackground(azulPadrao);
       btnEditarDentista.setForeground(Color.white);
    }//GEN-LAST:event_btnEditarDentistaMouseExited

    private void btnSalvarDentistaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarDentistaMouseEntered
        btnSalvarDentista.setBackground(Color.white);
         btnSalvarDentista.setForeground(azulPadrao);
    }//GEN-LAST:event_btnSalvarDentistaMouseEntered

    private void btnSalvarDentistaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarDentistaMouseExited
        btnSalvarDentista.setBackground(azulPadrao);
       btnSalvarDentista.setForeground(Color.white);
    }//GEN-LAST:event_btnSalvarDentistaMouseExited

    private void btnLimparCamposMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparCamposMouseEntered
        btnLimparCampos.setBackground(Color.white);
        btnLimparCampos.setForeground(azulPadrao);
    }//GEN-LAST:event_btnLimparCamposMouseEntered
 
    private void btnLimparCamposMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparCamposMouseExited
        btnLimparCampos.setBackground(azulPadrao);
        btnLimparCampos.setForeground(Color.white);
    }//GEN-LAST:event_btnLimparCamposMouseExited

    private void btnExcluirDentistaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirDentistaMouseEntered
        btnExcluirDentista.setBackground(vermelhoHover);
        btnExcluirDentista.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnExcluirDentistaMouseEntered

    private void btnExcluirDentistaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirDentistaMouseExited
        btnExcluirDentista.setBackground(vermelhoPadraoExcluir);
        btnExcluirDentista.setForeground(Color.white);
    }//GEN-LAST:event_btnExcluirDentistaMouseExited

    private void btnVoltarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseEntered
        btnVoltar.setBackground(Color.white);
        btnVoltar.setForeground(azulPadrao);
    }//GEN-LAST:event_btnVoltarMouseEntered

    private void btnVoltarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVoltarMouseExited
        btnVoltar.setBackground(azulClaroo);
        btnVoltar.setForeground(Color.white);
    }//GEN-LAST:event_btnVoltarMouseExited

    private void txtRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtRgActionPerformed

    private void txtCroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCroActionPerformed

    private void txtNumeroConsultorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroConsultorioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNumeroConsultorioActionPerformed

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
                c.getNome(),
                c.getCro(),
                c.getConsultorio(),
                c.getValorConsulta()
            });
        }
    }//GEN-LAST:event_txtPesquisaDentista1KeyPressed

    private void txtPesquisaDentista1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaDentista1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaDentista1ActionPerformed

    private void btnZoomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnZoomMouseEntered
        btnZoom.setBackground(Color.white);
        btnZoom.setForeground(azulPadrao);
    }//GEN-LAST:event_btnZoomMouseEntered

    private void btnZoomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnZoomMouseExited
        btnZoom.setBackground(azulPadrao);
        btnZoom.setForeground(Color.white);
    }//GEN-LAST:event_btnZoomMouseExited

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
        txtId.setFont(fonteNormal);
        txtTelefone.setFont(fonteNormal);
        txtNome1.setFont(fonteNormal);
        txtCpf.setFont(fonteNormal);
        txtRg.setFont(fonteNormal);
        txtNascimento.setFont(fonteNormal);
        txtLogin.setFont(fonteNormal);
        txtSenha.setFont(fonteNormal);
        txtConfirmarSenha.setFont(fonteNormal);
        txtEstado.setFont(fonteNormal);
        txtRua.setFont(fonteNormal);
        txtNumeroConsultorio.setFont(fonteNormal);
        txtValorConsulta.setFont(fonteNormal);
        txtBairro.setFont(fonteNormal);
        txtComplemento.setFont(fonteNormal);
        txtNumero.setFont(fonteNormal);
        txtTelefone.setFont(fonteNormal);
        txtCelular.setFont(fonteNormal);
        txtCep.setFont(fonteNormal);
        txtEmail.setFont(fonteNormal);
        txtCidade.setFont(fonteNormal);

    }
    
    private void aplicarFonteBotoesNormal(){
         btnEditarDentista.setFont(fonteNormalBotoes);
        btnExcluirDentista.setFont(fonteNormalBotoes);
        btnLimparCampos.setFont(fonteNormalBotoes);
        btnNovoDentista.setFont(fonteNormalBotoes);
        btnLimparCampos.setFont(fonteNormalBotoes);
        btnSalvarDentista.setFont(fonteNormalBotoes);
    
    }
    
    
    
    private void aplicarZoomTexto() {
       txtId.setFont(fonteZoomTexto);
        txtTelefone.setFont(fonteZoomTexto);
        txtNome1.setFont(fonteZoomTexto);
        txtCpf.setFont(fonteZoomTexto);
        txtRg.setFont(fonteZoomTexto);
        txtNascimento.setFont(fonteZoomTexto);
        txtLogin.setFont(fonteZoomTexto);
        txtSenha.setFont(fonteZoomTexto);
        txtConfirmarSenha.setFont(fonteZoomTexto);
        txtEstado.setFont(fonteZoomTexto);
        txtRua.setFont(fonteZoomTexto);
        txtNumeroConsultorio.setFont(fonteZoomTexto);
        txtValorConsulta.setFont(fonteZoomTexto);
        txtBairro.setFont(fonteZoomTexto);
        txtComplemento.setFont(fonteZoomTexto);
        txtNumero.setFont(fonteZoomTexto);
        txtTelefone.setFont(fonteZoomTexto);
        txtCelular.setFont(fonteZoomTexto);
        txtCep.setFont(fonteZoomTexto);
        txtEmail.setFont(fonteZoomTexto);
        txtCidade.setFont(fonteZoomTexto);

    }

    private void aplicarZoomBotoes() {
         btnEditarDentista.setFont(fonteZoomBotoes);
        btnExcluirDentista.setFont(fonteZoomBotoes);
        btnLimparCampos.setFont(fonteZoomBotoes);
        btnNovoDentista.setFont(fonteZoomBotoes);
        btnLimparCampos.setFont(fonteZoomBotoes);
        btnSalvarDentista.setFont(fonteZoomBotoes);
    }
    
    
    
    
    private void jmiPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPacientesActionPerformed

        frmPaciente frm = new frmPaciente();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        this.dispose();

    }//GEN-LAST:event_jmiPacientesActionPerformed

    private void jmiDentistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDentistasActionPerformed

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
        frmAgendaGeral frm = new frmAgendaGeral();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        this.dispose();
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

    private void txtCepKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCepKeyReleased
        buscarCep(txtCep.getText());
    }//GEN-LAST:event_txtCepKeyReleased

    private void txtCepKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCepKeyPressed
        txtCidade.setText("");
        txtRua.setText("");
        txtEstado.setText("");
        txtBairro.setText("");
    }//GEN-LAST:event_txtCepKeyPressed

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
            java.util.logging.Logger.getLogger(frmDentista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmDentista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmDentista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmDentista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmDentista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarDentista;
    private javax.swing.JButton btnExcluirDentista;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JButton btnNovoDentista;
    private javax.swing.JButton btnSalvarDentista;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JButton btnZoom;
    private javax.swing.JLabel endwe;
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
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    public javax.swing.JMenuItem jmiConsultas;
    public javax.swing.JMenuItem jmiDentistas;
    private javax.swing.JMenuItem jmiEstoque;
    public javax.swing.JMenuItem jmiPacientes;
    public javax.swing.JMenuItem jmiRecepcionistas;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JLabel nconsu;
    private javax.swing.JLabel nconsu1;
    private javax.swing.JLabel nconsu2;
    private javax.swing.JLabel nconsu3;
    private javax.swing.JLabel nconsu4;
    private javax.swing.JTable tblDentista;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JFormattedTextField txtCelular1;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JTextField txtConfirmarSenha;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JTextField txtCro;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JFormattedTextField txtNascimento;
    private javax.swing.JTextField txtNome1;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtNumeroConsultorio;
    private javax.swing.JTextField txtPesquisaDentista1;
    private javax.swing.JFormattedTextField txtRg;
    private javax.swing.JTextField txtRua;
    private javax.swing.JTextField txtSenha;
    private javax.swing.JFormattedTextField txtTelefone;
    private javax.swing.JTextField txtValorConsulta;
    // End of variables declaration//GEN-END:variables
}
