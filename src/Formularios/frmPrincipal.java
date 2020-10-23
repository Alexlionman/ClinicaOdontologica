package Formularios;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.Timer;

public class frmPrincipal extends javax.swing.JFrame {
    Color azulPadrao = new Color(129,167,255);
    Color azulClaro = new Color(226, 235, 255);
    Color vermelhoHover = new Color(242, 198, 196);
    Color vermelhoPadraoExcluir = new Color(255,117,117);
    
    public void usuarioLogado(String usuario){
        lblUsuario.setText(usuario);
    }
    //classe para atualizar a hora em segundos
    class hora implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Calendar now=Calendar.getInstance();
            lblHora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
        }
    }
    
    public frmPrincipal() {
        initComponents();
        //Iniciando a data da maquina no JLabel
        Date data= new Date();
        SimpleDateFormat formato= new SimpleDateFormat("dd/MM/yyyy");
        lblData.setText(formato.format(data));
        //Iniciando a hora da maquina no JLabel
        Timer timer= new Timer(1000, new hora());
        timer.start();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblUsuario = new javax.swing.JLabel();
        lblBemVindo = new javax.swing.JLabel();
        lblFotoUsuario = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        btnZoom = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        lblData = new javax.swing.JLabel();
        btnEstoque = new javax.swing.JButton();
        btnAgendas = new javax.swing.JButton();
        btnAgendarConsulta = new javax.swing.JButton();
        btnRegistrarPaciente = new javax.swing.JButton();
        barraMenu = new javax.swing.JMenuBar();
        mnEspaco1 = new javax.swing.JMenu();
        mnRegistrar = new javax.swing.JMenu();
        jmiPacientes = new javax.swing.JMenuItem();
        jmiDentistas = new javax.swing.JMenuItem();
        jmiRecepcionistas = new javax.swing.JMenuItem();
        jmiConsultas = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jmiEstoque = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        jmiSair = new javax.swing.JMenuItem();
        mnEspaco2 = new javax.swing.JMenu();
        mnAgendas = new javax.swing.JMenu();
        jmiAgenda = new javax.swing.JMenuItem();
        jmiAgendaEspecifica = new javax.swing.JMenuItem();
        mnEspaco3 = new javax.swing.JMenu();
        mnProntuarios = new javax.swing.JMenu();
        mnEspaco4 = new javax.swing.JMenu();
        mnAjuda = new javax.swing.JMenu();
        jmiAjuda = new javax.swing.JMenuItem();
        jmiSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        setUndecorated(true);
        setResizable(false);

        lblUsuario.setFont(new java.awt.Font("Arial", 1, 30)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(129, 167, 255));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblUsuario.setText("admin");
        lblUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        lblBemVindo.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        lblBemVindo.setForeground(new java.awt.Color(129, 167, 255));
        lblBemVindo.setText("Olá, bem vindo!");

        lblFotoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/foto-de-perfil.png"))); // NOI18N

        lblHora.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(51, 51, 51));
        lblHora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHora.setText("Hora");
        lblHora.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnZoom.setBackground(new java.awt.Color(139, 215, 255));
        btnZoom.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnZoom.setForeground(new java.awt.Color(255, 255, 255));
        btnZoom.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/zoom.png"))); // NOI18N
        btnZoom.setText("Zoom");
        btnZoom.setBorder(null);

        btnSair.setBackground(new java.awt.Color(255, 117, 117));
        btnSair.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 255, 255));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/sair.png"))); // NOI18N
        btnSair.setText("Sair");
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

        lblData.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lblData.setForeground(new java.awt.Color(51, 51, 51));
        lblData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblData.setText("Data");
        lblData.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnEstoque.setBackground(new java.awt.Color(129, 167, 255));
        btnEstoque.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEstoque.setForeground(new java.awt.Color(255, 255, 255));
        btnEstoque.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/incluir.png"))); // NOI18N
        btnEstoque.setText("Estoque");
        btnEstoque.setBorder(null);
        btnEstoque.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEstoqueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEstoqueMouseExited(evt);
            }
        });
        btnEstoque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstoqueActionPerformed(evt);
            }
        });

        btnAgendas.setBackground(new java.awt.Color(129, 167, 255));
        btnAgendas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAgendas.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/agendar.png"))); // NOI18N
        btnAgendas.setText("Agendas");
        btnAgendas.setBorder(null);
        btnAgendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgendasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgendasMouseExited(evt);
            }
        });
        btnAgendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendasActionPerformed(evt);
            }
        });

        btnAgendarConsulta.setBackground(new java.awt.Color(129, 167, 255));
        btnAgendarConsulta.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnAgendarConsulta.setForeground(new java.awt.Color(255, 255, 255));
        btnAgendarConsulta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/agendar.png"))); // NOI18N
        btnAgendarConsulta.setText("Agendar Consulta");
        btnAgendarConsulta.setBorder(null);
        btnAgendarConsulta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnAgendarConsultaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnAgendarConsultaMouseExited(evt);
            }
        });
        btnAgendarConsulta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgendarConsultaActionPerformed(evt);
            }
        });

        btnRegistrarPaciente.setBackground(new java.awt.Color(129, 167, 255));
        btnRegistrarPaciente.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnRegistrarPaciente.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarPaciente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/novo.png"))); // NOI18N
        btnRegistrarPaciente.setText("Registrar Paciente");
        btnRegistrarPaciente.setBorder(null);
        btnRegistrarPaciente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegistrarPacienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegistrarPacienteMouseExited(evt);
            }
        });
        btnRegistrarPaciente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarPacienteActionPerformed(evt);
            }
        });

        barraMenu.setBackground(new java.awt.Color(129, 167, 255));
        barraMenu.setForeground(new java.awt.Color(129, 167, 255));
        barraMenu.setBorderPainted(false);
        barraMenu.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        barraMenu.setPreferredSize(new java.awt.Dimension(346, 60));

        mnEspaco1.setText("         ");
        mnEspaco1.setEnabled(false);
        barraMenu.add(mnEspaco1);

        mnRegistrar.setBorder(null);
        mnRegistrar.setForeground(new java.awt.Color(255, 255, 255));
        mnRegistrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/registrar.png"))); // NOI18N
        mnRegistrar.setText(" Registrar");
        mnRegistrar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

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
        mnRegistrar.add(jmiPacientes);

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
        mnRegistrar.add(jmiDentistas);

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
        mnRegistrar.add(jmiRecepcionistas);

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
        mnRegistrar.add(jmiConsultas);

        jSeparator1.setForeground(java.awt.Color.white);
        mnRegistrar.add(jSeparator1);

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
        mnRegistrar.add(jmiEstoque);

        jSeparator4.setForeground(java.awt.Color.white);
        mnRegistrar.add(jSeparator4);

        jmiSair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_BACK_SPACE, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiSair.setBackground(new java.awt.Color(129, 167, 255));
        jmiSair.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiSair.setForeground(java.awt.Color.white);
        jmiSair.setText("Sair");
        jmiSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSairActionPerformed(evt);
            }
        });
        mnRegistrar.add(jmiSair);

        barraMenu.add(mnRegistrar);

        mnEspaco2.setText("         ");
        mnEspaco2.setEnabled(false);
        barraMenu.add(mnEspaco2);

        mnAgendas.setForeground(new java.awt.Color(255, 255, 255));
        mnAgendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/agendar.png"))); // NOI18N
        mnAgendas.setText(" Agendas");
        mnAgendas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N

        jmiAgenda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_1, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiAgenda.setBackground(new java.awt.Color(129, 167, 255));
        jmiAgenda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiAgenda.setForeground(java.awt.Color.white);
        jmiAgenda.setText("Consultas");
        jmiAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgendaActionPerformed(evt);
            }
        });
        mnAgendas.add(jmiAgenda);

        jmiAgendaEspecifica.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_2, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiAgendaEspecifica.setBackground(new java.awt.Color(129, 167, 255));
        jmiAgendaEspecifica.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiAgendaEspecifica.setForeground(java.awt.Color.white);
        jmiAgendaEspecifica.setText("Consultas por dentista");
        jmiAgendaEspecifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAgendaEspecificaActionPerformed(evt);
            }
        });
        mnAgendas.add(jmiAgendaEspecifica);

        barraMenu.add(mnAgendas);

        mnEspaco3.setText("         ");
        mnEspaco3.setEnabled(false);
        barraMenu.add(mnEspaco3);

        mnProntuarios.setForeground(new java.awt.Color(255, 255, 255));
        mnProntuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/prontuario.png"))); // NOI18N
        mnProntuarios.setText(" Prontuários");
        mnProntuarios.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        mnProntuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnProntuariosMouseClicked(evt);
            }
        });
        barraMenu.add(mnProntuarios);

        mnEspaco4.setText("         ");
        mnEspaco4.setEnabled(false);
        barraMenu.add(mnEspaco4);

        mnAjuda.setForeground(new java.awt.Color(255, 255, 255));
        mnAjuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ImagensIcones/newIcons/ajuda.png"))); // NOI18N
        mnAjuda.setText(" Ajuda");
        mnAjuda.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        mnAjuda.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);

        jmiAjuda.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiAjuda.setBackground(new java.awt.Color(129, 167, 255));
        jmiAjuda.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiAjuda.setForeground(java.awt.Color.white);
        jmiAjuda.setText("Ajuda");
        jmiAjuda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAjudaActionPerformed(evt);
            }
        });
        mnAjuda.add(jmiAjuda);

        jmiSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_9, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jmiSobre.setBackground(new java.awt.Color(129, 167, 255));
        jmiSobre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jmiSobre.setForeground(java.awt.Color.white);
        jmiSobre.setText("Sobre");
        jmiSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiSobreActionPerformed(evt);
            }
        });
        mnAjuda.add(jmiSobre);

        barraMenu.add(mnAjuda);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnAgendarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnAgendas, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblFotoUsuario))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(btnZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblBemVindo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnZoom, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblBemVindo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(lblFotoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblData, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgendas, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgendarConsulta, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRegistrarPaciente, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiPacientesActionPerformed
        this.dispose();
        frmPaciente frm = new frmPaciente();
        frm.setVisible(true);
    }//GEN-LAST:event_jmiPacientesActionPerformed

    private void jmiDentistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiDentistasActionPerformed
      this.dispose();
      frmDentista frm = new frmDentista();
      frm.setVisible(true);
    }//GEN-LAST:event_jmiDentistasActionPerformed

    private void jmiConsultasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiConsultasActionPerformed
        this.dispose();
        frmAgendarConsulta frm = new frmAgendarConsulta();
        frm.setVisible(true);
    }//GEN-LAST:event_jmiConsultasActionPerformed

    private void jmiAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgendaActionPerformed
        this.dispose();
        frmAgendaGeral frm = new frmAgendaGeral();
        frm.setVisible(true);
    }//GEN-LAST:event_jmiAgendaActionPerformed

    private void jmiEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiEstoqueActionPerformed
        this.dispose();
        frmEstoqueGeral frm = new frmEstoqueGeral();
        frm.setVisible(true);
    }//GEN-LAST:event_jmiEstoqueActionPerformed

    private void jmiAgendaEspecificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAgendaEspecificaActionPerformed
        this.dispose();
        frmAgendaEspecifica frm = new frmAgendaEspecifica();
        frm.setVisible(true);
    }//GEN-LAST:event_jmiAgendaEspecificaActionPerformed

    private void jmiRecepcionistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiRecepcionistasActionPerformed
        this.dispose();
        frmRecepcionista frm = new frmRecepcionista();
        frm.setVisible(true);
    }//GEN-LAST:event_jmiRecepcionistasActionPerformed

    private void jmiSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jmiSairActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnRegistrarPacienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarPacienteActionPerformed
        this.dispose();
        frmPaciente frm = new frmPaciente();
        frm.setVisible(true);
    }//GEN-LAST:event_btnRegistrarPacienteActionPerformed

    private void btnAgendarConsultaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendarConsultaActionPerformed
        this.dispose();
        frmAgendarConsulta frm = new frmAgendarConsulta();
        frm.setVisible(true);
    }//GEN-LAST:event_btnAgendarConsultaActionPerformed

    private void btnAgendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgendasActionPerformed
        this.dispose();
        frmAgendaGeral frm = new frmAgendaGeral();
        frm.setVisible(true);
    }//GEN-LAST:event_btnAgendasActionPerformed

    private void btnEstoqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstoqueActionPerformed
        this.dispose();
        frmEstoqueGeral frm = new frmEstoqueGeral();
        frm.setVisible(true);
    }//GEN-LAST:event_btnEstoqueActionPerformed

    private void btnRegistrarPacienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarPacienteMouseEntered
       btnRegistrarPaciente.setBackground(Color.white);
       btnRegistrarPaciente.setForeground(azulPadrao);
    }//GEN-LAST:event_btnRegistrarPacienteMouseEntered

    private void btnRegistrarPacienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarPacienteMouseExited
        btnRegistrarPaciente.setBackground(azulPadrao);
        btnRegistrarPaciente.setForeground(Color.white);
    }//GEN-LAST:event_btnRegistrarPacienteMouseExited

    private void btnAgendarConsultaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendarConsultaMouseEntered
        btnAgendarConsulta.setBackground(Color.white);
        btnAgendarConsulta.setForeground(azulPadrao);
    }//GEN-LAST:event_btnAgendarConsultaMouseEntered

    private void btnAgendarConsultaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendarConsultaMouseExited
        btnAgendarConsulta.setBackground(azulPadrao);
        btnAgendarConsulta.setForeground(Color.white);
    }//GEN-LAST:event_btnAgendarConsultaMouseExited

    private void btnAgendasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendasMouseEntered
        btnAgendas.setBackground(Color.white);
        btnAgendas.setForeground(azulPadrao);
    }//GEN-LAST:event_btnAgendasMouseEntered

    private void btnAgendasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgendasMouseExited
        btnAgendas.setBackground(azulPadrao);
        btnAgendas.setForeground(Color.white);
    }//GEN-LAST:event_btnAgendasMouseExited

    private void btnEstoqueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstoqueMouseEntered
        btnEstoque.setBackground(Color.white);
        btnEstoque.setForeground(azulPadrao);
    }//GEN-LAST:event_btnEstoqueMouseEntered

    private void btnEstoqueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEstoqueMouseExited
        btnEstoque.setBackground(azulPadrao);
       btnEstoque.setForeground(Color.white);
    }//GEN-LAST:event_btnEstoqueMouseExited

    private void btnSairMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseEntered
        btnSair.setBackground(vermelhoHover);
        btnSair.setForeground(Color.BLACK);
    }//GEN-LAST:event_btnSairMouseEntered

    private void btnSairMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSairMouseExited
        btnSair.setBackground(vermelhoPadraoExcluir);
        btnSair.setForeground(Color.white);
    }//GEN-LAST:event_btnSairMouseExited

    private void mnProntuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnProntuariosMouseClicked
        this.dispose();
        frmProntuario frm = new frmProntuario();
        frm.setVisible(true);
    }//GEN-LAST:event_mnProntuariosMouseClicked

    private void jmiAjudaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAjudaActionPerformed
        frmAjuda frm = new frmAjuda();
        frm.setVisible(true);
    }//GEN-LAST:event_jmiAjudaActionPerformed

    private void jmiSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiSobreActionPerformed
        frmSobre frm = new frmSobre();
        frm.setVisible(true);
    }//GEN-LAST:event_jmiSobreActionPerformed

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
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenu;
    public javax.swing.JButton btnAgendarConsulta;
    private javax.swing.JButton btnAgendas;
    private javax.swing.JButton btnEstoque;
    public javax.swing.JButton btnRegistrarPaciente;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnZoom;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JMenuItem jmiAgenda;
    private javax.swing.JMenuItem jmiAgendaEspecifica;
    private javax.swing.JMenuItem jmiAjuda;
    public javax.swing.JMenuItem jmiConsultas;
    public javax.swing.JMenuItem jmiDentistas;
    private javax.swing.JMenuItem jmiEstoque;
    public javax.swing.JMenuItem jmiPacientes;
    public javax.swing.JMenuItem jmiRecepcionistas;
    private javax.swing.JMenuItem jmiSair;
    private javax.swing.JMenuItem jmiSobre;
    private javax.swing.JLabel lblBemVindo;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblFotoUsuario;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JMenu mnAgendas;
    private javax.swing.JMenu mnAjuda;
    private javax.swing.JMenu mnEspaco1;
    private javax.swing.JMenu mnEspaco2;
    private javax.swing.JMenu mnEspaco3;
    private javax.swing.JMenu mnEspaco4;
    private javax.swing.JMenu mnProntuarios;
    private javax.swing.JMenu mnRegistrar;
    // End of variables declaration//GEN-END:variables
}
