/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projetoa3.footcup2022;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import projetoa3.footcup2022.DAO.Grupo;
import projetoa3.footcup2022.DAO.Time;
import projetoa3.footcup2022.Lib.Acesso;
import projetoa3.footcup2022.Lib.Comum;

/**
 *
 * @author Lucas Parra
 */
public class frmTimes extends javax.swing.JFrame {

    /**
     * Creates new form frmTimes
     */
    private String imgPath = System.getProperty("user.dir") + "/src/main/java/projetoa3/footcup2022/Imagens/Times/";

    public frmTimes() {
        initComponents();
        preparaAcessoMenu();

        for (Enumeration<AbstractButton> buttons = rbtnGrpContinente.getElements(); buttons.hasMoreElements();) {
            AbstractButton btn = buttons.nextElement();
            btn.setActionCommand(btn.getText());
        }

    }

    private void preparaAcessoMenu() {
        if (Acesso.User.TipoPrivilegio != 0) {
            jtableTime.setEnabled(false);
            jtabMenu.remove(jpnlCrud);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rbtnGrpContinente = new javax.swing.ButtonGroup();
        jPanel8 = new javax.swing.JPanel();
        jbtnVoltar = new javax.swing.JButton();
        jtabMenu = new javax.swing.JTabbedPane();
        jpnlVisualizarTime = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtableTime = new javax.swing.JTable();
        jpnlCrud = new javax.swing.JPanel();
        jlblBandeira = new javax.swing.JLabel();
        jPanelEdit = new javax.swing.JPanel();
        jtxtNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jcboGrupo = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        rbtnAmerica = new javax.swing.JRadioButton();
        rbtnAfrica = new javax.swing.JRadioButton();
        rbtnEuropa = new javax.swing.JRadioButton();
        rbtnAsia = new javax.swing.JRadioButton();
        rbtnOceania = new javax.swing.JRadioButton();
        jlblIdTime = new javax.swing.JLabel();
        jtxtIdTime = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbtnConfirmar = new javax.swing.JButton();
        jbtnLimpar = new javax.swing.JButton();
        jbtnDeletar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel8.setBackground(new java.awt.Color(42, 170, 56));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnVoltar.setText("Voltar");
        jbtnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnVoltarActionPerformed(evt);
            }
        });
        jPanel8.add(jbtnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 30));

        jpnlVisualizarTime.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jpnlVisualizarTimeComponentShown(evt);
            }
        });

        jtableTime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nome", "Grupo", "Continente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtableTime.setEditingColumn(0);
        jtableTime.setEditingRow(0);
        jtableTime.setRowHeight(30);
        jtableTime.setShowGrid(false);
        jtableTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtableTimeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtableTime);

        javax.swing.GroupLayout jpnlVisualizarTimeLayout = new javax.swing.GroupLayout(jpnlVisualizarTime);
        jpnlVisualizarTime.setLayout(jpnlVisualizarTimeLayout);
        jpnlVisualizarTimeLayout.setHorizontalGroup(
            jpnlVisualizarTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlVisualizarTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpnlVisualizarTimeLayout.setVerticalGroup(
            jpnlVisualizarTimeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlVisualizarTimeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 357, Short.MAX_VALUE)
                .addContainerGap())
        );

        jtabMenu.addTab("Visualizar", jpnlVisualizarTime);

        jlblBandeira.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jlblBandeira.setIcon(new javax.swing.ImageIcon("D:\\lp_dir\\USJT\\2022_2\\ProjetoA3\\src\\main\\java\\projetoa3\\footcup2022\\Imagens\\Times\\time_default.png")); // NOI18N
        jlblBandeira.setText(" ");

        jPanelEdit.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jtxtNome.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtxtNomeFocusLost(evt);
            }
        });

        jLabel1.setText("Nome do time");

        jLabel2.setText("Grupo do time");

        jcboGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D", "E" }));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Continente"));

        rbtnGrpContinente.add(rbtnAmerica);
        rbtnAmerica.setText("América");

        rbtnGrpContinente.add(rbtnAfrica);
        rbtnAfrica.setText("África");

        rbtnGrpContinente.add(rbtnEuropa);
        rbtnEuropa.setText("Europa");

        rbtnGrpContinente.add(rbtnAsia);
        rbtnAsia.setText("Ásia");

        rbtnGrpContinente.add(rbtnOceania);
        rbtnOceania.setText("Oceania");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(rbtnAmerica)
                .addGap(18, 18, 18)
                .addComponent(rbtnAfrica)
                .addGap(18, 18, 18)
                .addComponent(rbtnAsia)
                .addGap(18, 18, 18)
                .addComponent(rbtnEuropa)
                .addGap(18, 18, 18)
                .addComponent(rbtnOceania)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtnAmerica)
                    .addComponent(rbtnAfrica)
                    .addComponent(rbtnAsia)
                    .addComponent(rbtnOceania)
                    .addComponent(rbtnEuropa))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jlblIdTime.setText("Id do time");

        jtxtIdTime.setEnabled(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("*");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("*");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("*");

        javax.swing.GroupLayout jPanelEditLayout = new javax.swing.GroupLayout(jPanelEdit);
        jPanelEdit.setLayout(jPanelEditLayout);
        jPanelEditLayout.setHorizontalGroup(
            jPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEditLayout.createSequentialGroup()
                        .addGroup(jPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jlblIdTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtxtIdTime, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEditLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanelEditLayout.createSequentialGroup()
                                .addComponent(jtxtNome)
                                .addGap(35, 35, 35)))
                        .addGroup(jPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcboGrupo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(7, 7, 7))
        );
        jPanelEditLayout.setVerticalGroup(
            jPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEditLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanelEditLayout.createSequentialGroup()
                            .addComponent(jlblIdTime)
                            .addGap(6, 6, 6)
                            .addComponent(jtxtIdTime, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanelEditLayout.createSequentialGroup()
                            .addGroup(jPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jtxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelEditLayout.createSequentialGroup()
                        .addGroup(jPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcboGrupo)))
                .addGroup(jPanelEditLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEditLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(23, 23, 23))))
        );

        jbtnConfirmar.setText("Confirmar");
        jbtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnConfirmarActionPerformed(evt);
            }
        });

        jbtnLimpar.setText("Limpar");
        jbtnLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnLimparActionPerformed(evt);
            }
        });

        jbtnDeletar.setText("Deletar");
        jbtnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeletarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnlCrudLayout = new javax.swing.GroupLayout(jpnlCrud);
        jpnlCrud.setLayout(jpnlCrudLayout);
        jpnlCrudLayout.setHorizontalGroup(
            jpnlCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlCrudLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnlCrudLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77))
            .addGroup(jpnlCrudLayout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jlblBandeira, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnlCrudLayout.setVerticalGroup(
            jpnlCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlCrudLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelEdit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jlblBandeira, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(jpnlCrudLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnDeletar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jtabMenu.addTab("Add/Edit", jpnlCrud);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jtabMenu)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jtabMenu)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean Consiste() {
        boolean mRetorno = true;

        if (jtxtNome.getText().isBlank()) {
            mRetorno = false;
        }

        mRetorno = false;
        JRadioButton rbtnContinenteSelecionado = Comum.getSelectedRadio(rbtnGrpContinente);
        if (rbtnContinenteSelecionado != null) {
            if (rbtnContinenteSelecionado.isSelected()) {
                mRetorno = true;
            }
        }

        if (jcboGrupo.getSelectedItem().toString().isBlank()) {
            mRetorno = false;
        }

        return mRetorno;
    }

    private void jbtnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnVoltarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        frmHome frm = new frmHome();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }//GEN-LAST:event_jbtnVoltarActionPerformed

    private void jbtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnConfirmarActionPerformed
        //JOptionPane.showMessageDialog(null, bandeira);
        if (Consiste()) {
            String continente = rbtnGrpContinente.getSelection().getActionCommand();
            String bandeira = jlblBandeira.getIcon().toString();
            bandeira = bandeira.substring(bandeira.indexOf("Times") + 6);

            Time oTime = new Time();
            oTime.Nome = jtxtNome.getText().toUpperCase().charAt(0) + jtxtNome.getText().substring(1, jtxtNome.getText().length());
            oTime.IdGrupo = jcboGrupo.getSelectedItem().toString();
            oTime.Continente = continente;
            oTime.Bandeira = bandeira;

            try {
                //Se o campo ID estiver vazio significa que deve ser feita um inclusão de um novo time.
                String Id = jtxtIdTime.getText();
                if (Id.isBlank()) {
                    oTime.Incluir();
                    JOptionPane.showMessageDialog(null, "Time incluido com sucesso.");
                } else {
                    oTime.Atualizar(Integer.parseInt(Id));
                    JOptionPane.showMessageDialog(null, "Time atualizado com sucesso.");
                }
            } catch (SQLException ex) {
                if (ex.getMessage().contains("times.cnome_UNIQUE")) {
                    JOptionPane.showMessageDialog(null, "Não é possível incluir " + jtxtNome.getText() + " pois o time já existe.",
                            "", JOptionPane.OK_OPTION);
                } else {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "", JOptionPane.OK_OPTION);
                }
            } finally {
                jbtnLimparActionPerformed(evt);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Campos não podem ser vazios.", "", JOptionPane.OK_OPTION);
            //JOptionPane.showConfirmDialog(null, "Campos não podem ser vazios.");
        }
    }//GEN-LAST:event_jbtnConfirmarActionPerformed

    private void jbtnLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnLimparActionPerformed
        // TODO add your handling code here:
        jtxtNome.setText("");
        //jcboGrupo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "A", "B", "C", "D", "E" }));
        jcboGrupo.setSelectedIndex(0);
        rbtnGrpContinente.clearSelection();
        jtxtIdTime.setText("");

        String usrIcon = "time_default.png";
        String credito = "<a href=\"https://www.flaticon.com/free-icons/pennant\" Created by itim2101 - Flaticon</a>";
        jlblBandeira.setIcon(new ImageIcon(imgPath + usrIcon));
        jlblBandeira.setToolTipText(credito);
    }//GEN-LAST:event_jbtnLimparActionPerformed

    private void jbtnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeletarActionPerformed
        Time oTime = new Time();
        try {
            if (JOptionPane.showConfirmDialog(null, "Deseja excluir " + jtxtNome.getText() + " ?", "",
                    JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                oTime.Deletar(Integer.parseInt(jtxtIdTime.getText()));
                JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            jbtnLimparActionPerformed(evt);
        }
    }//GEN-LAST:event_jbtnDeletarActionPerformed

    private void jpnlVisualizarTimeComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jpnlVisualizarTimeComponentShown
        ArrayList<Time> lTimes = null;
        try {
            lTimes = new Time().Listar();

            DefaultTableModel model = (DefaultTableModel) jtableTime.getModel();
            model.setNumRows(0);

            for (Time time : lTimes) {
                model.addRow(new Object[]{
                    //retorna os dados da tabela do BD, cada campo e um coluna.
                    time.Id,
                    time.Nome,
                    time.IdGrupo,
                    time.Continente
                });
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jpnlVisualizarTimeComponentShown

    private void jtableTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtableTimeMouseClicked
        // TODO add your handling code here:
        int row = jtableTime.rowAtPoint(evt.getPoint());
        int col = jtableTime.columnAtPoint(evt.getPoint());
        if (row >= 0 && col >= 0) {
            if (Acesso.User.TipoPrivilegio == 0) {
                jtabMenu.setSelectedIndex(1);
                jtxtIdTime.setText(jtableTime.getValueAt(row, 0).toString());
                jtxtNome.setText(jtableTime.getValueAt(row, 1).toString());
                Comum.setTextoCombo(jtableTime.getValueAt(row, 2).toString(), jcboGrupo);
                Comum.setSelectedRadio(jtableTime.getValueAt(row, 3).toString(), rbtnGrpContinente);
                Comum.setBandeiraTime(jlblBandeira, jtxtNome.getText());
            }
        }
    }//GEN-LAST:event_jtableTimeMouseClicked

    private void jtxtNomeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtxtNomeFocusLost
        Comum.setBandeiraTime(jlblBandeira, jtxtNome.getText());
    }//GEN-LAST:event_jtxtNomeFocusLost

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
            java.util.logging.Logger.getLogger(frmTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmTimes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmTimes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelEdit;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnConfirmar;
    private javax.swing.JButton jbtnDeletar;
    private javax.swing.JButton jbtnLimpar;
    private javax.swing.JButton jbtnVoltar;
    private javax.swing.JComboBox<String> jcboGrupo;
    private javax.swing.JLabel jlblBandeira;
    private javax.swing.JLabel jlblIdTime;
    private javax.swing.JPanel jpnlCrud;
    private javax.swing.JPanel jpnlVisualizarTime;
    private javax.swing.JTabbedPane jtabMenu;
    private javax.swing.JTable jtableTime;
    private javax.swing.JTextField jtxtIdTime;
    private javax.swing.JTextField jtxtNome;
    private javax.swing.JRadioButton rbtnAfrica;
    private javax.swing.JRadioButton rbtnAmerica;
    private javax.swing.JRadioButton rbtnAsia;
    private javax.swing.JRadioButton rbtnEuropa;
    private javax.swing.ButtonGroup rbtnGrpContinente;
    private javax.swing.JRadioButton rbtnOceania;
    // End of variables declaration//GEN-END:variables
}
