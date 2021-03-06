package Formularios;

import Classes.Conecta;
import Classes.Paciente;
import Classes.PacienteDAO;
import Classes.Utilidades;
import java.awt.Color;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class frmPaciente extends javax.swing.JFrame {

    Color azulPadrao = new Color(129, 167, 255);
    Color azulFundo = new Color(226, 235, 255);
    Color azulClaroo = new Color(139, 215, 255);
    Color azulHover = new Color(192, 216, 235);
    Color vermelhoHover = new Color(242, 198, 196);
    Color vermelhoPadraoExcluir = new Color(223, 107, 111);
    public String situacao = "";
    String logradouro;
    String bairro;
    String cidade;
    String uf;

    //fonte para o zoom
    Font fonteZoomTexto = new Font("Arial", Font.BOLD, 18);
    Font fonteNormal = new Font("Arial", Font.BOLD, 14);
    
    Font fonteZoomBotoes = new Font("Arial", Font.BOLD, 18);
    Font fonteNormalBotoes = new Font("Arial", Font.BOLD, 14);

    public void buscarCep(String cep) {
        String json;

        try {
            URL url = new URL("http://viacep.com.br/ws/" + cep + "/json");
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
    public boolean verificaPreenchimento() {
        if (txtNome.getText().equals("")
                || txtEstado.getText().equals("")
                || txtCelular.getText().equals("")
                || txtBairro.getText().equals("")
                || txtRua.getText().equals("")
                || txtEstado.getText().equals("")
                || txtEmail.getText().equals("")
                || txtNumero.getText().equals("")
                || txtComplemento.getText().equals("")
                || txtCidade.getText().equals("")
                || txtTelefone.getText().equals("")
                || txtCpf.getText().equals("   .   .   -  ")
                || txtRg.getText().equals("  .   .   - ")
                || txtData.getText().equals("  /  /    ")) {
            return false;
        }
        return true;
    }
    public void habilitaCampos() {
        txtTelefone.setEnabled(true);
        txtNome.setEnabled(true);
        txtCpf.setEnabled(true);
        txtRg.setEnabled(true);
        txtData.setEnabled(true);
        txtEstado.setEnabled(true);
        txtRua.setEnabled(true);
        txtBairro.setEnabled(true);
        txtComplemento.setEnabled(true);
        txtNumero.setEnabled(true);
        txtTelefone.setEnabled(true);
        txtCelular.setEnabled(true);
        txtCep.setEnabled(true);
        txtEmail.setEnabled(true);
        txtCidade.setEnabled(true);

    }
    public void desabilitaCampos() {
        txtTelefone.setEnabled(false);
        txtNome.setEnabled(false);
        txtCpf.setEnabled(false);
        txtRg.setEnabled(false);
        txtData.setEnabled(false);
        txtEstado.setEnabled(false);
        txtRua.setEnabled(false);
        txtBairro.setEnabled(false);
        txtComplemento.setEnabled(false);
        txtNumero.setEnabled(false);
        txtTelefone.setEnabled(false);
        txtCelular.setEnabled(false);
        txtCep.setEnabled(false);
        txtEmail.setEnabled(false);
        txtCidade.setEnabled(false);

    }
    public void limparCampos() {

        txtNome.setText("");
        txtTelefone.setText("");
        txtRg.setText("");
        txtCpf.setText("");
        txtData.setText("");
        txtNome.setText("");
        txtBairro.setText("");
        txtCelular.setText("");
        txtCep.setText("");
        txtCidade.setText("");
        txtRua.setText("");
        txtPesquisaPaciente1.setText("");
        txtComplemento.setText("");
        txtNumero.setText("");
        txtEstado.setText("");
        txtEmail.setText("");
    }
    private void carregaTabela() {
        DefaultTableModel modelo = (DefaultTableModel) tblPaciente.getModel();
        modelo.setNumRows(0);
        try {
            java.sql.Connection con = Conecta.getConexao();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("select * from paciente order by nome");
            rs = pstm.executeQuery();

            while (rs.next()) {  //enquanto existirem registros no banco, ele continuar
                modelo.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("cpf"),
                    rs.getString("rg"),
                    rs.getString("nascimento"),});
            }
            pstm.close();
            con.close();
            rs.close();
        } catch (Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados" + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public frmPaciente() {
        initComponents();
        desabilitaCampos();
        this.setExtendedState(MAXIMIZED_BOTH);
        //Mudando a cor do fundo da tabela
        jScrollPane2.getViewport().setBackground(Color.WHITE);
        carregaTabela();
        getContentPane().setBackground(azulFundo);
        //mudar a cor do cabeçalho da tabela
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(azulPadrao);
        headerRenderer.setForeground(Color.WHITE);
        for (int i = 0; i < tblPaciente.getModel().getColumnCount(); i++) {
            tblPaciente.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
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

        jLabel4 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPaciente = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        btnExcluirPaciente = new javax.swing.JButton();
        btnEditarPaciente = new javax.swing.JButton();
        btnNovoPaciente = new javax.swing.JButton();
        btnSalvarPaciente = new javax.swing.JButton();
        txtCpf = new javax.swing.JFormattedTextField();
        txtData = new javax.swing.JFormattedTextField();
        txtRg = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        btnLimparCampos = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        txtNumero = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtComplemento = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtBairro = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        txtCidade = new javax.swing.JTextField();
        endwe = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtRua = new javax.swing.JTextField();
        txtCep = new javax.swing.JFormattedTextField();
        btnZoom = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        txtPesquisaPaciente1 = new javax.swing.JTextField();
        txtId = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtTelefone = new javax.swing.JFormattedTextField();
        txtCelular = new javax.swing.JFormattedTextField();
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

        setBackground(new java.awt.Color(226, 235, 255));
        setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        setUndecorated(true);
        setResizable(false);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(129, 167, 255));
        jLabel4.setText("INFORMAÇÕES DO PACIENTE");

        txtNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNome.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtNome.setPreferredSize(new java.awt.Dimension(0, 20));
        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Pesquisar Paciente:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setText("ID:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Nome:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("RG:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("CPF:");

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Data de Nasc:");

        jScrollPane2.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jScrollPane2.setOpaque(false);

        tblPaciente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblPaciente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "CPF", "RG", "Nascimento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPaciente.setGridColor(new java.awt.Color(255, 255, 255));
        tblPaciente.setOpaque(false);
        tblPaciente.setSelectionBackground(new java.awt.Color(129, 167, 255));
        tblPaciente.getTableHeader().setResizingAllowed(false);
        tblPaciente.getTableHeader().setReorderingAllowed(false);
        tblPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPacienteMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPaciente);
        if (tblPaciente.getColumnModel().getColumnCount() > 0) {
            tblPaciente.getColumnModel().getColumn(0).setResizable(false);
            tblPaciente.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblPaciente.getColumnModel().getColumn(1).setResizable(false);
            tblPaciente.getColumnModel().getColumn(1).setPreferredWidth(140);
            tblPaciente.getColumnModel().getColumn(2).setResizable(false);
            tblPaciente.getColumnModel().getColumn(2).setPreferredWidth(110);
            tblPaciente.getColumnModel().getColumn(3).setResizable(false);
            tblPaciente.getColumnModel().getColumn(3).setPreferredWidth(110);
            tblPaciente.getColumnModel().getColumn(4).setResizable(false);
            tblPaciente.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        btnSair.setBackground(new java.awt.Color(102, 204, 255));
        btnSair.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/voltar.png"))); // NOI18N
        btnSair.setText(" Voltar");
        btnSair.setActionCommand("Voltar");
        btnSair.setBorder(null);
        btnSair.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSairMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSairMouseExited(evt);
            }
        });
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnExcluirPaciente.setBackground(new java.awt.Color(223, 107, 111));
        btnExcluirPaciente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnExcluirPaciente.setForeground(new java.awt.Color(255, 255, 255));
        btnExcluirPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/excluir.png"))); // NOI18N
        btnExcluirPaciente.setText("Excluir Paciente");
        btnExcluirPaciente.setBorder(null);
        btnExcluirPaciente.setEnabled(false);
        btnExcluirPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnExcluirPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnExcluirPacienteMouseExited(evt);
            }
        });
        btnExcluirPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirPacienteActionPerformed(evt);
            }
        });

        btnEditarPaciente.setBackground(new java.awt.Color(129, 167, 255));
        btnEditarPaciente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnEditarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        btnEditarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/editar.png"))); // NOI18N
        btnEditarPaciente.setText(" Editar Paciente");
        btnEditarPaciente.setBorder(null);
        btnEditarPaciente.setEnabled(false);
        btnEditarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditarPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditarPacienteMouseExited(evt);
            }
        });
        btnEditarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarPacienteActionPerformed(evt);
            }
        });

        btnNovoPaciente.setBackground(new java.awt.Color(129, 167, 255));
        btnNovoPaciente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNovoPaciente.setForeground(new java.awt.Color(255, 255, 255));
        btnNovoPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/novo.png"))); // NOI18N
        btnNovoPaciente.setText(" Novo Paciente");
        btnNovoPaciente.setBorder(null);
        btnNovoPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnNovoPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNovoPacienteMouseExited(evt);
            }
        });
        btnNovoPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoPacienteActionPerformed(evt);
            }
        });

        btnSalvarPaciente.setBackground(new java.awt.Color(129, 167, 255));
        btnSalvarPaciente.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalvarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        btnSalvarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/salvar.png"))); // NOI18N
        btnSalvarPaciente.setText("Salvar Paciente");
        btnSalvarPaciente.setBorder(null);
        btnSalvarPaciente.setEnabled(false);
        btnSalvarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnSalvarPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnSalvarPacienteMouseExited(evt);
            }
        });
        btnSalvarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarPacienteActionPerformed(evt);
            }
        });

        txtCpf.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        try {
            txtCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCpf.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCpf.setPreferredSize(new java.awt.Dimension(0, 20));
        txtCpf.setSelectionColor(new java.awt.Color(51, 51, 51));

        txtData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        try {
            txtData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtData.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtData.setPreferredSize(new java.awt.Dimension(0, 20));

        txtRg.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        try {
            txtRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###-#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtRg.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtRg.setPreferredSize(new java.awt.Dimension(0, 20));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Celular:");

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setText("E-mail:");

        txtEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtEmail.setPreferredSize(new java.awt.Dimension(0, 20));

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

        jPanel1.setBackground(new java.awt.Color(226, 235, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), " Endereço ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel15.setText("Numero:");

        txtNumero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtNumero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtNumero.setPreferredSize(new java.awt.Dimension(0, 20));

        jLabel16.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel16.setText("Complemento:");

        txtComplemento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtComplemento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtComplemento.setPreferredSize(new java.awt.Dimension(0, 20));

        jLabel19.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel19.setText("CEP:");

        txtBairro.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtBairro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtBairro.setPreferredSize(new java.awt.Dimension(0, 20));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setText("Bairro:");

        txtEstado.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtEstado.setPreferredSize(new java.awt.Dimension(0, 20));

        jLabel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel24.setText("Estado:");

        txtCidade.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtCidade.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtCidade.setPreferredSize(new java.awt.Dimension(0, 20));

        endwe.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        endwe.setText("Cidade:");

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Logradouro:");

        txtRua.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtRua.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtRua.setPreferredSize(new java.awt.Dimension(0, 20));

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
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(endwe, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel20)
                .addGap(0, 0, 0)
                .addComponent(txtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(endwe, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setText("Telefone:");

        txtPesquisaPaciente1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        txtPesquisaPaciente1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        txtPesquisaPaciente1.setPreferredSize(new java.awt.Dimension(0, 20));
        txtPesquisaPaciente1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPesquisaPaciente1KeyPressed(evt);
            }
        });

        txtId.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        txtId.setForeground(new java.awt.Color(129, 167, 255));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));
        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jSeparator2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 1, true));

        txtTelefone.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)#### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTelefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        txtCelular.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        try {
            txtCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)##### - ####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCelular.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

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

        jmiPacientes.setBackground(new java.awt.Color(129, 167, 255));
        jmiPacientes.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiPacientes.setForeground(java.awt.Color.white);
        jmiPacientes.setText("Acessando tela de pacientes...");
        jmiPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiPacientesActionPerformed(evt);
            }
        });
        jMenu1.add(jmiPacientes);

        jmiDentistas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiDentistas.setBackground(new java.awt.Color(129, 167, 255));
        jmiDentistas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiDentistas.setForeground(java.awt.Color.white);
        jmiDentistas.setText("Registrar Dentista");
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
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCelular)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtPesquisaPaciente1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluirPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNovoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, 0)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11)
                        .addGap(0, 0, 0)
                        .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel12))
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13)
                        .addGap(0, 0, 0)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addGap(0, 0, 0)
                            .addComponent(txtPesquisaPaciente1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(30, 30, 30)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnNovoPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(35, 35, 35)
                                    .addComponent(btnSalvarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(36, 36, 36)
                                    .addComponent(btnEditarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(34, 34, 34)
                                    .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(37, 37, 37)
                                    .addComponent(btnExcluirPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))))
                .addGap(45, 45, 45))
        );

        setSize(new java.awt.Dimension(1210, 730));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void tblPacienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPacienteMouseClicked
        desabilitaCampos();
        int item = tblPaciente.getSelectionModel().getMinSelectionIndex();  //pega a linha selecionada
        item = (int) tblPaciente.getModel().getValueAt(item, 0);
        Paciente p = new PacienteDAO().pesquisarPaciente(item);
        txtNome.setText(p.getNome());
        txtId.setText(p.getId() + "");
        txtRua.setText(p.getRua());
        txtCpf.setText(p.getCpf());
        txtRg.setText(p.getRg());
        txtData.setText(p.getNascimento());
        txtNumero.setText(p.getNumero());
        txtRua.setText(p.getRua());
        txtEmail.setText(p.getEmail());
        txtCelular.setText(p.getCelular());
        txtCidade.setText(p.getCidade());
        txtComplemento.setText(p.getComplemento());
        txtEstado.setText(p.getEstado());
        txtCep.setText(p.getCep());
        txtTelefone.setText(p.getTelefone());
        txtBairro.setText(p.getBairro());

        btnEditarPaciente.setEnabled(true);
        btnExcluirPaciente.setEnabled(true);
        btnSalvarPaciente.setEnabled(false);
        btnNovoPaciente.setEnabled(true);
        btnLimparCampos.setEnabled(false);
    }//GEN-LAST:event_tblPacienteMouseClicked

    private void btnEditarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarPacienteActionPerformed
        habilitaCampos();
        situacao = "edicao";

        btnNovoPaciente.setEnabled(false);
        btnExcluirPaciente.setEnabled(false);
        btnSalvarPaciente.setEnabled(true);
        btnEditarPaciente.setEnabled(false);
    }//GEN-LAST:event_btnEditarPacienteActionPerformed

    private void btnExcluirPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirPacienteActionPerformed
        switch (JOptionPane.showConfirmDialog(null, "Deseja realmente excluir esse paciente?")) {
            case 0:
                Paciente paciente = new Paciente(Integer.parseInt(txtId.getText()));
                String resp = new PacienteDAO().excluirPaciente(paciente);
                if (resp.equals("OK")) {
                    JOptionPane.showMessageDialog(null, "Paciente excluido com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, "Não é possivel remover esse(a) paciente pois existem procedimentos marcados no nome dele(a)");
                }
                carregaTabela();
                limparCampos();
                desabilitaCampos();
                btnNovoPaciente.setEnabled(true);
                btnEditarPaciente.setEnabled(false);
                btnExcluirPaciente.setEnabled(false);
                btnLimparCampos.setEnabled(false);
                btnSalvarPaciente.setEnabled(false);
                break;

        }
    }//GEN-LAST:event_btnExcluirPacienteActionPerformed

    private void btnNovoPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoPacienteActionPerformed
        limparCampos();
        habilitaCampos();
        btnLimparCampos.setEnabled(true);
        btnSalvarPaciente.setEnabled(true);
        btnEditarPaciente.setEnabled(false);
        btnExcluirPaciente.setEnabled(false);
        situacao = "cadastro";
    }//GEN-LAST:event_btnNovoPacienteActionPerformed

    private void btnSalvarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarPacienteActionPerformed
        if (verificaPreenchimento()) {
            if (situacao == "cadastro") {
                Paciente paciente = new Paciente(txtNome.getText(), txtCpf.getText(), txtRg.getText(), txtData.getText(), txtRua.getText(),
                        txtNumero.getText(), txtTelefone.getText(), txtCelular.getText(), txtComplemento.getText(),
                        txtCep.getText(), txtEmail.getText(), txtBairro.getText(), txtEstado.getText(), txtCidade.getText());
                if (new PacienteDAO().verificaCpfExistente(paciente).equals(txtCpf.getText())) {
                    JOptionPane.showMessageDialog(null, "CPF ja cadastrado!\nEsse CPF ja esta cadastrado, digite outro.");
                } else {
                    String resp = new PacienteDAO().gravarPaciente(paciente);
                    if (resp.equals("OK")) {
                        Utilidades.criarMensagemSucesso();
                        limparCampos();
                        desabilitaCampos();
                        carregaTabela();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, resp);
                    }

                    situacao = "";
                    btnEditarPaciente.setEnabled(false);
                    btnExcluirPaciente.setEnabled(false);
                    btnLimparCampos.setEnabled(false);
                    btnSalvarPaciente.setEnabled(false);
                    btnNovoPaciente.setEnabled(true);
                }
            } else if (situacao == "edicao") {
                Paciente paciente = new Paciente(txtNome.getText(), txtCpf.getText(), txtRg.getText(), txtData.getText(), txtRua.getText(),
                        txtNumero.getText(), txtTelefone.getText(), txtCelular.getText(), txtComplemento.getText(),
                        txtCep.getText(), txtEmail.getText(), txtBairro.getText(), txtEstado.getText(), txtCidade.getText());

                String resp = new PacienteDAO().editarPaciente(paciente);
                if (resp.equals("OK")) {
                    JOptionPane.showMessageDialog(null, "Paciente Alterado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(null, resp);
                }
                carregaTabela();
                limparCampos();
                situacao = "";
                btnEditarPaciente.setEnabled(false);
                btnExcluirPaciente.setEnabled(false);
                btnLimparCampos.setEnabled(false);
                btnSalvarPaciente.setEnabled(false);
                btnNovoPaciente.setEnabled(true);

            }

        } else {
            JOptionPane.showMessageDialog(null, "Campo Vazio!\nPreencha todos os campos obrigatórios.");
        }
    }//GEN-LAST:event_btnSalvarPacienteActionPerformed

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void txtPesquisaPaciente1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaPaciente1KeyPressed
        //para pesquisar conforme o usuario digita uma letra
        String nome = txtPesquisaPaciente1.getText() + "%";

        PacienteDAO dao = new PacienteDAO();
        List<Paciente> lista = dao.buscaPacientePorNome(nome);
        DefaultTableModel dados = (DefaultTableModel) tblPaciente.getModel();
        dados.setNumRows(0); //limpar

        for (Paciente c : lista) {
            dados.addRow(new Object[]{
                c.getId(),
                c.getNome(),
                c.getCpf(),
                c.getRg(),
                c.getNascimento()
            });
        }
    }//GEN-LAST:event_txtPesquisaPaciente1KeyPressed

    private void btnNovoPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoPacienteMouseEntered
        btnNovoPaciente.setBackground(Color.white);
        btnNovoPaciente.setForeground(azulPadrao);
    }//GEN-LAST:event_btnNovoPacienteMouseEntered

    private void btnNovoPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNovoPacienteMouseExited
        btnNovoPaciente.setBackground(azulPadrao);
        btnNovoPaciente.setForeground(Color.white);
    }//GEN-LAST:event_btnNovoPacienteMouseExited

    private void btnSalvarPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarPacienteMouseEntered
        btnSalvarPaciente.setBackground(Color.white);
        btnSalvarPaciente.setForeground(azulPadrao);
    }//GEN-LAST:event_btnSalvarPacienteMouseEntered

    private void btnSalvarPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalvarPacienteMouseExited
        btnSalvarPaciente.setBackground(azulPadrao);
        btnSalvarPaciente.setForeground(Color.white);
    }//GEN-LAST:event_btnSalvarPacienteMouseExited

    private void btnEditarPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarPacienteMouseEntered
        btnEditarPaciente.setBackground(Color.white);
        btnEditarPaciente.setForeground(azulPadrao);
    }//GEN-LAST:event_btnEditarPacienteMouseEntered

    private void btnEditarPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditarPacienteMouseExited
        btnEditarPaciente.setBackground(azulPadrao);
        btnEditarPaciente.setForeground(Color.white);
    }//GEN-LAST:event_btnEditarPacienteMouseExited

    private void btnLimparCamposMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparCamposMouseEntered
        btnLimparCampos.setBackground(Color.white);
        btnLimparCampos.setForeground(azulPadrao);
    }//GEN-LAST:event_btnLimparCamposMouseEntered

    private void btnLimparCamposMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLimparCamposMouseExited
        btnLimparCampos.setBackground(azulPadrao);
        btnLimparCampos.setForeground(Color.white);
    }//GEN-LAST:event_btnLimparCamposMouseExited

    private void btnExcluirPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirPacienteMouseEntered
        btnExcluirPaciente.setBackground(vermelhoHover);
        btnExcluirPaciente.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnExcluirPacienteMouseEntered

    private void btnExcluirPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcluirPacienteMouseExited
        btnExcluirPaciente.setBackground(vermelhoPadraoExcluir);
        btnExcluirPaciente.setForeground(Color.white);
    }//GEN-LAST:event_btnExcluirPacienteMouseExited

    private void btnZoomMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnZoomMouseEntered
        btnZoom.setBackground(Color.white);
        btnZoom.setForeground(azulPadrao);
    }//GEN-LAST:event_btnZoomMouseEntered

    private void btnZoomMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnZoomMouseExited
        btnZoom.setBackground(azulPadrao);
        btnZoom.setForeground(Color.white);
    }//GEN-LAST:event_btnZoomMouseExited

    private void btnSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseEntered
        btnSair.setBackground(Color.white);
        btnSair.setForeground(azulPadrao);
    }//GEN-LAST:event_btnSairMouseEntered

    private void btnSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseExited
        btnSair.setBackground(azulClaroo);
        btnSair.setForeground(Color.white);
    }//GEN-LAST:event_btnSairMouseExited

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void jmiPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPacientesActionPerformed

    }//GEN-LAST:event_jmiPacientesActionPerformed

    private void jmiDentistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDentistasActionPerformed
        frmDentista frm = new frmDentista();
        frm.setVisible(true);
        frm.setLocationRelativeTo(null);
        this.dispose();
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
        txtNome.setFont(fonteNormal);
        txtTelefone.setFont(fonteNormal);
        txtRg.setFont(fonteNormal);
        txtCpf.setFont(fonteNormal);
        txtData.setFont(fonteNormal);
        txtNome.setFont(fonteNormal);
        txtBairro.setFont(fonteNormal);
        txtCelular.setFont(fonteNormal);
        txtCep.setFont(fonteNormal);
        txtCidade.setFont(fonteNormal);
        txtRua.setFont(fonteNormal);
        txtPesquisaPaciente1.setFont(fonteNormal);
        txtComplemento.setFont(fonteNormal);
        txtNumero.setFont(fonteNormal);
        txtEstado.setFont(fonteNormal);
        txtEmail.setFont(fonteNormal);

    }
    
    private void aplicarFonteBotoesNormal(){
     btnEditarPaciente.setFont(fonteNormalBotoes);
        btnExcluirPaciente.setFont(fonteNormalBotoes);
        btnLimparCampos.setFont(fonteNormalBotoes);
        btnNovoPaciente.setFont(fonteNormalBotoes);
        btnSalvarPaciente.setFont(fonteNormalBotoes);
    
    }
    
    
    
    private void aplicarZoomTexto() {
        txtNome.setFont(fonteZoomTexto);
        txtTelefone.setFont(fonteZoomTexto);
        txtRg.setFont(fonteZoomTexto);
        txtCpf.setFont(fonteZoomTexto);
        txtData.setFont(fonteZoomTexto);
        txtNome.setFont(fonteZoomTexto);
        txtBairro.setFont(fonteZoomTexto);
        txtCelular.setFont(fonteZoomTexto);
        txtCep.setFont(fonteZoomTexto);
        txtCidade.setFont(fonteZoomTexto);
        txtRua.setFont(fonteZoomTexto);
        txtPesquisaPaciente1.setFont(fonteZoomTexto);
        txtComplemento.setFont(fonteZoomTexto);
        txtNumero.setFont(fonteZoomTexto);
        txtEstado.setFont(fonteZoomTexto);
        txtEmail.setFont(fonteZoomTexto);

    }

    private void aplicarZoomBotoes() {
        btnEditarPaciente.setFont(fonteZoomBotoes);
        btnExcluirPaciente.setFont(fonteZoomBotoes);
        btnLimparCampos.setFont(fonteZoomBotoes);
        btnNovoPaciente.setFont(fonteZoomBotoes);
        btnSalvarPaciente.setFont(fonteZoomBotoes);
    }

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
            java.util.logging.Logger.getLogger(frmPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPaciente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPaciente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditarPaciente;
    private javax.swing.JButton btnExcluirPaciente;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JButton btnNovoPaciente;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvarPaciente;
    private javax.swing.JButton btnZoom;
    private javax.swing.JLabel endwe;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
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
    private javax.swing.JTable tblPaciente;
    private javax.swing.JTextField txtBairro;
    private javax.swing.JFormattedTextField txtCelular;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtComplemento;
    private javax.swing.JFormattedTextField txtCpf;
    private javax.swing.JFormattedTextField txtData;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JLabel txtId;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumero;
    private javax.swing.JTextField txtPesquisaPaciente1;
    private javax.swing.JFormattedTextField txtRg;
    private javax.swing.JTextField txtRua;
    private javax.swing.JFormattedTextField txtTelefone;
    // End of variables declaration//GEN-END:variables
}
